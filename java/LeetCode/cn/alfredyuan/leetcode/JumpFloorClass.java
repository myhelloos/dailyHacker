package cn.alfredyuan.leetcode;

import java.util.HashMap;
import java.util.Map;

public class JumpFloorClass {
  private Map<Integer, Integer> cache = new HashMap<>();

  public int JumpFloor(int target) {
    cache.put(1, 0);
    cache.put(2, 0);
    return cacheJumpFloor(target);
  }

  private int cacheJumpFloor(int target) {
    if (cache.containsKey(target))
      return cache.get(target);
    int value = cacheJumpFloor(target - 1) + cacheJumpFloor(target - 2);
    cache.put(target, value);
    return value;
  }
}
