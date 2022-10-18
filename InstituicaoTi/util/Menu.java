package InstituicaoTi.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import InstituicaoTi.Pessoa.Aluno;
import InstituicaoTi.Pessoa.Professor;
import InstituicaoTi.geral.BaseTurma;

public class Menu {
	
	public void MontaMenu() {
		var opcao=0;
		
		Scanner in=new Scanner(System.in);
		
		while (opcao==0) {
			System.out.println("\"------------------------------------------------------------\\r\\n\"\r\n"
					+ "		+ \"Instituição TI\\r\\n\"\r\n"
					+ "		+ \"------------------------------------------------------------\\r\\n\"\r\n"
					+ "		+ \"Escolha uma das opções a seguir:\\r\\n\"\r\n"
					+ "		+ \"1) Listar todas as turmas\\r\\n\"\r\n"
					+ "		+ \"2) Informar dados de uma turma\\r\\n\"\r\n"
					+ "		+ \"3) Consultar os dados de uma turma\\r\\n\"\r\n"
					+ "		+ \"4) Consultar estatísticas gerais\\r\\n\"\r\n"
					+ "		+ \"5) Sair do sistema\\r\\n\"\r\n"
					+ "		+ \"------------------------------------------------------------\"\n\n"
					+ "Digite o número da opção: ");
			

			opcao=in.nextInt();
			
			switch (opcao) {
			case 1:
				ListaTurmas();
				break;
				
			case 2: 
				InformarDadosTurma();
				 break;
				
			case 3:
				ConsultarDadosTurma();
				break;
				
//			case 4:
	//			ConsultarEstatisticasGerais();
				
			case 5:
				System.out.println("Saindo do sistema...");
				break;
			}
		}
		in.close();
	}
	
	private void ListaTurmas() {
		Scanner in = new Scanner( System.in );
		if (BaseTurma.quantidadeTurmas==0) {
			System.out.println("Não há turmas cadastradas, tente selecionar a opção de: Informar dados de uma turma\n");
			
			System.out.println ("Pressione uma tecla para voltar ao menu.");
			
			in.nextLine();
			
			MontaMenu();
			
			in.close();
		}
		else {
		
			System.out.println(BaseTurma.retornaListaDeTurma());
			
			System.out.println ("Pressione uma tecla para voltar ao menu.");

			in.nextLine();

			MontaMenu();
			
			in.close();
		}
	}
	
	private void InformarDadosTurma() {
		String scanner= new String();
		BaseTurma turmaNova= new BaseTurma();
		BaseTurma.quantidadeTurmas++;
		
		Scanner in= new Scanner(System.in);
		
		System.out.println("Informe o código da turma:");
		var testaCodigo=in.nextInt();
		
		BaseTurma.retornaListaDeTurma(testaCodigo);
		
		while (!BaseTurma.retornaListaDeTurma(testaCodigo).equals("turma não encontrada")) {
			System.out.println("Já existe uma turma com este código, informe outro número:");
			testaCodigo=in.nextInt();
		}
		
		turmaNova.setCodigoTurma(testaCodigo);
	
		in.reset();	
		
		System.out.println("Informe o nome da disciplina:");
		
		turmaNova.setDisciplina(in.next());
		
		in.reset();
		
		System.out.println("Informe o código do professor:");
		
		turmaNova.setProfessor(new Professor());
	
		turmaNova.getProfessor().setCodigoProfessor(in.nextInt());
		
		in.reset();
		
		System.out.println("Informe o nome do professor:");
		
		turmaNova.getProfessor().setNome(in.next());
		
		in.reset();
		
		String pergunta= "S";
		
		List<Aluno> listaAlunos = new ArrayList<Aluno>();
		
		while (pergunta.equals("S") && turmaNova.getQuantidadeAlunos()<=30) {
			
			System.out.println("--------Informando alunos------\n");
			
			System.out.println("Informe o código do aluno:");
			
			turmaNova.setAluno(new Aluno());
			
			turmaNova.getAluno().setCodigoAluno(in.nextInt());
			
			in.reset();
			
			System.out.println("Informe o nome do aluno:");
			
			turmaNova.getAluno().setNome(in.next());
			
			in.reset();
			
			System.out.println("Informe o email do aluno:");
			
			turmaNova.getAluno().setEmail(in.next());
			
			listaAlunos.add(turmaNova.getAluno());
			
			in.reset();
			
			turmaNova.setQuantidadeAlunos(turmaNova.getQuantidadeAlunos()+1);
			
			System.out.println("Você quer continuar informando dados de alunos?[S-sim, N-não");
			
			pergunta=(in.next());
			
			in.reset();
		}
		
		turmaNova.setListaAlunos(listaAlunos);
		
		BaseTurma.colocaTurmaNaLista(turmaNova);
		
		MontaMenu();
		
		in.close();
	}
	
	private void ConsultarDadosTurma() {
		Scanner in= new Scanner(System.in);
		
		System.out.println("Digite o código da turma que você deseja consultar:");
		
		int consulta=in.nextInt();
		
		System.out.println(BaseTurma.retornaListaDeTurma (consulta));
		
		in.next();
		
		MontaMenu();

		in.close();
	}
}