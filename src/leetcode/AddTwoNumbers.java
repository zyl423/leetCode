package leetcode;

/**
 * 两数之和
 */
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(null == l1 && null == l2){
            return null;
        }
        l1 = (null != l1) ? l1 : new ListNode(0);
        l2 = (null != l2) ? l2 : new ListNode(0);

        ListNode node = new ListNode(l1.val + l2.val);

        boolean mark = false;
        if(node.val > 9){
            node.val -= 10;
            if(null != l1.next){
                l1.next.val++;
            }else if(null != l2.next){
                l2.next.val++;
            }else{
                l1 = new ListNode(1);
                mark = true;
            }
        }
        if(!mark){
            l1 = l1.next;
        }
        l2 = l2.next;
        node.next = addTwoNumbers(l1, l2);

        return node;


/*        leetcode.ListNode dummyHead = new leetcode.ListNode(0);
        leetcode.ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new leetcode.ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new leetcode.ListNode(carry);
        }
        return dummyHead.next;*/
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        //node1.next = new leetcode.ListNode(4);
       // node1.next.next = new leetcode.ListNode(3);

        ListNode node2 = new ListNode(8);
        //node2.next = new leetcode.ListNode(6);
        //node2.next.next = new leetcode.ListNode(4);

        System.out.println(node1.toString());
        System.out.println(node2.toString());
        ListNode resultNode = addTwoNumbers(node1, node2);
        System.out.println(resultNode.toString());
    }

}

