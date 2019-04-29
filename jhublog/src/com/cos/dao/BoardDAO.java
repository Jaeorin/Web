package com.cos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.domain.Board;
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

	public List<Board> findall() {

		final String SQL = "SELECT num, title, content, userID, readCount, createDate,"
							+ " updateDate FROM board ORDER BY num DESC";
		Connection conn = DBManager.getConnection();
		List<Board> list = new ArrayList<Board>();
		try {
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();

			while (rs.next()) {

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

}
