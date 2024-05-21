package com.example.TaskManageApp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

	User findByUserId(String userId);

}
