package problems.graph_general;

import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.Map;

public class Clone {
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

    class Solution {
        private Map<Node, Node> oldToNew = new HashMap<>();

        public Node cloneGraph(Node node) {
            if (node == null) {
                return null;
            }
            return dfs(node);
        }

        private Node dfs(Node node) {
            if (oldToNew.containsKey(node)) {
                return oldToNew.get(node);
            }
            Node copy = new Node(node.val);
            oldToNew.put(node, copy);
            for (Node neighbor : node.neighbors) {
                copy.neighbors.add(dfs(neighbor));
            }
            return copy;
        }
    }

    /*
Pros:
- **Simple and Intuitive**: Utilizes Depth-First Search (DFS) for graph traversal, which is straightforward and easy to implement.
- **Handles Cycles**: The use of a HashMap (`oldToNew`) ensures that each node is cloned only once, effectively managing graphs with cycles and preventing infinite recursion.
- **Preserves Graph Structure**: Accurately clones both the nodes and their connections, maintaining the original graph's structure.

Cons:
- **Recursive Depth**: For very deep or large graphs, the recursive approach may lead to a stack overflow due to excessive recursion depth.
- **Memory Usage**: The HashMap stores references to all original and cloned nodes, which can consume significant memory for large graphs.

Time Complexity: O(V + E)
- **Explanation**: Each of the V vertices and E edges is processed once during the traversal and cloning process.

Space Complexity: O(V)
- **Explanation**: The HashMap (`oldToNew`) stores a mapping for each of the V nodes. Additionally, the recursion stack may hold up to V calls in the worst case, contributing to the space complexity.
*/

}
