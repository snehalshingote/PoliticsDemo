package com.party.App.service;

import java.util.List;

import com.party.App.dto.LeaderVO;
import com.party.App.dto.PartyRequectVO;
import com.party.App.dto.PartyVO;
import com.party.App.util.StatusDto;

public interface PartyService {

	StatusDto savePartyDetails(PartyVO partyVO);
	
	PartyRequectVO getPartyDetailsById(Integer partyId);

	StatusDto deletePartyById(Number partyId);

	boolean isPartyExist(Number partyId);

	List<LeaderVO> getAllLeadersParty(Number partyId);
	

}
