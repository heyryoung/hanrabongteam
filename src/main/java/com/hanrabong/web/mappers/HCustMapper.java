package com.hanrabong.web.mappers;

import org.springframework.stereotype.Repository;

import com.hanrabong.web.domains.HCustDTO;

@Repository
public interface HCustMapper {

	public int countHCusts();
	public int  lastCNum();
	public HCustDTO selectHCustById(HCustDTO param);
	public HCustDTO selectHCustByCNum(int param);
	public void insertHCust(HCustDTO param);
	
	
}
