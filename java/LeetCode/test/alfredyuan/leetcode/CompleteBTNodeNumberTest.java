package test.alfredyuan.leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.alfred.util.TreeNode;
import cn.alfredyuan.day03.CompleteBTNodeNumber;

public class CompleteBTNodeNumberTest {

  @Test
  public void testNodeNum() {
    TreeNode<Integer> root = new TreeNode<>(2);
    root.setLeft(new TreeNode<Integer>(1));
    root.setRight(new TreeNode<Integer>(3));
    int number = new CompleteBTNodeNumber<Integer>().nodeNum(root);
    assertEquals(3, number);
  }

}
