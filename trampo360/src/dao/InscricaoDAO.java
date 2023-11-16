package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionMySQL;
import model.Aluno;
import model.Inscricao;
import model.Vaga;

public class InscricaoDAO {

	// create
	public void create(Inscricao inscricao) {

		String sql = "insert into Compra (Id_Aluno, Id_Vaga, Id_Inscricao, Nome, Data_Inscricao) values (?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, inscricao.getAluno().getId_aluno());
			pstm.setInt(2, inscricao.getVaga().getId_vaga());
			pstm.setString(3, inscricao.getNome());
			pstm.setString(4, inscricao.getData_Inscricao());
			pstm.setInt(5, inscricao.getId_Inscricao());
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// read
	public List<Inscricao> read() {
		List<Inscricao> inscricao = new ArrayList<Inscricao>();
		String sql = "select * from Inscricao";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Inscricao inscricao = new Inscricao();

				int Id_Vaga = rset.getInt("Id_Vaga");
				VagaDAO vagadao = new VagaDAO();
				Vaga vaga = vagadao.readById(Id_Vaga);
				inscricao.setInscricao(inscricao);

				int Id_Aluno = rset.getInt("Id_Aluno");
				AlunoDAO clientedao = new AlunoDAO();
				Aluno aluno = alunodao.readById(Id_Aluno);
				inscricao.setInscricao(inscricao);

				inscricao.setId_inscricao(rset.getInt("Id_Inscricao"));

				inscricao.add(inscricao);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return inscricao;
	}

	// update
	public void update(Inscricao compra) {
		String sql = "UPDATE compra SET Id_Aluno = ?, Id_Vaga = ?, Nome = ?, Data_Inscricao = ? WHERE Id_Inscricao = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, Inscricao.getAluno().getId_Aluno());
			pstm.setInt(2, Inscricao.getVaga().getId_Vaga());
			pstm.setInt(3, Inscricao.getNome();
			pstm.setInt(4, Inscricao.getData_Inscricao();
			pstm.setInt(5, Inscricao.getId_inscricao());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// delete
	public void delete(int id) {
		String sql = "DELETE FROM Inscricao WHERE Id_Inscricao = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// readById
	public Inscricao readById(int id) {
		Inscricao compra = new Inscricao();
		String sql = "select * from Inscricao WHERE Id_Inscricao = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();

			int Id_Vaga = rset.getInt("Id_Vaga");
			VagaDAO Vagadao = new VagaDAO();
			Vaga vaga = vagadao.readById(Id_Vaga);
			Inscricao.setId_inscricao(vaga);

			int Id_Aluno = rset.getInt("Id_Aluno");
			AlunoDAO alunodao = new AlunoDAO();
			Aluno cliente = alunodao.readById(Id_Aluno;
			Inscricao.setAluno(aluno);
			Inscricao.setId_inscricao(rset.getInt("Id_Inscricao"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return inscricao;
	}

}