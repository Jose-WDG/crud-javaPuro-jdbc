package br.com.ecommerce.testeConexao;

import java.sql.SQLException;

import br.com.ecommerce.Dao.ProdutoDao;

/*import br.com.ecommerce.Dao.ProdutoDao;
import br.com.ecommerce.jdbc.modelo.Produto;*/

public class testeConexao {
	public static void main(String[] args) throws SQLException {
		/*
		 * // variavel responsavel por acessar o banco de dados ProdutoDao dao = new
		 * ProdutoDao(); // responsavel por criar um objeto produto Produto novoProduto
		 * = new Produto();
		 * 
		 * try { novoProduto.setNome("mause razer");
		 * novoProduto.setDescricao("mause gamer razer naga");
		 * novoProduto.setPreco(600); dao.inserir(novoProduto);
		 * System.out.println("Inserido com sucesso"); } catch (Exception e) {
		 * System.out.println("Erro: " + e.getMessage()); }
		 */
		
		/*
		 * ProdutoDao produtos = new ProdutoDao();
		 * 
		 * System.out.println(produtos.getList());
		 */
		
		ProdutoDao pesquisa = new ProdutoDao();
		
		System.out.println("Produto pesquisado: "+pesquisa.pesquisar(5));
	
		ProdutoDao deletarProduto = new ProdutoDao();
		deletarProduto.excluir(5);
		
		
	}
}
