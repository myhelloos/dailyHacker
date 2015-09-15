package test.alfredyuan.leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.alfredyuan.day03.SubsequenceMaxProduct;

public class SubsequenceMaxProductTest {

  @Test
  public void testMaxProduct() {
    double[] inputs = {-2.5, 4, 0, 3, 0.5, 8, -1};
    double result = new SubsequenceMaxProduct().maxProduct(inputs);
    assertTrue(0.001 > 12 - result);
  }

}
