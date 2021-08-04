package com.stock.app.Services;

import java.util.Set;

import com.stock.app.model.UserEntity;
import com.stock.app.model.UserRole;

public interface UserService {
	
	public UserEntity createUser(UserEntity user, Set<UserRole> userRoles) throws Exception;

}
