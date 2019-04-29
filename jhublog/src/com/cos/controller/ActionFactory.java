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
			return new BoardMainAction();
		}else if (cmd.contentEquals("boardListPage")) {
			return new BoardListPagingAction();
		}
		
		return null;
		
	}

}
