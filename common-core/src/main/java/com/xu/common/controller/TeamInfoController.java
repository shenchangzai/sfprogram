package com.xu.common.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.xu.common.model.Demo;
import com.xu.common.model.Result;
import com.xu.common.service.AnybusService;
import com.xu.common.service.DemoService;

@RestController
@RequestMapping("/teamInfo")
public class TeamInfoController extends BaseCRUDController<String, Demo, DemoService>{
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource
	public AnybusService anybusService;
	
	
	@RequestMapping(value = "/{teamId}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "获取集团详情")
	public Result getTeamInfo(@ApiParam(value = "当前目录", required = true) @PathVariable("teamId") String teamId){
		return Result.succeed(service.getDemo(teamId));
	}

}
