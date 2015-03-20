/* 用一个数组实现三个栈 */
public class FixedStackOnArray {
	private int stacksize;
	private int[] buffer;
	/* 用于追踪栈顶元素的指针 */
	int[] stackPointer = { -1, -1, -1 };

	public FixedStackOnArray() {
		this(100);
	}

	public FixedStackOnArray(int stacksize) {
		this.stacksize = stacksize;
		this.buffer = new int[stacksize * 3];
	}

	public void push(int stackNum, int value) throws Exception {
		/* 检查有无空闲空间 */
		if (stackPointer[stackNum] + 1 >= stacksize) { // 最后一个元素
			throw new Exception("Out of space");
		}
		/* 栈指针自增，然后更新栈顶元素的指 */
		stackPointer[stackNum]++;
		buffer[absTopOfStack(stackNum)] = value;
	}

	public int pop(int stackNum) throws Exception {
		if (stackPointer[stackNum] == -1) {
			throw new Exception("Trying to pop an empty stack.");
		}
		int value = buffer[absTopOfStack(stackNum)]; // 获取栈顶元素的值
		buffer[absTopOfStack(stackNum)] = 0; // 清零指定索引元素的值
		stackPointer[stackNum]--; // 指针自减
		return value;
	}

	public int peek(int stackNum) {
		return buffer[absTopOfStack(stackNum)];
	}

	public boolean isEmpty(int stackNum) {
		return stackPointer[stackNum] == -1;
	}

	/* 返回栈"stackNum"栈顶元素的索引，绝对量 */
	private int absTopOfStack(int stackNum) {
		return stackNum * stacksize + stackPointer[stackNum];
	}

	public static void main(String[] args) {
		FixedStackOnArray stack = new FixedStackOnArray();
		try {
			for (int i = 0; i < 3; i++) {
				stack.push(i, 1);
				stack.push(i, 2);
				stack.push(i, 3);
				stack.push(i, 4);
				stack.push(i, 5);
				stack.push(i, 6);
				stack.push(i, 7);
				stack.push(i, 8);
				System.out.println("Stack " + i + " pop: " + stack.pop(i));
				System.out.println("Stack " + i + " peek: " + stack.peek(i));
				System.out.println("Stack " + i + " pop: " + stack.pop(i));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
