package pkgs.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cargo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 50)
	private String descricao;
	@ManyToOne(optional = false)
	private SubAreaAtuacao subAreaAtuacao;

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

	public SubAreaAtuacao getSubAreaAtuacao() {
		return subAreaAtuacao;
	}

	public void setSubAreaAtuacao(SubAreaAtuacao subAreaAtuacao) {
		this.subAreaAtuacao = subAreaAtuacao;
	}

	public Cargo() {
		super();
	}

	public Cargo(SubAreaAtuacao subAreaAtuacao, String descricao) {
		super();
		this.descricao = descricao;
		this.subAreaAtuacao = subAreaAtuacao;
	}

	@Override
	public String toString() {
		return "Cargo [id=" + id + ", descricao=" + descricao + ", subAreaAtuacao=" + subAreaAtuacao + "]";
	}

}
