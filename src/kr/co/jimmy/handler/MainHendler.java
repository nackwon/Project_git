package kr.co.jimmy.handler;

import javax.servlet.http.HttpServletRequest;

import kr.co.jimmy.command.Command;

public class MainHendler implements Command {

	@Override
	public String process(HttpServletRequest request) {
		String url ="./main/main.jsp";
		return url;
	}
}
