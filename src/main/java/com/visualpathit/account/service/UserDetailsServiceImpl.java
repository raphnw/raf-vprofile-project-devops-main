package com.visualpathit.account.service;

import com.visualpathit.account.model.Role;
import com.visualpathit.account.model.User;
import com.visualpathit.account.repository.UserRepository;
<<<<<<< HEAD
=======

>>>>>>> cdbce970c7a456416720070802fc86f3e3e63cab
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
<<<<<<< HEAD
import org.springframework.stereotype.Service;
=======
>>>>>>> cdbce970c7a456416720070802fc86f3e3e63cab
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
<<<<<<< HEAD

/** {@author imrant} !*/
@Service
=======
/** {@author imrant} !*/
>>>>>>> cdbce970c7a456416720070802fc86f3e3e63cab
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    /** userRepository !*/
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
<<<<<<< HEAD
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

=======
    public UserDetails loadUserByUsername(final String username) 
    				throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

>>>>>>> cdbce970c7a456416720070802fc86f3e3e63cab
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

<<<<<<< HEAD
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
=======
        return new org.springframework.security.core
        		   .userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
>>>>>>> cdbce970c7a456416720070802fc86f3e3e63cab
    }
}
