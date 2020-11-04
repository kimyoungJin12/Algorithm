import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
        int N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> preBuildingNumber = new ArrayList<>();
 
        for (int i = 0; i <= N; i++) {
            preBuildingNumber.add(new ArrayList<>());
        }
 
        int[] indegree = new int[N + 1]; // Ư�� �ǹ��� ���� ���� ���� ����� �� �ǹ��� ����
        int[] times = new int[N + 1]; // Ư�� �ǹ��� ���� �� �ɸ��� �ð�
 
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
 
            times[i] = Integer.parseInt(st.nextToken());	// �ش� �ǹ��� ���� ���� �ð�
            while (true) {
                int preBuildingNumberTemp = Integer.parseInt(st.nextToken());
 
                if (preBuildingNumberTemp == -1)
                    break;
 
                preBuildingNumber.get(preBuildingNumberTemp).add(i);
 
                indegree[i]++;		// �ش� �ǹ��� ���� �� ����� �� �ǹ��� ���� �����ش�.
            }
        }
 
        String timeForBuilding = topologicalSort(preBuildingNumber, indegree, times, N);
 
        System.out.print(timeForBuilding);

    }
    
    // ���� ����
    public static String topologicalSort(ArrayList<ArrayList<Integer>> a, int[] indegree, int[] times, int N) {
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        
        // ���� ������� �ǹ��� ���� �ǹ��� ť�� ���� ����. �ش� ť�� �ִ� �ǹ��� ���� ���´�.
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        // Ư�� �ǹ��� ���� ������ �ɸ� �ð� ����
        int[] result = new int[N + 1];
 
        while (!queue.isEmpty()) {
            int now = queue.poll();
 
            for (int next : a.get(now)) {
                indegree[next]--;
                
                // next �ǹ��� ���� ������ �ɸ� �ð� ���.
                result[next] = Math.max(result[next], result[now] + times[now]);
 
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        
        // Ư�� �ǹ��� ���� �� ���� ������� �ǹ��� �ð� + Ư�� �ǹ��� ���� �ð�
        for (int i = 1; i <= N; i++) {
            sb.append((result[i] + times[i]) + "\n");
        }
 
        return sb.toString();
    }
}