package pojo;

import java.sql.Date;

public class User {
	//id | name | email | password | reg_amt | reg_date   | role

	private int id;
	private String name;
	private String email;
	private String password;
	private double reg_amnt;
	private Date reg_date;
	private String role;
	
	//ctor
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	

	public User(int id, String name, String email, String password, double reg_amnt, Date reg_date, String role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.reg_amnt = reg_amnt;
		this.reg_date = reg_date;
		this.role = role;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getReg_amnt() {
		return reg_amnt;
	}

	public void setReg_amnt(double reg_amnt) {
		this.reg_amnt = reg_amnt;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", reg_amnt="
				+ reg_amnt + ", reg_date=" + reg_date + ", role=" + role + "]";
	}
	
	
	
	
}



