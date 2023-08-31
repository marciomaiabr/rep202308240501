package pkgs.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class SubAreaAtuacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 50)
	private String descricao;
	@ManyToOne(optional = false)
	private AreaAtuacao areaAtuacao;
	@OneToMany(mappedBy = "subAreaAtuacao", cascade = CascadeType.ALL)
	private List<Cargo> cargos;

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

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	public SubAreaAtuacao() {
		super();
	}

	public SubAreaAtuacao(AreaAtuacao areaAtuacao, String descricao) {
		super();
		this.areaAtuacao = areaAtuacao;
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "SubAreaAtuacao [id=" + id + ", descricao=" + descricao + ", areaAtuacao=" + areaAtuacao + "]";
	}

}
