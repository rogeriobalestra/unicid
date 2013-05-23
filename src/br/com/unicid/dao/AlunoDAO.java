package br.com.unicid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.unicid.model.Aluno;
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
	public void inserir(Aluno aluno) throws Exception{
		conectaMySQL(); //Conecta MySQL
		
		try {
			
			String sql = "INSERT INTO unicid.tb_aluno(ca, nome, email, data_nascimento, endereco, idade) VALUES(?,?,?,?,?,?)";
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, aluno.getCa());
			pstm.setString(2, aluno.getNome());
			pstm.setString(3, aluno.getEmail());
			pstm.setDate(4, aluno.getDataNascimento());
			pstm.setString(5, aluno.getEndereco());
			pstm.setInt(6, aluno.getIdade());
			pstm.execute();
			
		} finally {
			ConnectionFactory.closeConnection(conn, pstm, rs);
		}
	}
	
	

	

	
	
	
	
	
	
	
}
