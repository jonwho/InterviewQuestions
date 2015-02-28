/*
 * Fraction Reduction
 * Given a fraction A/B (where A and B are positive integers), print the fully
 * reduced fraction.
 * 
 * For example:
 * 12/15 should be reduced to 3/4.
 * 206/192
 *
 * Input Format
 * The first line contains an integer N, the number of fractions that will follow.
 * N lines follow, each containing a fraction provided in the form A/b
 *
 * Input Constraints
 * 1 <= A, B <= 2000
 * 1 <= N <= 500
 *
 * Output Format
 * The output should contain exactly N lines.
 * Each line should contain a reduced fraction corresponding to the inputs, in
 * sequential order.
 *
 * Sample Input
 * 10
 * 825/1161
 * 1092/1041
 * 315/840
 * 1104/1119
 * 724/404
 * 692/176
 * 208/286
 * 65/362
 * 126/151
 * 270/318
 *
 * Sample Output
 * 275/387
 * 364/347
 * 3/8
 * 368/373
 * 181/101
 * 173/44
 * 8/11
 * 65/362
 * 126/151
 * 45/53
 */ 

import java.io.*;
import java.util.*;

public class Fraction_Reduction {
	public static void reduceFraction(int A, int B) {
		// do Euclid's formula to get greatest common factor
		int gcf = 0;
		int tmpA = A;
		int tmpB = B;
		while(tmpB != 0) {
			gcf = tmpB;
			tmpB = tmpA % tmpB;
			tmpA = gcf;
		}
		// reduce the fraction by the greatest common factor between the two numbers
		A /= gcf;
		B /= gcf;
		System.out.println(A + "/" + B);
	}

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		// get N which will be the array size as well
		int N = scanner.nextInt();
		int[] array = new int[N];
		while(scanner.hasNextLine()) {
			String s = scanner.next();
			String[] sArray = s.split("/");
			int A = Integer.parseInt(sArray[0]);
			int B = Integer.parseInt(sArray[1]);
			reduceFraction(A, B);
		}
	}
}