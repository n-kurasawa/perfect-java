package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MyInstance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

			Class<?> clazz;
			try {
				clazz = Class.forName("java.lang.StringBuilder");
				Constructor<?> constructor = clazz.getConstructor(String.class);
				CharSequence sb = (CharSequence) constructor.newInstance("abc");

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	}

}
