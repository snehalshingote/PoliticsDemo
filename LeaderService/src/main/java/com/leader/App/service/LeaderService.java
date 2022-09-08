package com.leader.App.service;

import java.util.List;

import com.leader.App.Util.LeaderDetailsResponseDto;
import com.leader.App.Util.StatusDto;
import com.leader.App.vo.LeaderAssignTaskDetailsVo;
import com.leader.App.vo.LeaderAssignTaskReqVo;
import com.leader.App.vo.LeaderAssignTaskRespVo;
import com.leader.App.vo.LeaderVO;

public interface LeaderService {

	StatusDto registerLeaderDetails(LeaderVO leaderVO);

	boolean isLeaderExist(Number leaderId);

	StatusDto deleteLeaderById(Number leaderId);

	LeaderAssignTaskRespVo getAssignTaskDetails(Number leaderId);

	LeaderDetailsResponseDto getAllLeadersParty(Number partyId);

	boolean isPartyIdExist(Number partyId);

	LeaderAssignTaskDetailsVo getAllDeveloplemetWorkAssignByleader(LeaderAssignTaskReqVo leaderAssignTaskReqVo);

}
