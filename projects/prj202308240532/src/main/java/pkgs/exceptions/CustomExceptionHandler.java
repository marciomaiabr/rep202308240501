package pkgs.exceptions;

import java.util.Iterator;
import java.util.Map;

import javax.faces.FacesException;
import javax.faces.application.NavigationHandler;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

public class CustomExceptionHandler extends ExceptionHandlerWrapper {

	private ExceptionHandler exceptionHandler;

	public CustomExceptionHandler(ExceptionHandler exceptionHandler) {
		System.out.println("CustomExceptionHandler.CustomExceptionHandler()");
		this.exceptionHandler = exceptionHandler;
	}

	@Override
	public ExceptionHandler getWrapped() {
		System.out.println("CustomExceptionHandler.getWrapped()");
		return exceptionHandler;
	}

	@Override
	public void handle() throws FacesException {
		System.out.println("CustomExceptionHandler.handle()");
		final Iterator<ExceptionQueuedEvent> queue = getUnhandledExceptionQueuedEvents().iterator();

		while (queue.hasNext()) {
			System.out.println("CustomExceptionHandler.handle()... queue.hasNext()");
			ExceptionQueuedEvent item = queue.next();
			ExceptionQueuedEventContext exceptionQueuedEventContext = (ExceptionQueuedEventContext) item.getSource();

			try {
				Throwable throwable = exceptionQueuedEventContext.getException();
				System.err.println("Exception: " + throwable.getMessage());

				FacesContext context = FacesContext.getCurrentInstance();
				Map<String, Object> requestMap = context.getExternalContext().getRequestMap();
				NavigationHandler nav = context.getApplication().getNavigationHandler();

				requestMap.put("error-message", throwable.getMessage());
				requestMap.put("error-stack", throwable.getStackTrace());
				nav.handleNavigation(context, null, "/erro");
				context.renderResponse();

			} finally {
				queue.remove();
			}
		}
	}
}
