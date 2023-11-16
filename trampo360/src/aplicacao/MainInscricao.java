package aplicacao;

import java.util.Scanner;

import dao.AlunoDAO;
import dao.InscricaoDAO;
import dao.VagaDAO;
import model.Aluno;
import model.Inscricao;
import model.Vaga;

public class MainInscricao {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		InscricaoDAO inscricaoDAO = new InscricaoDAO();
		AlunoDAO alunoDAO = new AlunoDAO();
		VagaDAO vagaDAO = new VagaDAO();

		int opcao = 0, id = 0, id_Aluno = 0, id_Vaga = 0;

		String data_Inscricao = "";
		String nome = "";
		String inscricao = "";

		do {

			System.out.println("\n============================== Inscrição =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();

			switch (opcao) {
			case 1:
				System.out.println("Data da inscrição:");
				data_Inscricao = s.nextLine();
				System.out.println("Digite o nome:");
				nome = s.nextLine();
				System.out.println("Digite o id do aluno:");
				id_Aluno = s.nextInt();
				s.nextLine();
				System.out.println("Digite o id do curso:");
				id_Vaga = s.nextInt();
				s.nextLine();

				Aluno aluno1 = alunoDAO.readById(id_Aluno);
				Vaga vaga1 = vagaDAO.readById(id_Vaga);

				Inscricao inscricao1 = new Inscricao(data_Inscricao, nome, id_Aluno, id_Vaga);

				inscricaoDAO.create(inscricao1);

				break;
			case 2:

				for (Inscricao e : inscricaoDAO.read()) {

					System.out.println(e.toString());
				}

				break;
			case 3:
				System.out.println("Digite o id da escolha:");
				id = s.nextInt();
				s.nextLine();
				System.out.println("Digite o nome:");
				nome = s.nextLine();
				System.out.println("Digite o id do aluno:");
				id_Aluno = s.nextInt();
				s.nextLine();
				System.out.println("Digite o id da vaga:");
				id_Vaga = s.nextInt();
				s.nextLine();

				Aluno aluno2 = alunoDAO.readById(id_Aluno);
				Vaga vaga2 = vagaDAO.readById(vaga2);

				Inscricao inscricao2 = new Inscricao(id, nome, id_Aluno, vaga2);

				inscricaoDAO.update(inscricao2);
				break;
			case 4:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();

				inscricaoDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();

				Inscricao inscricao3 = inscricaoDAO.readById(id);

				System.out.println(inscricao3.toString());
				break;
			default:
				System.out.println(opcao != 0 ? "Opção invalida, digite novamente" : "");
				break;
			}

		} while (opcao != 0);

		System.out.println("Até mais!");
		s.close();

	}

}