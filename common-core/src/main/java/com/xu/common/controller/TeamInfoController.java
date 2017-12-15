package com.xu.common.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.xu.common.exception.MlsException;
import com.xu.common.model.Result;
import com.xu.common.model.TtTeam;
import com.xu.common.service.TeamInfoService;

@RestController
@RequestMapping("/teamInfo")
public class TeamInfoController extends BaseCRUDController<String, TtTeam, TeamInfoService>{
	
	@RequestMapping(value = "/{teamId}", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "获取集货团详情")
	public Result getTeamInfo(@ApiParam(value = "当前目录", required = true) @PathVariable("teamId") String teamId){
		try {
			return Result.succeed(service.getTeamInfo(teamId));
		}
		catch (Exception e) {
			logger.info("获取集货团详情失败,原因:",e);
			return Result.error("1", e.getMessage());
		}
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "获取集货团列表")
	public Result getTtTeamList(){
		try {
			return Result.succeed(service.getTtTeamList());
		} catch (MlsException e) {
			logger.info("获取集货团列表失败,原因:",e);
			return Result.error("1", e.getMessage());
		}
	}
}
