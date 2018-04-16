package kr.co.jimmy.command;

import javax.servlet.http.HttpServletRequest;

public interface Command {

	public String process(HttpServletRequest request);
}
