package pkgs.exceptions;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

public class EnderecoSimpleValidatorException extends ValidatorException {

	private static final long serialVersionUID = 7537808452390245987L;

	public EnderecoSimpleValidatorException() {
		super(new FacesMessage(FacesMessage.SEVERITY_FATAL, "Endereço inválido", null));
	}

	public EnderecoSimpleValidatorException(String message) {
		super(new FacesMessage(FacesMessage.SEVERITY_FATAL, "Endereço inválido", message));
	}

}
