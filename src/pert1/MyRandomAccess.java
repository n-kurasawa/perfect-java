package pert1;

import java.io.IOException;
import java.io.RandomAccessFile;

public class MyRandomAccess {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RandomAccessFile file = null;
		try {
			file = new RandomAccessFile(args[0], "rw");
			file.seek(file.length());
			file.write("abc".getBytes());

			file.seek(0);
			byte[] buf = new byte[(int) file.length()];
			int len = file.read(buf);
			if (len != -1) {
				System.out.println(new String(buf));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (file != null) {
					file.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
