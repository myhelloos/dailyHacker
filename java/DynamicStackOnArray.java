
public class DynamicStackOnArray {
    private int number_of_stacks;
    private int default_size;
    private int total_size;
    private StackData[] stacks;
    private int[] buffer;

    public DynamicStackOnArray() {
        this(4);
    }

    public DynamicStackOnArray(int default_size) {
        this.number_of_stacks = 3;
        this.default_size = default_size;
        this.total_size = this.default_size * this.number_of_stacks;
        this.stacks = new StackData[this.number_of_stacks];
        for (int i = 0; i < this.number_of_stacks; i++) {
            this.stacks[i] = new StackData(i * this.default_size, this.default_size);
        }
        this.buffer = new int[this.total_size];
    }

    public void push(int stackNum, int value) throws Exception {
        StackData stack = stacks[stackNum];
        /* 检查空间够不够 */
        if (stack.size >= stack.capacity) {
            if (numberOfElements() >= total_size) { // 全满了
                throw new Exception("Out of Space");
            } else { // 只需要搬移元素
                expand(stackNum);
            }
        }
        /* 找出栈顶元素在数组中的索引，并加1；增加栈指针*/
        stack.size++;
        stack.pointer = nextElement(stack.pointer);
        buffer[stack.pointer] = value;
    }

    public int pop(int stackNum) throws Exception{
        StackData stack = stacks[stackNum];
        if (stack.size == 0) {
            throw new Exception("Trying to pop an empty stack.");
        }
        int value = buffer[stack.pointer];
        buffer[stack.pointer] = 0;
        stack.pointer = previousElement(stack.pointer);
        stack.size--;
        return value;
    }

    public int peek(int stackNum) {
        return buffer[stacks[stackNum].pointer];
    }

    private int numberOfElements() {
        return stacks[0].size + stacks[1].capacity + stacks[2].capacity;
    }

    /* 搬移元素到其他栈上，以扩大栈的容量 */
    private void expand(int stackNum) {
        shift((stackNum + 1) % stackNum);
        stacks[stackNum].capacity++;
    }

    private void shift(int stackNum) {
        StackData stack = stacks[stackNum];
        if (stack.size >= stack.capacity) {
            shift((stackNum + 1) % number_of_stacks); //  腾出若干空间
            stack.capacity++;
        }

        //  以相反顺序移动元素
        for (int i = (stack.start + stack.capacity - 1) % total_size;
        stack.isWithinStack(0, total_size);
        i = previousElement(i)) {
            buffer[i] = buffer[previousElement(i)];
        }

        buffer[stack.start] = 0; // 清零指定索引元素的值
        stack.start = nextElement(stack.start); // 移动栈的起始位置
        stack.pointer = nextElement(stack.pointer); // 移动栈的指针
        stack.capacity--; // 更新栈的容量
    }

    private int nextElement(int index) {
        if (index + 1 == total_size) {
            return 0;
        }
        return index + 1;
    }

    private int previousElement(int index) {
        if (index == 0)
        return total_size - 1;
        else
        return index - 1;
    }

    public static void main(String[] args) {
        DynamicStackOnArray stack;
        if (args.length > 0) {
            stack = new DynamicStackOnArray(Integer.parseInt(args[0]));
        } else {
            stack = new DynamicStackOnArray();
        }
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

/* StckData 用来存放每个栈相关的数据，单并不存放栈的实际元素 */
class StackData{
    public int start;
    public int pointer;
    public int size = 0;
    public int capacity;
    public StackData(int start, int capacity) {
        this.start = start;
        this.pointer = start - 1;
        this.capacity = capacity;
    }
    public boolean isWithinStack(int index, int total_size) {
        /* 如果栈回绕了，首部（右侧）回绕到左侧 */
        if (start <= index && index < start + capacity) {
            // 不回绕，或回绕时的“首部”，右侧
            return true;
        } else if (start + capacity > total_size && index < (start + capacity) % total_size) {
            // 回绕时的尾部，左侧
            return true;
        }
        return false;
    }
}
