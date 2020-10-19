import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] array;
	static int N, M, L;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		array = new int[N + 2];
		array[0] = 0;
		array[N + 1] = L;

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(array);

		System.out.println(BinarySearch(0, L-1));
	}

	private static int BinarySearch(int left, int right) {
		while (left <= right) {
			int mid = (left + right) / 2;
			int sum = 0;

			for (int i = 1; i < N + 2; i++) {
				if (array[i] > array[i - 1])
					// �� ������ ���̿� ���� �� �ִ� ������ ��
					sum += (array[i] - array[i - 1] - 1) / mid;
			}

			// �������� ������ ���� �� ���� ����� ������ �ø���.
			if (sum > M)
				left = mid + 1;
			else	// �� ���� ����� ������ ���δ�.
				right = mid - 1;
		}

		return left;
	}
}
