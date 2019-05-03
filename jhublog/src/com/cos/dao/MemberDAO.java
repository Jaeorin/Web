package com.cos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import com.cos.domain.Member;
import com.cos.util.DBManager;
import com.cos.util.MyUtils;
import com.cos.dto.MemberUpdateDTO;

public class MemberDAO {
	
	private static MemberDAO instance = new MemberDAO();

	private MemberDAO() {
	}

	public static MemberDAO getInstance() {
		return instance;
	}

	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public int save(Member member) {
		final String SQL = "INSERT INTO member(num, userId, userPassword, userEmail, userPhone,"
							+ " userGender, userState, createDate, updateDate, userAddr)"
							+ " VALUES(member_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
			pstmt.setString(9, member.getUserAddr());

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
	
	public int findByUserId(String userId) {

		final String SQL = "SELECT count(*) FROM member WHERE userId = ?";
		Connection conn = DBManager.getConnection();

		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userId);
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
	
	public int adminCheck(String userId) {

		final String SQL = "SELECT admin FROM member WHERE userId = ?";
		Connection conn = DBManager.getConnection();

		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				int result = rs.getInt(1);
				return result; //  0이면 관리자, 1이면 사용자
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return -1;

	}
	
	public Member findByUserProfile(String userId) {
		final String SQL = "SELECT * FROM member WHERE userId = ? ";
		Connection conn = DBManager.getConnection();
		Member member = new Member();
		try {

			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userId);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				member.setNum(rs.getInt("num"));
				member.setUserId(rs.getString("userId"));
				member.setUserPassword(rs.getString("userPassword"));
				member.setUserEmail(rs.getString("userEmail"));
				member.setUserPhone(rs.getString("userPhone"));
				member.setUserGender(rs.getString("userGender"));
				member.setUserState(rs.getInt("userState"));
				member.setCreateDate(MyUtils.StringToLocalDate(rs.getString("createDate")));
				member.setUpdateDate(MyUtils.StringToLocalDate(rs.getString("updateDate")));
				member.setUserAddr(rs.getString("userAddr"));
				return member;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return null;
	}

	public int update(MemberUpdateDTO mDto) {
		final String SQL = "UPDATE member SET userPassword = ? , userEmail = ? , "
				+ "userPhone = ?, userGender = ?,userAddr = ?, updateDate = ? "
				+ "WHERE userId = ?";
		Connection conn = DBManager.getConnection();

		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, mDto.getUserPassword());
			pstmt.setString(2, mDto.getUserEmail());
			pstmt.setString(3, mDto.getUserPhone());
			pstmt.setString(4, mDto.getUserGender());
			pstmt.setString(5, mDto.getUserAddr());
			pstmt.setString(6, LocalDate.now().toString());
			pstmt.setString(7, mDto.getUserId());

			// result = 0 DML사용시 아무작용하지않았을 경우, 1~ 작용한 열의 갯수
			int result = pstmt.executeUpdate();// 트랜잭션 commit을 가지고 있다.
			return result;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

		return -1;
	}


}
