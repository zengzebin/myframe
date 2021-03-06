package ssxt.com.zeng.bean;

 
// Generated 2016-10-18 17:59:22 by Hibernate Tools 3.6.0.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SymUser generated by hbm2java
 */
public class SymUser implements java.io.Serializable {

	private Long id;
	 
	private SymUser symUser;
	private String loginId;
	private String name;
	private Long department;
	private Long position;
	private String whoCreate;
	private Date createTime;
	private Integer uiseq;
	private Integer isMaintenance;
	private Integer isOwner;
	private Integer isManager;
	private Integer isCustomer;
	private String addvcd;
	private String ownerNo;
	private String mbPhone;
	 
	private Set<SymUser> symUsers = new HashSet<SymUser>(0);
	
	private Integer isEnable;

	private Integer checkFlag;
	public SymUser() {
	}

	public SymUser(String loginId, String name, String whoCreate, Date createTime) {
		this.loginId = loginId;
		this.name = name;
		this.whoCreate = whoCreate;
		this.createTime = createTime;
	}

	public SymUser(  SymUser symUser, String loginId, String name, Long department, Long position,
			String whoCreate, Date createTime, Integer uiseq, Integer isMaintenance, Integer isOwner, Integer isManager,
			Integer isCustomer, String addvcd, String ownerNo,  
			  Set<SymUser> symUsers,Integer isEnable) {
	 
		this.symUser = symUser;
		this.loginId = loginId;
		this.name = name;
		this.department = department;
		this.position = position;
		this.whoCreate = whoCreate;
		this.createTime = createTime;
		this.uiseq = uiseq;
		this.isMaintenance = isMaintenance;
		this.isOwner = isOwner;
		this.isManager = isManager;
		this.isCustomer = isCustomer;
		this.addvcd = addvcd;
		this.ownerNo = ownerNo;
		 
		this.symUsers = symUsers;
		this.isEnable=isEnable;
	}

	public Integer getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(Integer isEnable) {
		this.isEnable = isEnable;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

 
	public SymUser getSymUser() {
		return this.symUser;
	}

	public void setSymUser(SymUser symUser) {
		this.symUser = symUser;
	}

	public String getLoginId() {
		return this.loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getDepartment() {
		return this.department;
	}

	public void setDepartment(Long department) {
		this.department = department;
	}

	public Long getPosition() {
		return this.position;
	}

	public void setPosition(Long position) {
		this.position = position;
	}

	public String getWhoCreate() {
		return this.whoCreate;
	}

	public void setWhoCreate(String whoCreate) {
		this.whoCreate = whoCreate;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getUiseq() {
		return this.uiseq;
	}

	public void setUiseq(Integer uiseq) {
		this.uiseq = uiseq;
	}

	public Integer getIsMaintenance() {
		return this.isMaintenance;
	}

	public void setIsMaintenance(Integer isMaintenance) {
		this.isMaintenance = isMaintenance;
	}

	public Integer getIsOwner() {
		return this.isOwner;
	}

	public void setIsOwner(Integer isOwner) {
		this.isOwner = isOwner;
	}

	public Integer getIsManager() {
		return this.isManager;
	}

	public void setIsManager(Integer isManager) {
		this.isManager = isManager;
	}

	public Integer getIsCustomer() {
		return this.isCustomer;
	}

	public void setIsCustomer(Integer isCustomer) {
		this.isCustomer = isCustomer;
	}

	public String getAddvcd() {
		return this.addvcd;
	}

	public void setAddvcd(String addvcd) {
		this.addvcd = addvcd;
	}

	public String getOwnerNo() {
		return this.ownerNo;
	}

	public void setOwnerNo(String ownerNo) {
		this.ownerNo = ownerNo;
	}

	 
 
	public Set<SymUser> getSymUsers() {
		return this.symUsers;
	}

	public void setSymUsers(Set<SymUser> symUsers) {
		this.symUsers = symUsers;
	}

	public String getMbPhone() {
		return mbPhone;
	}

	public void setMbPhone(String mbPhone) {
		this.mbPhone = mbPhone;
	}

	public Integer getCheckFlag() {
		return checkFlag;
	}

	public void setCheckFlag(Integer checkFlag) {
		this.checkFlag = checkFlag;
	}

}
