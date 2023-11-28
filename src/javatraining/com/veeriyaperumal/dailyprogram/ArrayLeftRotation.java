package javatraining.com.veeriyaperumal.dailyprogram;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayLeftRotation {
	private int arr[];
	private int rotationCount;

	public int getRotationCount() {
		return rotationCount;
	}

	public void setRotationCount(int rotationCount) {
		this.rotationCount = rotationCount;
	}

	public ArrayLeftRotation(int length) {
		this.arr = new int[length];
	}

	private void swapArrayElements(int start, int end) {
		start--;
		end--;
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	private void rotateArrayLeftApproach1() { // Approach 1 work bases on swapping the array values.
												// Optimized approach.O(n)time and O(1)space complexity.

		setRotationCount(getRotationCount() % arr.length);// To avoid unwanted rotation.
		swapArrayElements(1, getRotationCount());
		swapArrayElements(getRotationCount() + 1, arr.length);
		swapArrayElements(1, arr.length);
		System.out.print("\nArray after left rotation : ");
		printArray();
	}

	private void rotateArrayLeftApproach2() { // Approach 2 work bases on shifting the array values.
												// O(n*rotationCount)time and O(1)space complexity.
		int temp = 0;
		setRotationCount(getRotationCount() % arr.length);// To avoid unwanted rotation.
		while (rotationCount > 0) {
			temp = arr[0];
			for (int i = 0; i < arr.length - 1; i++) {
				arr[i] = arr[i + 1];
			}
			arr[arr.length - 1] = temp;
			rotationCount--;
		}
		System.out.print("\nArray after left rotation : ");
		printArray();
	}

	private void rotateArrayLeftApproach3() { // Approach 3 work bases on take one extra array and put value by based on
												// rotationCount.
												// O(n)time and O(n)space complexity.
		int index, i = 0;
		int resultArray[] = new int[arr.length];
		setRotationCount(getRotationCount() % arr.length);// To avoid unwanted rotation.
		index = getRotationCount();
		if (index != 0) {
			while (i < resultArray.length) {
				resultArray[i] = arr[index++];
				i++;
				if (index == arr.length) {
					index = 0;
				}
			}
			arr = resultArray;
		}
		System.out.print("\nArray after left rotation : ");
		printArray();
	}

	private void printArray() {
		System.out.print(Arrays.toString(arr));
	}

	public static void main(String[] args) {
		int n;
		Scanner read = new Scanner(System.in);
		System.out.print("Enter the length of the array : ");
		n = read.nextInt();
		ArrayLeftRotation obj = new ArrayLeftRotation(n);
		System.out.print("Enter the array elements one by one : ");
		for (int i = 0; i < n; i++) {
			obj.arr[i] = read.nextInt();
		}
		System.out.print("Enter the rotation count : ");
		obj.setRotationCount(read.nextInt());
		obj.rotateArrayLeftApproach1();

	}
}
