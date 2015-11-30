package com.lyn.shunfengMoving.service.exam;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lyn.shunfengMoving.dto.exam.SingleChoiceDTO;
import com.lyn.shunfengMoving.model.exam.*;


/**
 * @author Morgan-Leon
 * @Date 2015年9月19日
 * 
 */

public interface SingleChoiceService {
	
    public SingleChoice add(SingleChoiceDTO singleChoiceDTO);

    public SingleChoiceDTO update(SingleChoiceDTO singleChoiceDTO,Long singleChoiceID);

    public SingleChoice findById(Long id);

    public SingleChoice deleteById(Long id);

    Page<SingleChoice> findAll(Pageable pageable);

}
