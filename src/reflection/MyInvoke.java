package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyInvoke {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Class<?> clazz = Class.forName("java.lang.StringBuilder");
			Method append_method = StringBuilder.class.getMethod("append", String.class);
			Method length_method = clazz.getMethod("length");

			CharSequence sb = (CharSequence) clazz.newInstance();
			append_method.invoke(sb, "abc");
			append_method.invoke(sb, "def");
			append_method.invoke(sb, "ghi");
			System.out.println(sb);
			System.out.println(length_method.invoke(sb));
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}catch (InvocationTargetException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
