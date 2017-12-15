package com.xu.common.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.xu.common.config.ApplicationConfig;
import com.xu.common.model.Demo;
import com.xu.common.model.ImageCode;
import com.xu.common.model.Result;
import com.xu.common.service.DemoService;
import com.xu.common.utility.TwoDimensionCode;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/qrcode")
public class GenerateQrCodeController extends BaseCRUDController<String, Demo, DemoService>{
	
	@RequestMapping(value = "/generate/{teamId}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "生成二维码图片")
	public Result generateQrCode(@ApiParam(value = "当前目录", required = true) @PathVariable("teamId") String teamId){
		// 生成唯一ID
		int uuid = (int) (Math.random()* 100000);
		ApplicationConfig config=new ApplicationConfig();
		String contextPath=config.getProperty("server.domain")+"/#/teamDetail?id="+teamId;
		// 生成二维码
		String imgName = uuid + ".png";
		String saveFilePath =System.getProperty("user.dir")+"\\webapp\\"+imgName ;
		TwoDimensionCode handler = new TwoDimensionCode();
		handler.encoderQRCode(contextPath, saveFilePath, "png");
		// 生成的图片访问地址
		String qrCodeImg = config.getProperty("server.domain")+"/qrcode/download/"+uuid;
		ImageCode obj=new ImageCode();
		obj.setUuid(uuid);
		obj.setQrCodeImg(qrCodeImg);
		return Result.succeed(obj);
	}
	@RequestMapping(value = "/download/{fileid}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "下载文件")
	public void getfile(@ApiParam(value = "下载文件", required = true) @PathVariable("fileid") String fileid) throws IOException{
		HttpServletResponse response = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
		OutputStream outp = response.getOutputStream();
		//二维码图片地址
		String fullPath=System.getProperty("user.dir")+"\\webapp\\"+fileid+".png";
	    File file = new File(fullPath);
	    if (file.exists()) {
	        response.setContentType("APPLICATION/OCTET-STREAM");
	        String filedisplay = URLEncoder.encode(fileid+".png", "UTF-8");
	        response.addHeader("Content-Disposition", "attachment;filename="+ filedisplay);
	        FileInputStream in = null;
	        BufferedInputStream bis=null;
	        BufferedOutputStream bos=null;
	        try{
	           outp = response.getOutputStream();
	           in = new FileInputStream(fullPath);
	           byte[] b = new byte[8192];
	           int i = 0;
	           bis = new BufferedInputStream(in, 8192);
	           bos = new BufferedOutputStream(outp, 8192);
	           while ((i = bis.read(b)) > 0) {
	              bos.write(b, 0, i);
	              bos.flush();
	           }
	        } catch (Exception e) {
	        	logger.info(e.getMessage());
	        } finally {
	           if (bis != null) {
	              bis.close();
	           }
	           if (bos != null) {
	              bos.close();
	           }
	           if (in != null) {
	              in.close();
	           }
	           if (outp != null) {
	              outp.close();
	              response.flushBuffer();
	           }
	        }
	      } else {
	        outp.write("<script type=\"text/javascript\">alert(\"文件不存在!\");</script>".getBytes("utf-8"));
	      }
	}	
}
