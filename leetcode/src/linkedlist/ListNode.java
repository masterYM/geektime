package linkedlist;



public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public ListNode getNext(){
        return next;
    }

    public void setNext(ListNode next){
        this.next = next;
    }

    public static void main(String[] args) {
        ListNode q1 = new ListNode(1);
        ListNode q2 = new ListNode(2);
        ListNode q3 = new ListNode(3);
        ListNode q4 = new ListNode(4);
        ListNode q5 = new ListNode(5);
        q1.setNext(q2);
        q2.setNext(q3);
        q3.setNext(q4);
        q4.setNext(q5);

        reverse(q1,null);
        printNode(q5);
    }

    /**
     * 反转链表，递归实现
     * @param node
     * @param pre
     */
    public static void reverse(ListNode node,ListNode pre){
        if(node == null) return;
        ListNode next = node.getNext();
        node.setNext(pre);
        reverse(next,node);
    }

    public static void printNode(ListNode node){
        System.out.println(node.val);
        if(node.getNext() != null){
            printNode(node.getNext());
        }
    }
}
