package com.cos.controller;

import com.cos.controller.board.*;
import com.cos.controller.member.MemberJoinAction;
import com.cos.controller.member.MemberJoinProcAction;
import com.cos.controller.member.MemberLoginAction;
import com.cos.controller.member.MemberLoginProcAction;
import com.cos.controller.member.MemberLogoutAction;

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
		}else if (cmd.contentEquals("boardWrite")) {
			return new BoardWriteAction();
		}else if (cmd.contentEquals("boardWriteProc")) {
			return new BoardWriteProcAction();
		}else if (cmd.contentEquals("boardView")) {
			return new BoardViewtAction();
		}else if (cmd.contentEquals("boardUpdate")) {
			return new BoardUpdateAction();
		}else if (cmd.contentEquals("boardUpdateProc")) {
			return new BoardUpdateProcAction();
		}else if (cmd.contentEquals("boardDelete")) {
			return new BoardDeleteAction();
		}else if (cmd.contentEquals("memberJoin")) {
			return new MemberJoinAction();
		}else if (cmd.contentEquals("memberJoinProc")) {
			return new MemberJoinProcAction();
		}else if (cmd.contentEquals("memberLogin")) {
			return new MemberLoginAction();
		}else if (cmd.contentEquals("memberLoginProc")) {
			return new MemberLoginProcAction();
		}else if (cmd.contentEquals("memberLogout")) {
			return new MemberLogoutAction();
		}
		
		return null;
		
	}

}
