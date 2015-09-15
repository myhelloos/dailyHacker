package cn.alfredyuan.day03;

import cn.alfred.util.TreeNode;

/**
 * 给定一棵完全二叉树的头节点head，返回这棵树的节点个数。 如果完全二叉树的节点数为N， 请实现时间复杂度低于O(N)的解法。
 * 
 * @author alfred
 *
 */

public class CompleteBTNodeNumber<T> {

  public int nodeNum(TreeNode<T> head) {
    if (head == null) {
      return 0;
    }
    return bs(head, 1, mostLeftLevel(head, 1));
  }

  private int bs(TreeNode<T> node, int l, int h) {
    if (l == h) {
      return 1;
    }
    if (mostLeftLevel(node.getRight(), l + 1) == h) {
      return (1 << (h - l)) + bs(node.getRight(), l + 1, h);
    } else {
      return (1 << (h - l - 1)) + bs(node.getLeft(), l + 1, h);
    }
  }

  private int mostLeftLevel(TreeNode<T> node, int level) {
    while (node != null) {
      level++;
      node = node.getLeft();
    }
    return level - 1;
  }
}
