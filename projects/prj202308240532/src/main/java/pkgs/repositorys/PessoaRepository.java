package pkgs.repositorys;

import java.util.List;

import pkgs.models.AreaAtuacao;
import pkgs.models.SubAreaAtuacao;

public interface PessoaRepository extends Repository {

	public List<AreaAtuacao> listarAreasAtuacao();
	public AreaAtuacao getAreaAtuacaoById(Integer id);
	public SubAreaAtuacao getSubAreaAtuacaoById(Integer id);
	public List<SubAreaAtuacao> listarSubAreasAtuacao();

}
