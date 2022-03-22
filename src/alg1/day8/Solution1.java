package alg1.day8;

/**
 * 617 合并二叉树
 *
 * @author llliujw
 */
public class Solution1 {
    public static void main(String[] args) {
        TreeNode root1_1 = new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2));
        TreeNode root1_2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(7)));
        mergeTrees(root1_1, root1_2).print();

        TreeNode root2_1 = new TreeNode(1);
        TreeNode root2_2 = new TreeNode(1, new TreeNode(2), null);
        mergeTrees(root2_1, root2_2).print();
    }

    /**
     * 递归DFS
     */
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode merged = new TreeNode(root1.val + root2.val);
        merged.left = mergeTrees(root1.left, root2.left);
        merged.right = mergeTrees(root1.right, root2.right);
        return merged;
    }
}
