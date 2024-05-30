package com.funfit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.funfit.bean.Batch;
import com.funfit.bean.Participants;
import com.funfit.resource.DbResource;

public class ParticipantsDao {
	
	public static int addParticipants (Participants p) {
		try {
			Connection con = DbResource.getConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into participants values(null, ?, ?, ?, ?, ?);");
			pstmt.setString(1, p.getFname());
			pstmt.setString(2, p.getLname());
			pstmt.setInt(3, p.getAge());
			pstmt.setString(4, p.getPhoneNumer());
			pstmt.setInt(5, p.getBatchId());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return 0;
		}
	}
	public static List<Participants> getParticipants() {
		try {
			List<Participants> lp = new ArrayList();
			Connection con = DbResource.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from participants;");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Participants p = new Participants();
				p.setPartId(rs.getInt(1));
				p.setFname(rs.getString(2));
				p.setLname(rs.getString(3));
				p.setAge(rs.getInt(4));
				p.setPhoneNumer(rs.getString(5));
				p.setBatchId(rs.getInt(6));
				lp.add(p);
			}
			return lp;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}
	
	public static int deleteParticipant(int partId) {
		try {
			Connection con = DbResource.getConnection();
			PreparedStatement pstmt = con.prepareStatement("delete from participants where partId=?;");
			pstmt.setInt(1, partId);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			return 0;
		}
	}
	
	public static List<Participants> updateParticipants(Participants p) {
		try {
			Connection con = DbResource.getConnection();
			PreparedStatement pstmt = con.prepareStatement("update participants set fname=?, lname=?, age=?, phoneNumber=?, batchId=? where partId=?;");
			pstmt.setString(1, p.getFname());
			pstmt.setString(2, p.getLname());
			pstmt.setInt(3, p.getAge());
			pstmt.setString(4, p.getPhoneNumer());
			pstmt.setInt(5, p.getBatchId());
			pstmt.setInt(6, p.getPartId());
			int result = pstmt.executeUpdate();
			if (result > 0) {
				List<Participants> lp = new ArrayList();
				PreparedStatement pstmt2 = con.prepareStatement("select * from participants;");
				ResultSet rs = pstmt2.executeQuery();
				while(rs.next()) {
					Participants pp = new Participants();
					pp.setPartId(rs.getInt(1));
					pp.setFname(rs.getString(2));
					pp.setLname(rs.getString(3));
					pp.setAge(rs.getInt(4));
					pp.setPhoneNumer(rs.getString(5));
					pp.setBatchId(rs.getInt(6));
					lp.add(pp);
				}
				return lp;
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}

}
