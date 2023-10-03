package pkgs.converts;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import pkgs.models.AreaAtuacao;
import pkgs.repositorys.PessoaRepository;
import pkgs.repositorys.Repositorys;
import pkgs.util.JSFUtil;

@FacesConverter("entityConverter")
public class EntityConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		System.out.println("EntityConverter.getAsObject()");
		System.out.println("[component=" + component + "][value=" + value + "]");

		Object object = null;

		if(value!=null && !value.toString().trim().equals("")) {
			if(component.getClientId().toUpperCase().indexOf("AreaAtuacao".toUpperCase())>=0) {
				object = ((PessoaRepository) Repositorys.getRepository()).getAreaAtuacaoById(Integer.parseInt(value.toString()));
			}
		}

		System.out.println("[object=" + object + "]");

		return object;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		System.out.println("EnderecoConverter.getAsString()");
		System.out.println("[component=" + component + "][value=" + value + "]");

		String r = "";
		if(value!=null) {
			if(component.getClientId().toUpperCase().indexOf("AreaAtuacao".toUpperCase())>=0) {
				r = ((AreaAtuacao) value).getId().toString();
			}
		}

		System.out.println("[r=" + r + "]");

		return r;
	}

}
