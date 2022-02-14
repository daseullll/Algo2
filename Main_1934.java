import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1934 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			int limit = Math.min(A, B);
			int result = 0;
			for(int i=limit; i>0; i--) {
				if(A%i==0 && B%i==0) {
					//System.out.println("i:"+i);
					result = i * (A/i) * (B/i);
					break;
				}
			}
			
			sb.append(result+"\n");
			
			
		}
		System.out.println(sb.toString());
	}
}
