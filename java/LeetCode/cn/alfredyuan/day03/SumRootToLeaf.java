package cn.alfredyuan.day03;

import cn.alfred.util.TreeNode;

/**
 * Given a binary tree containing digits from0-9only, each root-to-leaf path
 * could represent a number.
 * 
 * An example is the root-to-leaf path1->2->3which represents the number123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * For example,
 * 
 * 1 / \ 2 3
 * 
 * 
 * The root-to-leaf path1->2represents the number12. The root-to-leaf
 * path1->3represents the number13.
 * 
 * Return the sum = 12 + 13 =25.
 * 
 * @author alfred
 *
 */
public class SumRootToLeaf {
  public int sumNumbers(TreeNode<Integer> root) {
    return adder(root, 0);
  }

  private int adder(TreeNode<Integer> root, int sum) {
    if (null == root)
      return 0;
    if (null == root.getLeft() && null == root.getRight()) {
      return sum * 10 + root.getValue();
    }
    return adder(root.getLeft(), sum * 10 + root.getValue())
        + adder(root.getRight(), sum * 10 + root.getValue());
  }
}
