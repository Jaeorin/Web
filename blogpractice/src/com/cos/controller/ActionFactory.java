package com.cos.controller;

import com.cos.controller.board.*;

public class ActionFactory {

	private static ActionFactory instance = new ActionFactory();

	private ActionFactory() {
	}
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String cmd) {
		if(cmd == null) {
			return new BoardListAction();
		}else if (cmd.contentEquals("boardList")) {
			return new BoardListAction();
		}else if (cmd.contentEquals("boardView")) {
			return new BoardViewtAction();
		}else if (cmd.contentEquals("boardWrite")) {
			return new BoardWriteAction();
		}else if (cmd.contentEquals("boardWriteProc")) {
			return new BoardWriteProcAction();
		}else if (cmd.contentEquals("boardUpdate")) {
			return new BoardUpdateAction();
		}else if (cmd.contentEquals("boardUpdateProc")) {
			return new BoardUpdateProcAction();
		}else if (cmd.contentEquals("boardDelete")) {
			return new BoardDeleteAction();
		}
		
		return null;
	}

}
