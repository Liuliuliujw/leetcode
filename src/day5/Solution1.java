package day5;

/**
 * 876 链表的中间结点
 *
 * @author llliujw
 */
public class Solution1 {
    public static void main(String[] args) {
        ListNode listNode1_5 = new ListNode(5);
        ListNode listNode1_4 = new ListNode(4, listNode1_5);
        ListNode listNode1_3 = new ListNode(3, listNode1_4);
        ListNode listNode1_2 = new ListNode(2, listNode1_3);
        ListNode listNode1_1 = new ListNode(1, listNode1_2);

        ListNode ans1 = middleNode(listNode1_1);
        ans1.print();

        ListNode listNode2_6 = new ListNode(6);
        ListNode listNode2_5 = new ListNode(5, listNode2_6);
        ListNode listNode2_4 = new ListNode(4, listNode2_5);
        ListNode listNode2_3 = new ListNode(3, listNode2_4);
        ListNode listNode2_2 = new ListNode(2, listNode2_3);
        ListNode listNode2_1 = new ListNode(1, listNode2_2);

        ListNode ans2 = middleNode(listNode2_1);
        ans2.print();
    }

    /**
     * 双指针（快慢指针）
     */
    public static ListNode middleNode(ListNode head) {
        ListNode index = head, double_index = head; //index --> slow, double_index --> fast
        while (double_index.next != null) {
            index = index.next;
            double_index = double_index.next;
            if (double_index.next == null) {
                return index;
            } else {
                double_index = double_index.next;
            }
        }
        return index;
    }
}
