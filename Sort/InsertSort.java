package test;

import java.util.Arrays;

public class InsertSort {
	public static void main(String[] args) {
		int[] arr = { 3, 7, 8, 2, 5, 6, 1, 9, 4 };

		for (int i = 1; i < arr.length; i++) {

			int standard = arr[i]; // ����

			int aux = i - 1; // ���� ���

			while (aux >= 0 && standard < arr[aux]) {

				arr[aux + 1] = arr[aux]; // �񱳴���� ū ��� ���������� �о

				aux--;

			}

			arr[aux + 1] = standard; // ���ذ� ����

		}
		System.out.println(Arrays.toString(arr));
	}// end of main
}// end of class
