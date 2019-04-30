package com.cos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.domain.Board;
import com.cos.dto.BoardUpdateDTO;
import com.cos.util.Code;
import com.cos.util.DBManager;
import com.cos.util.MyUtils;

//Data Access Object
public class BoardDAO {

	private static BoardDAO instance = new BoardDAO();

	private BoardDAO() {
	}

	public static BoardDAO getInstance() {
		return instance;
	}

	private PreparedStatement pstmt;
	private ResultSet rs;

	public List<Board> findall(int start, int end) {

		final String SQL = "select\r\n"
				+ "(select count(*) from board), num, title, content, userid, readcount, createdate, updatedate, mynum\r\n"
				+ "from(\r\n" + "select\r\n"
				+ "num, title, content, userid, readcount, createdate, updatedate, rownum as mynum\r\n" + "from\r\n"
				+ "board\r\n" + "order by\r\n" + "num DESC)\r\n" + "where\r\n" + "mynum > ? and mynum <= ?";
		Connection conn = DBManager.getConnection();
		List<Board> list = new ArrayList<Board>();
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				if (rs.isFirst()) {
					Code.setMaxListNum(rs.getInt(1));
				}

				Board board = new Board();
				board.setNum(rs.getInt("num"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setUserID(rs.getString("userID"));
				board.setReadCount(rs.getInt("readCount"));
				board.setCreateDate(MyUtils.StringToLocalDate(rs.getString("createDate")));
				board.setUpdateDate(MyUtils.StringToLocalDate(rs.getString("updateDate")));

				list.add(board);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			DBManager.close(conn, pstmt, rs);
		}

		return list;

	}
	
	public int save(Board board) {
		final String SQL = "INSERT INTO board(num, title, content, userID, readCount,"
				+ "createDate, updateDate) VALUES(board_seq.nextval, ?, ?, ?, ?, ?, ?)";
		Connection conn = DBManager.getConnection();
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getUserID());
			pstmt.setInt(4, board.getReadCount());
			pstmt.setString(5, board.getCreateDate().toString());
			pstmt.setString(6, board.getUpdateDate().toString());

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
	
	public Board findnum(int num) {

		// 완성되지 않은 쿼리문 생성
		final String SQL = "SELECT * FROM board WHERE num = ?";
		// DB와 연결
		Connection conn = DBManager.getConnection();
		// 값을 넣을보드 객체 생성
		Board board = null;
		try {

			// 완성되지 않은 쿼리문 받아오기
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, num);
			// rs는 첫번째 커서를 가리킨다
			rs = pstmt.executeQuery();

			if (rs.next()) {
				board = new Board();
				board.setNum(rs.getInt("num"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setUserID(rs.getString("userID"));
				board.setReadCount(rs.getInt("readCount"));
				board.setCreateDate(MyUtils.StringToLocalDate(rs.getString("createDate")));
				board.setUpdateDate(MyUtils.StringToLocalDate(rs.getString("updateDate")));
				return board;
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return null;

	}
	
	public int updateReadCount(int num) {
		final String SQL = "UPDATE board SET readCount = readCount+1 WHERE num = ?";
		Connection conn = DBManager.getConnection();

		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, num);

			int result = pstmt.executeUpdate();

			return result;

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBManager.close(conn, pstmt);

		}

		return -1;
	}
	
	public int update(BoardUpdateDTO bDto) {
		final String SQL = "UPDATE board SET title = ?, content = ?, updatedate = ? WHERE num = ?";
		Connection conn = DBManager.getConnection();

		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, bDto.getTitle());
			pstmt.setString(2, bDto.getContent());
			pstmt.setString(3, bDto.getUpdateDate().toString());
			pstmt.setInt(4, bDto.getNum());

			int result = pstmt.executeUpdate();

			return result;

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBManager.close(conn, pstmt);

		}

		return -1;
	}
	
	public int delete(int num) {

		final String SQL = "DELETE FROM board WHERE num = ?";
		Connection conn = DBManager.getConnection();

		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, num);

			int result = pstmt.executeUpdate();

			return result;

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBManager.close(conn, pstmt);

		}

		return -1;
	}


}
