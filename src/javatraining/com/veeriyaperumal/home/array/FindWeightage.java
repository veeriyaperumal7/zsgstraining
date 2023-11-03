package javatraining.com.veeriyaperumal.home.array;

import java.util.*;

public class FindWeightage {
	private static Scanner read;
	static {
		read = new Scanner(System.in);
	}

	class Person {
		static Person arr[];
		private int number;
		private int weight;

		public Person(int number, int weight) {
			this.number = number;
			this.weight = weight;
		}

		public String toString() {
			return "<" + this.number + " " + "," + this.weight + ">";
		}

	}

	public class PersonComparator implements Comparator<Person> {
		@Override
		public int compare(Person o1, Person o2) {
			if (o1.weight > o2.weight) {
				return -1;
			} else if (o1.weight < o2.weight) {
				return 1;
			}
			return 0;
		}

	}

	private static boolean isPerfectSquare(int weight) {
		int n = (int) Math.sqrt(weight);
		if (n * n == weight) {
			return true;
		}
		return false;
	}

	private static void calculateWeight(Person arr[]) {
		for (Person obj : arr) {
			int sum = 0;
			if (isPerfectSquare(obj.number)) {
				sum += 5;
			}
			if (obj.number % 4 == 0 && obj.number % 6 == 0) {
				sum += 4;
			}
			if (obj.number % 2 == 0) {
				sum += 3;
			}
			obj.weight = sum;
		}

	}

	public static void myMain() {

		System.out.print("Enter the number of weights need to find : ");
		int length = read.nextInt();
		Person.arr = new Person[length];
		System.out.println("Enter the number one by one  : ");
		for (int i = 0; i < length; i++) {
			int temp = read.nextInt();
			FindWeightage outerObj = new FindWeightage();
			Person obj = outerObj.new Person(temp, 0);
			Person.arr[i] = obj;
		}
		calculateWeight(Person.arr);
		FindWeightage outerObj = new FindWeightage();
		Arrays.sort(Person.arr, outerObj.new PersonComparator());
		System.out.print("Output : " + Arrays.toString(Person.arr));
	}
}
