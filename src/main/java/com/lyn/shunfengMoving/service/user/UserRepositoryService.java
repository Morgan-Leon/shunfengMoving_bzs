/**
 * 
 */
package com.lyn.shunfengMoving.service.user;

import javassist.NotFoundException;

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
	public User findByName(String name) throws NotFoundException {
		// TODO Auto-generated method stub
		User find;
		find = userRepo.findByName(name);
		if(find == null){
			throw new NotFoundException("Not Found " + name);
		}
		return find;
	}


	/* (non-Javadoc)
	 * @see com.lyn.shunfengMoving.service.user.UserService#add(com.lyn.shunfengMoving.model.user.User)
	 */
	@Override
	public User add(User user) throws Exception {
		// TODO Auto-generated method stub
		User model;
		model = findByName(user.getName());
		if (model != null) {
			throw new Exception("Duplicate User");
		}
		model = new User();
		model.setName(user.getName());
		model.setPassword(user.getPassword());
		model.setDescription(user.getDescription());
		
		
		return userRepo.save(model);
	}

}
