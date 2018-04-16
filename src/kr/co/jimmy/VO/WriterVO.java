package kr.co.jimmy.VO;

//게시판 작성자 정보
public class WriterVO {

	private String id;
	private String name;

	public WriterVO(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
