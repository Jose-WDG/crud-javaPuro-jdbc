package br.com.ecommerce.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {
	void inserir(T entidade) throws SQLException;
	void atualizar(int id) throws SQLException;
	void excluir(int id) throws SQLException;
	List<String> getList() throws SQLException;
	Object pesquisar(int idProduto) throws SQLException;
}
