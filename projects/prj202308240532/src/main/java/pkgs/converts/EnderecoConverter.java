package pkgs.converts;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import pkgs.exceptions.EnderecoConverterException;
import pkgs.models.Endereco;
import pkgs.repositorys.Repositorys;
import pkgs.util.JSFUtil;

@FacesConverter("enderecoConverter")
public class EnderecoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		System.out.println("EnderecoConverter.getAsObject()");
		System.out
				.println("[component=" + component + "][component.getId()=" + component.getId() + "][value=" + value
						+ "]");

		Endereco endereco = null;

		endereco = (Endereco) JSFUtil.buscaRequestAttribute("endereco");

		if (endereco == null) {
			String idPrincipal = JSFUtil.buscaRequestParameter("idPrincipal");

			if (idPrincipal != null) {
				endereco = Repositorys.getRepository().buscaPorId(Integer.parseInt(idPrincipal)).getEndereco();
			} else {
				endereco = new Endereco();
			}
		}

		endereco.setRua(value);

		System.out.println("[endereco=" + endereco + "]");

		JSFUtil.setRequestAttribute("endereco", endereco);

		return endereco;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		System.out.println("EnderecoConverter.getAsString()");
		System.out.println("[value=" + value + "]");

		Endereco endereco = (Endereco) value;

		String retorno = null;

		retorno = endereco.getRua();

		System.out.println("[retorno=" + retorno + "]");

		return retorno;
	}

}
