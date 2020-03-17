package Algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main13458_���谨�� {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] room = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < room.length; i++) {
			room[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		int totalDirector = Integer.parseInt(st.nextToken());
		int subDirector = Integer.parseInt(st.nextToken());
		long result = 0;
		for (int i = 0; i < room.length; i++) {
			result++; // ������ �����忡 �Ѱ������� ���� 1��
			int value = room[i] - totalDirector;
			if (value <= 0) { // 0���� ������ ��� ������ �� ����
				continue;
			} else { // ��� ������ �� ���� �� �ΰ��������� ��ü

				if (value / subDirector == 0) {
					result++;
				} else if (value / subDirector >= 1) {					

					if (value % subDirector != 0) {
						result++;
						result += (value / subDirector);
					} else {
						result += (value / subDirector);
					}

				}

			}
		}
		System.out.println(result);
	}// end of main
}// end of class
