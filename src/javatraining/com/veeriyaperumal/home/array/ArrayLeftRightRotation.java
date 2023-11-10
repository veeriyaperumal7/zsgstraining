package javatraining.com.veeriyaperumal.home.array;
import java.util.Arrays;
import java.util.Scanner;


public class ArrayLeftRightRotation {
	private static int arr[];
	private static int rotationCount;

	private static void swapArrayElements(int start, int end) {
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

	private static void rotateArrayLeft() {
		Arrays.sort(arr);
		if (rotationCount > arr.length) {
			rotationCount = rotationCount % arr.length;
		}
		swapArrayElements(1, rotationCount);
		swapArrayElements(rotationCount + 1, arr.length);
		swapArrayElements(1, arr.length);
		System.out.print("\nArray after left rotation : ");
		printArray();
	}

	private static void rotateArrayRight() {
		Arrays.sort(arr);
		if (rotationCount > arr.length) {
			rotationCount = rotationCount % arr.length;
		}
		swapArrayElements(1, arr.length);
		swapArrayElements(1, rotationCount);
		swapArrayElements(rotationCount+1 , arr.length);
		System.out.print("\nArray after right rotation : ");
		printArray();
	}

	private static void printArray() {
		System.out.print(Arrays.toString(arr));
	}

	private static void getArrayInput() {
		System.out.print("Enter the length of the array : ");
		Scanner read = new Scanner(System.in);
		int length = read.nextInt();
		arr = new int[length];
		System.out.println("Enter the array elements one by one : ");
		for (int i = 0; i < length; i++) {
			arr[i] = read.nextInt();
		}
		System.out.print("Enter how many rotation : ");
		rotationCount = read.nextInt();
	}

	public static void myMain() {
		getArrayInput();
		System.out.print("Arrays Before swapping : ");
		printArray();
		rotateArrayLeft();
		rotateArrayRight();
	}
}
