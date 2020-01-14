package Sort;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] arr = { 7, 8, 9, 1, 2, 3, 4, 5, 6 };
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	static void quickSort(int[] arr, int start, int end) {
		if (start >= end) { // �迭�� ���Ұ� �Ѱ�
			return;
		}

		int i = start + 1;
		int j = end;
		int pivot = start;
		int temp;

		while (i <= j) { // ������ �� ���� �ݺ�
			while (i <= end && arr[i] <= arr[pivot]) { // �Ǻ������� ������ ��� i++
				i++;
			}

			while (j > start && arr[j] >= arr[pivot]) { // �Ǻ������� ũ�� ��� j--
				j--;
			}

			if (i > j) { // ��������
				temp = arr[j];
				arr[j] = arr[pivot];
				arr[pivot] = temp;

			} else { //�������� ������

				temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;

			}

		}
		
		quickSort(arr, start, j-1);
		quickSort(arr, j+1, end);

	}
}
