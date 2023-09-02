package pkgs.repositorys;

import java.util.List;

import pkgs.models.AreaAtuacao;

public interface PessoaRepository extends Repository {

	public List<AreaAtuacao> listarAreasAtuacao();

}
