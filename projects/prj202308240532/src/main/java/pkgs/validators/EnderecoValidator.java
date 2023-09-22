package pkgs.validators;

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import pkgs.exceptions.EnderecoSimpleConverterException;

@FacesValidator("enderecoValidator")
public class EnderecoValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		System.out.println("EnderecoValidator.validate()");
		System.out.println("[component=" + component + "]");
		System.out.println("[value=" + value + "]");

		String sSubmittedValue = ((HtmlInputText) component).getSubmittedValue().toString();
		System.out.println("[sSubmittedValue=" + sSubmittedValue + "]");

		String[] aSEndereco = sSubmittedValue.split(";");

		if (aSEndereco.length != 5)
			throw new EnderecoSimpleConverterException("Campo endereço não possui 4 ;");

		String[] aSCidadeUf = aSEndereco[4].split("-");
		if (aSCidadeUf.length != 2)
			throw new EnderecoSimpleConverterException("Campo endereço não possui 1 -");

	}

}
