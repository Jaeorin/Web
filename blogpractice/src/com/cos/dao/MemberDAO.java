package com.cos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cos.domain.Member;
import com.cos.util.DBManager;

//Date Acces Object
public class MemberDAO {

	static final Logger LOG = LogManager.getLogger(DBManager.class.getName());

	private static MemberDAO instance = new MemberDAO();

	private MemberDAO() {
	}

	public static MemberDAO getInstance() {
		return instance;
	}

	private PreparedStatement pstmt;
	private ResultSet rs;

	public int save(Member member) {
		final String SQL = "INSERT INTO member(num, userId, userPassword, userEmail, userPhone, userGender, userState, createDate, updateDate) VALUES(member_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
		Connection conn = DBManager.getConnection();
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPassword());
			pstmt.setString(3, member.getUserEmail());
			pstmt.setString(4, member.getUserPhone());
			pstmt.setString(5, member.getUserGender());
			pstmt.setInt(6, member.getUserState());
			pstmt.setString(7, member.getCreateDate().toString());
			pstmt.setString(8, member.getUpdateDate().toString());

			// result=0 : fail, result=1 :success
			int result = pstmt.executeUpdate(); // 트랜잭션 commit을 가지고 있다
			return result;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		// 서버오류
		return -1;
	}

	public int findByUserIdAndUserPassword(String userId, String userPassword) {

		final String SQL = "SELECT count(*) FROM member WHERE userId = ? AND userPassword = ?";
		Connection conn = DBManager.getConnection();

		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPassword);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				int result = rs.getInt(1);
				return result; // count(*) 1이면 인증, 0이면 미인증
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return -1;

	}

}
