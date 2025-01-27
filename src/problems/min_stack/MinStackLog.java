package problems.min_stack;

class MinStackLog {
    public static void main(String[] args) {
        System.out.println("Creating a MinStack...");
        MinStackLog minStack = new MinStackLog();

        System.out.println("\nPushing elements onto the MinStack:");
        minStack.push(-2);
        System.out.println("Pushed: -2");
        minStack.push(0);
        System.out.println("Pushed: 0");
        minStack.push(-3);
        System.out.println("Pushed: -3");

        System.out.println("\nRetrieving the minimum value:");
        System.out.println("Minimum value in the stack: " + minStack.getMin()); // return -3

        System.out.println("\nPopping the top element...");
        minStack.pop();
        System.out.println("Top element popped.");

        System.out.println("\nRetrieving the top element:");
        System.out.println("Top element in the stack: " + minStack.top()); // return 0

        System.out.println("\nRetrieving the minimum value again:");
        System.out.println("Minimum value in the stack: " + minStack.getMin()); // return -2
    }

    private Node head;

    // Push an element onto the stack
    public void push(int x) {
        if (head == null) {
            // If stack is empty, initialize the first node
            head = new Node(x, x, null);
        } else {
            // Create a new node, setting the min to the smaller of the current value and the current head's min
            head = new Node(x, Math.min(x, head.min), head);
        }
        System.out.println("Pushed " + x + ". Current min: " + head.min);
    }

    // Pop the top element off the stack
    public void pop() {
        if (head != null) {
            System.out.println("Popped: " + head.val);
            head = head.next;
        } else {
            System.out.println("Stack is empty. Cannot pop.");
        }
    }

    // Get the value of the top element without removing it
    public int top() {
        if (head != null) {
            System.out.println("Top element: " + head.val);
            return head.val;
        } else {
            System.out.println("Stack is empty. No top element.");
            return -1; // Return a sentinel value
        }
    }

    // Get the minimum value in the stack
    public int getMin() {
        if (head != null) {
            System.out.println("Current minimum: " + head.min);
            return head.min;
        } else {
            System.out.println("Stack is empty. No minimum.");
            return -1; // Return a sentinel value
        }
    }

    // Node class to represent each element in the stack
    private class Node {
        int val;    // Value of the element
        int min;    // Minimum value at this node
        Node next;  // Pointer to the next node

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    /*
     * ===========================================================
     * Pros:
     * ===========================================================
     * 1. Efficient retrieval of the minimum value: O(1) time complexity.
     * 2. All stack operations (push, pop, top, getMin) are O(1).
     * 3. Simple implementation using a custom linked list.
     *
     * ===========================================================
     * Cons:
     * ===========================================================
     * 1. Memory overhead: Each node stores an additional `min` value.
     * 2. Not thread-safe: Multiple threads accessing the stack may cause issues unless synchronized.
     *
     * ===========================================================
     * Uses:
     * ===========================================================
     * 1. Ideal for problems requiring frequent minimum lookups while performing stack operations.
     * 2. Useful in algorithms where stack operations need to be augmented with minimum retrieval.
     *
     * ===========================================================
     * Time Complexity:
     * ===========================================================
     * 1. push(x): O(1) - Adding an element to the top of the stack is constant time.
     * 2. pop(): O(1) - Removing the top element is constant time.
     * 3. top(): O(1) - Accessing the top element is constant time.
     * 4. getMin(): O(1) - Retrieving the minimum value is constant time.
     *
     * ===========================================================
     * Space Complexity:
     * ===========================================================
     * 1. O(n) - Additional space is used to store the `min` value in each node of the stack.
     * 2. Linked list inherently has overhead due to pointers to the next node.
     */
}
