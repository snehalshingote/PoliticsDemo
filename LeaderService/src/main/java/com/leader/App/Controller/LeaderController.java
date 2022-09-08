package com.leader.App.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leader.App.Util.LeaderDetailsResponseDto;
import com.leader.App.Util.LeaderResourseNotExistException;
import com.leader.App.Util.PartyIdandLeadIdNotExistException;
import com.leader.App.Util.StatusDto;
import com.leader.App.service.LeaderService;
import com.leader.App.vo.DevelopementVo;
import com.leader.App.vo.LeaderAssignTaskDetailsVo;
import com.leader.App.vo.LeaderAssignTaskReqVo;
import com.leader.App.vo.LeaderAssignTaskRespVo;
import com.leader.App.vo.LeaderVO;


@RestController
@RequestMapping("/leader")
public class LeaderController {


	@Autowired
	private LeaderService leaderService;

	@PostMapping(value="/register",produces=MediaType.APPLICATION_JSON_VALUE)
	public StatusDto registerLeaderDetails(@RequestBody LeaderVO leaderVO) {
		StatusDto statusDto=leaderService.registerLeaderDetails(leaderVO);
		return statusDto;
	}	


	@DeleteMapping(value="/deleteParty/{leaderId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public StatusDto deletePartyById(@PathVariable Number leaderId) {
		StatusDto status=null;
		try {
			boolean flag=leaderService.isLeaderExist(leaderId);
			if(flag) {
				status=leaderService.deleteLeaderById(leaderId);
			}else {
				throw new LeaderResourseNotExistException("Data Not Found");
			}
		}catch(Exception ex) {
			throw new LeaderResourseNotExistException("Data Not Found");
		}
		return status;
	}

	@GetMapping(value="/getAllAssignTask/{leaderId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public LeaderAssignTaskRespVo getAssignTaskDetails(@PathVariable Number leaderId) {

		LeaderAssignTaskRespVo leaderRespDetails=leaderService.getAssignTaskDetails(leaderId);

		return leaderRespDetails;
	}


	@PostMapping(value="/getAllLeadersParty",produces=MediaType.APPLICATION_JSON_VALUE)
	public LeaderDetailsResponseDto getAllLeadersParty(@RequestBody LeaderDetailsResponseDto leadVo) {
		LeaderDetailsResponseDto leaderList=leaderService.getAllLeadersParty(leadVo.getPartyId());
		return leaderList;
	}

	@PostMapping(value="/getAllLeadersDevTask",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<DevelopementVo> getAllDeveloementWorkAssigntoLeader(@RequestBody LeaderAssignTaskReqVo leaderAssignTaskReqVo){
		LeaderAssignTaskDetailsVo  developementWorkList=null;
		try {
			developementWorkList=leaderService.getAllDeveloplemetWorkAssignByleader(leaderAssignTaskReqVo);
			if(!developementWorkList.getFlag()) {
				throw new PartyIdandLeadIdNotExistException("Party Id and Leader Id Not Exist");	
			}
		}catch (Exception e) {
			throw new PartyIdandLeadIdNotExistException("Party Id and Leader Id Not Exist");
		}
		return developementWorkList.getListDevVo();

	}



}
