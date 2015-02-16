load("BST.js");

var nums = new BST();
nums.insert(23);
nums.insert(45);
nums.insert(16);
nums.insert(37);
nums.insert(3);
nums.insert(99);
nums.insert(22);
print("InOrder traversal: ");
inOrder(nums.root);
print();
print("PreOrder traversal: ");
preOrder(nums.root);
print();
print("PostOrder traversal: ");
postOrder(nums.root);
print();
