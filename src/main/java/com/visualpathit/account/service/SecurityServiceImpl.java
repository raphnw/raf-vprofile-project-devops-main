package com.visualpathit.account.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
<<<<<<< HEAD
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
=======
import org.springframework.security.authentication
								   .UsernamePasswordAuthenticationToken;
>>>>>>> cdbce970c7a456416720070802fc86f3e3e63cab
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
<<<<<<< HEAD

@Service
public class SecurityServiceImpl implements SecurityService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    private static final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);

    @Override
    public String findLoggedInUsername() {
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if (userDetails instanceof UserDetails) {
            return ((UserDetails) userDetails).getUsername();
        }
=======
/** {@author imrant} !*/
@Service
public class SecurityServiceImpl implements SecurityService {
    /** authenticationManager !*/
	@Autowired
    private AuthenticationManager authenticationManager;
	/** userDetailsService !*/
    @Autowired
    private UserDetailsService userDetailsService;

    /** Logger creation !*/
    private static final Logger logger = LoggerFactory
    						.getLogger(SecurityServiceImpl.class);

    @Override
    public String findLoggedInUsername() {
        Object userDetails = SecurityContextHolder.getContext()
        					.getAuthentication().getDetails();
        if (userDetails instanceof UserDetails) {
            return ((UserDetails) userDetails).getUsername();
        }

>>>>>>> cdbce970c7a456416720070802fc86f3e3e63cab
        return null;
    }

    @Override
<<<<<<< HEAD
    public boolean autologin(final String username, final String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
=======
    public void autologin(final String username, final String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
        new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
>>>>>>> cdbce970c7a456416720070802fc86f3e3e63cab

        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
<<<<<<< HEAD
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            logger.debug(String.format("Auto login %s successfully!", username));
            return true;
        }
        logger.debug(String.format("Auto login %s failed!", username));
        return false;
=======
            SecurityContextHolder.getContext()
            .setAuthentication(usernamePasswordAuthenticationToken);
            logger.debug(String.format("Auto login %s successfully!", username));
        }
>>>>>>> cdbce970c7a456416720070802fc86f3e3e63cab
    }
}
