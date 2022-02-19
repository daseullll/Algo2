
import java.util.Scanner;

public class Main_1024 {
	static int N,L;
	static int s,e;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		int sum = 0;
		int j = 0;
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<=N; i++) {
			sum += i;
			while(sum>N) {
				sum-=j;
				j = j+1;
			}
			if(sum==N && i-j+1>=L) {
				if(min>i-j+1) {
					s = j;
					e = i;
					min = i-j+1;
				}
				
				if(i-j+1==1) break;
			}
		}
		if(sum-s==N && (e-s+1)>L) {//정수 0이 필요없을 때 빼준다.
			s+=1;
		}
		
		if(e-s+1>100 || min==Integer.MAX_VALUE) {//길이가 100보다 크거나 그런 수가 없을 때
			System.out.println(-1);
		}else {
			for (int i = s; i <=e; i++) {
				System.out.print(i+" ");
			}
		}

	
	}

}
