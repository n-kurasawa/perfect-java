package annot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MyEcho3 {
	private static class Pair {
		Pair(Object obj, Method method) {
			this.object = obj;
			this.method = method;
		}
		final Object object;
		final Method method;
	}

	private List<Pair> filters = new ArrayList<Pair>();

	public MyEcho3(String[] classNames) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		for (String className : classNames) {
			Class clazz = Class.forName(className);
			for (Method method : clazz.getMethods()) {
				MyFilter myfilter = method.getAnnotation(MyFilter.class);
				if (myfilter != null) {
					switch (myfilter.value()) {
					case BEFORE:
						filters.add(0, new Pair(clazz.newInstance(), method));
						break;
					case AFTERE:
						filters.add(new Pair(clazz.newInstance(), method));
						break;
					default:
						break;
					}
				}
			}
		}
	}

	public void doit() {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		try {
			while (true) {
				System.out.println("Input any text");
				String msg = stdin.readLine();

				String output = msg;
				for (Pair pair : filters) {
					output = (String)pair.method.invoke(pair.object, output);
				}
				System.out.println("You said, " + output);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * @param args
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		MyEcho3 echo = new MyEcho3(args);
		echo.doit();

	}

}
