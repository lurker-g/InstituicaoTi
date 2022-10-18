package InstituicaoTi.Pessoa;

public class Professor extends Pessoa {
	private int codigoProfessor;
	private String universidadeFormacao;
	
	public String getUniversidadeFormacao() {
		return universidadeFormacao;
	}
	public void setUniversidadeFormacao(String universidadeFormacao) {
		this.universidadeFormacao = universidadeFormacao;
	}
	public int getCodigoProfessor() {
		return codigoProfessor;
	}
	public void setCodigoProfessor(int codigoProfessor) {
		this.codigoProfessor = codigoProfessor;
	}
}	
