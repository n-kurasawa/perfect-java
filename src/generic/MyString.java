package generic;

public class MyString implements MyCompareble {

	String s;
	public MyString(String s) {
		this.s = s;
	}

	@Override
	public int compreTo(Object o) {
		if (o instanceof MyString) {
			return s.length() - ((MyString)o).s.length();
		} else {
			throw new IllegalArgumentException();
		}
	}

}
