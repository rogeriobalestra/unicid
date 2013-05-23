package br.com.unicid.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent; // cuidado ao importar esse (tem que o do package faces)

import br.com.unicid.dao.AlunoDAO;
import br.com.unicid.model.Aluno;

@ManagedBean(name = "alunoController")
@ViewScoped
public class AlunoController {

	private Aluno aluno; // Bean

	/** CONSTRUTOR */
	public AlunoController() {
		aluno = new Aluno();
		
	}

	
	
	
	
	
	/** GRAVAR  */
	public void gravar(ActionEvent evt){
		
		System.out.println(aluno.getDataNascimento());
		
		AlunoDAO dao = new AlunoDAO();
		
		try {
			dao.inserir(aluno);
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

}
