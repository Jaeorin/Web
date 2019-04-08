package com.cos.controller;

//공장 - 하나라는 것이 보증됨 - 싱글톤 패턴
public class ActionFactory {

	private static ActionFactory instance = new ActionFactory();

	private ActionFactory() {
	}

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String cmd) {
		if (cmd == null) {
			return null;
		} else if (cmd.equals("boardList")) {
			return null;
		}
		return null;
	}

}
