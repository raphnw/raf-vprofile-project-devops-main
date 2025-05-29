package com.visualpathit.account.controller;

import com.visualpathit.account.model.User;
import com.visualpathit.account.service.ProducerService;
import com.visualpathit.account.service.SecurityService;
import com.visualpathit.account.service.UserService;
import com.visualpathit.account.utils.MemcachedUtils;
import com.visualpathit.account.validator.UserValidator;
<<<<<<< HEAD
=======

import java.util.List;
import java.util.UUID;

>>>>>>> cdbce970c7a456416720070802fc86f3e3e63cab
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Controller
public class UserController {

=======
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**{@author imrant}*/
@Controller
public class UserController {
>>>>>>> cdbce970c7a456416720070802fc86f3e3e63cab
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
<<<<<<< HEAD

    @Autowired
    private ProducerService producerService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);
        boolean loginSuccessful = securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());
        if (!loginSuccessful) {
            return "redirect:/login?error";
        }

        return "redirect:/welcome";
    }

    @GetMapping("/")
    public String login(Model model, @RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout) {
        if (error != null) {
            model.addAttribute("error", "Your username and password is invalid.");
        }
        if (logout != null) {
=======
    
    @Autowired
    private ProducerService producerService;
    
    /** {@inheritDoc} */
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public final String registration(final Model model) {
        model.addAttribute("userForm", new User());
             	return "registration";
      }
    /** {@inheritDoc} */
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public final String registration(final @ModelAttribute("userForm") User userForm, 
    	final BindingResult bindingResult, final Model model) {
    	
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        System.out.println("User PWD:"+userForm.getPassword());
        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }
    /** {@inheritDoc} */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public final String login(final Model model, final String error, final String logout) {
        System.out.println("Model data"+model.toString());
    	if (error != null){
            model.addAttribute("error", "Your username and password is invalid.");
        }
        if (logout != null){
>>>>>>> cdbce970c7a456416720070802fc86f3e3e63cab
            model.addAttribute("message", "You have been logged out successfully.");
        }
        return "login";
    }
<<<<<<< HEAD

    @PostMapping("/login")
    public String loginPost(@ModelAttribute("user") User user, Model model) {
        boolean loginSuccessful = securityService.autologin(user.getUsername(), user.getPassword());
        if (!loginSuccessful) {
            model.addAttribute("error", "Your username and password is invalid.");
            return "login";
        }
        return "redirect:/welcome";
    }

    @GetMapping("/welcome")
    public String welcome(Model model) {
        return "welcome";
    }

    @GetMapping("/index")
    public String indexHome(Model model) {
        return "index_home";
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        List<User> users = userService.getList();
        model.addAttribute("users", users);
        return "userList";
    }

    @GetMapping("/users/{id}")
    public String getOneUser(@PathVariable("id") String id, Model model) {
        String result;
        try {
            User userData = MemcachedUtils.memcachedGetData(id);
            if (userData != null) {
                result = "Data is From Cache";
                model.addAttribute("user", userData);
            } else {
                User user = userService.findById(Long.parseLong(id));
                result = MemcachedUtils.memcachedSetData(user, id);
                if (result == null) {
                    result = "Memcached Connection Failure !!";
                }
                model.addAttribute("user", user);
            }
            model.addAttribute("Result", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "user";
    }

    @GetMapping("/user/{username}")
    public String userUpdate(@PathVariable("username") String username, Model model) {
        User user = userService.findByUsername(username);
        model.addAttribute("user", user);
        return "userUpdate";
    }

    @PostMapping("/user/{username}")
    public String userUpdateProfile(@PathVariable("username") String username, @ModelAttribute("user") User userForm) {
        User user = userService.findByUsername(username);
        updateUserDetails(user, userForm);
        userService.save(user);
        return "welcome";
    }

//    @GetMapping("/user/rabbit")
//    public String rabbitmqSetUp() {
//        for (int i = 0; i < 20; i++) {
//            producerService.produceMessage(generateString());
//        }
//        return "rabbitmq";
//    }

    private void updateUserDetails(User user, User userForm) {
        user.setUsername(userForm.getUsername());
        user.setUserEmail(userForm.getUserEmail());
        user.setDateOfBirth(userForm.getDateOfBirth());
        user.setFatherName(userForm.getFatherName());
        user.setMotherName(userForm.getMotherName());
        user.setGender(userForm.getGender());
        user.setLanguage(userForm.getLanguage());
        user.setMaritalStatus(userForm.getMaritalStatus());
        user.setNationality(userForm.getNationality());
        user.setPermanentAddress(userForm.getPermanentAddress());
        user.setTempAddress(userForm.getTempAddress());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setSecondaryPhoneNumber(userForm.getSecondaryPhoneNumber());
        user.setPrimaryOccupation(userForm.getPrimaryOccupation());
        user.setSecondaryOccupation(userForm.getSecondaryOccupation());
        user.setSkills(userForm.getSkills());
        user.setWorkingExperience(userForm.getWorkingExperience());
    }

    private static String generateString() {
        return "uuid = " + UUID.randomUUID().toString();
    }
=======
    /** {@inheritDoc} */
    @RequestMapping(value = { "/", "/welcome"}, method = RequestMethod.GET)
    public final String welcome(final Model model) {
        return "welcome";
    }
    /** {@inheritDoc} */
    @RequestMapping(value = { "/index"} , method = RequestMethod.GET)
    public final String indexHome(final Model model) {
        return "index_home";
    }
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getAllUsers(Model model)
    {	
   
        List<User> users = userService.getList();
        //JSONObject jsonObject
        System.out.println("All User Data:::" + users);
        model.addAttribute("users", users);
        return "userList";
    }
    
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public String getOneUser(@PathVariable(value="id") String id,Model model)
    {	
    	String Result ="";
    	try{
    		if( id != null && MemcachedUtils.memcachedGetData(id)!= null){    			
    			User userData =  MemcachedUtils.memcachedGetData(id);
    			Result ="Data is From Cache";
    			System.out.println("--------------------------------------------");
    			System.out.println("Data is From Cache !!");
    			System.out.println("--------------------------------------------");
    			System.out.println("Father ::: "+userData.getFatherName());
    			model.addAttribute("user", userData);
    			model.addAttribute("Result", Result);
    		}
    		else{
	    		User user = userService.findById(Long.parseLong(id)); 
	    		Result = MemcachedUtils.memcachedSetData(user,id);
	    		if(Result == null ){
	    			Result ="Memcached Connection Failure !!";
	    		}
	    		System.out.println("--------------------------------------------");
    			System.out.println("Data is From Database");
    			System.out.println("--------------------------------------------");
		        System.out.println("Result ::: "+ Result);	       
		        model.addAttribute("user", user);
		        model.addAttribute("Result", Result);
    		}
    	} catch (Exception e) {    		
    		System.out.println( e.getMessage() );
		}
        return "user";
    }
    
    /** {@inheritDoc} */
    @RequestMapping(value = { "/user/{username}"} , method = RequestMethod.GET)
    public final String userUpdate(@PathVariable(value="username") String username,final Model model) {
    	User user = userService.findByUsername(username); 
    	System.out.println("User Data:::" + user);
    	model.addAttribute("user", user);
    	return "userUpdate";
    }
    @RequestMapping(value = { "/user/{username}"} , method = RequestMethod.POST)
    public final String userUpdateProfile(@PathVariable(value="username") String username,final @ModelAttribute("user") User userForm,final Model model) {
    	User user = userService.findByUsername(username);
    	user.setUsername(userForm.getUsername());
    	user.setUserEmail(userForm.getUserEmail());
    	user.setDateOfBirth(userForm.getDateOfBirth());
    	user.setFatherName(userForm.getFatherName());
    	user.setMotherName(userForm.getMotherName());
    	user.setGender(userForm.getGender());
    	user.setLanguage(userForm.getLanguage());
    	user.setMaritalStatus(userForm.getMaritalStatus());
    	user.setNationality(userForm.getNationality());
    	user.setPermanentAddress(userForm.getPermanentAddress());
    	user.setTempAddress(userForm.getTempAddress());
    	user.setPhoneNumber(userForm.getPhoneNumber());
    	user.setSecondaryPhoneNumber(userForm.getSecondaryPhoneNumber());
    	user.setPrimaryOccupation(userForm.getPrimaryOccupation());
    	user.setSecondaryOccupation(userForm.getSecondaryOccupation());
    	user.setSkills(userForm.getSkills());
    	user.setWorkingExperience(userForm.getWorkingExperience());    	
    	userService.save(user); 
    	/*model.addAttribute("user", user);*/
    	return "welcome";
    }
    
    @RequestMapping(value={"/user/rabbit"}, method={RequestMethod.GET})
    public String rabbitmqSetUp() { 
    	System.out.println("Rabbit mq method is callled!!!");
      for (int i = 0; i < 20; i++) {
        producerService.produceMessage(generateString());
      }
      return "rabbitmq";
    }
    
    private static String generateString() {
      String uuid = UUID.randomUUID().toString();
      return "uuid = " + uuid;
    }
    

    
>>>>>>> cdbce970c7a456416720070802fc86f3e3e63cab
}
