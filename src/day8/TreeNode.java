package day8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;

/**
 * Solution1 附
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    //层序遍历打印数忽略null
    void print(){
        StringJoiner sj = new StringJoiner(",","[","]");
        TreeNode root = this;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            sj.add(String.valueOf(node.val));
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        System.out.println(sj);
    }
}

