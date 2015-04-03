import java.util.Scanner;


public class q2{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int times = in.nextInt();

        for (int i = 0; i<times; i++) {
            int numN = in.nextInt();
            int iniN = in.nextInt();

            int[] iniArr = new int[iniN];
            Node[] nodeArr = new Node[numN];
            int[] queue = new int[1024];
            int head = 0;
            int tail = 0;

            for (int j = 0; j < iniN; j++) {
                iniArr[j] = in.nextInt();
                queue[tail++] = iniArr[j];
            }

            // System.out.println("going to get the input");
            for (int j = 0; j < numN; j++) {
                int id = in.nextInt();
                int iniNum = in.nextInt();
                nodeArr[j] = new Node(id, iniNum);
                for (int k = 0; k < iniNum; k++) {
                    nodeArr[j].arr[k] = in.nextInt();
                }
            }

            while (head != tail) {
                int currId = queue[head];
                head = (head + 1) % 1024;
                for (int j = 0; j < numN; j++) {
                    if (nodeArr[j].id == currId) {
                        nodeArr[j].count++;
                        for (int k = 0; k < nodeArr[j].arr.length; k++) {
                            queue[tail] = nodeArr[j].arr[k];
                            tail = (tail + 1) % 1024;
                        }
                    }
                }
            }

            for (int j = 0; j < numN; j++) {
                System.out.print(nodeArr[j].count + " ");
            }
            System.out.println();
        }
    }
}

class Node {
    int id;
    int count;
    int[] arr;

    public Node(int id, int len) {
        this.id = id;
        this.count = 0;
        this.arr = new int[len];
    }
}
