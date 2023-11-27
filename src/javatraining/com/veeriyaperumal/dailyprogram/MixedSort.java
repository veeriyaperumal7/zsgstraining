package javatraining.com.veeriyaperumal.dailyprogram;

import java.util.Arrays;
import java.util.Scanner;

//Even position ascending order odd position descending order
public class MixedSort {
	private int arr[];
	private static Scanner read;

	static {
		read = new Scanner(System.in);
	}

	public MixedSort(int length) {
		arr = new int[length];
	}

	private void getArrayInput() {
		System.out.print("Enter the array elements one by one : ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = read.nextInt();
		}
	}

	public static void main(String[] args) {
		System.out.print("Even index in ascending order and odd index in descending order.\nEnter the array length : ");
		MixedSort obj = new MixedSort(read.nextInt());
		obj.getArrayInput();
		obj.sortApproach1();
		System.out.println("Arrays sorted after odd index in descending \nand even index in ascending : "
				+ Arrays.toString(obj.arr));
	}

	private void sortApproach1() {// Sort the array and use extra space to sort in specific order.
									// Time O(log n + n) Space O(n).
		Arrays.sort(arr);
		int tempArray[] = new int[arr.length];
		int j = arr.length - 1, k = 0;
		for (int i = 0; i < j; i++, j--, k++) {
			tempArray[k++] = arr[i];
			tempArray[k] = arr[j];
		}
		if (arr.length % 2 != 0) {
			tempArray[k] = arr[j];
		}
		arr = tempArray;
	}

	private void sortApproach2() {// Sort the array and use extra space to sort in specific order.
									// Time O(log n + n) Space O(1).
		Arrays.sort(arr);
		int temp = 0;
		for (int i = 1; i < arr.length; i += 2) {
			temp = arr[arr.length - 1];
			shiftArrayValue(i);
			arr[i] = temp;
		}
	}

	private void shiftArrayValue(int i) {
		int j = arr.length - 1;
		while (j > i) {
			arr[j] = arr[j - 1];
			j--;
		}
	}

	private void sortApproach3() {// Sort the array and use extra space to sort in specific order.
									// Time O(log n + 2n) Space O(1).
		Arrays.sort(arr);
		int maxElement = arr[arr.length - 1] + 1, minIndex = 0, maxIndex = arr.length - 1, temp = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				arr[i] = arr[i] + arr[maxIndex] % maxElement * maxElement;
				maxIndex--;
			} else {
				arr[i] = arr[i] + arr[minIndex] % maxElement * maxElement;
				minIndex++;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] / maxElement;
			if (i % 2 != 0) {
				temp = arr[i];
				arr[i] = arr[i - 1];
				arr[i - 1] = temp;
			}
		}
	}

}
