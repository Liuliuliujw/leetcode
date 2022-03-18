package day10;

/**
 * 206 反转链表
 *
 * @author llliujw
 */
public class Solution2 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        Solution1.print(reverseList(list1));

        ListNode list2 = new ListNode(1, new ListNode(2));
        Solution1.print(reverseList(list2));

        Solution1.print(reverseList(null));
    }

    /**
     * 迭代
     * 时间复杂度：O(n）
     * 空间复杂度：O(1)
     */
    public static ListNode reverseList(ListNode head) {
        ListNode ans = null;
        ListNode curr = head;
        ListNode temp;
        while (curr != null) {
            temp = curr.next;
            curr.next = ans;
            ans = curr;
            curr = temp;
        }
        return ans;
    }

}
