import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1992_안다슬 {
	static int[][] arr;
	static StringBuilder sb;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = line.charAt(j)-'0';
			}
		}
		divide(N,0,0);
		System.out.println(sb.toString());
	}

	public static void divide(int N, int r, int c) {
		
		//사각형의 값들을 압축할 수 있는지 확인함
		//압축할 수 있다면 숫자 저장
		if(check(N, r, c)) {
			sb.append(arr[r][c]);
			return;
		}
		
		// 재귀를 탈때마다 '('문자 추가
		sb.append("(");
		
		
		//왼쪽 위
		divide(N/2, r, c);
		//오른쪽 위
		divide(N/2, r,c+N/2);
		//왼쪽 아래
		divide(N/2, r+N/2, c);
		//오른쪽 아래
		divide(N/2, r+N/2, c+N/2);
		
		sb.append(')'); //4가지 경우를 모두 살펴봤으므로 닫아줌

	}
	
	//모두 값이 같은지 확인하는 메서드
	public static boolean check(int N, int r, int c) {
		int start = arr[r][c];
		
		for (int x = r; x < r + N; x++) { // 모두 탐색
			for (int y = c; y < c + N; y++) {
				if (start != arr[x][y]) { //다른 값이 있다면 false 리턴
					return false;
				}
			}
		}
		return true; //모두 같은 값
		
	}

}
