package aplicacao;

import java.util.Scanner;

import dao.AlunoDAO;
import model.Aluno;

public class MainAluno {

	public static void main(String[] args) {
		
		AlunoDAO alunoDAO = new AlunoDAO ();	
		Scanner s = new Scanner (System.in);
	
		int opcao = 0, id_Aluno = 0;
		
		String CPF = "", email = "", nome = "", senha = "";
		
		do {
			
			System.out.println("\n=============================== Aluno ===============================\n");
			System.out.println("1-CRIAR  2-CONSULTAR  3-ATUALIZAR  4-DELETAR  5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();
			
			switch (opcao) {
			case 1:
				
			   System.out.println("Digite o CPF:");
			   CPF = s.nextLine();
			   System.out.println("Digite o email:");
			   email = s.nextLine();
			   System.out.println("Digite o nome:");
			   nome = s.nextLine();
			   System.out.println("Digite a senha:");
			   senha = s.nextLine();
				
			   Aluno aluno1 = new Aluno (CPF, email, nome, senha);
			   
			   alunoDAO.create (aluno1);
			   break;
			   
			case 2:
				
				for (Aluno a : alunoDAO.read()){
					System.out.println(a.toString());
				}
				
				break;
				
			 case 3:
				 
				System.out.println("Digite o id:");
				id_Aluno = s.nextInt();
				s.nextLine();
				System.out.println("Digite o CPF:");
				CPF = s.nextLine();
				System.out.println("Digite o email:");
				email = s.nextLine();
				System.out.println("Digite o nome:");
				nome = s.nextLine();
				System.out.println("Digite a senha:");
				senha = s.nextLine();
				
				Aluno aluno2 = new Aluno(id_Aluno, CPF, email, nome, senha); 
				alunoDAO.update(aluno2);	
				break;
					   
			 case 4:
				 System.out.println("Digite um id:");
				 id_Aluno = s.nextInt();
				 s.nextLine();
				 	
				alunoDAO.delete(id_Aluno);		
				break;
						   
			 case 5:
				 
				 System.out.println("Digite um id:");
				 id_Aluno = s.nextInt();
				 s.nextLine();
				 	
				Aluno aluno3 = alunoDAO.readById(id_Aluno);
				System.out.println(aluno3.toString());
				break;
				
			default:	
				break;
			}
			
			
		} while (opcao !=0);
		
		System.out.println("Até mais!");
		 s.close();
    }

}