package medium;


public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
//        l1 = [2,4,3], l2 = [5,6,4]
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode res = addTwoNumbers(l1, l2);
        while (res != null) {
            System.out.print(res.val);
            res = res.next;
        }
        System.out.println("------------");

        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(2);
        l3.next.next = new ListNode(3);

        ListNode l4 = new ListNode(4);
        l4.next = new ListNode(5);

        ListNode res2 = addTwoNumbers(l3, l4);
        while (res2 != null) {
            System.out.print(res2.val);
            res2 = res2.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode currentNode = null;
        ListNode l1Current = l1;
        ListNode l2Current = l2;
        int increment = 0;
        while (l1Current != null || l2Current != null) {
            int l1Value = 0;
            int l2Value = 0;
            if (l1Current != null) {
                l1Value = l1Current.val;
                l1Current = l1Current.next;
            }
            if (l2Current != null) {
                l2Value = l2Current.val;
                l2Current = l2Current.next;
            }
            int resultValue = l1Value + l2Value + increment;

            if (result == null) {
                result = new ListNode(resultValue % 10);
                currentNode = result;
            } else {
                currentNode.next = new ListNode(resultValue % 10);
                currentNode = currentNode.next;
            }
            increment = resultValue >= 10 ? 1 : 0;
            // end case
            if (l1Current == null && l2Current == null && increment == 1) {
                currentNode.next = new ListNode(increment);
                currentNode = currentNode.next;
            }
        }

        return result;
    }
}
