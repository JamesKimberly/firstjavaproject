package MPVO;

public class MPVO {
	private String id;
	private String pw;
	private String name;
	private String phone;
	private String email;
	private int MaxScore;
	
	
	public MPVO(String id, String name, int maxScore) {
		this.id = id;
		this.name = name;
		MaxScore = maxScore;
	}

	public MPVO(String name, String id, String pw, String phone, String email, int maxScore) {
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.phone = phone;
		this.email = email;
		this.MaxScore = maxScore;
	}
	
	public MPVO(String id, String pw, String name, String phone, String email) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	
	public MPVO() {
		
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getMaxScore() {
		return MaxScore;
	}
	public void setMaxScore(int maxScore) {
		MaxScore = maxScore;
	}
}
