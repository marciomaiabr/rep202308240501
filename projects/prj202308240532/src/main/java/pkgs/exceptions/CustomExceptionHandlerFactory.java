package pkgs.exceptions;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

public class CustomExceptionHandlerFactory extends ExceptionHandlerFactory {

	private ExceptionHandlerFactory exceptionHandlerFactory;

	public CustomExceptionHandlerFactory() {
		System.out.println("CustomExceptionHandlerFactory.CustomExceptionHandlerFactory()");
	}

	public CustomExceptionHandlerFactory(ExceptionHandlerFactory exceptionHandlerFactory) {
		System.out.println("CustomExceptionHandlerFactory.CustomExceptionHandlerFactory()");
		this.exceptionHandlerFactory = exceptionHandlerFactory;
	}

	@Override
	public ExceptionHandler getExceptionHandler() {
		System.out.println("CustomExceptionHandlerFactory.getExceptionHandler()");
		return new CustomExceptionHandler(exceptionHandlerFactory.getExceptionHandler());
	}
}
