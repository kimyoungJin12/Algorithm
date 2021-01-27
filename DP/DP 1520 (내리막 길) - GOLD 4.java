import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Algorithm {
	private static int N, M;
	private static int[][] array, dp;
	
	public static void main(String[] args) throws Exception {
		SetData();
		System.out.println(bfs(0,0));
	}

	// ������
	private static void SetData() throws Exception {
		InputReader in = new InputReader(System.in);
		
        M = in.nextInt();
		N = in.nextInt();
		array = new int[M][N];
		dp = new int[M][N];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				array[i][j] = in.nextInt();
				dp[i][j] = -1;
			}
		}
		
	}

	// �޸� �ʰ������� �޸� ���̱� ����
	private static int[][] xy = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	
	// �޸� �ʰ� ������ bfs�� queue���� ��ͷ� �ٲ�
	private static int bfs(int a, int b) {
		// base case
		if (a == M - 1 && b == N - 1)	return 1;
		// �̹� ������ ���̸� return���� �ش� index�� ���� �������ش�. �̷��� �����ν� �Դ����� �����ʾƵ� ��.
		if(dp[a][b] != -1)	 return dp[a][b];
		dp[a][b] = 0;
		
		for (int[] direction : xy) {
			int r = a + direction[0];
			int c = b + direction[1];

			if (r >= 0 && c >= 0 && r < M && c < N) {
				// �۾��� ���� ��ͷ� ��
				if (array[a][b] > array[r][c]) {
					// ��͸� ���鼭 �ش� index ���⿡�� ������ ������ Ƚ���� �����ؼ� index�� �� ����
					dp[a][b] += bfs(r, c);
					
				}
			}
		}
		return dp[a][b];
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

	public String readString() {
		int c = read();
		while (isSpaceChar(c)) {
			c = read();
		}
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		} while (!isSpaceChar(c));
		return res.toString();
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