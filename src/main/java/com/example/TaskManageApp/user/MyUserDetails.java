package com.example.TaskManageApp.user;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails{
//UserDetails...認証処理で必要になる資格情報とユーザの状態を提供するインタフェース
	
	
	private final User user;
	
	public MyUserDetails(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities(){
		return AuthorityUtils.createAuthorityList("ROLE_" + this.user.getRoleName().name());
	}
	// ユーザの権限(役割)を返すインタフェースの抽象メソッド。
	// 役割はenum型で宣言している
	
	
	@Override
	public String getPassword() {
		return this.user.getPassword();
	}
	
	@Override
	public String getUsername() {
		return this.user.getUserId();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}
}
