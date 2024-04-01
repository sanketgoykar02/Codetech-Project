package in.codetech.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import in.codetech.model.User;
import in.codetech.model.UserRole;

@Service
public interface UserService {

	public User createUser(User user, Set<UserRole> userRoles) throws Exception;

	public User getUserById(Long id);
	
	public User getUser(String username);

	public User saveUser(User user);

	public void deleteUserById(Long id);

}
