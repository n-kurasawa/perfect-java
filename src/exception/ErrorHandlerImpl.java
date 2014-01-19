package exception;

public class ErrorHandlerImpl implements ErrorHandler {

	@Override
	public void onError(String error) {
		System.out.println("error:" + error);
	}

}
