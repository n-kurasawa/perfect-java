package pert1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MyBinarySearch {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");

		System.out.println("original list");

		for (String string : list) {
			System.out.println(string);
		}

		Collections.sort(list);
		System.out.println("sorted list");
		for (String string : list) {
			System.out.println(string);
		}

		int found_index = Collections.binarySearch(list, "seven", null);
		System.out.println(found_index);

		int notfound_index = Collections.binarySearch(list, "even", null);
		System.out.println(notfound_index);

	}

}
