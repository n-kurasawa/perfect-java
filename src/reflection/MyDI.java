package reflection;

import java.lang.reflect.Constructor;
import java.util.List;

public class MyDI {
	public Object resolv(String targetType, String argType, String argObjectType) throws Exception {
		Class<?> targetClass = Class.forName(targetType);

		Class<?> argClass = Class.forName(argObjectType);
		Object arg = argClass.newInstance();

		Constructor<?> constructor = targetClass.getConstructor(Class.forName(argType));
		return constructor.newInstance(arg);
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		MyDI my = new MyDI();
		StringList sl = (StringList)my.resolv("reflection.StringList", "java.util.List", "java.util.ArrayList");
		sl.append("one");
		sl.append("two");
		sl.dump();
	}

}

class StringList {
	private List<String> list;

	public StringList(List<String> list) {
		this.list = list;
	}

	public void append(String s) {
		this.list.add(s);
	}
	public void dump() {
		for (String s : list) {
			System.out.println(s);
		}
	}
}
