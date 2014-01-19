package pert1;

import java.util.Comparator;

public class MyHost {

	private static class StringLengthComparator implements Comparator<String> {

		@Override
		public int compare(String s1, String s2) {
			return s1.length() - s2.length();
		}
	}
	public Comparator<String> getComparator() {
		return new StringLengthComparator();
	}

	private static class MyHelper {
		private static String nested_priv_class_field = "nested private class field";
		private String nested_priv_inst_field = "nested private instance field";

		private static void class_doit() {
			System.out.println(MyHost.priv_class_field);
			System.out.println(new MyHost().priv_inst_field);
		}

		private void doit(MyHost my) {
			System.out.println(my.priv_inst_field);
		}
	}

	private static String priv_class_field = "private class field";
	private String priv_inst_field = "private instance field";

	private void doit() {
		MyHelper helper = new MyHelper();
		helper.doit(this);
	}

	public static void main(String[] args) {
		System.out.println(MyHelper.nested_priv_class_field);

		MyHelper helper = new MyHelper();
		System.out.println(helper.nested_priv_inst_field);

		MyHelper.class_doit();

		MyHost my = new MyHost();
		my.doit();

	}
}

class Test {

	public void test1() {
		MyHost host = new MyHost();
		Comparator<String> comparator = host.getComparator();
	}
}
