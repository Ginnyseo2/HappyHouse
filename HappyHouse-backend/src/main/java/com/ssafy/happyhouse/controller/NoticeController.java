package com.ssafy.happyhouse.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.happyhouse.model.FileInfoDto;

import com.ssafy.happyhouse.model.BoardDto;
import com.ssafy.happyhouse.model.BoardParameterDto;
import com.ssafy.happyhouse.model.NoticeDto;
import com.ssafy.happyhouse.model.NoticeParameterDto;
import com.ssafy.happyhouse.model.UserDto;
import com.ssafy.happyhouse.model.service.NoticeService;
import com.ssafy.util.PageNavigation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/notice")
@Api("공지사항 컨트롤러")
public class NoticeController {
   private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
   private static final String SUCCESS = "success";
   private static final String FAIL = "fail";
   
   @Autowired
   private NoticeService noticeService;
   
   @Autowired
   private ServletContext servletContext;
   
   
   @PostMapping("/register")
   public ResponseEntity<String> writeArticle(
         @RequestParam("userid") @ApiParam(value = "게시글 정보.", required = true) String userid, 
         @RequestParam("subject") @ApiParam(value = "게시글 정보.", required = true) String subject, 
         @RequestParam("content") @ApiParam(value = "게시글 정보.", required = true) String content) throws Exception {
      
      
//      logger.info("registerArticle - 호출" + userid +" "+subject+" "+files.length);
      
      NoticeDto noticeDto=new NoticeDto();
      noticeDto.setUserid(userid);
      noticeDto.setSubject(subject);
      noticeDto.setContent(content);
      
      
//      System.out.println(files[0].getName());
      

      if (noticeService.writeArticle(noticeDto)) {
         return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
      }
      return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
   }
	@GetMapping("/total")
	public ResponseEntity<Integer> totalArticle(@ApiParam(value = "게시글을 얻기위한 부가정보.", required = true) NoticeParameterDto noticeParameterDto) throws Exception {
		logger.info("totalArticle - 호출");
		return new ResponseEntity<Integer>(noticeService.totalArticle(noticeParameterDto), HttpStatus.OK);
	}
   @GetMapping("/list")
   public ResponseEntity<Map<String, Object>> list(@RequestParam Map<String, String> map) throws Exception {
      Map<String,Object> resultMap = new HashMap<>();

      String spp = map.get("spp"); // size per page (페이지당 글갯수)
      map.put("spp", spp != null ? spp : "10");
      List<NoticeDto> list = noticeService.listArticle(map);
      System.out.println("**************************************");
      System.out.println("리스트 GET 호출시 무엇이 담겨있나요?? " + list.toString());
      for(int i = 0; i < list.size(); i++) {
         System.out.println(list.get(i));
      }
      System.out.println("**************************************");
      PageNavigation pageNavigation = noticeService.makePageNavigation(map);
      resultMap.put("articles", list);
      resultMap.put("navigation", pageNavigation);
      resultMap.put("key", map.get("key"));
      resultMap.put("word", map.get("word"));
      
      return new ResponseEntity<Map<String, Object>>(resultMap,HttpStatus.OK);
   }
    

   @ApiOperation(value = "게시판 글보기", notes = "글번호에 해당하는 게시글의 정보를 반환한다.", response = BoardDto.class)
   @GetMapping("/{articleno}")
   public ResponseEntity<NoticeDto> getArticle(@PathVariable("articleno") @ApiParam(value = "얻어올 글의 글번호.", required = true) int articleno) throws Exception {
      logger.info("getArticle - 호출 : " + articleno);
      return new ResponseEntity<NoticeDto>(noticeService.getArticle(articleno), HttpStatus.OK);
   }
   
	@PutMapping
	public ResponseEntity<String> modifyArticle(@RequestBody @ApiParam(value = "수정할 글정보.", required = true) NoticeDto noticeDto) throws Exception {
		logger.info("modifyArticle - 호출");
		
		if (noticeService.modifyArticle(noticeDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}
   
   @DeleteMapping("/{articleno}")
   public ResponseEntity<String> deleteArticle(@PathVariable("articleno") @ApiParam(value = "살제할 글의 글번호.", required = true) int articleno) throws Exception {
      logger.info("deleteArticle - 호출");
      if (noticeService.deleteArticle(articleno, servletContext.getRealPath("/resources/img") )) {
         return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
      }
      return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
   }
   
}