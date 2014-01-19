package reflection;


public class MyReflect {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Class<StringBuilder> clazz1 = StringBuilder.class;

			StringBuilder sb = new StringBuilder();
			Class<? extends StringBuilder> clazz2 = sb.getClass();

			Class<?> clazz3 = Class.forName("java.lang.StringBuilder");
			Class<? extends StringBuilder> clazz4 = clazz3.asSubclass(StringBuilder.class);

			System.out.println(clazz1.hashCode() + ", " + clazz2.hashCode() + ", " + clazz3.hashCode() + ", " + clazz4.hashCode());
			assert(clazz1 == clazz2);
			assert(clazz2 == clazz3);

			Class<Integer> type = Integer.TYPE;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
