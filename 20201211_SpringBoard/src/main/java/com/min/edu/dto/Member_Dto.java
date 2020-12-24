package com.min.edu.dto;

import java.io.Serializable;

public class Member_Dto implements Serializable {

	private static final long serialVersionUID = -8189992431355138954L;

	public String id;
	public String pw;
	public String auth;
	public String delflag;
	public String regdate;
	public String name;

	public Member_Dto() {
	}

	public Member_Dto(String id, String pw, String auth, String delflag, String regdate, String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.auth = auth;
		this.delflag = delflag;
		this.regdate = regdate;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Member_Dto [id=" + id + ", pw=" + pw + ", auth=" + auth + ", delflag=" + delflag + ", regdate="
				+ regdate + ", name=" + name + "]";
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

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
