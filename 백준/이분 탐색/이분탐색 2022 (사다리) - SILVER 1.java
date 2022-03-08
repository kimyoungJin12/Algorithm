import java.io.*;
import java.util.*;

public class Main {
	static double x, y, c, answer;

	public static void main(String[] args) throws Exception {
		SetData();
		System.out.println(String.format("%.3f", answer));
	}

	private static void SetData() throws Exception {
		InputReader in = new InputReader(System.in);

		String[] s = in.nextLine().split(" ");
		x = Double.parseDouble(s[0]);
		y = Double.parseDouble(s[1]);
		c = Double.parseDouble(s[2]);

		double low = 0, high = Math.min(x, y);

		while (high - low > 0.000001) {
			double mid = (high + low) / 2.0;

			if (getC(mid) >= c) {
				answer = mid;
				low = mid;
			} else
				high = mid;

		}
	}

	private static double getC(double d) {
		double a = Math.sqrt(x * x - d * d);
		double b = Math.sqrt(y * y - d * d);
		return (a * b) / (a + b);
	}
}

class Node implements Comparable<Node> {
	int value;
	int absoluteValue;

	public Node(int value, int absoluteValue) {
		this.value = value;
		this.absoluteValue = absoluteValue;
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		if (this.absoluteValue == o.absoluteValue) {
			return this.value - o.value;
		} else {
			return this.absoluteValue - o.absoluteValue;
		}
	}
}

class InputReader {
	private final InputStream stream;
	private final byte[] buf = new byte[8192];
	private int curChar, snumChars;

	public InputReader(InputStream st) {
		this.stream = st;
	}

	public int read() {
		if (snumChars == -1)
			throw new InputMismatchException();
		if (curChar >= snumChars) {
			curChar = 0;
			try {
				snumChars = stream.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (snumChars <= 0)
				return -1;
		}
		return buf[curChar++];
	}

	public int nextInt() {
		int c = read();
		while (isSpaceChar(c)) {
			c = read();
		}
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		int res = 0;
		do {
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}

	public long nextLong() {
		int c = read();
		while (isSpaceChar(c)) {
			c = read();
		}
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		long res = 0;
		do {
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}

	public int[] nextIntArray(int n) {
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = nextInt();
		}
		return a;
	}

	public String nextLine() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		} while (!isEndOfLine(c));
		return res.toString();
	}

	public boolean isSpaceChar(int c) {
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}

	private boolean isEndOfLine(int c) {
		return c == '\n' || c == '\r' || c == -1;
	}
}