/**
 * 
 */
package com.lyn.shunfengMoving.controller.moving;

import javassist.NotFoundException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lyn.shunfengMoving.common.model.PageResource;
import com.lyn.shunfengMoving.model.moving.MovingInfo;
import com.lyn.shunfengMoving.model.moving.MovingInfo.Status;
import com.lyn.shunfengMoving.service.moving.MovingInfoService;

/**
 * @author Morgan-Leon
 * @Date 2015年11月30日
 * 
 */
@Controller
@RequestMapping(value="/api")
public class MovingInfoController {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(MovingInfoController.class);

    private MovingInfoService service;
    @Autowired
    public MovingInfoController(MovingInfoService service) {
        this.service = service;
    }
    
    @RequestMapping(value = "/movingInfo", method = RequestMethod.POST)
    @ResponseBody
    public MovingInfo add(@Valid @RequestBody MovingInfo movingInfo) {
        LOGGER.debug("Adding a new single choice entry with information: {}", movingInfo);

        MovingInfo added = service.add(movingInfo);
        LOGGER.debug("Added a single choice entry with information: {}", movingInfo);

       return added;
    }
    
    @RequestMapping(value = "/movingInfo", method = RequestMethod.GET)
    @ResponseBody
    public PageResource<MovingInfo> findAll(
			@RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam(value="sortBy", required = false) String sortBy) throws NotFoundException {
    LOGGER.debug("Finding  books in shelf entry with id: {}" );
    	
	sortBy = sortBy==null?"id": sortBy;
	Pageable pageable = new PageRequest(page,size,new Sort(sortBy));
	Page<MovingInfo> pageResult = service.findAll(pageable);
		return  new PageResource<>(pageResult,"page","size");
    }
    
    @RequestMapping(value = "/movingInfo/{id}", method = RequestMethod.GET)
    @ResponseBody
    public MovingInfo findOne(@PathVariable("id")Long id) throws NotFoundException {
    LOGGER.debug("Finding  books in shelf entry with id: {}" );
		return  service.findById(id);
    }
    
    @RequestMapping(value = "/movingInfo/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public MovingInfo update(@RequestParam("status") Status status, @PathVariable("id") Long id) throws NotFoundException {
        LOGGER.debug("Updating bookshelf with information: {}", status);

        MovingInfo updated = service.update(status,id);
        LOGGER.debug("Updated the information of a bookshelf to: {}", updated);

        return updated;
    }
    
    
}
