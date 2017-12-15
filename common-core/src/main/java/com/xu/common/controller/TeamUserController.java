package com.xu.common.controller;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.cj.core.util.StringUtils;
import com.xu.common.exception.MlsException;
import com.xu.common.model.Demo;
import com.xu.common.model.Result;
import com.xu.common.model.TeamUser;
import com.xu.common.service.DemoService;
import com.xu.common.service.TeamInfoService;
import com.xu.common.service.TeamUserService;
import com.xu.common.utility.UUIDUtil;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/teamUser")
public class TeamUserController extends BaseCRUDController<String, Demo, DemoService>{
	
	private static final Logger logger = LoggerFactory.getLogger(TeamUserController.class);
	
	@Resource
	public TeamUserService teamUserService;
	@Resource
	public TeamInfoService teamInfoService;
	
	static final String NO_TEAM_ID = "参团ID参数不能为空";
	static final String NO_USER_BQ = "所在地区不能为空";
	static final String NO_USER_ADD = "详细地址不能为空";
	static final String NO_SEND_USER = "寄件人姓名不能为空";
	static final String NO_SEND_PH = "寄件人电话不能为空";
	static final String NO_SEND_NUM = "寄件数量不能为空";
	static final String NO_SEND_WEIGHT = "寄件重量不能为空";
	static final String NO_ENOUGF_SEND_NUM = "寄件数量不够";
	static final String NOT_RIGHT_SEND_PH = "寄件人电话不正确";
	
	/**
	 * 报名集货
	 * @return: Result
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "报名集货")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "报名集货成功"), @ApiResponse(code = 400, message = "报名集货错误") })
	public Result getProvinces(@RequestBody TeamUser teamUser) {
		try {
			// 1 核心参数校验
			teamUser.setUserId(UUIDUtil.getUUID());// 设置用户
			String checkResult = checkParamIsEmpty(teamUser); // 参数为空校验
			if(!StringUtils.isNullOrEmpty(checkResult)){
				return Result.error("7009", "参数为空自定义提示", checkResult);
			}
			// 2逻辑数据校验
			if(!checkMobile(teamUser.getSendPh())){ // 校验 移动 联通 电信 手机号格式
				return Result.error("7010", "自定义提示", NOT_RIGHT_SEND_PH);
			}
			Map<String, Object> map = teamInfoService.getTeamInfo(teamUser.getTeamId());
			if(!checkDailyMinPackages(teamUser,map)){ // 动态校验客户快递件数是否达标
				return Result.error("7011", "自定义提示", NO_SEND_WEIGHT);
			}
			if(!checkGoupStatus(map)){ // 校验团满
				return Result.error("7012", "团满提示", NO_SEND_WEIGHT);
			}
			// 3 报名集货
			teamUserService.addTeamUser(teamUser);
			
		} catch (MlsException e) {
			logger.error("报名集货异常",e);
			return Result.error("7013","报名集货异常");
		}		
		return Result.succeed(true);
	}
	
	/**
	 * 判断团满
	 * @param:  map    
	 * @return: boolean
	 */
	private boolean checkGoupStatus(Map<String,Object> map){
		int groupLimit = (int) map.get("groupLimit"); // 团人员限定
		int ctNum = (int) map.get("ctNum"); // 当前用户数
		if(ctNum==groupLimit){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * 动态校验客户快递件数是否达标
	 * @param:  teamUser 
	 * @param:  map 团购单基本详情
	 * @return: boolean true：合格  false：不合格
	 */
	private boolean checkDailyMinPackages(TeamUser teamUser,Map<String,Object> map){
		try {
			int dailyMinPackages = (int) map.get("dailyMinPackages");
			if(teamUser.getSendNum()<dailyMinPackages){
				return false;
			}
		} catch (Exception e) {
			logger.error("动态校验客户快递件数是否达标",e);
		}
		return true;		
	}
	
	/**
	 * 参数是否为空校验
	 * @param:  teamUser     
	 * @return: String 界面友好提示语 
	 */
	private String checkParamIsEmpty(TeamUser teamUser){
		if(StringUtils.isNullOrEmpty(teamUser.getTeamId())){
			return NO_TEAM_ID;
		}
		if(StringUtils.isNullOrEmpty(teamUser.getUserBq())){
			return NO_USER_BQ;
		}
		if(StringUtils.isNullOrEmpty(teamUser.getUserAdd())){
			return NO_USER_ADD;
		}
		if(StringUtils.isNullOrEmpty(teamUser.getSendUser())){
			return NO_SEND_USER;
		}
		if(StringUtils.isNullOrEmpty(teamUser.getSendPh())){
			return NO_SEND_PH;
		}
		if(teamUser.getSendNum()==null || teamUser.getSendNum()==0l){
			return NO_SEND_NUM;
		}
		if(teamUser.getSendWeight()==0l){
			return NO_SEND_WEIGHT;
		}
		return null;
	}
	
	/**
	 * 校验手机号格式
	 * 【支持 移动 联动 电信】
	 * @param:  mobile     
	 * @return: boolean
	 */
	private boolean checkMobile(String mobile){		
		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");   
		Matcher m = p.matcher(mobile);  
		return m.matches();  
	}
	
	
	
}
