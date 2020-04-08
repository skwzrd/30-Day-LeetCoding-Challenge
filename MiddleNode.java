/*
Day 8

Given a non-empty, singly linked list with head node head,
return a middle node of linked list.

If there are two middle nodes, return the second middle node.

Example
Input: [1,2,3,4,5,6]
Output: Node 4 from this list (Serialization: [4,5,6])
Since the list has two middle nodes with values 3 and 4,
we return the second one.
*/

class MiddleNode{
    
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode middleNode(ListNode head) {
        // Get length
        int length = 0;
        ListNode curr = head;
        while(curr!=null){
            length++;
            curr = curr.next;
        }

        // Loop to halfway
        int counter = 0;
        int halfway = length/2;
        curr = head;
        while(counter!=halfway){
            counter++;
            curr = curr.next;
        }
        return curr;
        
        // An alternative solution I found which was interesting
        // ListNode single_jump = head;
        // ListNode double_jump = head;
        
        // while(double_jump!=null && double_jump.next!=null){
        //     single_jump=single_jump.next;
        //     double_jump=double_jump.next.next;
        // }
        // return single_jump;
    }


    public static void main(String[] args) {
        
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        System.out.println(middleNode(head).val);
    }
}

