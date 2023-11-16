package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionMySQL;
import model.Aluno;

public class AlunoDAO {
	
	//CREATE
	public void create (Aluno aluno) {
		String sql = "insert into aluno (Cpf, email, nome, senha) values (?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, aluno.getCPF());
			pstm.setString(2, aluno.getEmail());
			pstm.setString(3, aluno.getNome());
			pstm.setString(4, aluno.getSenha());
			
			pstm.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			 try {
				
				 if (pstm !=null) {
					 pstm.close();
				
				 }
				 if (conn !=null) {
					 conn.close();
				 }
				 
				 }catch (Exception e) {
					 e.printStackTrace();
				 }
	}
		
	}

	//READ
		public List <Aluno> read(){
			List<Aluno> alunos = new ArrayList<Aluno>();
			String sql = "select * from aluno";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Aluno aluno = new Aluno();
				aluno.setId (rset.getInt("id_Aluno"));
				aluno.setCPF (rset.getString("CPF"));
				aluno.setEmail (rset.getString("email"));
				aluno.setNome (rset.getString("nome"));
				aluno.setSenha (rset.getString("senha"));
				
				alunos.add(aluno);
			}
		
	} catch (Exception e) {
		e.printStackTrace();
		
	}finally {
		 try {
			
			 if (pstm !=null) {
				 pstm.close();
			
			 }
			 if (conn !=null) {
				 conn.close();
			 }
			 
			 }catch (Exception e) {
				 e.printStackTrace();
			 }
}
		
		return alunos;
	}
	
	//UPDATE
	public void update (Aluno aluno) {
		String sql = "UPDATE aluno SET CPF = ?,  email = ?, nome = ?, senha = ? WHERE id_Aluno = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, aluno.getCPF());
			pstm.setString(2, aluno.getEmail());
			pstm.setString(3, aluno.getNome());
			pstm.setString(4, aluno.getSenha());
			
			pstm.setInt(5, aluno.getId());
			
			pstm.execute();
		
	} catch (Exception e) {
		e.printStackTrace();
		
	}finally {
		 try {
			
			 if (pstm !=null) {
				 pstm.close();
			
			 }
			 if (conn !=null) {
				 conn.close();
			 }
			 
			 }catch (Exception e) {
				 e.printStackTrace();
			 }
}
	} 
	
	//DELETE
	public void delete (int id_Aluno) {
	String sql = "DELETE FROM aluno WHERE id_Aluno = ?";
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	try {
		conn = ConnectionMySQL.createConnectionMySQL();
		
		pstm = conn.prepareStatement(sql);
		
		pstm.setInt(1, id_Aluno);
		
		pstm.execute();
	
	} catch (Exception e) {
		e.printStackTrace();
		
	}finally {
		 try {
			
			 if (pstm !=null) {
				 pstm.close();
			
			 }
			 if (conn !=null) {
				 conn.close();
			 }
			 
			 }catch (Exception e) {
				 e.printStackTrace();
			 
}
	}
	}
	//readById
	public Aluno readById (int id_Aluno) {
		Aluno aluno = new Aluno();
		String sql = "select * from aluno WHERE id_Aluno= ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id_Aluno);
			
			rset = pstm.executeQuery();
			
			rset.next();
			
			aluno.setId(rset.getInt("id_Aluno"));
			aluno.setCPF(rset.getString("CPF"));
			aluno.setEmail(rset.getString("email"));
			aluno.setNome(rset.getString("nome"));
			aluno.setSenha(rset.getString("senha"));
		
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			
			try {
				 if (pstm !=null) {
					 pstm.close();
				
				 }
				 if (conn !=null) {
					 conn.close();
				 }
				 
				 }catch (Exception e) {
					 e.printStackTrace();
				 }
	    }
		return aluno;
		}
	}