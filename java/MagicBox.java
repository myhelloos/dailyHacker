import java.util.Scanner;

class Box{
	private int x;
	private int y;
	private int z;
	int maxNum;
	private int cr, cb, cy;

	public Box(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.maxNum = this.cr = this.cy = this.cb = 0;
	}

	public int push(char c) {
		switch(c) {
		case 'R': this.cr++; break;
		case 'Y': this.cy++; break;
		case 'B': this.cb++; break;
		}
		vanish();
		return this.maxNum;
	}

	private void vanish() {
		int curNum = cr + cb + cy;
		if (curNum > maxNum) {
			maxNum = curNum;
		}
		int ry = Math.abs(cr - cy);
		int rb = Math.abs(cr - cb);
		int yb = Math.abs(cy - cb);
		if (max(x, y, z) == max(ry,  rb, yb) &&
				min(x, y, z) == min(ry, rb, yb) &&
				(x+y+z) == (ry+rb+yb)) {
			this.cr = this.cb = this.cy = 0;
		}
	}

	public int max(int a, int b, int c) {
		if (a > b) {
			return c > a? c : a;
		} else {
			return c > b? c : b;
		}
	}

	public int min(int a, int b, int c) {
		if (a < b) {
			return c < a? c : a;
		} else {
			return c < b? c : b;
		}
	}


}

public class MagicBox {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		int y = in.nextInt();
		int z = in.nextInt();
		String str = in.next();
		Box box = new Box(x, y, z);
		for (int i = 0; i < str.length(); i++) {
			box.push(str.charAt(i));
		}
		System.out.println(box.maxNum);
		in.close();
	}

}
