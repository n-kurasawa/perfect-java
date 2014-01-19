package pert1.inter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class MyEcho2 {

	private List<MyFilter> filters;

	public MyEcho2(List<MyFilter> filters) {
		this.filters = filters;
	}

	public void doit() {

		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		try {
			while (true) {
				System.out.println("input any here");
				String msg = stdin.readLine();

				String output = msg;
				for (MyFilter filter : filters) {
					output = filter.doJob(output);
				}

				System.out.println("you said, " + output);
				break;
			}
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		MyEcho2 echo = new MyEcho2(Arrays.asList(new MyFilter[] {new ReplaceImpl("he", "she"), new CapitalixeImpl()}));
		echo.doit();

		Thread.currentThread().dumpStack();
		print();
	}

	public static void print() {
		StackTraceElement frmes[] = Thread.currentThread().getStackTrace();
		for (StackTraceElement frme : frmes) {
			System.out.println(frme.getClassName() + "#" + frme.getMethodName() + ":" + frme.getLineNumber());
		}
	}

}
