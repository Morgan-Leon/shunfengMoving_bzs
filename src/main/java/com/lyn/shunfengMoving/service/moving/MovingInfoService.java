/**
 * 
 */
package com.lyn.shunfengMoving.service.moving;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lyn.shunfengMoving.model.moving.MovingInfo;
import com.lyn.shunfengMoving.model.moving.MovingInfo.Status;


/**
 * @author Morgan-Leon
 * @Date 2015年11月30日
 * 
 */
public interface MovingInfoService {
	
    public MovingInfo add(MovingInfo movingInfo);

    public MovingInfo update(Status status,Long movingInfoID);

    public MovingInfo findById(Long id);

    public MovingInfo deleteById(Long id);

    Page<MovingInfo> findAll(Pageable pageable);


}
