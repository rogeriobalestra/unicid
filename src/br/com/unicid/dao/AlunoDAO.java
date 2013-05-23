package br.com.unicid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.unicid.controller.Aluno;
import br.com.unicid.ultil.ConnectionFactory;

public class AlunoDAO {

	private Connection conn;
	private PreparedStatement pstm;
	private ResultSet rs;
	
	
	/** CONSTRUTOR */
	public AlunoDAO(){
		
	}
	
	
	/** CONECTA MYSQL */
	public void conectaMySQL() {
	
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	/** INSERIR */
	public void inserir(Aluno aluno) throws SQLException{
		conectaMySQL();
		String sql = "";
		
		pstm = conn.prepareStatement(sql);
		pstm.execute();
		
	}
	
	

	

	
	
	
	
	
	
	
}