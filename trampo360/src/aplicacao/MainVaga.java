package aplicacao;

import java.util.Scanner;

import dao.VagaDAO;
import model.Vaga;

public class MainVaga {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
	 VagaDAO vagaDAO = new VagaDAO();

		int opcao = 0, id = 0;

		String data_vaga = "";
		String nome = "";

		do {

			System.out.println("\n============================== Vaga =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();

			switch (opcao) {
			case 1:
				
				System.out.println("Digite a data da partida:");
				data_vaga = s.nextLine();
				System.out.println("Digite o nome da vaga:");
				nome = s.nextLine();

				Vaga vaga1 = new Vaga(data_vaga,nome);

				vagaDAO.create(vaga1);
				break;
			case 2:

				for (Vaga u : vagaDAO.read()) {
					System.out.println(u.toString());
				}

				break;
			case 3:

				System.out.println("Digite o id:");
				id = s.nextInt();
				s.nextLine();
				System.out.println("Digite a data:");
				data_vaga = s.nextLine();
				s.nextLine();
				System.out.println("Digite o nome do local:");
				nome = s.nextLine();

				Vaga vaga = new Vaga(id, data_vaga, nome);

		        vagaDAO.update(vaga);
				break;
			case 4:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();

				vagaDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();

				Vaga destino3 = vagaDAO.readById(id);

				Object vaga3;
				System.out.println(vaga3.toString());
				break;
			default:

				break;
			}

		} while (opcao != 0);

		System.out.println("Até mais!");
		s.close();

	}
}
