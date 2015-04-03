import java.util.Scanner;


public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        int z = in.nextInt();
        String str = in.next();

        int red = 0;
        int yel = 0;
        int blu = 0;

        for (int i = 0; i < str.length(); i++) {
            char curChar = str.charAt(i);
            if (curChar == 'R') red++;
            if (curChar == 'Y') yel++;
            if (curChar == 'B') blu++;
            if (ifVanish(x,y,z, red, yel, blu)) {
                red = 0;
                yel = 0;
                blu = 0;
            }
        }

        System.out.println(red + yel + blu);
    }

    public static boolean ifVanish(int x, int y, int z, int red, int yel, int blu) {
        int xy = Math.abs(red - yel);
        int xz = Math.abs(red - blu);
        int yz = Math.abs(yel - blu);

        if (max(x, y, z) == max(xy, xz, yz) && min(x, y, z) == min(xy, xz, yz) && (x+y+z) == (xy+xz+yz)) {
            return true;
        }
        return false;
    }

    public static int max(int a, int b, int c) {
        if (a > b) {
            if (a > c) return a;
            return c;
        } else {
            if (b > c) return b;
            return c;
        }
    }

    public static int min(int a, int b, int c) {
        if (a < b) {
            if (a < c) return a;
            return c;
        } else {
            if (b < c) return b;
            return c;
        }
    }
}
