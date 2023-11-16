package model;

public class Vaga {
	private int id_vaga;
	private String data_vaga;
	private String nome;

	public Vaga(int id_vaga, float data_vaga, String nome) {
		this.id_vaga = id_vaga;
		this.data_vaga = data_vaga;
		this.nome = nome;
		
	}

	public Vaga(String data_vaga, String nome) {
		this.data_vaga = data_vaga;
		this.nome = nome;
		
	}

	public Vaga() {

	}

	public int getId_vaga() {
		return id_vaga;
	}

	public void setId_vaga(int id_vaga) {
		this.id_vaga = id_vaga;
	}

	public float getdata_vaga() {
		return data_vaga;
	}

	public void setdata_vaga(float data_vaga) {
		this.data_vaga = data_vaga;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	
	}

	@Override
	public String toString() {
		return "Vaga [id_vaga=" + id_vaga + ", data_vaga=" + data_vaga + ", nome=" + nome + "]";
	}

}
