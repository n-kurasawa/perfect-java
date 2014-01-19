package pert1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyAnnon {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>() {

			{
				add("foo");
				add("bar");
				add("bazbazbaz");
				add("foofoo");
				add("barbarbarbar");
			}
		};

		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		});

		for (String string : list) {
			System.out.println(string);
		}

	}
}
