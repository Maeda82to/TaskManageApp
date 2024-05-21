package com.example.TaskManageApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) 
		throws UsernameNotFoundException {
//		System.out.println(userRepository.findAll());
		System.out.println(username);
		
			User user = userRepository.findByUserId(username);
//			.orElseThrow(()-> new UsernameNotFoundException(username + " is not found."));
			 
			if (user == null) {
		            throw new UsernameNotFoundException("User not found"); // ユーザーが見つからない場合、例外をスローします
		        }
			
			System.out.println(user);
			
			return new MyUserDetails(user);
	}
	
	 //新たにメソッドを追加します
    public User findByUsername(String username) {
        return userRepository.findByUserId(username); // ユーザー名でユーザーを検索し返します
    }

    @Transactional // トランザクションを開始します。メソッドが終了したらトランザクションがコミットされます。
    public void save(UserDto userDto) {
        // UserDtoからUserへの変換
        User user = new User();
        user.setUserId(userDto.getUsername());
        // パスワードをハッシュ化してから保存
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        // データベースへの保存
        userRepository.save(user); // UserRepositoryを使ってユーザーをデータベースに保存します
    }

	//データ追加
	 public void addUser(String userId, String rawPassword, RoleName roleName) {
	        User user = new User();
	        user.setUserId(userId);
	        user.setPassword(passwordEncoder.encode(rawPassword)); // パスワードをエンコード
	        user.setRoleName(roleName);
	        userRepository.save(user);
	    }
	//既存DBデータのパスワードエンコード処理
	public void encodeExistingUserPasswords() {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        userRepository.saveAll(users);
    }
}
