package com.care.root.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.dto.ShoesDTO;
import com.care.root.mybatis.FileMapper;

@Service
public class FileServiceImpl implements FileService{
	@Autowired FileMapper fm; 
	
	public void fileProcess(MultipartHttpServletRequest mul) {
		ShoesDTO dto = new ShoesDTO();
		dto.setId(mul.getParameter("id"));
		dto.setName(mul.getParameter("name"));
		
		MultipartFile file = mul.getFile("file");
		if(file.getSize() != 0) { //!file.isEmpty() 비어있지 않으면 실행.
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss-");
			Calendar calender = Calendar.getInstance(); //현재시간 캘린더
			
			String sysFileName = format.format(calender.getTime()); //28번째 줄에 지정한 형태로 추가
			sysFileName += file.getOriginalFilename(); //최종 저장되는 파일 이름
			
			dto.setImgName(sysFileName); //만약 파일이 있다면 dto DB에 파일 이름 저장함.
			
			File savaFile = new File(IMAGE_REPO + "/" + sysFileName);
			try {
				file.transferTo(savaFile);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			dto.setImgName("nan");
		}
		fm.saveData(dto);
	}
	public void getShoesImage(Model model) {
		model.addAttribute("list", fm.getShoesImage());
	}
}
