package com.cos.controller;

import com.cos.controller.board.*;

//공장 - 하나라는 것이 보증됨 - 싱글톤 패턴
public class ActionFactory {

	private static ActionFactory instance = new ActionFactory();

	private ActionFactory() {
	}

	public static ActionFactory getInstance() {
		return instance;
	}

	// 라우팅 기계
	public Action getAction(String cmd) {
		if (cmd == null) {
			return new BoardListAction();
		} else if (cmd.equals("boardList")) {
			return new BoardListAction();
		} else if (cmd.equals("boardView")) {
			return new BoardViewAction();
		} else if (cmd.equals("boardWrite")) {
			return new BoardWriteAction();
		} else if (cmd.equals("boardUpdate")) {
			return new BoardUpdateAction();
		} else if (cmd.equals("boardUpdateProc")) {
			return new BoardUpdateProcAction();
		} else if (cmd.equals("boardDelete")) {
			return new BoardDeleteAction();
		}

		return null;
		
	}

}
