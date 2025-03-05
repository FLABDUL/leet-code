package problems.graph_general.course_scheduler;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedulerAttempt {
    public static void main(String[] args) {
        CourseSchedulerAttempt scheduler = new CourseSchedulerAttempt();
        int[][] prerequisites1 = {{1, 0}, {2, 1}, {3, 2}};
        int[][] prerequisites2 = {{1, 0}, {0, 1}};

        System.out.println("Can finish courses (Test 1): " + scheduler.canFinish(4, prerequisites1));
        System.out.println("Can finish courses (Test 2): " + scheduler.canFinish(2, prerequisites2));
    }

    private boolean canFinish(int n, int[][] prereqs) {
        List<Integer>[] adj = new List[n];
        int[] indegree = new int[n];
        List<Integer> ans = new ArrayList<>();

        for(int[] pair : prereqs){
            int course = pair[0];
            int prereq = pair[1];
            if(adj[prereq] == null){
                adj[prereq] = new ArrayList<>();
            }
            adj[prereq].add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

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
        return false;
    }

    //crate queue for topological sorting
    //for each indegree
        //if no prereqs
        //add to queue

    //while queue not empyy
        //poll current course
        //add to answer

        //if adj current is not null no req
            //for each prereq
                //remove indegree
                //if it become 0 (no prereqs)
                    //add to queue
    //return size of ans to course

}
