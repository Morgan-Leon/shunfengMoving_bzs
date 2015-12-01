package com.lyn.shunfengMoving.model.moving;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
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
@Table(name="moving_info")
public class MovingInfo extends AbstractEntity{
	
//	public static final int MAX_LENGTH_NAME = 50;
	
	public static final int MAX_LENGTH_CONTACT = 50;
	
	public static final int MAX_LENGTH_AREA_CODE = 10;
	
	public static final int MAX_LENGTH_TELEPHONE = 100;
	
	public static final int MAX_LENGTH_DESCRIPTION = 200;
	
    @Column(nullable = true, length = MAX_LENGTH_DESCRIPTION)
    private String description;
    
//    @Column(name="name",nullable = false,length = MAX_LENGTH_NAME)
//    private String name;
    
    @Column(name="contact",nullable = false,length = MAX_LENGTH_CONTACT)
    private String contact;
    
    @Column(name="area_code",nullable = true,length = MAX_LENGTH_AREA_CODE)
    private String areaCode;
    
    @Column(name="telephone",nullable = false,length = MAX_LENGTH_TELEPHONE)
    private String telephone;
    
    @JsonSerialize(using = DateSerializer.class)
    @Column(nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime modificationTime;
    
    @JsonSerialize(using = DateSerializer.class)
    @Column(nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime time;
    
    //1:海淀区 2：朝阳区 3：西城区 4：东城区 5：丰台区 6：大兴区 7：石景山
    @Column(name="region",nullable = false)
    private int region;
    
    //1:金杯，2:皮卡，3：厢式货车, 4:1041货车
    @Column(name="car_type",nullable = false)
    private int carType = 3;
    
    @Enumerated(EnumType.STRING)
    private Status status = Status.未处理;
    
    
	public enum Status {
        未处理,已派车,已结束
    }

	

	public DateTime getTime() {
		return time;
	}


	public void setTime(DateTime time) {
		this.time = time;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getAreaCode() {
		return areaCode;
	}


	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public DateTime getModificationTime() {
		return modificationTime;
	}
	
    @PrePersist
    public void prePersist() {
        DateTime now = DateTime.now();
        creationTime = now;
        modificationTime = now;
    }
    
    @PreUpdate
    public void preUpdate() {
        modificationTime = DateTime.now();
    }


	public int getRegion() {
		return region;
	}


	public void setRegion(int region) {
		this.region = region;
	}


	public int getCarType() {
		return carType;
	}


	public void setCarType(int carType) {
		this.carType = carType;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	} 
	
	public static Builder getBuilder(int region, int carType, DateTime time, String contact, String areaCode, String telephone){
		return new Builder(region,carType,time,contact, areaCode,telephone);
	}
	
	
	public static class Builder{
		
		private MovingInfo built;
		
		public Builder(int region, int carType, DateTime time, String contact, String areaCode, String telephone){
			built = new MovingInfo();
			built.region = region;
			built.carType = carType;
			built.time = time;
			built.contact = contact;
			built.areaCode = areaCode;
			built.telephone = telephone;
		}
		
		
		public Builder description(String description) {
            built.description = description;
            return this;
        }
		
		public MovingInfo build() {
			// TODO Auto-generated method stub
			return built;
		}
	}
	
    
}
