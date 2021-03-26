import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Algorithm {	
	
	public static void main(String[] args) throws IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		int n = s.length(), max = 0;
		
		for(int i = 0; i < n; i++) 
			max = Math.max(max, KMP(s.substring(i, n)));
		
		System.out.println(max);
	}

	// KMP �˰��� - pi[] �迭���� �־��� ���ڿ��� �ε��� 0���� i������ �κ� ���ڿ� ��
	// ���λ� == ���̻簡 �Ǵ� ���� �� ���λ��� ���̸� �ִ´�.
	// ���� �� �ڵ忡�� ���λ�� j(����), ���̻�� i(������)�̴�.
	static int KMP(String s) {
		// j ���λ�
		int j = 0, n = s.length(), max = 0;
		int pi[] = new int[n];
		
		// i ���̻�
		for(int i = 1; i < n; i++) {
			while(j > 0 && s.charAt(i) != s.charAt(j)) 
				j = pi[j-1];
			
			if(s.charAt(i) == s.charAt(j)) 
				max = Math.max(max, pi[i] = ++j);
		}
		return max;
	}
}