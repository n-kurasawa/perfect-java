package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class MyServerTimeout {
	private static final int LISTEN_PIRT = 9000;
	private static final int ACCEPT_TIMEOUT = 5000;
	private static final int READ_TIMEOUT = 5000;

	public static void main(String[] args) {
		ServerSocket ssock = null;
		Socket sock = null;
		try {
			ssock = new ServerSocket(LISTEN_PIRT);
			ssock.setSoTimeout(ACCEPT_TIMEOUT);
			sock = ssock.accept();
			sock.setSoTimeout(READ_TIMEOUT);
			Reader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			Writer out = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
			StringBuilder sb = new StringBuilder(4096);

			int c;
			while ((c = in.read()) != -1) {
				if (c == '.') {
					break;
				}
				sb.append((char)c);
			}
			out.write(sb.toString());
			out.flush();

			System.out.println(sb);

		} catch (SocketTimeoutException e) {
			System.err.println("timeout");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (sock != null) {
					sock.close();
				}
				if (ssock != null) {
					ssock.close();
				}
			} catch (IOException e) {}
		}
	}

}
