package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.RendezVous;

public class RendezVousDAO {
	
	
	public List<RendezVous> getAll(){
		List<RendezVous> liste = new ArrayList<>();
		String sql = "select * from rendez_vous order by date_rdv, heure_rdv";
		
		try(Connection cn = ConnectionDB.getConnection(); 
				PreparedStatement pr = cn.prepareStatement(sql); 
				ResultSet rs = pr.executeQuery()){
			 while(rs.next()) {
				 RendezVous rdv = new RendezVous();
				 rdv.setId(rs.getInt("id"));
				 rdv.setDateRdv(rs.getString("date_rdv"));
				 rdv.setHeureRdv(rs.getString("heure_rdv"));
				 rdv.setDisponible(rs.getBoolean("disponible"));
				 rdv.setPatient(rs.getString("patient"));
				 liste.add(rdv);
			 }
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return liste;
	}
	
	
	public boolean reserver(int id, String patient) {
		String sql = "update rendez_vous set disponible = 0, patient = ? "
				+ "where id = ? and disponible = 1";
		try(Connection cn = ConnectionDB.getConnection(); 
				PreparedStatement pr = cn.prepareStatement(sql);){
			
			pr.setString(1,patient);
			pr.setInt(2, id);
			return pr.executeUpdate() > 0;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
