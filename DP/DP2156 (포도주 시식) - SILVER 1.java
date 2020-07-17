import java.util.Scanner;

public class Main{
    public static void main(String args[]) {
    	Scanner scanner = new Scanner(System.in);
        
    	int X = scanner.nextInt(); //���� �� �޾ƿ�
    	int[] dp = new int[X+3];		//�迭 ����
    	int[] arr = new int[X+3];
    	
    	for(int i = 3; i<X+3;i++) {
    		arr[i] = scanner.nextInt();
    	}

        for (int i = 3; i < X+3; i++) {
            dp[i] = Math.max(dp[i-3] + arr[i-1] + arr[i], dp[i-2] + arr[i]);
            //dp[i] = Math.max(dp[i-1], dp[i]);
        }
    	
    	System.out.println(dp[X+2]);
	}
}
