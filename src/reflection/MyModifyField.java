package reflection;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

public class MyModifyField {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			File file = new File("/tmp");
			Class clazz = file.getClass();
			Field field;
			field = clazz.getDeclaredField("path");
			if (!field.isAccessible()) {
				field.setAccessible(true);
			}

			System.out.println(field.get(file));
			field.set(file, "/tmp/newfile");
			file.createNewFile();
			System.out.println(field.get(file));
		} catch (SecurityException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
