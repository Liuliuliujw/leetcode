package day5;

/**
 * 19 删除链表的倒数第 N 个结点
 *
 * @author llliujw
 */
public class Solution2 {
    public static void main(String[] args) {
        //示例1
        ListNode listNode1_5 = new ListNode(5);
        ListNode listNode1_4 = new ListNode(4, listNode1_5);
        ListNode listNode1_3 = new ListNode(3, listNode1_4);
        ListNode listNode1_2 = new ListNode(2, listNode1_3);
        ListNode listNode1_1 = new ListNode(1, listNode1_2);
        ListNode ans1 = removeNthFromEnd(listNode1_1, 2);
        ans1.print();
        //示例2
        ListNode listNode2_1 = new ListNode(1);
        ListNode ans2 = removeNthFromEnd(listNode2_1, 1);
        if (ans2 == null) System.out.println("[]");
        //示例3
        ListNode listNode3_2 = new ListNode(2);
        ListNode listNode3_1 = new ListNode(1, listNode3_2);
        ListNode ans3 = removeNthFromEnd(listNode3_1, 1);
        ans3.print();
    }

    /**
     * 对第一版答案的改进 --> 引入哑节点，避免头节点的非空判断和删除时没有前驱的问题
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head); //哑节点
        ListNode slow = dummy, fast = head;
        while (n > 0) {
            fast = fast.next;
            n--;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }

    /**
     * 第一版答案
     * 双指针
     * 时间复杂度 O(n) ---> 一次遍历
     * 空间复杂度 O(1)
     */
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        if (head == null)return null;
        ListNode slow = head, fast = head;
        while (n > 0) { //将fast后移N个节点
            fast = fast.next;
            n--;
        }

        if (fast == null) { //若fast 为空，则删除的是第一个节点
            return head.next;
        }

        while (fast.next != null) { //若fast非空，slow和fast后移，直至fast为尾，此时slow为删除节点的前驱
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next; //删除

        return head;
    }
}
