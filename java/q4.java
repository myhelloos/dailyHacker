import java.util.Scanner;

class Node {
    int num;
    int ability;
    int salary;
    Node next;
}

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int X = in.nextInt();
        int Y = in.nextInt();
        int B = in.nextInt();
        Node maleHead = new Node();
        maleHead.next = null;
        Node femaleHead = new Node();
        femaleHead.next = null;
        Node tempNode = null;
        int tempNum = 0;
        char tempGen = 0;
        int tempAbi = 0;
        int tempSal = 0;

        // read in data
        for (int i = 0; i < N; i++) {
            tempNum = i + 1;
            tempGen = in.next(".").charAt(0);
            tempAbi = in.nextInt();
            tempSal = in.nextInt();
            if (tempGen == 'F') {
                tempNode = femaleHead;
                while (tempNode.next != null) {
                    if (tempNode.next.ability > tempAbi) tempNode = tempNode.next;
                }
                while (tempNode.next != null) {
                    if (tempNode.next.salary < tempSal) tempNode = tempNode.next;
                }
                Node temp = new Node();
                temp.num = tempNum;
                temp.next = tempNode.next;
                temp.salary = tempSal;
                temp.ability = tempAbi;
            } else {
                tempNode = maleHead;
                while (tempNode.next != null) {
                    if (tempNode.next.ability > tempAbi) tempNode = tempNode.next;
                }
                while (tempNode.next != null) {
                    if (tempNode.next.salary < tempSal) tempNode = tempNode.next;
                }
                Node temp = new Node();
                temp.num = tempNum;
                temp.next = tempNode.next;
                temp.salary = tempSal;
                temp.ability = tempAbi;
            }
        }

        Node[] ansM = new Node[X];
        Node[] ansF = new Node[Y];
        Node maP = maleHead.next;
        Node feP = femaleHead.next;
        int resAbi = 0;
        int resSal = 0;
        // init answer
        for (int i = 0; i < X; i++) {
            ansM[i] = maP;
            resAbi += maP.ability;
            resSal += maP.salary;
            maP = maP.next;
        }
        for (int i = 0; i < Y; i++) {
            ansF[i] = feP;
            resAbi += feP.ability;
            resSal += feP.salary;
            feP = feP.next;
        }

        // unfinished
        // while (resSal > B) {
        //     if ()
        // }

        System.out.println(resAbi + " " + resSal);
        StringBuilder str = new StringBuilder();
        for(int i=0, j=0;i < X || j < Y;) {
            if (ansM[i].num < ansF[j].num) {str.append(ansM[i].num + " "); i++;}
            else {str.append(ansF[j].num + " "); j++;}
        }
        System.out.println(str.toString());
    }
}
