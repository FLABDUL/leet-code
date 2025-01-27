package problems.simplify_path;

import java.util.Deque;
import java.util.LinkedList;

public class SimplifyPathLog {
    public static void main(String[] args) {
        String path = "/home/";
        SimplifyPathLog simplifyPathLog = new SimplifyPathLog();
        System.out.println("Input path: " + path);
        System.out.println("Result: " + simplifyPathLog.simplifyPath(path));
    }

    /**
     * Simplifies the given Unix-style file path.
     *
     * @param path The input path (Unix-style).
     * @return The canonical path.
     */
    public String simplifyPath(String path) {
        // Stack to hold valid directory names
        Deque<String> stack = new LinkedList<>();

        // Log the initial path
        System.out.println("Splitting the path into components:");

        // Split the path by "/" and process each part
        for (String s : path.split("/")) {
            System.out.println("Processing: '" + s + "'");
            if (s.equals("..")) {
                // ".." means go up one directory (if possible)
                if (!stack.isEmpty()) {
                    System.out.println("Popping from stack: " + stack.peek());
                    stack.poll();
                } else {
                    System.out.println("Stack is empty, cannot go up further.");
                }
            } else if (!s.equals("") && !s.equals(".")) {
                // Valid directory name, push it onto the stack
                System.out.println("Pushing onto stack: " + s);
                stack.push(s);
            } else {
                // Ignore empty strings and "."
                System.out.println("Skipping: '" + s + "'");
            }
        }

        // If stack is empty, return root "/"
        if (stack.isEmpty()) {
            System.out.println("Stack is empty. Returning '/' as the canonical path.");
            return "/";
        }

        // Construct the canonical path by combining valid directory names
        StringBuilder sb = new StringBuilder();
        System.out.println("Building the canonical path:");
        while (!stack.isEmpty()) {
            String dir = stack.pollLast();
            System.out.println("Appending: " + dir);
            sb.append("/").append(dir);
        }

        // Final canonical path
        String canonicalPath = sb.toString();
        System.out.println("Canonical path: " + canonicalPath);
        return canonicalPath;
    }

    /*
     * ==========================
     * Time and Space Complexity:
     * ==========================
     * Time Complexity: O(n)
     * - The input path is split into components, which takes O(n), where n is the length of the string.
     * - Each component is processed once, leading to overall O(n) complexity.
     *
     * Space Complexity: O(n)
     * - The stack stores directory names, which could take up space proportional to the number of valid directories.
     *
     * =================
     * Pros:
     * =================
     * 1. Efficient: Processes the input in O(n) time.
     * 2. Simple: Easy-to-understand stack-based approach.
     * 3. Handles edge cases: Correctly handles empty directories, ".", "..", and paths with redundant slashes.
     * 4. Scalable: Works well for large input paths.
     *
     * =================
     * Cons:
     * =================
     * 1. Assumes a valid Unix-style input path.
     * 2. Stack-based implementation may use extra space for long paths with many directories.
     *
     * =================
     * Uses:
     * =================
     * 1. Operating systems: Simplifying file paths in Unix-based systems.
     * 2. File management applications: Resolving canonical paths for better directory navigation.
     * 3. Web servers: Normalizing URL paths for routing requests.
     */
}
