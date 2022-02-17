import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1247_안다슬 {
	static int N, min, sum;
	static int[][] map;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N+2][2]; //출발 좌표랑 도착지까지 함께 저장해 줄 배열 
			visited = new boolean[N+2];
			min = Integer.MAX_VALUE;
			sum = 0;
			//초기화 끝
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N + 2; i++) {
				map[i][0] = Integer.parseInt(st.nextToken()); // x좌표
				map[i][1] = Integer.parseInt(st.nextToken()); // y좌표
			}

			// ----input end
			sb.append("#"+tc+" ");
			dfs(0,0,0);
			sb.append(min);
			sb.append("\n");
			
		}
		System.out.println(sb.toString());

	}
	
	/**
	 * @param r : 좌표 정보들이 저장 되어 있는 배열의 행 값
	 * @param cnt : 몇번을 건너갔는지 카운트
	 * @param current : 현재까지 온 거리 총 합
	 */
	public static void dfs(int r, int cnt, int current) {
		
		if(cnt==N+1) { //도착지 전까지 왔을 경우 
			int temp = d(map[r][0],map[r][1],map[1][0],map[1][1]); //마지막 좌표와 도착지 좌표 거리 계산
			min = Math.min(temp+current, min); //현재의 최솟값보다 작다면 바꿔주기
			return;
		}
		
		for(int i=2; i<N+2; i++) { //좌표가 저장된 배열의 첫번째 행과 두번째행은 출발지와 도착지이므로 2부터 시작
			if(visited[r]==true) continue; //이미 사용했던 좌표면 건너감
			visited[r] = true;
			int temp = d(map[r][0],map[r][1],map[i][0],map[i][1]);
			dfs(i,cnt+1, current+temp); //다음으로 계속 타고 들어가면서 거리누적 값 계속 전달
			visited[r] = false;
		}
		
	}

	//거리 계산 함수
	public static int d(int x1, int y1, int x2, int y2) {
		int distance = Math.abs(x1 - x2) + Math.abs(y1 - y2);
		return distance;
	}

}
