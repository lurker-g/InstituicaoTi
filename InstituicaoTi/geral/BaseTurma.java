package InstituicaoTi.geral;

import java.util.ArrayList;
import java.util.List;

import InstituicaoTi.Pessoa.Aluno;
import InstituicaoTi.Pessoa.Professor;


public class BaseTurma  {
	private int codigoTurma;
	private String disciplina;
	private Professor professor;
	private Aluno aluno;
	private static List<BaseTurma> listaTurmas=new ArrayList<BaseTurma>();
	private List<Aluno> listaAlunos;
	private int quantidadeAlunos;
	private int alunos;
	public static int quantidadeTurmas;
	
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public int getQuantidadeAlunos() {
		return quantidadeAlunos;
	}
	public void setQuantidadeAlunos(int quantidadeAlunos) {
		this.quantidadeAlunos = quantidadeAlunos;
	}
	
	public String getListaAlunos() {
		String listaDeAlunos=null;
		for (var item:listaAlunos) {
			if (listaDeAlunos!=null) {
				listaDeAlunos=listaDeAlunos+item.getNome()+"\n\n";	
			}
			else { 
				listaDeAlunos=item.getNome()+"\n\n";	
				}
		}	
		return listaDeAlunos;
	}
	public void setListaAlunos(List<Aluno> listaAlunos) {
		this.listaAlunos = listaAlunos;
	}

	public int getCodigoTurma() {
		return codigoTurma;
	}
	public void setCodigoTurma(int codigoTurma) {
		this.codigoTurma = codigoTurma;
	}
	
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	
	public int getAlunos() {
		return alunos;
	}
	public void setAlunos(int alunos) {
		this.alunos = alunos;
	}
	
	public static int getQuantidadeTurmas() {
		return quantidadeTurmas;
	}
	
	public static void colocaTurmaNaLista (BaseTurma turma) {
		BaseTurma.listaTurmas.add(turma);
	}
	
	public static String retornaListaDeTurma () {
		String listaDeTurmas=null;
		for (var item:listaTurmas) {
			if (listaDeTurmas!=null) {
				listaDeTurmas=listaDeTurmas+item.toString()+"\n";	
			}
			else { 
				listaDeTurmas=item.toString()+"\n";	
			}
		}
		return listaDeTurmas;
	}
	
	public static String retornaListaDeTurma (int codigo) {
		String listaDeTurmas=null;
		for (var item:listaTurmas) {
			if (item.getCodigoTurma()==codigo) {
				listaDeTurmas=item.toString();
			}
		}
		if (listaDeTurmas==null) {
			return "turma não encontrada";
		}
		else {
			return listaDeTurmas;
		}
	}
	
	@Override
	public String toString() {
		return "BaseTurma [codigoTurma=" + codigoTurma + ", disciplina=" + disciplina + ", professor=" + professor.getNome()
				+ ", alunos:\n" + getQuantidadeAlunos() + "]";
	}
	
}
