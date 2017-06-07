/**
 * Created by supriyaJaha on 06-06-2017.
 */
public class LinkedList {

    Node head;

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void push(int data) {
        Node temp = new Node(data);
        temp.next = head;
        head = temp;
    }

    public void append(int data) {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = temp;
        }
    }

    public int getLengthIterative() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    private int getLengthRecursive(Node node) {
        if (node == null)
            return 0;
        return getLengthRecursive(node.next) + 1;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public boolean searchIterative(int data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == data)
                return true;
            temp = temp.next;
        }
        return false;
    }

    private boolean searchRecursive(int data, Node node) {
        if (node == null)
            return false;
        if (node.data == data)
            return true;
        return searchRecursive(data, node.next);
    }

    /**
     * 1. Traverse through the linked list till you find data1,data2
     * 2. Maintain pointers of current(node of data) and previous nodes
     * 3. If at the end of loop, temp is still null, then return as no data was found
     * 4. If prev1 == null, means firstSwapNode is headNode, point headNode=curr2
     * 5. First change next of previous pointers, then change next of current pointers
     */

    public void swap(int data1, int data2) {
        boolean flag = false;
        Node prev1 = null, prev2 = null, prev = null, curr1 = null, curr2 = null, temp = head;
        if (data1 == data2)
            return;
        while (temp != null) {
            if (temp.data == data1 || temp.data == data2) {
                if (!flag) {
                    prev1 = prev;
                    curr1 = temp;
                    flag = true;
                } else {
                    prev2 = prev;
                    curr2 = temp;
                    break;
                }
            }
            prev = temp;
            temp = temp.next;
        }
        if (temp == null)
            return;
        if (prev1 != null) {
            prev1.next = curr2;
        } else {
            head = curr2;
        }
        prev2.next = curr1;
        temp = curr2.next;
        curr2.next = curr1.next;
        curr1.next = temp;
    }

    public int getMiddleNode() throws Exception {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slow != null)
            return slow.data;
        else
            throw new Exception("Linked list is empty");
    }

    /**
     *
     * TC - O(2n)
     */
    public void printNthNode_iterative(int n) {
        int length = getLengthIterative();
        Node temp = head;
        if (length > n) {
            n = length - n + 1;
            while (n > 1) {
                temp = temp.next;
                n--;
            }
            System.out.println(temp.data);
        }
    }

    /**
     * 1. Maintain two pointers – reference pointer and main pointer.
     * 2. Initialize both reference and main pointers to head.
     * 3. First move reference pointer to n nodes from head.
     * 4. Now move both pointers one by one until reference pointer reaches end.
     * 5. Now main pointer will point to nth node from the end.
     * 6. Return main pointer.
     * TC - O(n)
     */
    public void printNthNode_optimized(int n){
        Node main_ptr=head,ref_ptr=head;
        int count=1;
        while(ref_ptr!=null && count!=n){
            count++;
            ref_ptr=ref_ptr.next;
        }
        if(ref_ptr==null)
            return;
        while(ref_ptr.next!=null){
            ref_ptr=ref_ptr.next;
            main_ptr = main_ptr.next;
        }
        System.out.println(main_ptr.data);
    }

    /*
    TC - O(n)
     */
    public int count(int data){
        Node temp=head;
        int count=0;
        while(temp!=null){
            if(temp.data==data)
                count++;
            temp=temp.next;
        }
        return count;
    }
    
    /* TC - O(n) */
    public void reverse(){
        if(head!=null){
            Node curr=head.next,prev=head,next;
            while(curr!=null){
                next=curr.next;
                curr.next=prev;
                if(prev==head)
                    prev.next=null;
                prev=curr;
                curr=next;
            }
            head=prev;
        }
}
