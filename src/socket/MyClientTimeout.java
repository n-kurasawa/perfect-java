package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class MyClientTimeout {
	private static final String SERVER_HOST = "localhost";
	private static final int SERVER_PORT = 9000;
	private static final int CONNECT_TIMEOUT = 5000;
	private static final int READ_TIMEOUT = 5000;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length < 1) {
			System.err.println("usage: java " + MyClientTimeout.class.getSimpleName() + "messages");
			System.exit(-1);
		}
		Socket sock = null;
		try {
			sock = new Socket();
			sock.connect(new InetSocketAddress(SERVER_HOST, SERVER_PORT), CONNECT_TIMEOUT);
			sock.setSoTimeout(READ_TIMEOUT);
			Reader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			Writer out = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));

			for (String arg : args) {
				out.write(arg);
			}
			out.write('.');
			out.flush();

			char[] buf = new char[4096];
			while (in.read(buf) != -1) {
				System.out.println(buf);
			}
		} catch (SocketTimeoutException e) {
			System.out.println("timeout");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (sock != null) {
					sock.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
