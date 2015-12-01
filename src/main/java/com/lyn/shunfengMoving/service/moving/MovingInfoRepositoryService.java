
package com.lyn.shunfengMoving.service.moving;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyn.shunfengMoving.model.moving.MovingInfo;
import com.lyn.shunfengMoving.repository.moving.MovingInfoRepository;


/**
 * @author Morgan-Leon
 * @Date 2015年11月30日
 * 
 */
@Service
public class MovingInfoRepositoryService implements MovingInfoService{

	
	private static final Logger LOGGER = LoggerFactory.getLogger(MovingInfoRepositoryService.class);
	private MovingInfoRepository movingInfoRepo;
	
    @Autowired
    public MovingInfoRepositoryService(MovingInfoRepository movingInfoRepo)
    {
    	this.movingInfoRepo = movingInfoRepo;
    }
    
	/* (non-Javadoc)
	 * @see com.lyn.shunfengMoving.service.moving.MovingInfoService#add(com.lyn.shunfengMoving.model.moving.MovingInfo)
	 */
    @Transactional
	@Override
	public MovingInfo add(MovingInfo movingInfo) {
		// TODO Auto-generated method stub
    	MovingInfo model = new MovingInfo();
    	model = MovingInfo.getBuilder(movingInfo.getRegion(), movingInfo.getCarType(), 
    			movingInfo.getTime(), movingInfo.getContact(), movingInfo.getAreaCode(), movingInfo.getTelephone())
    			.description(movingInfo.getDescription()).build();
   
		return movingInfoRepo.save(model);
	}

	/* (non-Javadoc)
	 * @see com.lyn.shunfengMoving.service.moving.MovingInfoService#update(com.lyn.shunfengMoving.model.moving.MovingInfo, java.lang.Long)
	 */
	@Override
	public MovingInfo update(MovingInfo movingInfo, Long movingInfoID) {
		// TODO Auto-generated method stub
		MovingInfo model = movingInfoRepo.findOne(movingInfoID);
		model.setStatus(movingInfo.getStatus());
		return  movingInfoRepo.save(model);
	}

	/* (non-Javadoc)
	 * @see com.lyn.shunfengMoving.service.moving.MovingInfoService#findById(java.lang.Long)
	 */
	@Override
	public MovingInfo findById(Long id) {
		// TODO Auto-generated method stub
		
		return movingInfoRepo.findOne(id);
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
		return movingInfoRepo.findAll(pageable);
	}

}
