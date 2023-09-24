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

		if(endereco == null) {
			String idPrincipal = JSFUtil.buscaRequestParameter("idPrincipal");

			if (idPrincipal != null) {
				endereco = Repositorys.getRepository().buscaPorId(Integer.parseInt(idPrincipal)).getEndereco();
			} else {
				endereco = new Endereco();
			}
		}

		if (component.getId().equals("iptRua"))
			endereco.setRua(value);
		else if (component.getId().equals("iptNumero"))
			endereco.setNumero(value);
		else if (component.getId().equals("iptComplemento"))
			endereco.setComplemento(value);
		else if (component.getId().equals("iptBairro"))
			endereco.setBairro(value);
		else if (component.getId().equals("iptCidade"))
			endereco.setCidade(value);
		else if (component.getId().equals("iptUf"))
			endereco.setUf(value);

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

		if (component.getId().equals("iptRua"))
			retorno = endereco.getRua();
		else if (component.getId().equals("iptNumero"))
			retorno = endereco.getNumero();
		else if (component.getId().equals("iptComplemento"))
			retorno = endereco.getComplemento();
		else if (component.getId().equals("iptBairro"))
			retorno = endereco.getBairro();
		else if (component.getId().equals("iptCidade"))
			retorno = endereco.getCidade();
		else if (component.getId().equals("iptUf"))
			retorno = endereco.getUf();

		System.out.println("[retorno=" + retorno + "]");

		return retorno;
	}

}
