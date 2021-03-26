import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algorithm {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int array[] = new int[N+1];
		int dp[] = new int[N+1];
		int max = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= i; j++) {
				// �տ� �ڽź��� ���� ���ڰ� ������ dp[j]+1�� ���� ���� i �ε������� Ŭ�� dp[i] ����
				if (array[j] < array[i])
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			// ���� i �ε����� dp ���� max������ ũ�� max���� dp[i]�� ����
			max = Math.max(max, dp[i]);
		}

		// ������ �ִ� ���� + 1
		System.out.println(max+1);
	}
}