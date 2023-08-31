package pkgs.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SubAreaAtuacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 50)
	private String descricao;
	@ManyToOne
	private AreaAtuacao areaAtuacao;

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

	public AreaAtuacao getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(AreaAtuacao areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}

	@Override
	public String toString() {
		return "SubAreaAtuacao [id=" + id + ", descricao=" + descricao + ", areaAtuacao=" + areaAtuacao + "]";
	}

}
