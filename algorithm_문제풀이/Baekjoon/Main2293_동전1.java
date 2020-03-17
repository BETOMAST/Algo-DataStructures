package Algo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



/*
 *  ó���� dfs�� k�� ������ �ٴϸ鼭 ���� �ε������� ���༭ count == 0 �̸� result�� �ϳ��� �߰����ְ�
 *  0���� ������ return; ���༭ ������ ���� ���� value[idx+1]���� ���༭ result�� ���������� ����ߴµ� 
 *  12%���� �ð��ʰ�
 * 	�׷��� �ٸ� ������� Ǯ���� 
 *  dp[0] = 1�� ������ Ȯ������ �ƹ��͵� �������� �ʾ��� �� 1�� �����ϴ� �Ͱ� ���� �ǹ�
 *  
 *  ���ÿ��� value = [1, 2, 5] , k = 10;
 *  1���� ����ϴ� ���   
 *  1�� 2�� 3�� 4�� 5�� 6�� ----- 10�� ==> ��� 1������
 *    
 *  1,2���� ����ϴ� ��� ǥ�� �׷��� ������ dp[j] += dp[j-value[i]] ��� ��ȭ���� ���ɴϴ�. *  
 * 
 */


public class Main2293_����1 {
	private static int n,k, result;
	private static int[] value;
	private static int[] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n =Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		value = new int[n];
		
		for (int i = 0; i < value.length; i++) {
			value[i] = Integer.parseInt(br.readLine());
		}
		
		dp = new int[k+1];
		dp[0] = 1;
		result = 0;
		
		for (int i = 0; i < value.length; i++) {
			for (int j = value[i] ; j <=k ; j++) {
				dp[j] += dp[j-value[i]];
			}			
		}
		
//		dfs(0, k);
		
		System.out.println(dp[k]);
		
	}//end of main
	private static void dfs(int idx, int count) {
		// TODO Auto-generated method stub
		if(idx >= n ) return;
		if(count < 0) return;
		if(count == 0) {
			result++;
			return;
		}
		
		dfs(idx, count - value[idx]);
		dfs(idx+1, count);
	}
}//end of class
