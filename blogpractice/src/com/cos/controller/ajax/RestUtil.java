package com.cos.controller.ajax;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.cos.dao.MemberDAO;
import com.cos.domain.Reply;
import com.cos.util.DBManager;
public class RestUtil {
	
	private PreparedStatement pstmt;

	public String duplicateId(String userId) {

		MemberDAO memberDAO = MemberDAO.getInstance();

		int result = memberDAO.findByUserId(userId);

		if (result == 0) {
			return "OK";
		}

		return "ERROR";
		
	}
	
	public int save(Reply reply) {
		final String SQL = "INSERT INTO reply VALUES(reply_seq.nextval, ?, ?, ?, ?)";
		Connection conn = DBManager.getConnection();
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, reply.getContent());
			pstmt.setString(2, reply.getUserId());
			pstmt.setInt(3, reply.getBoardNum());
			pstmt.setString(4, reply.getCreateDate());

			int result = pstmt.executeUpdate();
			return result;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}


}
