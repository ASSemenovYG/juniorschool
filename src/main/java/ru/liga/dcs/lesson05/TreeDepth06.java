package ru.liga.dcs.lesson05;

/**
 * Класс для определения глубины дерева.
 */
public class TreeDepth06 {
    /**
     * Узел дерева.
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        private boolean peekLeft() {
            return this.left != null;
        }

        private boolean peekRight() {
            return this.right != null;
        }
    }

    /**
     * Определяет глубину дерева.
     *
     * @param root корневой узел дерева
     * @return глубина дерева
     */
    public int maxDepth(TreeNode root) {
        int result = 0;
        if (root != null) {
            result++;
            result = getNextNodeDepth(root, result);
        }
        return result;
    }

    private int getNextNodeDepth(TreeNode node, int depth) {
        int leftDepth = depth;
        int rightDepth = depth;
        if (node.peekLeft()) {
            leftDepth = getNextNodeDepth(node.left, depth + 1);
        }
        if (node.peekRight()) {
            rightDepth = getNextNodeDepth(node.right, depth + 1);
        }
        return Math.max(leftDepth, rightDepth);
    }
}
