package com.springboot.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Track")
public class Track {
	@Id
	@Column(name = "userid")
	private long userid;
	@Column(name = "password")
	private String password;
	@Column(name = "cache")
	private String cache;

	public Track() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCache() {
		return cache;
	}

	public void setCache(String cache) {
		this.cache = cache;
	}

	public Track(long userid, String password, String cache) {
		super();
		this.userid = userid;
		this.password = password;
		this.cache = cache;
	}

}