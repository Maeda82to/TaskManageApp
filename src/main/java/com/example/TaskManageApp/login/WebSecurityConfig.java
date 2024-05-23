package com.example.TaskManageApp.login;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.TaskManageApp.user.MyUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {
	
	private MyUserDetailsService myUserDetailsService;
//	
//	@Autowired
//	public WebSecurityConfig(MyUserDetailsService myUserDetailsService) {
//		this.myUserDetailsService = myUserDetailsService;
//	}

	//パスワードエンコーダの設定
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/js/**", "/css/**","/register").permitAll() 
                .anyRequest().authenticated() //セキュリティ対策が不要なリソースにはSpSe処理を適用しないように、それ以外は認証を要求
                    )
            .formLogin(login -> login
                .loginPage("/loginForm") //URL指定
                .loginProcessingUrl("/login") //認証処理のURLを指定(ログインフォームのaction属性と対応)
                .usernameParameter("username") //ユーザ名のリクエストパラメータ名指定
                .passwordParameter("password") //パスワードのリクエストパラメータ名指定
                .defaultSuccessUrl("/taskApp", true)  // 認証成功後のリダイレクト先を指定
                .failureUrl("/loginForm?error=true") //認証失敗時のリダイレクト先を指定
                .permitAll() //これらは認証なしでアクセスを許可
            );
        return http.build();
    }
    
//    @Autowired
//    public void configureAuthenticationManager(AuthenticationManagerBuilder auth) throws Exception {
//    	auth.userDetailsService(myUserDetailsService)	
//    	 .passwordEncoder(passwordEncoder());
//    }
}
