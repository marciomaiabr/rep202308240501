package pkgs.exceptions;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

public class CustomExceptionHandlerFactory extends ExceptionHandlerFactory {
	private ExceptionHandlerFactory parent;

	public CustomExceptionHandlerFactory(ExceptionHandlerFactory parent) {
		System.out.println("CustomExceptionHandlerFactory.CustomExceptionHandlerFactory()");
		this.parent = parent;
	}

	@Override
	public ExceptionHandler getExceptionHandler() {
		System.out.println("CustomExceptionHandlerFactory.getExceptionHandler()");
		ExceptionHandler handler = new CustomExceptionHandler(parent.getExceptionHandler());
		return handler;
	}

}
