import java.util.Arrays;
import java.util.Scanner;

public class Main_17213 {
	static int[] input, fruit;
	static boolean[] visited;
	static int count;
	static int N,M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //과일의 종류
		M = sc.nextInt()-N; //훔치려는 과일 개수
		
		fruit = new int[M+1];
		for(int i=0; i<M+1; i++) {
			fruit[i] = i;
		}
		input = new int[N];
		
		comb(0,0,0);
		System.out.println(count);
	}
	
	public static void comb(int cnt, int start, int sum) {
		if(sum>M) return;
		if(cnt==N) {
//			int sum = 0;
//			for(int i=0; i<N; i++) {
//				sum += input[i];
//			}
			if(sum!=M) return;
			
//			for(int i=0; i<N; i++) {
//				System.out.println(Arrays.toString(input));
//			}
			count++;
			return;
		}
		
		for(int i=0; i<M+1; i++) {
			input[cnt] = fruit[i];
			comb(cnt+1, i, sum+i);
		}
	}

}
