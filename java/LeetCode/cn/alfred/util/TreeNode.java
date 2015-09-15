package cn.alfred.util;

public class TreeNode<T> {
  T val;
  TreeNode<T> left;
  TreeNode<T> right;

  public TreeNode(T val) {
    this.val = val;
  }

  public TreeNode<T> getLeft() {
    return this.left;
  }

  public TreeNode<T> getRight() {
    return this.right;
  }

  public T getValue() {
    return this.val;
  }

  public void setLeft(TreeNode<T> left) {
    this.left = left;
  }

  public void setRight(TreeNode<T> right) {
    this.right = right;
  }
  
  public void setValue(T val) {
    this.val = val;
  }
}
