import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {	
	static String firstString, secondString;
	static int pi[];
	
	public static void main(String[] args) throws IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		firstString = br.readLine();
		secondString = br.readLine();
		pi = new int[secondString.length()];
				
		System.out.println(KMP());
	}

	// KMP �˰��� - pi[] �迭���� �־��� ���ڿ��� �ε��� 0���� i������ �κ� ���ڿ� ��
	// ���λ� == ���̻簡 �Ǵ� ���� �� ���λ��� ���̸� �ִ´�.
	// ���� �� �ڵ忡�� ���λ�� j(����), ���̻�� i(������)�̴�.
	static int KMP() {
		// j ���λ�
		int j = 0;
		
		// i ���̻�
	    for (int i = 1; i < secondString.length(); ++i) {
	        while (j > 0 && secondString.charAt(i) != secondString.charAt(j)) j = pi[j - 1];
	        if (secondString.charAt(i) == secondString.charAt(j)) pi[i] = ++j;
	    }
	    
	    j = 0;
	    for (int i = 0; i < firstString.length(); ++i) {
            if(firstString.charAt(i)>='0' && firstString.charAt(i)<='9') continue;
	        while (j > 0 && firstString.charAt(i) != secondString.charAt(j)) j = pi[j - 1];
	        if (firstString.charAt(i) == secondString.charAt(j)) {
	            if (j == secondString.length() - 1) {
	                return 1;
	            }
	            else ++j;
	        }
	    }
	    return 0;
	}
}