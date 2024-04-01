package in.codetech.serviceImpl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.codetech.model.User;
import in.codetech.model.UserRole;
import in.codetech.repository.RoleRepository;
import in.codetech.repository.UserRepository;
import in.codetech.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteUserById(Long id) {
		this.userRepository.deleteById(id);

	}
	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return this.userRepository.findByUsername(username);
	}
    
	
	
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		
		User local = this.userRepository.findByUsername(user.getUsername());
		if(local != null) {
			
			System.out.println("User is already there !!");
			throw new Exception("User already present !!");
		}else {
			//user create
			for(UserRole ur : userRoles) {
				roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			local = this.userRepository.save(user);
		}
		
		
		return local;
	}

	


	

}
