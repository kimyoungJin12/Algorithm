import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algorithm {
	static int n;
	static int[][] array, dp;
	static int[] x = { -1, 1, 0, 0 };
	static int[] y = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine());
		array = new int[n][n];
		dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(dfs(i, j), max);
            }
        }
        System.out.println(max);
    }
 
    static int dfs(int i, int j) {
        // basecase ������ ������ִ� dp ���� return
    	if(dp[i][j] != 0) {
            return dp[i][j];
        }
        
        int count = 1;
        for (int direction = 0; direction < 4; direction++) {
			int r = i + x[direction];
			int c = j + y[direction];
			
            if(r >= 0 && r < n && c >= 0 && c < n) {
                if(array[i][j] < array[r][c]) {
                    count = Math.max(dfs(r, c) + 1, count);
                    // ���� ū count ���� dp�� ����
                    dp[i][j] = count;
                }
            }
        }
        return count;
    }
}