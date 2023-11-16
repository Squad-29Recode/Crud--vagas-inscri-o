package model;

public class Inscricao {
	private int id_inscricao;
	private Aluno aluno;
	private Vaga vaga;

	public Inscricao(int id_inscricao, Aluno aluno, Vaga vaga) {
		this.id_inscricao = id_inscricao;
		this.aluno = aluno;
		this.vaga = vaga;
	}

	
	
	public Inscricao(Aluno aluno, Vaga vaga) {
		this.aluno = aluno;
		this.vaga = vaga;
	}



	public Inscricao() {

	}

	public int getId_inscricao() {
		return id_inscricao;
	}

	public void setId_inscricao(int id_inscricao) {
		this.id_inscricao = id_inscricao;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}



	@Override
	public String toString() {
		return "Inscricao [id_inscricao=" + id_inscricao + ",vaga=" + vaga + ",aluno=" + aluno + "]";
	}

}
