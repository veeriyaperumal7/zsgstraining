package javatraining.com.veeriyaperumal.home.oopsconcept;

import java.util.Scanner;

public abstract class Shape {
	
	
	public abstract float calculateArea();

	public static void main(String[] args) {
		myMain();
	}

	public static void myMain() {
		Scanner read = new Scanner(System.in);
		System.out.println("===================Choose the shape want to find a area ===================");
		System.out.println(" 1 - > Rectangle\n 2 - > Square\n 3 - > Triangle\n 4 - > Circle\n");
		System.out.print("Enter your choice : ");
		int n = read.nextInt();
		switch (n) {
		case 1: {
			System.out.print("Enter the length :");
			float len = read.nextFloat();
			System.out.print("Enter the breadth :");
			float bre = read.nextFloat();
			Shape rectangele = new Rectangle(len, bre);
			System.out.println("The area of rectangle is : " + rectangele.calculateArea());
			break;
		}
		case 2: {
			System.out.print("Enter the side :");
			float side = read.nextFloat();
			Shape square = new Square(side);
			System.out.println("The area of square is : " + square.calculateArea());
			break;
		}
		case 3: {
			System.out.print("Enter the base :");
			float base = read.nextFloat();
			System.out.print("Enter the height :");
			float height = read.nextFloat();
			Shape triangle = new Triangle(base, height);
			System.out.println("The area of triangle is : " + triangle.calculateArea());
			break;
		}
		case 4: {
			System.out.print("Enter the radius :");
			float radius = read.nextFloat();
			Shape circle = new Circle(radius);
			System.out.println("The area of circle is : " + circle.calculateArea());
			break;
		}
		default: {
			System.out.println("Entered wrong input!!!.Program terminated.\n");
		}
		}
		System.out.println("=============================================================================");
	}
}

class Circle extends Shape {
	private float radius;

	public Circle(float radius) {
		this.radius = radius;
	}

	@Override
	public float calculateArea() {
		return (float) (Math.PI * radius * radius);
	}
}

class Rectangle extends Shape {
	private float length, breadth;

	public Rectangle(float length, float breadth) {
		this.length = length;
		this.breadth = breadth;
	}

	@Override
	public float calculateArea() {
		return (length * breadth);
	}
}

class Square extends Shape {
	private float side;

	public Square(float side) {
		this.side = side;
	}

	@Override
	public float calculateArea() {
		return (float) Math.pow(side, 2);
	}
}

class Triangle extends Shape {
	private float base, height;

	public Triangle(float base, float height) {
		this.base = base;
		this.height = height;
	}

	@Override
	public float calculateArea() {
		return (float) (0.5 * base * height);
	}
}
