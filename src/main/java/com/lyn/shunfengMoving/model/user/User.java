/**
 * 
 */
package com.lyn.shunfengMoving.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lyn.shunfengMoving.common.model.AbstractEntity;
import com.lyn.shunfengMoving.utill.DateSerializer;

/**
 * @author Morgan-Leon
 * @Date 2015年11月30日
 * 
 */
@Entity
@Table(name="user")
public class User extends AbstractEntity{
	
	public static final int MAX_LENGTH_DESCRIPTION = 200;
	
	public static final int MAX_LENGTH_PASSWORD = 200;

	public static final int MAX_LENGTH_NAME = 50;

    @Column(nullable = true, length = MAX_LENGTH_DESCRIPTION)
    private String description;
    
	@JsonSerialize(using = DateSerializer.class)
    @Column(nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime modificationTime;
    
    @Column(name="name",nullable = true,length = MAX_LENGTH_NAME)
    private String name;
    
    @Column(name="password",nullable = true,length = MAX_LENGTH_PASSWORD)
    private String password;
    
    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DateTime getModificationTime() {
		return modificationTime;
	}

	public void setModificationTime(DateTime modificationTime) {
		this.modificationTime = modificationTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}

