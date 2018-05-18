package ssxt.com.jdbc;

import java.util.Date;
import common.annotation.*;
/**
 * Users entity. @author MyEclipse Persistence Tools
 */
 
@Table(name = "Users")
public class Users implements java.io.Serializable {

	// Fields

	private Integer userid;
	private String username;
	private String password;
	private Date createTime;

	// Constructors

	@Column(name = "createTime")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(Integer userid) {
		this.userid = userid;
	}

	/** full constructor */
	public Users(Integer userid, String username, String password) {
		this.userid = userid;
		this.username = username;
		this.password = password;
	}

	// Property accessors
	 
	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	@Column(name = "username")
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password")
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}