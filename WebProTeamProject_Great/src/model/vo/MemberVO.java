package model.vo;

public class MemberVO {

	private String id;
	private String password;
	private String name;
	private String email;
	private String birthday;
	private String address;	
	private int point;
	private String grade;
	
	public MemberVO() {}

	public MemberVO(String id, String password, String name, String email, String birthday, String address, int point,
			String grade) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.birthday = birthday;
		this.address = address;
		this.point = point;	
		this.grade = grade;
	}

	public MemberVO(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	public MemberVO(String id, String password, String name, String email, String birthday, String address) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.birthday = birthday;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", birthday="
				+ birthday + ", address=" + address + ", point=" + point + ", grade=" + grade + "]";
	}

	
}