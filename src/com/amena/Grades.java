package com.amena;

import java.util.Scanner;

/**
 * @author AmenaKassim
 * @date 02/29/2024 
 * A program that does calculations (averages) using the user inputted categorical grades
 */

public class Grades {

	/**
	 * Main method
	 * @param args Command Line arguments
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// User Inputs marks for each category
		// Knowledge
		System.out.println("Enter the mark you got for K/U (as a %): ");
		System.out.print("> ");
		double kU = input.nextDouble();

		// Application
		System.out.println("Enter the mark you got for application (as a %): ");
		System.out.print("> ");
		double app = input.nextDouble();
		
		// Thinking
		System.out.println("Enter the mark you got for thinking (as a %): ");
		System.out.print("> ");
		double think = input.nextDouble();
		
		// Communication
		System.out.println("Enter the mark you got for communication (as a %): ");
		System.out.print("> ");
		double comm = input.nextDouble();

		// Input grades
		double[] testGrades = { kU, app, think, comm };

		double simpleAvg = calcSimpleAvg(testGrades);
		double weightedAvg = calcWeightedAvg(testGrades);
		String all = gradesToString(testGrades, simpleAvg, weightedAvg);

		System.out.println(all);
		String practice = ("please practice the following to improve your grade: " + whatToPractice(testGrades));
		System.out.println(practice);
		input.close();
	}

	/**
	 * Calculates the simple average of four percentages.
	 * @param testGrades An array of test grades on each category
	 * @return The simple average of over the four categories, rounded to the nearest whole number.
	 */
	public static double calcSimpleAvg(double[] testGrades) {
		// Calculating simple average by adding each categorical grades inputted by user and divided by how many catagories there are (4)
		double sum = 0;
		double simpleAvg = 0;
		for (int i = 0; i < testGrades.length; i++) {
			sum = sum + testGrades[i];
			simpleAvg = sum / testGrades.length;
		}
		return simpleAvg;
	}

	/**
	 * Calculates the weighted average of four percentages.
	 * @param testGrades An array of test grades on each category.
	 * @return The weighted average of over the four categories, rounded to the nearest whole number.
	 */
	public static double calcWeightedAvg(double[] testGrades) {

		// What each category weighs.
		double kU = 0.25;
		double app = 0.3;
		double thinking = 0.25;
		double comm = 0.20;

		// Calculating weighted average by multiplying the weighted % with user inputted categories grades.
		double weightedkU = testGrades[0] * kU;
		double weightedApp = testGrades[1] * app;
		double weightedTh = testGrades[2] * thinking;
		double weightedComm = testGrades[3] * comm;

		// Adding all the category grades together to get the weighted average.
		double weightedAvg = weightedkU + weightedApp + weightedTh + weightedComm;

		return weightedAvg;
	}

	/**
	 * Return a grade report that shows the marks in all four categories along with both averages.
	 * @param testGrades  An array of test grades on each category.
	 * @param simpleAvg   The simple average of the grades.
	 * @param weightedAvg The weighted average of the grades.
	 * @return A string of the above form that can be printed to console.
	 */
	public static String gradesToString(double[] testGrades, double simpleAvg, double weightedAvg) {

		double kU = testGrades[0];
		double app = testGrades[1];
		double thinking = testGrades[2];
		double comm = testGrades[3];
		
		double simpleAvg1 = calcSimpleAvg(testGrades);
		double weightedAvg1 = calcWeightedAvg(testGrades);
		String all = ("K/U: " + kU + "% -- " + "APP: " + app + "% -- " + "THINK: " + thinking + "% -- " + "COMM: "
				+ comm + "%" + "\n" + "Simple average: " + simpleAvg1 + "%" + "\n" + "Weighted average: " + weightedAvg1
				+ "%");
		return all;
	}

	/**
	 * Finding the lowest grade and telling the user what they should practice.
	 * @param testGrades An array of test grades on each category.
	 * @return A sentence describing which category you should practice more.
	 */
	public static String whatToPractice(double[] testGrades) {

		// Using finding minimum index of the lowest grade to find out what category requires improvement.
		String lowestCategory = null;
		int minI = 0;
		for (int i = 0; i < testGrades.length; i++) {
			if (testGrades[i] < testGrades[minI]) {
				minI = i;
			}
			if (minI == 0) {
				lowestCategory = "knowledge";
			} else if (minI == 1) {
				lowestCategory = "application";

			} else if (minI == 2) {
				lowestCategory = "thinking";
			} else if (minI == 3) {
				lowestCategory = "communication";
			}
		}
		return lowestCategory;
	}
}
