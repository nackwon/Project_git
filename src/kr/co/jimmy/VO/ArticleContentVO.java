package kr.co.jimmy.VO;

// �Խ��� ����
public class ArticleContentVO {

	private String content;
	private int number;

	public ArticleContentVO(String content, int number){
		this.content = content;
		this.number = number;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}
