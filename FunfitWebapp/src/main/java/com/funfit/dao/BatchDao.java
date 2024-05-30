package com.funfit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.funfit.bean.Batch;
import com.funfit.resource.DbResource;

public class BatchDao {
	
		public static int addBatch (Batch batch) {
			try {
				Connection con = DbResource.getConnection();
				PreparedStatement pstmt = con.prepareStatement("insert into batch values(null, ?, ?);");
				pstmt.setString(1, batch.getTypeOfBatch());
				pstmt.setString(2, batch.getTime());
				return pstmt.executeUpdate();
			} catch (Exception e) {
				System.err.println(e.getMessage());
				return 0;
			}
		}
		public static List<Batch> getBatch(){
			try {
				List<Batch> lb = new ArrayList();
				Connection con = DbResource.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from batch;");
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					Batch b = new Batch();
					b.setBatchId(rs.getInt(1));
					b.setTypeOfBatch(rs.getString(2));
					b.setTime(rs.getString(3));
					lb.add(b);
				}
				return lb;
			} catch (Exception e) {
				System.err.println(e.getMessage());
				return null;
			}
		}
		public static int deleteBatch(int batchId) {
			try {
				Connection con = DbResource.getConnection();
				PreparedStatement pstmt = con.prepareStatement("delete from batch where batchId=?;");
				pstmt.setInt(1, batchId);
				return pstmt.executeUpdate();
			} catch (Exception e) {
				return 0;
			}
			
		}
		
		public static List<Batch> updateBatch(Batch b) {
			try {
				Connection con = DbResource.getConnection();
				PreparedStatement pstmt = con.prepareStatement("update batch set typeOfBatch=?, time=? where batchId=?;");
				pstmt.setString(1, b.getTypeOfBatch());
				pstmt.setString(2, b.getTime());
				pstmt.setInt(3, b.getBatchId());
				int result = pstmt.executeUpdate();
				if (result > 0) {
					List<Batch> lb = new ArrayList();
					PreparedStatement pstmt2 = con.prepareStatement("select * from batch;");
					ResultSet rs = pstmt2.executeQuery();
					while(rs.next()) {
						Batch bb = new Batch();
						bb.setBatchId(rs.getInt(1));
						bb.setTypeOfBatch(rs.getString(2));
						bb.setTime(rs.getString(3));
						lb.add(bb);
					}
					return lb;
				} else {
					return null;
				}
			} catch (Exception e) {
				return null;
			}
		}
}