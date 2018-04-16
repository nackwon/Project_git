package kr.co.jimmy.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jimmy.command.Command;

public class HandlerController extends HttpServlet {

	private HashMap<String, Command> map;

	@Override
	public void init() throws ServletException {
		map = new HashMap<String, Command>();
		String path = getServletContext().getRealPath("WEB-INF/file/commandList.txt");
		File file = new File(path);
		BufferedReader br = null;
		FileReader fr = null;
		String line = "";

		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);

			while ((line = br.readLine()) != null) {
				System.out.println(line); // Ȯ�� �۾�
				String[] temp = line.split("=");
				Object obj = Class.forName(temp[1]).newInstance(); // Ŭ���� �����ϴ� ����
				Command cmd = (Command) obj; // ���� ���� Ÿ���� Ŀ�ǵ� Ÿ���̴� ĳ����
				map.put(temp[0], cmd); // ���� ���������� map�� �ִ´�.
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String url = request.getServletPath();
		System.out.println("����" + url);

		Command cmd = map.get(url);
		String toUrl = cmd.process(request);
		RequestDispatcher rd = request.getRequestDispatcher(toUrl);
		rd.forward(request, response);
	}
}
