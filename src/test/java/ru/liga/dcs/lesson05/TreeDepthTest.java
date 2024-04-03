package ru.liga.dcs.lesson05;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import static ru.liga.dcs.lesson05.TreeDepth06.TreeNode;

/**
 * Тесты для класса TreeDepth.
 */
public class TreeDepthTest {

    @Test
    public void testMaxDepth_EmptyTree() {
        TreeDepth06 treeDepth = new TreeDepth06();
        assertEquals(0, treeDepth.maxDepth(null));
    }

    @Test
    public void testMaxDepth_SingleNode() {
        TreeDepth06 treeDepth = new TreeDepth06();
        TreeNode root = new TreeNode(5);
        assertEquals(1, treeDepth.maxDepth(root));
    }

    @Test
    public void testMaxDepth_BalancedTree() {
        TreeDepth06 treeDepth = new TreeDepth06();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        assertEquals(3, treeDepth.maxDepth(root));
    }

    @Test
    public void testMaxDepth_UnbalancedTree() {
        TreeDepth06 treeDepth = new TreeDepth06();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        assertEquals(3, treeDepth.maxDepth(root));
    }
    @Test
    public void testMaxDepth_DeepTree() {
        TreeDepth06 treeDepth = new TreeDepth06();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        assertEquals(4, treeDepth.maxDepth(root));
    }

}
