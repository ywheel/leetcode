package ywheel.leetcode._129_sum_root_to_leaf_numbers;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path
 * could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * For example,
 *    1
 *   / \ 
 *  2   3 The root-to-leaf path 1->2 represents the number 12. The
 * root-to-leaf path 1->3 represents the number 13.
 * 
 * Return the sum = 12 + 13 = 25.
 * 
 * @author ywheel
 * 
 */
public class SumRootToLeafNumbers {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int sumNumbers(TreeNode root) {
        return sumSubTree(0, root);
    }
    
    private int sumSubTree(int decade, TreeNode subTreeRoot) {
        int sum = 0;
        if (subTreeRoot == null) {
            return 0;
        } else {
            if (subTreeRoot.left == null && subTreeRoot.right == null) {
                // leaf node
                sum = decade * 10 + subTreeRoot.val;
            } else {
                // has child node
                if (subTreeRoot.left != null) {
                    sum += sumSubTree(decade*10+subTreeRoot.val, subTreeRoot.left);
                }
                if (subTreeRoot.right != null) {
                    sum += sumSubTree(decade*10+subTreeRoot.val, subTreeRoot.right);
                }
            }
        }
        return sum;
    }
    
    public TreeNode constructTree() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        return root;
    }
    
    public static void main(String[] args) {
        SumRootToLeafNumbers solution = new SumRootToLeafNumbers();
        System.out.println(solution.sumNumbers(solution.constructTree()));
    }
}
