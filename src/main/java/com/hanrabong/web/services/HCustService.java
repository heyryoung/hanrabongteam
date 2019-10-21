package com.hanrabong.web.services;

import org.springframework.stereotype.Component;

import com.hanrabong.web.domains.HCustDTO;
@Component
public interface HCustService {
	
	public int countHCusts();
	public int lastCNum();
	public HCustDTO selectHCustByCNum(int param);
	
	public HCustDTO login(HCustDTO param);
	public void insertHCust(HCustDTO param);
	
}
