package Algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
/*
 * ��ó���� ���θ� �������� �ʰ� ���
 * ���� ��ġ�ؼ� ���
 * 
 * ----------
 * ����ϴ� �κп��� ó���� Queue�� ��Ƽ� ��������� ���������µ�
 * �ð��ʰ����� �ٸ������ Ǯ�� �����ؼ� ǰ
 *
 */
public class Main16637_��ȣ�߰��ϱ� {
	private static int N,result;
	private static char[] oper;
	private static int[] number;
	private static boolean[] visited;
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	
    	number = new int[N/2 +1];
    	oper = new char[N/2];
    	visited = new boolean[N/2];
    	String str = br.readLine();
    	
    	int numberIdx = 0;
    	int operIdx = 0;    	
    	for (int i = 0; i < str.length(); i++) {
			if(i % 2 == 0) number[numberIdx++] = str.charAt(i) -'0';
			else oper[operIdx++] = str.charAt(i);
		}
    	
    	//��ȣ ����    	
    	result = Integer.MIN_VALUE;
    	select(0);
    	System.out.println(result);
    	
    }//end of main	
	private static void select(int idx) {
		if(idx >= oper.length) {
			process();
			return;
		}else {
			
			select(idx+1); // ��ȣ���� ���
			
			for (int i = idx; i < oper.length; i++) {
				if(i ==0 || (i -1 >= 0 && !visited[i-1])) {
					if(i== oper.length-1 || (i+1 < oper.length && !visited[i+1])) {
						visited[i] = true;
						select(idx+1);
						visited[i] = false;	
				}
					
				}
			}
			
			
		}
	}
	private static void process() {
		int[] newArr = number.clone();
		// ��ȣ ���� ���
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i])
				continue;

			int a = number[i];
			int b = number[i + 1];
			char c = oper[i];
			int num = cal(a, b, c);
			newArr[i] = num;
			newArr[i + 1] = num;
		}
		// ��ȣ ��� �� ������� ���
		for (int i = 0; i < visited.length; i++) {
			if (visited[i])
				newArr[i + 1] = newArr[i];
			else {
				int num = cal(newArr[i], newArr[i + 1], oper[i]);
				newArr[i + 1] = num;
			}

		}
		result = Math.max(result, newArr[newArr.length - 1]);
		
		//�ð��ʰ��� �ڵ�
		/*Queue<Integer> queue = new LinkedList<Integer>();
		int[] temp = new int[N/2];
		temp = number.clone();
		
		for (int i = 0; i < visited.length; i++) {
			if(visited[i]) {
				int num = cal(number[i], number[i+1], i);
				temp[i] = num;
				temp[i+1] = -1;
				queue.add(num);
			}else {
				if(temp[i] > 0)
				queue.add(temp[i]);
			}
		}
		if(temp[temp.length-1] >= 0) {
			queue.add(temp[temp.length-1]);
			
		}
		int tempResult=0;
		
		int num = queue.poll();
		while(!queue.isEmpty()) {
			
			for (int i = 0; i < visited.length; i++) {
				if(!visited[i]) {
					int reNum = cal(num, queue.poll(),i);
					num = reNum;
				}
			}
			
		}
		
		result = result < num ? num : result;*/
		
	}
	private static int cal(int a, int b, int c) {
		int result = 0;
		switch (c) {
		case '+':
			result = a + b;
			break;
		case '-':
			result = a - b;
			break;
		case '*':
			result = a * b;
			break;
		}
		return result;
	}
}//end of class