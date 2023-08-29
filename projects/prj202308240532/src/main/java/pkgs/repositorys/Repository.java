package pkgs.repositorys;

import java.util.List;

import pkgs.models.Pessoa;

public interface Repository {
	public boolean salvar(Pessoa pessoa);

	public List<Pessoa> listar();

	public Pessoa buscaPorId(Integer id);
}
