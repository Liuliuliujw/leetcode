package day8;

/**
 * 116 填充每个节点的下一个右侧节点指针
 *
 * @author llliujw
 */
public class Solution2 {
    public static void main(String[] args) {
        Node root = new Node(1, new Node(2, new Node(4), new Node(5), null),
                new Node(3, new Node(6), new Node(7), null), null);
        System.out.println(connect(root));
    }

    /**
     * 利用已建立的next实现层序遍历(广度优先)
     * 时间复杂度 O(n) ---> 遍历一次所有节点
     * 空间复杂度 O(1) ---> temp和curr
     */
    public static Node connect(Node root) {
        if (root == null) return null;
        Node temp = root;
        Node curr;
        while (temp.left != null) {
            curr = temp;
            while (curr.next != null) {
                curr.left.next = curr.right;
                curr.right.next = curr.next.left;
                curr = curr.next;
            }
            curr.left.next = curr.right;
            temp = temp.left;
        }
        return root;
    }
}
