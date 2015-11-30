
package com.lyn.shunfengMoving.service.moving;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lyn.shunfengMoving.model.moving.MovingInfo;


/**
 * @author Morgan-Leon
 * @Date 2015年11月30日
 * 
 */
@Service
public class MovingInfoRepositoryService implements MovingInfoService{

	
	private static final Logger LOGGER = LoggerFactory.getLogger(MovingInfoRepositoryService.class);
	private MovingInfoRepositoryService movingInfoRepo;
	
	
	/* (non-Javadoc)
	 * @see com.lyn.shunfengMoving.service.moving.MovingInfoService#add(com.lyn.shunfengMoving.model.moving.MovingInfo)
	 */
	@Override
	public MovingInfo add(MovingInfo movingInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.lyn.shunfengMoving.service.moving.MovingInfoService#update(com.lyn.shunfengMoving.model.moving.MovingInfo, java.lang.Long)
	 */
	@Override
	public MovingInfo update(MovingInfo movingInfo, Long movingInfoID) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.lyn.shunfengMoving.service.moving.MovingInfoService#findById(java.lang.Long)
	 */
	@Override
	public MovingInfo findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.lyn.shunfengMoving.service.moving.MovingInfoService#deleteById(java.lang.Long)
	 */
	@Override
	public MovingInfo deleteById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.lyn.shunfengMoving.service.moving.MovingInfoService#findAll(org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<MovingInfo> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
