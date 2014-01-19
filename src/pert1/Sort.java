package pert1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Sort {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>() {
			{
				add("foo");
				add("bar");
				add("bazbazbazbaz");
				add("foofoo");
			}
		};

		Collections.sort(list, new Comparator<String>() {
			@Override public int compare(String arg0, String arg1) {
				return arg0.length() - arg1.length();
			};
		});
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			iterator.remove();
			System.out.println(string);
		}
		System.out.println(list.size());
	}


}
