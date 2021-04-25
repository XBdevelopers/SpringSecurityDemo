package edu.xbd.custom.spring.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.xbd.custom.spring.security.entity.User;
import edu.xbd.custom.spring.security.model.MyUserDetails;
import edu.xbd.custom.spring.security.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.getUserByName(username);
		user.orElseThrow(() -> new UsernameNotFoundException(username + "Not Found!"));
		return user.map(MyUserDetails::new).get();
	}

}
