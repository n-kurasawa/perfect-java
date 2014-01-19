package pert1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyEcho {

	private String replase(String in, String origStr, String newStr) {
		return in.replaceAll(origStr, newStr);
	}

	private String capitalise(String in) {
		return in.toUpperCase();
	}

	public void doit() {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		try {
			while (true) {
				System.out.println("Input any text");
				String msg = stdin.readLine();
				System.out.println("You said, " + capitalise(replase(msg, "he", "she")));
			}
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		MyEcho echo = new MyEcho();
		echo.doit();
	}

}
