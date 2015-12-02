/**
 * 
 */
package com.lyn.shunfengMoving.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lyn.shunfengMoving.model.user.*;
/**
 * @author Morgan-Leon
 * @Date 2015年11月30日
 * 
 */
public interface UserRepository extends JpaRepository<User,Long>{
	
	public User findByName(String name);
	
}
