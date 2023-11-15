package javatraining.com.veeriyaperumal.home.patternprinting;

import java.util.*;

public class AllPatternAndPyramidProgram {

	private static void printPattern1(int length) {
		for (int row = 1; row <= length; row++) {
			for (int column = 1; column <= length; column++) {
				if (row == 1) {
					System.out.print("*");
				} else {
					if (row == column || column == length) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}
	}

	private static void printPattern2(int length) {
		for (int row = 1; row <= length; row++) {
			for (int column = 1; column <= length; column++) {
				if (row == 1) {
					System.out.print("*");
				} else {
					if (column == 1 || column == length - (row - 1)) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}
	}

	private static void printPattern3(int length) {
		for (int row = 1; row <= length; row++) {
			for (int column = 1; column <= length * 2 - 1; column++) {
				if (row == 1) {
					System.out.print("*");
				} else {
					if (column == row || column == (length * 2 - 1) - (row - 1)) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}
	}

	private static void printPattern4(int length) {
		for (int row = 1; row <= length; row++) {
			for (int column = 1; column <= length * 2 - 1; column++) {
				if (row == length) {
					System.out.print("*");
				} else {
					if (column == (length + 1) - row || column == (length - 1) + row) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}
	}

	private static void printPattern5(int length) {
		for (int row = 0; row < length; row++) {
			for (int column = 1; column <= length + row; column++) {
				if (row == 0) {
					System.out.print("*");
				} else {
					if (column == row || column == length + row || row == length - 1 && column >= row) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}
	}

	private static void printPattern6(int length) {
		for (int row = 1; row <= length; row++) {
			for (int space = 1; space <= length - row; space++) {
				System.out.print(" ");
			}
			for (int column = 1; column <= length; column++) {
				if (row == 1 || row == length) {
					System.out.print("*");
				} else {
					if (column == 1 || column == length) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}
	}

	private static void printPattern7(int length) {
		for (int row = 1; row <= length * 2; row++) {
			int columnEnd = (row <= length) ? row : length - (row - length);
			/*
			 * For first half of the pattern true part value will be assigned. For second
			 * half of the pattern false part value will be assigned. Because row value will
			 * be goes to length * 2 on that case row will be greater than length,so we need
			 * to handle that part row based value when we used.
			 */
			for (int column = 1; column <= columnEnd; column++) {
				if (column == 1 || column == columnEnd) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	private static void printPattern8(int length) {
		for (int row = 1; row <= length * 2; row++) {
			int columnEnd = (row <= length) ? row : length - (row - length);
			/*
			 * For first half of the pattern true part value will be assigned. For second
			 * half of the pattern false part value will be assigned. Because row value will
			 * be goes to length * 2 on that case row will be greater than length,so we need
			 * to handle that part row based value when we used.
			 */
			for (int space = 1; space <= length - columnEnd; space++) {
				System.out.print(" ");
			}
			for (int column = 1; column <= columnEnd; column++) {
				if (column == 1 || column == columnEnd) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	private static void printPattern9(int length) {
		for (int row = 1; row <= length * 2; row++) {
			int columnEnd = (row <= length) ? row * 2 - 1 : ((length - (row - length)) * 2 - 1);
			/*
			 * For first half of the pattern true part value will be assigned. For second
			 * half of the pattern false part value will be assigned. Because row value will
			 * be goes to length * 2 on that case row will be greater than length,so we need
			 * to handle that part row based value when we used.Below space logic also
			 * worked like columnEnd logic.
			 */

			int spaceLength = (row <= length) ? length - row : length - (length - (row - length));
			for (int space = 1; space <= spaceLength; space++) {
				System.out.print(" ");
			}
			for (int column = 1; column <= columnEnd; column++) {
				if (column == 1 || column == columnEnd) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	private static void printPattern10(int length) {
		int left = length * 2 / 2, right = (length * 2 / 2) + 1;// left and right pointer sets
		for (int row = 1; row <= length * 2; row++) {
			for (int column = 1; column <= length * 2; column++) {
				if (column <= left || column >= right) {// print the values before the left and
														// after the right pointer.
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			if (row < length) {// First half of the pattern pointer increment,decrement happened.
				left--;
				right++;
			} else {
				if (row != length) {// For check mid of the pattern reached or not reached.
					left++;
					right--;
				} else {// Set the values to pointer for next below half will be print.
					left = 1;
					right = length * 2;
				}
			}
			System.out.println();
		}

	}

	private static void printPattern11(int length) {
		for (int row = 1; row <= length; row++) {
			for (int column = 1; column <= length; column++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void printPattern12(int length) {
		for (int row = 1; row <= length; row++) {
			for (int column = 1; column <= length; column++) {
				if (column == 1 || column == length || row == 1 || row == length) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	private static void printPattern13(int length) {
		for (int left = 1; left <= length * 2 - 1; left++) {
			int end = (left <= length) ? (length - left) + 1 : ((left + 1) - length);// Define the end of the column by
																						// rows value.
			for (int space = 1; space <= length - end; space++) {
				System.out.print(" ");
			}
			for (int right = 1; right <= end; right++) {
				if (left == 1 || left == length * 2 - 1) { // First and last row full column print
					System.out.print("* ");
					continue;
				}
				if (right == 1 || right == end) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}

	private static void printPattern14(int length) {
		for (int left = 1, right = length * 2; left <= length * 2; left++, right--) {
			if (right + 1 == left) {// To avoid mid line printing two times
				continue;
			}
			for (int column = 1; column <= length * 2; column++) {
				if (left <= length) { // For printing above half block
					if (column <= left || column >= right) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				} else {
					if (column <= right || column >= left) { // For printing below half block
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}

			}
			System.out.println();
		}
	}

	private static void printPyramid1(int length) {
		for (int row = 1; row <= length; row++) {
			for (int column = 1; column <= length; column++) {
				if (column > length - row) {// Define a start point of the row
					System.out.print(row + " ");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	private static void printPyramid2(int length) {
		for (int row = length; row >= 1; row--) {
			for (int column = 1; column <= length; column++) {
				if (column > length - row) {// Define a start point of the row
					System.out.print(row + " ");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	private static void printPyramid3(int length) {
		for (int i = length; i >= 1; i--) {
			for (int column = 1; column <= length; column++) {
				if (column > length - i) {// Define start point of the row
					System.out.print("* ");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	private static void printPyramid4(int length) {
		for (int row = length; row >= 1; row--) {
			for (int column = 1; column <= length * 2; column++) {
				if (column >= row) { // For define start point of the row
					if (column <= length) {// Divide the the two part of row
						System.out.print(column + " ");
					} else {
						if (length - (column - length) >= row) {// print the second part of the row
							System.out.print(length - (column - length) + " ");
						} else {
							break;
						}
					}
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}

	private static void printPyramid5(int length) {
		for (int row = 1; row <= length; row++) {
			int count = 1;
			for (int column = 1; column <= length * 2 - 1; column++) {
				if (column > length - row) { // For define start point of the row
					if (column <= length) { // Divide the the two part
						System.out.print(count + " ");
						count = (column != length) ? count + 1 : count;// After reach mid of the pattern row no need to
																		// increment
					} else {
						count--;
						if (column - length < row) {// print the second part of the row
							System.out.print(count + " ");
						} else {
							break;
						}
					}
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}

	private static void printPyramid6(int length) {
		for (int row = 1; row <= length; row++) {
			for (int space = 1; space <= length - row; space++) {
				System.out.print(" ");
			}
			for (int column = 1; column <= row; column++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	private static void printPyramid7(int length) {
		for (int row = 1; row <= length; row++) {
			for (int space = 1; space <= length - row; space++) {
				System.out.print(" ");
			}
			for (int column = 1; column <= row; column++) {
				System.out.print(column + " ");
			}
			System.out.println();
		}
	}

	private static void printAllPattern(int n) {
		// Call all pattern print method.
		System.out.println("\n==========================================================================\n");
		printPattern1(n);
		System.out.println("\n==========================================================================\n");
		printPattern2(n);
		System.out.println("\n==========================================================================\n");
		printPattern3(n);
		System.out.println("\n==========================================================================\n");
		printPattern4(n);
		System.out.println("\n==========================================================================\n");
		printPattern5(n);
		System.out.println("\n==========================================================================\n");
		printPattern6(n);
		System.out.println("\n==========================================================================\n");
		printPattern7(n);
		System.out.println("\n==========================================================================\n");
		printPattern8(n);
		System.out.println("\n==========================================================================\n");
		printPattern9(n);
		System.out.println("\n==========================================================================\n");
		printPattern10(n);
		System.out.println("\n==========================================================================\n");
		printPattern11(n);
		System.out.println("\n==========================================================================\n");
		printPattern12(n);
		System.out.println("\n==========================================================================\n");
		printPattern13(n);
		System.out.println("\n==========================================================================\n");
		printPattern14(n);
		System.out.println("\n==========================================================================\n");
		printPyramid1(n);
		System.out.println("\n==========================================================================\n");
		printPyramid2(n);
		System.out.println("\n==========================================================================\n");
		printPyramid3(n);
		System.out.println("\n==========================================================================\n");
		printPyramid4(n);
		System.out.println("\n==========================================================================\n");
		printPyramid5(n);
		System.out.println("\n==========================================================================\n");
		printPyramid6(n);
		System.out.println("\n==========================================================================\n");
		printPyramid7(n);
		System.out.println("\n==========================================================================\n");
	}

	public static void myMain(){
		int n = 0;
		Scanner read = new Scanner(System.in);
		System.out.print("Enter the number : ");
		n = read.nextInt();
		read.close();
		printAllPattern(n);
	}
}
