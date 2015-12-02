/**
 * 
 */
package com.lyn.shunfengMoving.service.user;


import javassist.NotFoundException;

import com.lyn.shunfengMoving.model.user.User;

/**
 * @author Morgan-Leon
 * @Date 2015年11月30日
 * 
 */
public interface UserService {
	public User findById(Long id);
	
	public User findByName(String name) throws NotFoundException;
	
	public User add(User user)throws Exception;
}
