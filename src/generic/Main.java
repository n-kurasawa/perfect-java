package generic;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MyCompareble[] sarr = new MyString[] {new MyString("a"), new MyString("aa"), new MyString("sss")};
		MyString o = (MyString)max(sarr);
		System.out.println(o);

	}

	static Object max(MyCompareble[] arr) {
		MyCompareble ret = null;
		for (MyCompareble myCompareble : arr) {
			if (ret == null) {
				ret = myCompareble;
				continue;
			}
			if (myCompareble.compreTo(ret) > 0) {
				ret = myCompareble;
			}
		}
		return ret;
	}

}
