package xyz.bbxc.estate.controller.flutter;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import xyz.bbxc.estate.common.MessageConstant;
import xyz.bbxc.estate.common.Result;
import xyz.bbxc.estate.common.StatusCode;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * @Auth: 白白小草
 * @Desc: 文件上传-控制器
 * @DateTime: 2020/12/14 15:02
 */
@RestController
@RequestMapping("/Get")
public class FormImageController {
	/**
	 * 功能描述: 上传文件
	 * @param file	上传文件的参数名，必须和前端参数名称一致
	 * @param request	请求对象
	 * @param response 	响应对象
	 * @return : com.heima.estatemanagement.common.Result
	 */
	@RequestMapping(value="/imageupload")
	public Result uploadImage(@RequestParam("file")MultipartFile file, HttpServletRequest request,HttpServletResponse response) throws IOException {
		//获取当前项目所在绝对路径
		String absolutePath = System.getProperty("user.dir");
		//文件上传后所在绝对路径
//		String savePath = absolutePath+"/src/images/";
		String savePath = "/www/wwwroot/image.wuye.bbxc.xyz/baoxiuapp/";
		//保存在数据库的文件地址
		String saveUrl = "/";
		// 定义允许上传的文件扩展名
		HashMap<String, String> extMap = new HashMap<String, String>();
		extMap.put("image", "gif,jpg,jpeg,png,bmp");
//		String imageName = request.getParameter("name");
//		System.out.println("原名称"+imageName);
		// 最大文件大小
		long maxSize = 20971520; //20M
		response.setContentType("text/html; charset=UTF-8");
		if (!ServletFileUpload.isMultipartContent(request)) {
			return new Result(false, StatusCode.ERROR, MessageConstant.NO_FILE_SELECTED);
		}

		File uploadDir = new File(savePath);
		// 判断文件夹是否存在,如果不存在则创建文件夹
		if (!uploadDir.exists()) {
			uploadDir.mkdirs();
		}

		// 检查目录写权限
		if (!uploadDir.canWrite()) {
			return new Result(false, StatusCode.ERROR,MessageConstant.NO_WRITE_PERMISSION);
		}

		String dirName = request.getParameter("dir");
		if (dirName == null) {
			dirName = "image";
		}
		if (!extMap.containsKey(dirName)) {
			return new Result(false, StatusCode.ERROR,MessageConstant.INCORRECT_DIRECTORY_NAME);
		}

		MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = mRequest.getFileMap();
		String fileName = null;
		Iterator<Map.Entry<String, MultipartFile>> iter = fileMap.entrySet().iterator();

		for (Iterator<Map.Entry<String, MultipartFile>> it = fileMap.entrySet().iterator(); it.hasNext();) {
			Map.Entry<String, MultipartFile> entry = it.next();
			MultipartFile mFile = entry.getValue();
			fileName = mFile.getOriginalFilename();
			// 检查文件大小
			if (mFile.getSize() > maxSize) {
				return new Result(false, StatusCode.ERROR,MessageConstant.SIZE_EXCEEDS__LIMIT);
			}
			String fileExt = fileName.substring(fileName.lastIndexOf(".")+1);
			if (!Arrays.<String> asList(extMap.get(dirName).split(",")).contains(fileExt)) {
				return new Result(false, StatusCode.ERROR,MessageConstant.FILE_TYPE_ERROR);
			}
			UUID uuid = UUID.randomUUID();
			String path = savePath + uuid +"."+ fileExt;
			System.out.println("文件存储地址:【"+path+"】");
			saveUrl = saveUrl  + uuid +"."+ fileExt;

			try {
				BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(path));
				FileCopyUtils.copy(mFile.getInputStream(), outputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return new Result(true,StatusCode.OK, MessageConstant.COMMUNITY_PIC_UPLOAD_SUCCESS,saveUrl);
	}

}

