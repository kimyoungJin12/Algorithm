import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Algorithm {
    static int N, M;
    static int[][] array;
    static ArrayList<int[]> chickens;
    static ArrayList<int[]> houses;
    static Stack<int[]> selectedChicken;
    static int min;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[N + 1][N + 1];
        min = Integer.MAX_VALUE;
        chickens = new ArrayList<>();
        houses = new ArrayList<>();
        selectedChicken = new Stack<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());

                if (array[i][j] == 1) {
                	// ��
                    houses.add(new int[] {i, j});
                } else if (array[i][j] == 2) {
                    // ġŲ��
                    chickens.add(new int[] {i, j});
                }
            }
        }

        SelectChicken(0, 0);

        System.out.println(min);
    }

    static void SelectChicken(int start, int count) {
    	// Basecase
        if (count == M) {
            bfs();
            return;
        }

        // ���õ� ġŲ�� 3���� ���ϱ� ����.
        for (int i = start; i < chickens.size(); i++) {
        	selectedChicken.push(chickens.get(i));
            SelectChicken(i + 1, count + 1);
            selectedChicken.pop();
        }
    }

    static void bfs() {
        int sum = 0;
        for (int[] house : houses) {
            int tempMin = Integer.MAX_VALUE;
            
            // �ش� ġŲ�������� �ּ� ��� ���� ���� ����
            for (int[] chicken : selectedChicken) {
                int tempValue = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
                tempMin = Math.min(tempMin, tempValue);
            }
            sum += tempMin;

            // ��������� ���� ���Ϸ��� �ּҰ����� ũ�� �۾��� �� ���ص� �� => return
            if (sum > min) {
                return;
            }
        }
        min = Math.min(sum, min);
    }
}