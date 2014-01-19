package generic;

public class MyInteger implements MyCompareble {

	int i;
	public MyInteger(int i) {
		this.i =  i;
	}

	@Override
	public int compreTo(Object o) {
		if (o instanceof MyInteger) {
			return i - ((MyInteger)o).i;
		} else {
			throw new IllegalArgumentException();
		}
	}

}
