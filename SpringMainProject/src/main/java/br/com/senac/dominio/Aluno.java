package br.com.senac.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Aluno implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	private String senha;
	/*
	private Set<Login> login;
	*/
	
	@OneToMany(mappedBy="aluno")
	private List<Endereco> enderecos = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name="telefone")
	private Set<String> telefones = new HashSet<>();
	
	@OneToMany(mappedBy="aluno")
	private List<Pedido> pedidos = new ArrayList<>();
	/*
	@ManyToMany(mappedBy="alunos_login")
	*/
	
	public Integer getId() {
		return id;
	}
	/*
	public Set<Login> getLogin() {
		return login;
	}

	public void setLogin(Set<Login> login) {
		this.login = login;
	}
	*/
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
