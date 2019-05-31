package VO;

public abstract class VO {
	private int id;
	
	public VO() {}

	public VO(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
