package com.wangp.myaop.leetcode.middle;

/**
 * <pre>
 * classname GetTargetCopy
 * description
 *
 * 给你两棵二叉树，原始树 original 和克隆树 cloned，以及一个位于原始树 original 中的目标节点 target。
 *
 * 其中，克隆树 cloned 是原始树 original 的一个 副本 。
 *
 * 请找出在树 cloned 中，与 target 相同 的节点，并返回对该节点的引用（在 C/C++ 等有指针的语言中返回 节点指针，其他语言返回节点本身）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 *
 * @author wangpeng
 * @date 2020/11/5 20:07
 **/
public class GetTargetCopy {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {

        if (cloned.val == target.val) {
            return cloned;
        }
        TreeNode res = null;
        if (cloned.left != null) {
            res = getTargetCopy(original.left, cloned.left, target);
        }
        if (res != null) {
            return res;
        }
        if (cloned.right != null) {
            res = getTargetCopy(original.right, cloned.right, target);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(7);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(19);

        node.left = node1;
        node.right = node2;
        node2.left = node3;
        node2.right = node4;

        System.out.println(new GetTargetCopy().getTargetCopy(node, node, node2));
    }
}


class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

