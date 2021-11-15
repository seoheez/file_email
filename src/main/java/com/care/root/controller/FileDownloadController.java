package com.care.root.controller;

import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.root.service.FileService;

@Controller
public class FileDownloadController {
	@GetMapping("download")
	public void download(@RequestParam("file") String fileName,
							HttpServletResponse response) throws Exception {	//file이라는 이름으로 넘어오는 값을 fileName에 대입. 동일하면 "file" 생략가능함.
							
		/*
		 Content-disposition : 파일 다운로드하겠다는 의미.
		 attachment : 파일을 다운로드하여 브라우저로 표현함.
		 */
	response.addHeader("Content-disposition","attachment; fileName="+fileName);
		File file = new File(FileService.IMAGE_REPO + "/" + fileName);
		FileInputStream in = new FileInputStream(file); 	// 저장소에 있는 값 가져옴.
		FileCopyUtils.copy(in, response.getOutputStream() ); // 왼쪽에 있는 데이터를 오른쪽에 있는 데이터로 복사.
		in.close();
	}
}







