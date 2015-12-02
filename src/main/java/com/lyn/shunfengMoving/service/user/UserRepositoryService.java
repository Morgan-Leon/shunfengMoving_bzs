/**
 * 
 */
package com.lyn.shunfengMoving.service.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyn.shunfengMoving.model.user.User;
import com.lyn.shunfengMoving.repository.user.UserRepository;

/**
 * @author Morgan-Leon
 * @Date 2015年11月30日
 * 
 */
@Service
public class UserRepositoryService implements UserService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserRepositoryService.class);
	private UserRepository userRepo;
	
    @Autowired
    public UserRepositoryService(UserRepository userRepo)
    {
    	this.userRepo = userRepo;
    }
    

	/* (non-Javadoc)
	 * @see com.lyn.shunfengMoving.service.user.UserService#findById(java.lang.Long)
	 */
	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.lyn.shunfengMoving.service.user.UserService#findByName(java.lang.String)
	 */
	@Override
	public User findByName(String name) {
		// TODO Auto-generated method stub
		return userRepo.findByName(name);
	}

}
