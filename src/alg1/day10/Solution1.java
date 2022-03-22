package alg1.day10;

import java.util.StringJoiner;

/**
 * 21 合并两个有序链表
 *
 * @author llliujw
 */
public class Solution1 {
    public static void main(String[] args) {
        ListNode list1_1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list1_2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        print(mergeTwoLists(list1_1, list1_2));

        print(mergeTwoLists(null, null));

        ListNode list3_2 = new ListNode(0);
        print(mergeTwoLists(null, list3_2));
    }

    /**
     * 递归或迭代
     * 时间复杂度 O(N) N为长链表的长度
     * 空间复杂度 O(1)
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val <= list2.val) return new ListNode(list1.val, mergeTwoLists(list1.next, list2));
        else return new ListNode(list2.val, mergeTwoLists(list1, list2.next));
    }

    static void print(ListNode list) {
        if (list == null) {
            System.out.println("[]");
            return;
        }
        StringJoiner sj = new StringJoiner(",", "[", "]");
        while (list != null) {
            sj.add(String.valueOf(list.val));
            list = list.next;
        }
        System.out.println(sj);
    }
}
