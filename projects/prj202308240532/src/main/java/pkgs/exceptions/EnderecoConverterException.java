package pkgs.exceptions;

import javax.faces.application.FacesMessage;
import javax.faces.convert.ConverterException;

public class EnderecoConverterException extends ConverterException {

	private static final long serialVersionUID = 7537808452390245987L;

	public EnderecoConverterException() {
		super(new FacesMessage(FacesMessage.SEVERITY_FATAL, "Endereço inválido", null));
	}

	public EnderecoConverterException(String message) {
		super(new FacesMessage(FacesMessage.SEVERITY_FATAL, "Endereço inválido", message));
	}

}
