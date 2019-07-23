package br.com.ecommerce.jdbc.modelo;

import java.sql.Date;
import java.util.Calendar;

public class Produto {
	private int id;
	private String nome;
	private String descricao;
	private long preco;
	private java.sql.Date creat_at;

	public java.sql.Date getCreat_at() {
		creat_at = new Date(Calendar.getInstance().getTimeInMillis());
		return creat_at;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(long preco) {
		this.preco = preco;
	}

}
