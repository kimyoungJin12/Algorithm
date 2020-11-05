import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algorithm {
	static int N,M, minMemory;
	static int[] usingByteOfMemory, disabledByteOfMemory, dp;

	public static void main(String[] args) throws Exception {
		SetData();	
		minMemory = ReturnMinMemory();
		System.out.println(minMemory);
	}

	// ������
	private static void SetData() throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		usingByteOfMemory = new int[N];
		disabledByteOfMemory = new int[N];
		dp = new int[10001];
		Arrays.fill(dp, -1);
		minMemory = Integer.MAX_VALUE;
		
		st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			usingByteOfMemory[i] = Integer.parseInt(st.nextToken());
			disabledByteOfMemory[i] = Integer.parseInt(st2.nextToken());
		}
	}
	
	private static int ReturnMinMemory() {		
		
		// dp[i]: i cost�� �Ἥ Ȯ���� �� �ִ� �ִ� �޸�
		for(int i=0; i<N; i++){
			int cost = disabledByteOfMemory[i];
			// �ڿ��� ���� Ȯ���ؾ� ��ġ�� �ʰ� ���� update �� �� �ִ�.
			for(int j=10000; j>=cost; j--){
				if(dp[j-cost] != -1){
					// ���� j-cost ������ �ִ� ���� ���� memory�� ���ϴ°� �� ũ�ٸ� update
					if(dp[j-cost] + usingByteOfMemory[i] > dp[j])
						dp[j] = dp[j-cost] + usingByteOfMemory[i];
				}
			}
			// �޸� ������Ʈ�� �ȵǾ��ִ� ��� ������Ʈ
			// �� �޸𸮰� �� ū ��쿡�� ������Ʈ ����
			if(dp[cost] < usingByteOfMemory[i]) dp[cost] = usingByteOfMemory[i];
		}

		for(int i=0; i<10001; i++){
			// �ּ� �޸� return
			if(dp[i] >= M){
				return i;
			}
		}
		return 0;
	}
}