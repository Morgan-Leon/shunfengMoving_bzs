/**
 * 
 */
package com.lyn.shunfengMoving.controller.user;

import javax.validation.Valid;

import javassist.NotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lyn.shunfengMoving.model.user.User;
import com.lyn.shunfengMoving.service.user.UserService;

/**
 * @author Morgan-Leon
 * @Date 2015年11月30日
 * 
 */
@Controller
@RequestMapping(value="/api")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private UserService service;
    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }
    
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public User add(@Valid @RequestBody User user) throws Exception {
    LOGGER.debug("Finding  books in shelf entry with id: {}" );
		return  service.add(user);
    }
    
    @RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
    @ResponseBody
    public User findOne(@PathVariable("name")String name) throws NotFoundException {
    LOGGER.debug("Finding  books in shelf entry with id: {}" );
		return  service.findByName(name);
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public User login(@Valid @RequestBody User user) throws NotFoundException {
    LOGGER.debug("Finding  books in shelf entry with id: {}" );
		User model =  service.findByName(user.getName());
		if(!model.getPassword().equals(user.getPassword()))
			throw new NotFoundException("Wrong Password");
		
		return model;
    }

}
