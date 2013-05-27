package br.com.unicid.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
			
			String sql = "INSERT INTO unicid.tb_aluno(ca, nome, email, data_nascimento, endereco, idade) VALUES(?,?,?,?,?,?);";
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, aluno.getCa());
			pstm.setString(2, aluno.getNome());
			pstm.setString(3, aluno.getEmail());
			pstm.setString(4, aluno.getDataNascimento());
			pstm.setString(5, aluno.getEndereco());
			pstm.setInt(6, aluno.getIdade());
			pstm.execute();
			
		} finally {
			ConnectionFactory.closeConnection(conn, pstm, rs);
		}
	}
	
	

	/** LISTA */
	public List<Aluno> listarAlunos() throws Exception{
		conectaMySQL(); //Conecta MySQL
		
		List<Aluno> lista = new ArrayList<Aluno>();
		Aluno aluno = null;
		
		try {
			
			String sql = "SELECT * FROM unicid.tb_aluno";
			
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()){
				aluno = new Aluno();
				aluno.setCa(rs.getString("ca"));
				aluno.setNome(rs.getString("nome"));
				aluno.setEmail(rs.getString("email"));
				aluno.setDataNascimento(rs.getString("data_nascimento"));
				aluno.setEndereco(rs.getString("endereco"));
				aluno.setIdade(rs.getInt("idade"));
				lista.add(aluno);
			}
			
		} finally {
			ConnectionFactory.closeConnection(conn, pstm, rs);
		}
		
		return lista;
	}
	
	
	
	/** ALTERAR */
	public void alterar(Aluno aluno) throws Exception{
		conectaMySQL(); //Conecta MySQL
		
		try {
			
			String sql = "UPDATE unicid.tb_aluno SET ca = ?, nome = ?, email = ?, data_nascimento = ?, endereco = ?, idade = ? WHERE ca = ?";
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, aluno.getCa());
			pstm.setString(2, aluno.getNome());
			pstm.setString(3, aluno.getEmail());
			pstm.setString(4, aluno.getDataNascimento());
			pstm.setString(5, aluno.getEndereco());
			pstm.setInt(6, aluno.getIdade());
			pstm.setString(7, aluno.getCa());
			pstm.execute();
			
		} finally {
			ConnectionFactory.closeConnection(conn, pstm, rs);
		}
	}

	
	/** EXCLUIR */
	public void excluir(Aluno aluno) throws Exception{
		conectaMySQL(); //Conecta MySQL
		
		try {
			
			String sql = "DELETE FROM unicid.tb_aluno WHERE ca = ?";
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, aluno.getCa());
			pstm.execute();
			
		} finally {
			ConnectionFactory.closeConnection(conn, pstm, rs);
		}
	}
	
	
	
	
	
	
}
