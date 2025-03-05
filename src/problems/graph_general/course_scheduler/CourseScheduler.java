package problems.graph_general.course_scheduler;

import java.util.*;

class CourseScheduler {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<Integer>[] adj = new List[n]; // Adjacency list to store course dependencies
        int[] indegree = new int[n]; // Array to track in-degrees of nodes (courses)
        List<Integer> ans = new ArrayList<>(); // List to store the order of courses taken

        // Build the adjacency list and compute in-degrees
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prerequisite = pair[1];
            if (adj[prerequisite] == null) {
                adj[prerequisite] = new ArrayList<>();
            }
            adj[prerequisite].add(course);
            indegree[course]++;//whatever node and edge points to gets incremented by one
        }

        System.out.println("Initial indegree array: " + Arrays.toString(indegree));

        Queue<Integer> queue = new LinkedList<>(); // Queue for topological sorting

        // Enqueue courses with no prerequisites (in-degree = 0)
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                System.out.println("Course " + i + " has no prerequisites, adding to queue.");
            }
        }

        // Process courses using BFS (Kahn's Algorithm)
        while (!queue.isEmpty()) {
            int current = queue.poll();
            ans.add(current);
            System.out.println("Processing course: " + current);

            if (adj[current] != null) {
                for (int next : adj[current]) {
                    indegree[next]--;//simulate removing node from graph by decreasing indegree of all affected nodes
                    System.out.println("Reducing indegree of course " + next + " to " + indegree[next]);
                    if (indegree[next] == 0) {
                        queue.offer(next);
                        System.out.println("Course " + next + " has no more prerequisites, adding to queue.");
                    }
                }
            }
        }

        System.out.println("Final processed course order: " + ans);
        return ans.size() == n;//if not, not all nodes in graph were processed, so there is cycle!
    }

    public static void main(String[] args) {
        CourseScheduler scheduler = new CourseScheduler();
        int[][] prerequisites1 = {{1, 0}, {2, 1}, {3, 2}};
        int[][] prerequisites2 = {{1, 0}, {0, 1}};

        System.out.println("Can finish courses (Test 1): " + scheduler.canFinish(4, prerequisites1));
        System.out.println("Can finish courses (Test 2): " + scheduler.canFinish(2, prerequisites2));
    }
}
// Algo explain:
// - https://www.youtube.com/watch?v=cIBFEhD77b4
// - only works of Directed Acyclic Graphs (DAGs) = finite directed graph with no directed cycles
// Pros:
// - Uses Kahn's algorithm (BFS) to detect cycles in a Directed Acyclic Graph (DAG).
// - Efficient for large graphs where dependencies must be processed in order.
//
// Cons:
// - Requires additional space for adjacency list and queue.
// - Cannot detect cycles if additional constraints are involved (e.g., constraints outside prerequisites array).
//
// Uses:
// - Used to determine if all courses in a curriculum can be completed given prerequisite dependencies.
// - Can be applied in job scheduling, dependency resolution, and task ordering problems.
//
// Time Complexity: O(n + e), where n = number of courses (nodes) and e = number of dependencies (edges).
// - Building the adjacency list takes O(e).
// - Traversing nodes and edges takes O(n + e).
//
// Space Complexity: O(n + e) for storing the adjacency list and auxiliary data structures.
