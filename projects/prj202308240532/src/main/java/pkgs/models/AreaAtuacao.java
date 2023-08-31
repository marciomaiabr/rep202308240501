package pkgs.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class AreaAtuacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 50)
	private String descricao;
	@OneToMany(mappedBy = "areaAtuacao", cascade = CascadeType.ALL)
	private List<SubAreaAtuacao> subAreaAtuacao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<SubAreaAtuacao> getSubAreaAtuacao() {
		return subAreaAtuacao;
	}

	public void setSubAreaAtuacao(List<SubAreaAtuacao> subAreaAtuacao) {
		this.subAreaAtuacao = subAreaAtuacao;
	}

	@Override
	public String toString() {
		return "AreaAtuacao [id=" + id + ", descricao=" + descricao + "]";
	}

}
