package com.xu.common.controller;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.xu.common.model.Demo;
import com.xu.common.model.Result;
import com.xu.common.service.AnybusService;
import com.xu.common.service.DemoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/demo")
public class DemoController extends BaseCRUDController<String, Demo, DemoService>{
	
	
	@Resource
	public AnybusService anybusService;
	
	
	/**
	 * 
	 * @param currentFolder
	 * @param newFolderName
	 * @return
	 */
	@RequestMapping(value = "/{currentFolder}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "创建文件夹")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "新增成功"), @ApiResponse(code = 400, message = "参数错误") })
	public Result createFolder(@ApiParam(value = "当前目录", required = true) @PathVariable("currentFolder") String currentFolder, 
			@ApiParam(value = "文件夹名", required = false) @RequestParam(value = "newFolderName", required = false) String newFolderName) {
		logger.info(service.getProperty("scss.nas.path.static"));
		return Result.succeed(anybusService.getMkt());
	}
	
	@RequestMapping(value = "/list/{key}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "创建文件夹")
	public Result getkey(@ApiParam(value = "当前目录", required = true) @PathVariable("key") String key){
		return Result.succeed(service.getDemo(key));
	}
	
	@RequestMapping(value = "/er", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "创建文件夹")
	public Result geterror(){
		return Result.error("7001", "自定义提示", "权限验证");
	}

}
