import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_안다슬 {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V =  Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][N];
		
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			
			arr[from][to] = arr[to][from] = 1;
		} 
		
		dfs(arr,new boolean[N+1], V);
		System.out.println();
		bfs(arr,V);
	}
	
	public static void bfs(int[][] arr, int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current+" ");
			for(int j=1; j<=N; j++) {
				if(!(visited[j]) && arr[current-1][j-1]>0 ) {
				queue.offer(j);
				visited[j] = true;
				}
			}
		}
		
	}
	
	public static void dfs(int[][] arr, boolean[] visited, int current) {
		visited[current] = true;
		System.out.print(current+" ");
		
		for(int j=1; j<=N; j++) {
			if(!(visited[j]) && arr[current-1][j-1]>0 ) dfs(arr,visited,j);
			
		}
		
	}

}
