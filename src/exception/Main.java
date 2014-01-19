package exception;

public class Main {

	public static void main(String[] args) {
		My my = new My();
		my.registerErrorHandler(new ErrorHandlerImpl());
		my.doit();
	}

}

class My {
	private ErrorHandler errorHandler;
	public void registerErrorHandler(ErrorHandler errorHandler) {
		this.errorHandler = errorHandler;
	}

	public void doit() {
		if (true) {
			if (errorHandler != null) {
				errorHandler.onError("somthing wrong happened");
			}
		}
	}
}
