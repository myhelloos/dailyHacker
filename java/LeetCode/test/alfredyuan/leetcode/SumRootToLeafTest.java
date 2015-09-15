package test.alfredyuan.leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.alfred.util.TreeNode;
import cn.alfredyuan.day03.SumRootToLeaf;

public class SumRootToLeafTest {

  @Test
  public void testSumNumbers() {
    TreeNode<Integer> root = new TreeNode<Integer>(4);
    root.setLeft(new TreeNode<Integer>(9));
    root.setRight(new TreeNode<Integer>(0));
    root.getLeft().setLeft(new TreeNode<Integer>(1));;
    int result = new SumRootToLeaf().sumNumbers(root);
    assertEquals(531, result);
  }

}
