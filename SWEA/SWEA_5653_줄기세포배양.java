import java.util.*;
import java.io.*;

public class SWEA_5653_줄기세포배양 {
	static int N,M,K;
	static boolean[][] visited; 
	static List<Cell> list; // 현재 상태 세포들을 임시로 저장하는 리스트
	static List<Cell> result; // 죽은 세포 제외하고 최종적으로 남은 세포들을 저장하는 리스트
	static Queue<Cell> queue;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for(int t=0; t<T; t++) { 
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken()); // 세로 크기
			M = Integer.parseInt(st.nextToken()); // 가로 크기
			K = Integer.parseInt(st.nextToken()); // 시간
			
			visited = new boolean[N + K * 2][M + K * 2];
			result = new ArrayList<Cell>(); 
			queue = new PriorityQueue<>((a, b) -> b.life - a.life); // 생명력이 높은 세포가 우선되는 큐 (내림차순)
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for(int j=0; j<M; j++) {
					int life = Integer.parseInt(st.nextToken());
					
					if(life==0) continue;
					
					int row = i + K; int col = j + K;
					queue.offer(new Cell(row, col, life, life, 0)); // 세포를 큐에 추가
					visited[row][col] = true;
				}
			}
			
			update();
			sb.append("#").append(t+1).append(" ").append(result.size()).append("\n");
			
		} // end testcase
		
		bw.write(sb.toString());  bw.close(); br.close();
		
	} // end main
	
		private static void breed(Cell cell) {
		for(int k=0; k<4; k++) {
			int nr = cell.row + dr[k]; int nc = cell.col + dc[k];
			
			if(!visited[nr][nc]) {
				visited[nr][nc] = true;
				list.add(new Cell(nr,nc,cell.life,cell.life,0));
			}
		}
	} 
	
	private static void update() {
		for(int t = 0; t < K ; t++) { // K시간 동안 반복
			
			list = new ArrayList<Cell>();  // 현재 시간에 활성화 및 비활성화된 세포 저장
			
			while(!queue.isEmpty()) {
				Cell cell = queue.poll();
				
				if(cell.state == 0) { //비활성 상태라면
					cell.time -= 1; // 활성화까지 남은 시간 1 감소
					
					if(cell.time == 0) { // 활성화 시간이 되면
						cell.state = 1; // 상태 변경
						cell.time = cell.life; // 활성 상태에서 남은 시간 초기화
					}
					list.add(cell); // 세포 리스트에 추가
					
				} else if (cell.state == 1) { // 활성 상태라면
					if(cell.time == cell.life) { // 활성 상태 첫 시간이라면 번식
						breed(cell); // 번식
					}
					
					cell.time -= 1; // 활성 상태 시간 감소
					if(cell.time == 0) cell.state = 2; // 활성 상태에서 남은 시간이 0이 되면 죽음 상태로 변경
					
					list.add(cell); // 세포 리스트에 추가
				}
			} // end while
			
			for(int i=0; i<list.size(); i++) queue.offer(list.get(i)); // 현재 시간에 업데이트된 세포들을 큐에 추가
		} // end for
		
		result = new ArrayList<Cell>(); // 최종적으로 큐에 남은 세포들을 결과 리스트에 저장
		for(Cell c : queue) {
			if(c.state != 2) result.add(c); // 죽지 않은 세포들만 저장
		}
	}

}// end class

class Cell {
	int row, col, life, time, state;

	public Cell(int row, int col, int life, int time, int state) {
		super();
		this.row = row; // 세포의 행 좌표
		this.col = col; // 세포의 열 좌표
		this.life = life;  // 생명력
		this.time = time;  // 현재 상태에서 남은 시간
		this.state = state; // 세포 상태 ( 0: 비활성 / 1: 활성 / 2: 죽음 )
	}
	
	
}
