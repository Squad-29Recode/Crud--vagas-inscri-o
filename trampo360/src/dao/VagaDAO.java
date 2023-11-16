package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionMySQL;
import model.Vaga;

public class VagaDAO {

	// create
	public void create(Vaga vaga) {

		String sql = "insert into Destino (Data_vaga, Nome) values (?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setFloat(1, vaga.getData_vaga());
			pstm.setString(2, vaga.getNome());		
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
	public List<Vaga> read() {
		List<Vaga> vagas = new ArrayList<Vaga>();
		String sql = "select * from Vaga";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Vaga vaga = new Vaga();

				vagas.setId_Vaga(rset.getInt("Id_Vaga"));
				vagas.setData_vaga(rset.getFloat("Data_vaga"));
				vagas.setNome(rset.getString("Nome"));
				vagas.add(vaga);
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

		return vagas;
	}

	// update
	public void update(Vaga destino) {
		String sql = "UPDATE destino SET Nome = ?, Data_vaga = ? WHERE Id_Vaga = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setFloat(1, Vaga.getData_vaga());
			pstm.setString(2, Vaga.getNome());
			pstm.setInt(3, Vaga.getId_Vaga());

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
		String sql = "DELETE FROM Vaga WHERE Id_Vaga = ?";

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
	public Vaga readById(int id) {
		Vaga vaga = new Vaga();
		String sql = "select * from Vaga WHERE Id_Vaga = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();

			vaga.setId_Vaga(rset.getInt("Id_Vaga"));
			vaga.setData_vaga(rset.getFloat("Data_vaga"));
			vaga.setNome(rset.getString("Nome"));

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
		return vaga;
	}

}