package pkgs.exceptions;

import javax.faces.application.FacesMessage;
import javax.faces.convert.ConverterException;

public class EnderecoSimpleConverterException extends ConverterException {

	private static final long serialVersionUID = 7537808452390245987L;

	public EnderecoSimpleConverterException() {
		super(new FacesMessage(FacesMessage.SEVERITY_FATAL, "Endereço inválido", null));
	}

	public EnderecoSimpleConverterException(String message) {
		super(new FacesMessage(FacesMessage.SEVERITY_FATAL, "Endereço inválido", message));
	}

}
