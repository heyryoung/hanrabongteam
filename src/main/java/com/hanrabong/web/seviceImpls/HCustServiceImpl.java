package com.hanrabong.web.seviceImpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hanrabong.web.mappers.HCustMapper;
import com.hanrabong.web.services.HCustService;

@Service
public class HCustServiceImpl implements HCustService{
	@Autowired HCustMapper hCustMapper;
	
	@Override
	public int countHCusts() {
		return hCustMapper.countHCusts();
	}


}
