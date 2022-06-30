package com.ssafy.happyhouse.model.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.model.NoticeDto;
import com.ssafy.happyhouse.model.NoticeParameterDto;
import com.ssafy.happyhouse.model.BoardDto;
import com.ssafy.happyhouse.model.BoardParameterDto;
import com.ssafy.happyhouse.model.FileInfoDto;
import com.ssafy.happyhouse.model.mapper.BoardMapper;
import com.ssafy.happyhouse.model.mapper.NoticeMapper;
import com.ssafy.util.PageNavigation;

@Service
public class NoticeServiceImpl implements NoticeService {

   @Autowired
   private SqlSession sqlSession;
   
   @Override
   public boolean writeArticle(NoticeDto noticeDto) throws Exception {
      // TODO Auto-generated method stub
      if(noticeDto.getSubject() == null || noticeDto.getContent() == null) {
         throw new Exception();
      }
      NoticeMapper noticeMapper = sqlSession.getMapper(NoticeMapper.class);
      int insert =noticeMapper.writeArticle(noticeDto);
      List<FileInfoDto> fileInfos = noticeDto.getFileInfos();
      if (fileInfos != null && !fileInfos.isEmpty()) {
         noticeMapper.registerFile(noticeDto);
      }
      return insert == 1;
      
   }

   @Override
   public List<NoticeDto> listArticle(Map<String, String> map) throws Exception {
      // TODO Auto-generated method stub
      Map<String, Object> param = new HashMap<String, Object>();
      param.put("key", map.get("key") == null ? "" : map.get("key"));
      param.put("word", map.get("word") == null ? "" : map.get("word"));
      int currentPage = Integer.parseInt(map.get("pg") == null ? "1" : map.get("pg"));
      int sizePerPage = Integer.parseInt(map.get("spp"));
      int start = (currentPage - 1) * sizePerPage;
      param.put("start", start);
      param.put("spp", sizePerPage);
      return sqlSession.getMapper(NoticeMapper.class).listArticle(param);
   }

   @Override
   public PageNavigation makePageNavigation(Map<String, String> map) throws Exception {
      PageNavigation pageNavigation = new PageNavigation();
      
//      int naviSize = 10;
//      int currentPage = Integer.parseInt(map.get("pg"));
//      int sizePerPage = Integer.parseInt(map.get("spp"));
//      
//      pageNavigation.setCurrentPage(currentPage);
//      pageNavigation.setNaviSize(naviSize);
//      int totalCount = sqlSession.getMapper(NoticeMapper.class).getTotalCount(map);
//      pageNavigation.setTotalCount(totalCount);
//      int totalPageCount = (totalCount - 1) / sizePerPage + 1;
//      pageNavigation.setTotalPageCount(totalPageCount);
//      boolean startRange = currentPage <= naviSize;
//      pageNavigation.setStartRange(startRange);
//      boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;
//      pageNavigation.setEndRange(endRange);
//      pageNavigation.makeNavigator();
      
      return pageNavigation;
   }

   @Override
   public NoticeDto getArticle(int articleNo) throws Exception {
      // TODO Auto-generated method stub
      return sqlSession.getMapper(NoticeMapper.class).getArticle(articleNo);
   }
   
   @Override
   public List<FileInfoDto> getFile(int articleNo) throws Exception {
      // TODO Auto-generated method stub
      return sqlSession.getMapper(NoticeMapper.class).getFile(articleNo);
   }

   @Override
   @Transactional
   public void updateArticle(NoticeDto noticeDto) throws Exception {
      // TODO Auto-generated method stub
      sqlSession.getMapper(NoticeMapper.class).updateArticle(noticeDto);
   }

	@Override
	@Transactional
	public boolean modifyArticle(NoticeDto noticeDto) throws Exception {
		return sqlSession.getMapper(NoticeMapper.class).modifyArticle(noticeDto) == 1;
	}
   
   @Override
   @Transactional
   public boolean deleteArticle(int articleNo, String path) throws Exception {
      // TODO Auto-generated method stub
      NoticeMapper noticeMapper = sqlSession.getMapper(NoticeMapper.class);
      List<FileInfoDto> fileList = noticeMapper.getFile(articleNo);
      noticeMapper.deleteFile(articleNo);
      noticeMapper.deleteArticle(articleNo);
      for(FileInfoDto fileInfoDto : fileList) {
         File file = new File(path + File.separator + fileInfoDto.getSaveFolder() + File.separator + fileInfoDto.getSaveFile());
         file.delete();
      }
      return true;
   }

	@Override
	public int totalArticle(NoticeParameterDto noticeParameterDto) throws Exception {
		return sqlSession.getMapper(NoticeMapper.class).getTotalCount(noticeParameterDto);
	}
   @Override
   public List<FileInfoDto> listFile(Map<String, String> map) throws Exception {
      Map<String, Object> param = new HashMap<String, Object>();
      param.put("key", map.get("key") == null ? "" : map.get("key"));
      param.put("word", map.get("word") == null ? "" : map.get("word"));
      int currentPage = Integer.parseInt(map.get("pg") == null ? "1" : map.get("pg"));
      int sizePerPage = Integer.parseInt(map.get("spp"));
      int start = (currentPage - 1) * sizePerPage;
      param.put("start", start);
      param.put("spp", sizePerPage);
      return sqlSession.getMapper(NoticeMapper.class).listFile(param);
   }

}