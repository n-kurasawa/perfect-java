package reflection;

import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class MyCompiler {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		if (args.length < 2) {
			System.err.println("usage: java" + MyCompiler.class.getSimpleName() + " loas-class-name method-name");
			return;
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		Console con = System.console();
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		if (compiler == null) {
			System.out.println("compiler is not found");
			return;
		}

		while (true) {
			int ret = compiler.run(null, null, null, new String[]{args[0] + ".java"});
			if (ret == 0) {
				ClassLoader loader = URLClassLoader.newInstance(new URL[]{new File(".").toURI().toURL()}, null);
				Class<?> clazz = Class.forName(args[2], true, loader);
				if (clazz != null) {
					clazz.getMethod(args[1]).invoke(clazz.newInstance());
				}
			} else {
				System.out.println("compile failed");
				break;
			}
			System.out.println("press enter key to continue");
			br.readLine();
		}
	}

}
