package com.visualpathit.account.service;

/** method for finding already added user !*/
public interface SecurityService {
	/** {@inheritDoc}} !*/
    String findLoggedInUsername();

<<<<<<< HEAD
    boolean autologin(String username, String password);
=======
    void autologin(String username, String password);
>>>>>>> cdbce970c7a456416720070802fc86f3e3e63cab
}
