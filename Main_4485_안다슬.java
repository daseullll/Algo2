import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main_4485_안다슬 {
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[] distance;
	static boolean[] visited;
	static Node[][] arr;
	static int N = -1;
	static int end;

	static class Node implements Comparable<Node> {
		int vertex, coin, r, c;

		public Node(int vertex, int coin, int r, int c) {
			super();
			this.vertex = vertex;
			this.coin = coin;
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(Node o) {
			return this.coin - o.coin;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = 1;
		while (true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if (N == 0)
				break;
			arr = new Node[N][N];
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = new Node((cnt++), Integer.parseInt(st.nextToken()),i,j);
				}
			}
			// --input end--
			distance = new int[N * N];
			visited = new boolean[N * N];
			end = N*N-1;
			
			Arrays.fill(distance, Integer.MAX_VALUE);
			go();
			sb.append("Problem "+(tc++)+": ");
			sb.append(distance[N*N-1]+"\n");
		}
		
		System.out.println(sb.toString());
	}

	public static void go() {

		int r = 0, c = 0;
		distance[0] = arr[r][c].coin;
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.offer(arr[r][c]);

		while (!pq.isEmpty()) {
			Node current = pq.poll();
			if (visited[current.vertex])
				continue;

			visited[current.vertex] = true;
			if(current.vertex==end) break;
			
			r = current.r;
			c = current.c;
			for (int dir = 0; dir < 4; dir++) {
				int nr = r + delta[dir][0];
				int nc = c + delta[dir][1];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[arr[nr][nc].vertex] == true)
					continue;
				if(distance[arr[nr][nc].vertex]> distance[current.vertex]+arr[nr][nc].coin) {
					distance[arr[nr][nc].vertex] = distance[current.vertex]+arr[nr][nc].coin;	
					pq.offer(new Node(arr[nr][nc].vertex, distance[arr[nr][nc].vertex],nr,nc));
				}
			}
		}
	}

	
}
