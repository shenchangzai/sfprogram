package com.xu.common.controller;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.xu.common.dto.AddressDTO;
import com.xu.common.model.Area;
import com.xu.common.model.City;
import com.xu.common.model.Demo;
import com.xu.common.model.Province;
import com.xu.common.model.Result;
import com.xu.common.service.AreaService;
import com.xu.common.service.CityService;
import com.xu.common.service.DemoService;
import com.xu.common.service.ProvinceService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/address")
public class AddressController extends BaseCRUDController<String, Demo, DemoService>{
	
//	private static final Logger logger = LoggerFactory.getLogger(AddressController.class);
	
	@Resource
	public ProvinceService provinceService;
	@Resource
	public CityService cityService;
	@Resource
	public AreaService areaService;
	
	/**
	 * 获取三级联动省-市-区
	 * @return: Result
	 */
	@RequestMapping(value = "/get", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "获取三级联动省-市-区")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "获取三级联动省-市-区成功"), @ApiResponse(code = 400, message = "获取三级联动省-市-区错误") })
	public Result get() {
		List<AddressDTO> addressList = new ArrayList<AddressDTO>();
		
		List<Province> provinceList = provinceService.getProvinces();
		List<AddressDTO> firstList =  provinceList.stream().map(
				it -> new AddressDTO(it.getProvinceName(),it.getProvinceId()))
				.collect(toList());
		addressList.addAll(firstList);
		
		List<City> cityList = cityService.getCities();
		List<AddressDTO> secondList =  cityList.stream().map(
				it -> new AddressDTO(it.getCityName(),it.getCityId(),it.getProvinceId()))
				.collect(toList());
		addressList.addAll(secondList);
		
		List<Area> areaList = areaService.getAreas();
		List<AddressDTO> thirdList =  areaList.stream().map(
				it -> new AddressDTO(it.getAreaName(),it.getAreaId(),it.getCityId()))
				.collect(toList());
		addressList.addAll(thirdList);
		
		return Result.succeed(addressList);
	}
	
	/**
	 * 获取省份列表
	 * @return: Result
	 */
	@RequestMapping(value = "/getProvinces", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "获取省份列表")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "获取省份列表成功"), @ApiResponse(code = 400, message = "获取省份列表错误") })
	public Result getProvinces() {
		List<Province> provinceList = provinceService.getProvinces();
		List<AddressDTO> addressDTOList =  provinceList.stream().map(
				it -> new AddressDTO(it.getProvinceName(),it.getProvinceId()))
				.collect(toList());
		
		return Result.succeed(addressDTOList);
	}
	
	
	
	/**
	 * 查询某省|直辖市|自治区旗下城市
	 * @return: Result
	 */
	@RequestMapping(value = "/getCitiesByProvinceId/{provinceId}", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "查询某省|直辖市|自治区旗下城市")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "查询某省|直辖市|自治区旗下城市成功"), @ApiResponse(code = 400, message = "查询某省|直辖市|自治区旗下城市错误") })
	public Result getCities(@PathVariable("provinceId") String provinceId) {
		return Result.succeed(cityService.getCitiesByProvinceId(provinceId));
	}

	/**
	 * 查询某城市下地区
	 * @return: Result
	 */
	@RequestMapping(value = "/getAreasByCityId/{cityId}", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "查询某城市下地区")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "查询某城市下地区成功"), @ApiResponse(code = 400, message = "查询某城市下地区错误") })
	public Result getAreas(@PathVariable("cityId") String cityId) {
		return Result.succeed(areaService.getAreasByCityId(cityId));
	}
}
