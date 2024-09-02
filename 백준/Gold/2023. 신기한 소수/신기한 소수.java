import java.io.*;
import java.util.*;
public class Main {
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim()); // 자릿수를 입력받음
		dfs(0,N); // DFS탐색
	}

	private static void dfs(int V, int N) {
		// 자릿수를 다 채웠을 때, 현재 숫자 출력
		if(N==0) {
			System.out.println(V);
			return;
		}
		
		// 1부터 9까지 숫자를 다음 자릿수로 추가
		for(int i=1; i<=9; i++) {
			int temp = 10 * V + i; // 현재 숫자에 새로운 자릿수를 추가
			
			// 남은 자릿수가 있고 temp가 소수인 경우에만 계속 탐색
			if(N > 0 && isPrime(temp)) dfs(temp, N-1); // 자릿수를 하나 줄이고 재귀적으로 탐색
		}
		
	}
	
	// 소수 판별 
	// 소수란, 1과 자기 자신 이외의 자연수로는 나누어 떨어지지 않는 2 이상의 자연수
	private static boolean isPrime(int temp) {
		if(temp < 2) return false; // 2보다 작은 숫자(0or1)는 소수가 아니다
		
		for(int i=2; i*i <= temp; i++) { // 2부터 temp의 제곱근까지 나누어 떨어지는지 검사
			if(temp % i == 0) return false; // temp가 i의 배수이면 소수가 아니다
		}
		
		return true;
	}
}