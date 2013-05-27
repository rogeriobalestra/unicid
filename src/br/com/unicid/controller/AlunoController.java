package br.com.unicid.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent; // cuidado ao importar esse (tem que o do package faces)
import br.com.unicid.dao.AlunoDAO;
import br.com.unicid.model.Aluno;

@ManagedBean(name = "alunoController")
@ViewScoped
public class AlunoController {

	private Aluno aluno; // Bean
	private List<Aluno> listaAluno;
	
	
	
	
	/** CONSTRUTOR */
	public AlunoController() {
		aluno = new Aluno();
		
	}

	
	/** MENSAGEM */
	public void mensagem(String mensagem){
		 FacesMessage msg = new FacesMessage("",mensagem);
		 FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}
	
	
	
	/** GRAVAR  */
	public void gravar(ActionEvent evt){
		AlunoDAO dao = new AlunoDAO();
		
		try {
			dao.inserir(aluno);//insere
			mensagem("inserido com sucesso !");
			listar(); //chama lista
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/** LISTAR ALUNOS */
	public void listar(){
		AlunoDAO dao = new AlunoDAO();
		
		try {
			listaAluno = null;
			listaAluno = dao.listarAlunos();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/** ALTERAR */
	public void alterar(){
		AlunoDAO dao = new AlunoDAO();
		try {
			if(aluno != null){
				dao.alterar(aluno);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/** EXCLUIR */
	public void excluir(){
		AlunoDAO dao = new AlunoDAO();
		try {
			dao.excluir(aluno);
			listar();//chama lista
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	
	
	
	
	// GETTS AND SETTER  - DO CONTROLLER
	
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Aluno> getListaAluno() {
		return listaAluno;
	}

	public void setListaAluno(List<Aluno> listaAluno) {
		this.listaAluno = listaAluno;
	}
	
	
	

}
