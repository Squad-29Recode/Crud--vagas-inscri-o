package model;

public class Aluno {

    //atributos
	private int id_Aluno;
	private String CPF;
	private String email;
	private String nome;
	private String senha;
	
	//construtor
	public Aluno () {
	}

	public Aluno(int id_Aluno, String CPF, String email, String nome, String senha) {
		this.id_Aluno = id_Aluno;
		this.CPF = CPF;
		this.email = email;
		this.nome = nome;
		this.senha = senha;
	}

	public  Aluno(String CPF, String email, String nome, String senha) {
		this.CPF = CPF;
		this.email = email;
		this.nome = nome;
		this.senha = senha;
	}
	

	//getters e setters	
	public int getId() {
		return id_Aluno;
	}

	public void setId(int id_Aluno) {
		this.id_Aluno = id_Aluno;
	}
	
	public String getCPF() {
		return CPF;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	//toString
	
	@Override
	public String toString() {
		return "Aluno [id_Aluno=" + id_Aluno + ", CPF=" + CPF + ", email=" + email + ", nome=" + nome + ", senha=" + senha + "]";
	}

	
		
}