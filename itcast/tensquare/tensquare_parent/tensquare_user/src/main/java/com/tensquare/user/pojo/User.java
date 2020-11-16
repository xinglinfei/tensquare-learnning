package com.tensquare.user.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName User
 * @Description
 * @Author xlf
 * @Date 2020/10/23 1:23
 **/
@TableName("tb_user")
public class User implements Serializable {
	
	@TableId(type = IdType.INPUT)
	@NotNull(message = "用户id不允许为空")
	private String id;
	@NotNull(message = "手机号码不允许为空")
	@Pattern(regexp = "^(?:(?:\\+|00)86)?1\\d{10}$", message = "手机号码格式不正确")
	private String mobile;
	@NotNull(message = "用户密码不能为空")
	@Size(min = 6, max = 11, message = "密码长度必须为6-11个字符")
	private String password;
	private String nickname;
	private String sex;
	@JsonFormat(timezone = "GMT+8" ,pattern = "yyyy-MM-dd")
	private Date birthday;
	private String avatar;
	@Email(message = "邮箱格式不正确")
	private String email;
	@JsonFormat(timezone = "GMT+8" ,pattern = "yyyy-MM-dd HH:mm:ss")
	private Date regdate;
	@JsonFormat(timezone = "GMT+8" ,pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updatedate;
	@JsonFormat(timezone = "GMT+8" ,pattern = "yyyy-MM-dd HH:mm:ss")
	private Date lastdate;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Long online;
	private String interest;
	private String personality;
	private Integer fanscount;
	@PositiveOrZero(message = "跟随数不能为负数")
	private Integer followcount;
	
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public String getAvatar() {
		return avatar;
	}
	
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getRegdate() {
		return regdate;
	}
	
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	public Date getUpdatedate() {
		return updatedate;
	}
	
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	
	public Date getLastdate() {
		return lastdate;
	}
	
	public void setLastdate(Date lastdate) {
		this.lastdate = lastdate;
	}
	
	public Long getOnline() {
		return online;
	}
	
	public void setOnline(Long online) {
		this.online = online;
	}
	
	public String getInterest() {
		return interest;
	}
	
	public void setInterest(String interest) {
		this.interest = interest;
	}
	
	public String getPersonality() {
		return personality;
	}
	
	public void setPersonality(String personality) {
		this.personality = personality;
	}
	
	public Integer getFanscount() {
		return fanscount;
	}
	
	public void setFanscount(Integer fanscount) {
		this.fanscount = fanscount;
	}
	
	public Integer getFollowcount() {
		return followcount;
	}
	
	public void setFollowcount(Integer followcount) {
		this.followcount = followcount;
	}
}
