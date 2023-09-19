package pkgs.converts;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import pkgs.exceptions.EnderecoSimpleConverterException;
import pkgs.models.Endereco;
import pkgs.repositorys.Repositorys;
import pkgs.util.JSFUtil;

@FacesConverter("enderecoConverter")
public class EnderecoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		System.out.println("EnderecoConverter.getAsObject()");
		System.out.println("[value=" + value + "]");

		String[] aSEndereco = value.split(";");

		if (aSEndereco.length != 5)
			throw new EnderecoSimpleConverterException("Campo endereço não possui 4 ;");
		String[] aSCidadeUf = aSEndereco[4].split("-");
		if (aSCidadeUf.length != 2)
			throw new EnderecoSimpleConverterException("Campo endereço não possui 1 -");

		Endereco endereco = null;
		String idPrincipal = JSFUtil.buscaRequestParameter("idPrincipal");
		if(idPrincipal!=null)
			endereco = Repositorys.getRepository().buscaPorId(Integer.parseInt(idPrincipal)).getEndereco();
		else
			endereco = new Endereco();

		endereco.setRua(aSEndereco[0]);
		endereco.setNumero(aSEndereco[1]);
		endereco.setComplemento(aSEndereco[2]);
		endereco.setBairro(aSEndereco[3]);
		endereco.setCidade(aSCidadeUf[0]);
		endereco.setUf(aSCidadeUf[1]);

		System.out.println("[endereco=" + endereco + "]");

		return endereco;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		System.out.println("EnderecoConverter.getAsString()");
		System.out.println("[value=" + value + "]");

		Endereco endereco = (Endereco) value;

		String sEndereco = "";
		sEndereco += endereco.getRua() + ";" + endereco.getNumero() + ";" + endereco.getComplemento() + ";"
				+ endereco.getBairro() + ";";
		sEndereco += endereco.getCidade() + "-" + endereco.getUf();

		System.out.println("[sEndereco=" + sEndereco + "]");

		return sEndereco;
	}

}
