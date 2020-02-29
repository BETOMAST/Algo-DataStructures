package Algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17471_�Ը������ {
	private static int N, ans;
	private static int[][] area;
	private static int[] population;
	private static boolean[] visited;
	private static int[] set;
	private static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		population = new int[N];
		visited = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < population.length; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}

		area = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int t = Integer.parseInt(st.nextToken());
			for (int j = 0; j < t; j++) {
				int connect = Integer.parseInt(st.nextToken());
				area[i][connect - 1] = 1;
				area[connect - 1][i] = 1;

			}
		}
		
		//���� ���������°�
		arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		

		for (int i = 1; i <= N-1; i++) {
			set = new int[i];
			combi(i, 0 , 0);
		}

	}// end of main
	private static void combi(int count, int idx , int k) {
		if(idx == count) {
			boolean flag = check();
			if(flag) process();
			return;
		}
		
		for (int i = k; i < arr.length; i++) {
			set[idx] = arr[i];
			visited[i] = true;
			combi(count , idx +1, i+1);
			visited[i] = false;
		}
		
		
	}
	//�ΰ��� ���������ٸ� �α����� �ּ� ���ϱ�
	private static void process() {
	
		
	}
	
	//������ �ΰ��� ������������ ���ߴ��� Ȯ��
	private static boolean check() {
		// TODO Auto-generated method stub
		//A ����
		boolean aCheck = false;
		int startIdx = set[0];
		int setIdx = 0;
		while(setIdx != set.length) {
			
			if(set.length == 1) {
				aCheck = true;
				break;
			}
			
			
			for (int i = 0; i < N; i++) {
				if(area[startIdx][i] == 1) {
					if(visited[i]) {
						startIdx = i;
						aCheck = true;
						break;
					}
				}
			}			
			setIdx++;
		}
		
		if(!aCheck) return false;
		
		
			
		//B ����
		
		return false;
	}

}// end of class
