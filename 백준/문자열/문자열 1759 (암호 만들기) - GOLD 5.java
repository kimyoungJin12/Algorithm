import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Algorithm {	
	static char[] array;
	static int L, C;
	
	public static void main(String[] args) throws IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		array = new char[C];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < C; i++) {
			array[i] = st.nextToken().charAt(0);		
		}
		Arrays.sort(array);		
		
		IncreasedString("", 0);
	}
	
	private static void IncreasedString(String s, int index) {
        if(s.length() == L){ // ���̰� L�� �̰�
            if(isPossible(s)){ // �����ϳ��̻�, ���� 2���̻� ������
                System.out.println(s); // ���
            }
            return;
        }
        if(index >= C ){ // index ���� �ǳ��� ������ ����
            return;
        }        

       	IncreasedString(s + array[index], index + 1);// �ڱ��ڽŰ� ���� ���ڱ��� ����
        IncreasedString(s, index+ 1);// �ڱ��ڽŸ�
	}
	
	// ���� 2���̻�, ���� 1�� �̻�����
    private static boolean isPossible(String s){
        int vowel = 0, consonant = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if(isCollection(s.charAt(i))){
                vowel++;
            }else {
                consonant++;
            }
        }
        return vowel>=1 && consonant >=2;
    }
	
    // ��������
	private static boolean isCollection(char c) {
		if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
			return true;

		return false;
	}
}