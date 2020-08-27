import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algorithm {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String firstInput = br.readLine();
		String secondInput = br.readLine();

		int[][] dp = new int[firstInput.length() + 1][secondInput.length() + 1]; // �� ���ڿ��� ���̸�ŭ ����
		// �����ؾ� �� ���� ������ �������� ������ �������� ���� �� ������ �°� �������־�� �Ѵ�.
		// ���⼱ b�� �������� a�� ���ϰ� �ȴ�.

		for (int i = 1; i <= firstInput.length(); i++) { 
			for (int j = 1; j <= secondInput.length(); j++) { 
				if (firstInput.charAt(i - 1) == secondInput.charAt(j - 1)) { 
					dp[i][j] = dp[i - 1][j - 1] + 1; // ��ȭ��
				} else { 
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]); // ��ȭ��					
				}
			}
		}

		System.out.println(dp[firstInput.length()][secondInput.length()]); // �̰� ���� ����� �Ȱ��� ������־�� ��Ÿ�� ������ ���� �ʴ´�.

	}
}
