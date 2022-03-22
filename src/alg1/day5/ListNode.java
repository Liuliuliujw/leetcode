package alg1.day5;

import java.util.StringJoiner;

/**
 * @author llliujw
 */
public class ListNode {
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

    void print() {
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        ListNode temp = this;
        do {
            stringJoiner.add(String.valueOf(temp.val));
            temp = temp.next;
        } while (temp != null);
        System.out.println(stringJoiner);
    }
}
