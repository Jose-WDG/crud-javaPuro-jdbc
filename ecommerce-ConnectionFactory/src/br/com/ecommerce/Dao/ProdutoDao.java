package br.com.ecommerce.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import br.com.ecommerce.interfaces.Dao;
import br.com.ecommerce.jdbc.ConnectionFactory;
import br.com.ecommerce.jdbc.modelo.Produto;

public class ProdutoDao implements Dao<Produto> {
	private Connection connection;

	public ProdutoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	@Override
	public void inserir(Produto produto) throws SQLException {
		String sql = "INSERT into produtos (nome,descricao,preco,creat_at) VALUES (?,?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

			// seta os valores
			preparedStatement.setString(1, produto.getNome());
			preparedStatement.setString(2, produto.getDescricao());
			preparedStatement.setLong(3, (long) produto.getPreco());
			preparedStatement.setDate(4, produto.getCreat_at());
			preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			connection.close();
		}
	}

	@Override
	public void atualizar(int id) throws SQLException {
		Produto produto = new Produto();
		String sql = "UPDATE produtos set nome=?, descricao=?,preco=? WHERE id=?";
		try {
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

			preparedStatement.setString(1, produto.getNome());
			preparedStatement.setString(2, produto.getDescricao());
			preparedStatement.setLong(3, (long) produto.getPreco());
			preparedStatement.setInt(4, id);
			preparedStatement.execute();
			preparedStatement.close();
			System.out.println("Atualizado com sucesso!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			connection.close();
		}

	}

	@Override
	public void excluir(int id) throws SQLException {
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement("DELETE FROM produtos WHERE id=?");
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
			System.out.println("Excluido com sucesso!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			connection.close();
		}

	}

	@Override
	public List<String> getList() throws SQLException {
		List<String> carrinho = new ArrayList<>();
		java.sql.PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from produtos");

		ResultSet rs = preparedStatement.executeQuery();

		while (rs.next()) {

			int id = rs.getInt("id");
			String nome = rs.getString("nome");
			String descricao = rs.getString("descricao");
			long preco = rs.getLong("preco");
			java.sql.Date data = rs.getDate("creat_at");

			carrinho.add(id + " - " + nome + " - " + descricao + " - " + preco + " - " + data + "\n");
		}

		preparedStatement.close();
		connection.close();

		return carrinho;
	}

	@Override
	public Object pesquisar(int idProduto) throws SQLException {
		String produto = null;
		String sql = "SELECT * FROM produtos WHERE id LIKE ?";
		// prepared statement para inserção
		PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		preparedStatement.setInt(1, idProduto);
		preparedStatement.execute();
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {

			int id = rs.getInt("id");
			String nome = rs.getString("nome");
			String descricao = rs.getString("descricao");
			long preco = rs.getLong("preco");
			java.sql.Date data = rs.getDate("creat_at");

			produto = id + " - " + nome + " - " + descricao + " - " + preco + " - " + data + "\n";
		}
		return produto;
	}

}
