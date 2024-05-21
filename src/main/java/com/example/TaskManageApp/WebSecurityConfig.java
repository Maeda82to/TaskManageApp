package com.example.TaskManageApp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

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
                .anyRequest().authenticated()
            )
            .formLogin(login -> login
                .loginPage("/loginForm")
                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/taskApp", true)  // 認証成功後のリダイレクト先を確認
                .failureUrl("/loginForm?error=true")
                .permitAll()
            );
        return http.build();
    }
    
//    @Autowired
//    public void configureAuthenticationManager(AuthenticationManagerBuilder auth) throws Exception {
//    	auth.userDetailsService(myUserDetailsService)	
//    	 .passwordEncoder(passwordEncoder());
//    }
}
