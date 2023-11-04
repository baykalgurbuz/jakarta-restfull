package com.bilgeadam.postgresqljdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bilgeadam.postgresqljdbc.Constants;
import com.bilgeadam.postgresqljdbc.model.Ogrenci; 

public class OgrenciRepository {
	public Ogrenci getByID(long id) throws SQLException
	{
		Ogrenci ogr = null;
		Connection con = Constants.getConnection();
		String sql = "select * from \"public\".\"OGRENCI\" where \"ID\" = ?";
		PreparedStatement stmnt = con.prepareStatement(sql);
		stmnt.setLong(1, id);
		ResultSet result = stmnt.executeQuery();
		while (result.next())
		{
			ogr = new Ogrenci(result.getLong("ID"), result.getString("NAME"), result.getLong("OGRENCI_NUMBER"),result.getLong("YEAR"));
		}
		con.close();
		return ogr;
	}
	public ArrayList<Ogrenci> getAll() throws SQLException
	{
		ArrayList<Ogrenci> ogr=new ArrayList<>() ;
		Connection con = Constants.getConnection();
		Statement stmnt = con.createStatement();
		ResultSet result = stmnt.executeQuery("select * from \"public\".\"OGRENCI\" order by \"ID\" asc");
		while (result.next())
		{
			long id = result.getLong("ID");
			String name = result.getString("NAME");
			long ogrencı_number = result.getLong("OGRENCI_NUMBER");
			long year = result.getLong("YEAR");
			ogr.add(new Ogrenci(id, name, ogrencı_number,year));
		}
		result.close();
		stmnt.close();
		con.close();
		return ogr;
	 
		
	}
	public boolean save(Ogrenci ogrenci) throws SQLException
	{
		boolean result = false;
		Connection con = Constants.getConnection();
		String sql = "INSERT INTO \"public\".\"OGRENCI\"(\"NAME\", \"OGRENCI_NUMBER\",\"YEAR\") VALUES (?, ?, ?)";
		PreparedStatement stmnt = con.prepareStatement(sql);
		stmnt.setString(1, ogrenci.getNAME());
		stmnt.setLong(2, ogrenci.getOGRENCI_NUMBER());
		stmnt.setLong(3, ogrenci.getYEAR());
		result = stmnt.executeUpdate() == 1;
		stmnt.close();
		con.close();
		return result;
	}
	public boolean deleteByID(long id) throws SQLException
	{
		Connection con = Constants.getConnection();
		String sql = "delete from \"public\".\"OGRENCI\" where \"ID\" = ?";
		PreparedStatement stmnt = con.prepareStatement(sql);
		stmnt.setLong(1, id);
		boolean result = stmnt.executeUpdate() == 1;
		stmnt.close();
		con.close();
		return result;
	}	 
}
