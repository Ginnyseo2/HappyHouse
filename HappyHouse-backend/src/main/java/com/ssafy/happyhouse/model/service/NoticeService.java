package com.ssafy.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.NoticeDto;
import com.ssafy.happyhouse.model.NoticeParameterDto;
import com.ssafy.happyhouse.model.BoardDto;
import com.ssafy.happyhouse.model.BoardParameterDto;
import com.ssafy.happyhouse.model.FileInfoDto;
import com.ssafy.util.PageNavigation;

public interface NoticeService {

   boolean writeArticle(NoticeDto noticeDto) throws Exception;
   List<NoticeDto> listArticle(Map<String, String> map) throws Exception;
   List<FileInfoDto> listFile(Map<String, String> map) throws Exception;
   PageNavigation makePageNavigation(Map<String, String> map) throws Exception;
   NoticeDto getArticle(int articleNo) throws Exception;
   public int totalArticle(NoticeParameterDto noticeParameterDto) throws Exception;
   void updateArticle(NoticeDto noticeDto) throws Exception;
   boolean deleteArticle(int articleNo, String path) throws Exception;
   List<FileInfoDto> getFile(int articleNo) throws Exception;
   public boolean modifyArticle(NoticeDto noticeDto) throws Exception;
   
}