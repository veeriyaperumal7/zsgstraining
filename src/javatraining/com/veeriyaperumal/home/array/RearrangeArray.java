package javatraining.com.veeriyaperumal.home.array;

import java.util.*;

public class RearrangeArray {
	static Scanner read;
	static int arr[];
	static {
		read = new Scanner(System.in);
	}

	private static void printRearrangeArray(int arr[]) {
		System.out.println("Before Rearranging array : " + Arrays.toString(arr));
		System.out.print("After Rearranging array : ");
		Arrays.sort(arr);
		int mid = arr.length / 2;
		if (arr.length % 2 == 0) {
			mid -= 1;
		}

		for (int i = 0; i <= mid; i++) {
			if (i == 0) {
				System.out.print(arr[mid] + " ");
				continue;
			}
			System.out.print(arr[mid + i] + " ");
			System.out.print(arr[mid - i] + " ");
		}
		if(arr.length%2==0) {  //For even length array. 
			System.out.print(arr[arr.length-1] + " ");
		}
	}

	private static void getInput() {
		System.out.print("Enter the length of the array : ");
		int n = read.nextInt();
		arr= new int[n];
		System.out.print("Enter the array elements one by one : ");
		for (int i = 0; i < n; i++) {
			arr[i] = read.nextInt();
		}
	}

	public static void myMain() {
		// TODO Auto-generated method stub
		getInput();
		printRearrangeArray(arr);
		
	}

}
