package com.example.TaskManageApp;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usr")
public class User implements Serializable {
	
	@Id
	@Column(name = "user_id")
	private String userId;
	
	private String password;
	
	@Enumerated(EnumType.STRING)
	private RoleName roleName;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RoleName getRoleName() {
		return roleName;
	}

	public void setRoleName(RoleName roleName) {
		this.roleName = roleName;
	}
	
	@Override
    public String toString() {
        return "User{userId='" + userId + "', password='" + password + "', roleName=" + roleName + "}";
    }
}
