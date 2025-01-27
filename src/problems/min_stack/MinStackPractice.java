package problems.min_stack;

public class MinStackPractice {
    private Node head;
    public MinStackPractice() {//empty constructor
    }

    public void push(int val) {
        if(head==null){
            head=new Node(val, val, null);
        }else{
            head=new Node(val, Math.min(val, head.min), head);
        }
    }

    public void pop() {
        if(head!=null){
            head=head.next;
        }else{
            System.out.println("Emtpy stack");
        }
    }

    public int top() {
        if(head!=null){
            return head.val;
        }else{
            return -1;
        }
    }

    public int getMin() {
        if(head!=null){
            return head.min;
        }else{
            return -1;
        }
    }

    private class Node {
        int val;
        int min;
        Node next;

        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}
