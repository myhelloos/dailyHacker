class Result {
    public LinkedListNode<Character> node;
    public boolean result;

    public Result(LinkedListNode<Character> node, boolean result) {
        this.node = node;
        this.result = result;
    }
}

public class LinkedList {
    private LinkedListNode<Character> head = null;
    public LinkedList(String data) {
        LinkedListNode<Character> tail = head;
        for (int i = 0; i < data.length(); i++) {
            LinkedListNode<Character> temp = new LinkedListNode<Character>();
            int char_temp = data.codePointAt(i);
            temp.data = (char) char_temp;
            if (Character.isSupplementaryCodePoint(char_temp)) {
                i++;
            }
            if (head == null) {
                head = temp;
                tail = temp;
            } else {
                tail.next = temp;
                tail = tail.next;
            }
        }
    }

    private Result isPalindromeRecurse(LinkedListNode<Character> head, int length) {
        if ((head == null) || length == 0) {
            return new Result(null, true);
        } else if (length == 1) {
            return new Result(head.next, true);
        } else if (length == 2) {
            return new Result(head.next.next, head.data == head.next.data);
        }
        Result res = isPalindromeRecurse(head.next, length - 2);
        if (!res.result || res.node == null) {
            return res;
        } else {
            res.result = head.data == res.node.data;
            res.node = res.node.next;
            return res;
        }
    }

    boolean isPalindrome() {
        Result p = isPalindromeRecurse(head, this.listSize());
        return p.result;
    }

    int listSize() {
        if (head == null) {
            return 0;
        } else {
            LinkedListNode<Character> pointer = head;
            int result = 0;
            while (pointer != null) {
                result++;
                pointer = pointer.next;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.printf("Usage: java %s String\n", LinkedList.class.getName());
            return;
        }
        LinkedList test_base = new LinkedList(args[0]);
        System.out.println("The lenght is " + test_base.listSize());
        System.out.printf("The input string %s %s a palindrome.\n", args[0], (test_base.isPalindrome()? "is" : "isn't"));
    }
}
