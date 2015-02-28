/**
 * Most Often Substring
 * Problem Statement.
 * We have a string of length N. The string contains only lower-case letters(a-z). Can you
 * figoure out the number of occurrences of the most frequent substring in this string?
 * We are only interested in the substrings that follow the following properties:
 * * The length of a substring lies between K & L.
 * * The number of unique characters in the substring do not exceed M.
 * Constraints:
 * 2 <= N <= 100000
 * 2 <= K <= L <= 26, L < N
 * 2 <= M <= 26
 * Input
 * The first line contains an integer N. The second line contains three space separated
 * integers, K L M. The third line contains the string of length N.
 * Sample Input #00
 * 5
 * 2 4 26
 * abcde
 * Sample Output #00
 * 1
 * Explanation #00
 * All substrings of length 2, 3, or 4 in abcde have only 1 occurrence. And number of character
 * substring is clearly less than 26 hence answer is 1
 * Sample Input #01
 * 6
 * 2 3 4
 * ababab
 * Sample Output #01
 * 3
 * Explanation
 * Size 2 we have 'ab': count is 3, 'ba' count is 2
 * Size 3 we have 'aba': count is 2, 'bab' count is 2
 * Clearly most often subsring is 'ab' and hence Answer is 3
 */

import java.io.*;
import java.util.*;

public class Most_Frequent_Substring {
	private static Map<String, Integer> map = new HashMap<String, Integer>();
	private static int N, K, L, M;
	private static String s;
	private static int mostSubCount = 0;

	// print the count of the substring that appeared the most
	private static void mostOftenSubstring() {
		for(int i = K; i <= L; i++) {
			getSubs(i);
		}
		for(int count : map.values()) {
			if(count > mostSubCount)
				mostSubCount = count;
		}
		System.out.println(mostSubCount);
	}

	// add subsequence string of length size to Set
	private static void getSubs(int size) {
		for(int i = 0; i < s.length(); i++) {
			if(i + size > s.length())
				break;
			else {
				String sub = s.substring(i, size + i);
				// if same substring update the count
				if(map.get(sub) != null) {
					int count = map.get(sub);
					count++;
					map.put(sub, count);
				}
				// else initialize substring with count 1
				else
					map.put(sub, 1);
			}
		}
	}

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        Scanner keyboard = new Scanner(System.in);

        // get N
        N = keyboard.nextInt();
        // get K, L, M
        K = Integer.parseInt(keyboard.next());
        L = Integer.parseInt(keyboard.next());
        M = Integer.parseInt(keyboard.next());
        // get string
        s = keyboard.next();

        mostOftenSubstring();
    }
}