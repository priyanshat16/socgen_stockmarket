package com.stock.app.Services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.app.dao.RoleRepository;
import com.stock.app.dao.UserRepository;
import com.stock.app.model.UserEntity;
import com.stock.app.model.UserRole;



@Service
public class UserServiceImpl implements UserService{

@Autowired
private UserRepository userRepository;

@Autowired
private RoleRepository roleRepository;

@Override
public UserEntity createUser(UserEntity user, Set<UserRole> userRoles) throws Exception {

UserEntity local = this.userRepository.findByUsername(user.getUsername());
if(local!=null)
{
System.out.println("User already exits");
throw new Exception("User already exists");

}
else {
for(UserRole ur : userRoles)
{
roleRepository.save(ur.getRole());
}
user.getUserRoles().addAll(userRoles);
local = this.userRepository.save(user);
}
return local;
}

}
