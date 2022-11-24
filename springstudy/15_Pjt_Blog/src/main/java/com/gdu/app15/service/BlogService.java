package com.gdu.app15.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gdu.app15.domain.BlogDTO;

public interface BlogService {
	
	public void getBlogList(Model model);
	public void saveBlog(HttpServletRequest request, HttpServletResponse response);
	// HttpServletRequest request, HttpServletResponse response 이거를 Model로 실어줘도 된다. (Controller에서)
	public Map<String, Object> saveSummernoteImage(MultipartHttpServletRequest multipartRequest);
	public int increseBlogHit(int blogNo);
	public BlogDTO getBlogByNo(int blogNo);
	public void modifyBlog(HttpServletRequest request, HttpServletResponse response);
	public void removeBlog(HttpServletRequest request, HttpServletResponse response);
}
