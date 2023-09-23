package pkgs.exceptions;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

public class EnderecoValidatorException extends ValidatorException {

	private static final long serialVersionUID = 7537808452390245987L;

	public EnderecoValidatorException() {
		super(new FacesMessage(FacesMessage.SEVERITY_FATAL, "Endereço inválido", null));
	}

	public EnderecoValidatorException(String message) {
		super(new FacesMessage(FacesMessage.SEVERITY_FATAL, "Endereço inválido", message));
	}

}
