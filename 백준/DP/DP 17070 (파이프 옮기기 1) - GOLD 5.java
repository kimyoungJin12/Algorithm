import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algorithm {	
	static int[][] array;
	static int N;
	static int count;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		array = new int[N+1][N+1];
		count = 0;
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				 array[i][j] = Integer.parseInt(st.nextToken());
			}
		}		
		
		RecurPipe(1, 2, 0);

		System.out.println(count);
    }
	
	private static void RecurPipe(int x, int y, int type) {
		if(x == N && y == N && array[x][y] != 1) {
			count++;
			return;
		}
		
		// ����
		if(type == 0) {
			// ������
			if(check(x, y+1) && array[x][y+1] == 0) 
				RecurPipe(x, y+1, 0);			
			// ������ �Ʒ� �밢��
			if(check(x+1, y+1) && array[x+1][y+1] == 0 && array[x+1][y] == 0 && array[x][y+1] == 0) 
				RecurPipe(x+1, y+1, 2); 
			
		} else if(type == 1) { // ����
			// ��
			if(check(x+1, y) && array[x+1][y] == 0) 
				RecurPipe(x+1, y, 1);			
			// ������ �Ʒ� �밢��
			if(check(x+1, y+1) && array[x+1][y+1] == 0 && array[x+1][y] == 0 && array[x][y+1] == 0) 
				RecurPipe(x+1, y+1, 2);
			
		} else if(type == 2) {	// �밢
			// ����
			if(check(x, y+1) && array[x][y+1] == 0) 
				RecurPipe(x, y+1, 0);			
			// ����
			if(check(x+1, y) && array[x+1][y] == 0) 
				RecurPipe(x+1,y, 1);			
			// �״�� �밢��
			if(check(x+1, y+1) && array[x+1][y+1] == 0) 
				RecurPipe(x+1,y+1,2);
		}
	}
	
	public static boolean check(int x, int y) {
		return x>=1 && x<=N && y>=1 && y<=N;
	}
}