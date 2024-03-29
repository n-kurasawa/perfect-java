package socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class MyClientNio {
	private static long POLL_TIMEOUT = 5000;

	private SocketChannel channel = null;
	private Selector selector = null;
	private enum State {
		SEND_REQUEST,
		RECV_RESPONSE,
	}
	private State state;

	public MyClientNio(String server_host, int server_port) throws IOException {
		channel = SocketChannel.open();
		selector = Selector.open();
		InetSocketAddress address = new InetSocketAddress(server_host, server_port);
		channel.connect(address);
		channel.configureBlocking(false);
	}

	public void close() {
		try {
			if (channel != null) {
				channel.close();
			}
			if (selector != null) {
				selector.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void doHttpClient() throws IOException {
		state = State.SEND_REQUEST;
		loop:
		while (true) {
			switch (state) {
			case SEND_REQUEST:
				channel.register(selector, SelectionKey.OP_WRITE);
				break;
			case RECV_RESPONSE:
				channel.register(selector, SelectionKey.OP_READ);
				break;
			default:
				assert(false);
			}
			if (selector.select(POLL_TIMEOUT) > 0) {
				for (SelectionKey sock : selector.selectedKeys()) {
					if (state == State.SEND_REQUEST && sock.isWritable()) {
						sendRequest();
						state = State.RECV_RESPONSE;
					} else if (state == State.RECV_RESPONSE && sock.isReadable()) {
						recvResponse();
					}
				}
				selector.selectedKeys().clear();
			} else {
				System.out.println("contine? [y/n]");
				String input = System.console().readLine();
				if (input.charAt(0) == 'y') {
					state = State.SEND_REQUEST;
					continue;
				} else {
					break loop;
				}
			}
		}
	}

	private void sendRequest() throws IOException {
		ByteBuffer buffer = ByteBuffer.allocate(4096);
		buffer.put("GET / HTTP/1.1¥r¥n".getBytes());
		buffer.put("Host: localhost¥r¥n".getBytes());
		buffer.put("¥r¥n".getBytes());
		buffer.flip();

		channel.write(buffer);
	}

	private void recvResponse() throws IOException {
		ByteBuffer buffer = ByteBuffer.allocate(4096);
		channel.read(buffer);
		System.out.println(new String(buffer.array(), "UTF-8"));
	}

	public static void main(String[] args) {
		if (args.length < 1) {
			System.err.println("usage: java " + MyClientNio.class.getSimpleName() + " web-server-name");
			System.exit(-1);
		}
		MyClientNio my = null;
		try {
			my = new MyClientNio(args[0], 80);
			my.doHttpClient();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (my != null) {
				my.close();
			}
		}

	}

}
