package kr.co.jimmy.handler;

import javax.servlet.http.HttpServletRequest;

import kr.co.jimmy.command.Command;

public class logoutHandler implements Command {

	@Override
	public String process(HttpServletRequest request) {
		String url = "./main/logout.jsp";
		return url;
	}
}
