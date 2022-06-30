package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.NoticeDto;
import com.ssafy.happyhouse.model.NoticeParameterDto;
import com.ssafy.happyhouse.model.BoardParameterDto;
import com.ssafy.happyhouse.model.FileInfoDto;

@Mapper
public interface NoticeMapper {

   int writeArticle(NoticeDto noticeDto) throws Exception;
   void registerFile(NoticeDto noticeDto) throws Exception;
   List<NoticeDto> listArticle(Map<String, Object> map) throws Exception;
   List<FileInfoDto> listFile(Map<String, Object> map) throws Exception;
   int getTotalCount(NoticeParameterDto noticeParameterDto) throws Exception;
   NoticeDto getArticle(int articleNo) throws Exception;
   public int modifyArticle(NoticeDto noticeDto) throws SQLException;
   void updateArticle(NoticeDto noticeDto) throws Exception;
   void deleteFile(int articleNo) throws Exception;
   boolean deleteArticle(int articleNo) throws Exception;
   List<FileInfoDto> getFile(int articleNo) throws Exception;
}