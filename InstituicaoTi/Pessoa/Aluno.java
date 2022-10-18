package InstituicaoTi.Pessoa;

import java.util.List;

import InstituicaoTi.geral.BaseCurso;

public class Aluno extends Pessoa {
	private int codigoAluno;
	private String email;
	private List <Double> notas;
	private BaseCurso curso;

	public int getCodigoAluno() {
		return codigoAluno;
	}

	public void setCodigoAluno(int codigoAluno) {
		this.codigoAluno = codigoAluno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
