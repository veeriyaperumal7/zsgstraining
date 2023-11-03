package javatraining.com.veeriyaperumal.home.array;

import java.util.*;

public class MatrixMultiplication {
	static Scanner read;
	static {
		read = new Scanner(System.in);
	}

	private static void getInput(int matrix[][]) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = read.nextInt();
			}
		}
	}

	public static void myMain() {
		int row1, row2, column1, column2;
		System.out.print("Enter the first matrix rows count : ");
		row1 = read.nextInt();
		System.out.print("Enter the first matrix columns count : ");
		column1 = read.nextInt();
		System.out.print("Enter the second matrix rows count : ");
		row2 = read.nextInt();
		System.out.print("Enter the second matrix columns count : ");
		column2 = read.nextInt();
		if (row1 < 1 || row2 < 1 || column1 < 1 || column2 < 1) {
			System.out.println("Rows and columns value must be greater than or equal to 1");
			return;
		}
		if(column1!=row2) {
			System.out.println("Rules not meet : \n The number of columns in the first matrix has to equal the number of rows in the second matrix.");
		return ;
		}
		int matrix1[][] = new int[row1][column1];
		int matrix2[][] = new int[row2][column2];
		int matrix3[][] = new int[row2][column2];
		System.out.print("Enter first matrix input row by row :");
		getInput(matrix1);
		System.out.print("Enter second matrix input row by row :");
		getInput(matrix2);
		multiplyMatrix(matrix1, matrix2, matrix3);
		System.out.println("Matrix 1: ");
		for(int[] arr : matrix1) {
			System.out.println(Arrays.toString(arr));
		}
		System.out.println("Matrix 2: ");
		for(int[] arr : matrix2) {
			System.out.println(Arrays.toString(arr));
		}
		System.out.println("Matrix 1 * Matrix 2 : ");
		for(int[] arr : matrix3) {
			System.out.println(Arrays.toString(arr));
		}
	}

	private static void multiplyMatrix(int[][] matrix1, int[][] matrix2, int[][] matrix3) {
		for(int row3=0;row3<matrix3.length;row3++) {
			for(int column3=0;column3<matrix3[row3].length;column3++) {
				int sum=0;
				for(int i=0;i<matrix1[0].length;i++) {
					sum+=matrix1[row3][i]*matrix2[i][column3];
				}
				matrix3[row3][column3]=sum;
			}
		}
	}

}
