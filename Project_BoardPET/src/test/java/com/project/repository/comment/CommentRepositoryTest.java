
package com.project.repository.comment;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.AppTest;
import com.project.domain.comment.CommentVO;

import lombok.extern.log4j.Log4j;

@Log4j
public class CommentRepositoryTest extends AppTest {
	
	@Autowired
	CommentRepository commentRepository;
	
	@Ignore
	@Test
	public void boardCommentInsertTest() { // 자유게시글 댓글 작성 테스트
		CommentVO vo = CommentVO.builder()
				.content("댓글 작성테스트 입니다2")
				.writer("작성자")
				.bno(1L)
				.build();
		commentRepository.boardCommentInsert(vo);
		log.info("댓글 작성 : " + vo);
	}
	
	@Ignore
	@Test
	public void questionBoardCommentInsertTest() { // 질문게시글 댓글 작성 테스트
		CommentVO vo = CommentVO.builder()
				.content("댓글 작성테스트 입니다 !!")
				.writer("작성자")
				.QUESbno(1L)
				.build();
		commentRepository.questionBoardCommentInsert(vo);
		log.info("댓글 작성 : " + vo);
	}
	
	@Ignore
	@Test
	public void commentReadTest() { // 댓글 단독 조회
		CommentVO commentRead = commentRepository.commentRead(1L);
		log.info(commentRead);
	}
	
	@Ignore
	@Test
	public void boardCommentReadTest() { // 자유게시글 댓글 조회
		List<CommentVO> list = commentRepository.boardCommentRead(1L);
		log.info(list);
	}
	
	@Ignore
	@Test
	public void questionBoardCommentReadTest() { // 질문게시글 댓글 조회
		List<CommentVO> list = commentRepository.questionBoardCommentRead(1L);
		log.info(list);
	}
	
	@Ignore
	@Test
	public void commentDeleteTest() { // 댓글 영구 삭제 테스트
		commentRepository.commentDelete(2L);
		log.info("댓글 삭제 완료");
	}
	
	@Ignore
	@Test
	public void commentUpdateTest() { // 댓글 수정 테스트
		CommentVO vo = new CommentVO();
		vo.setContent("댓글 수정 테스트입니다 !!");
		vo.setCommentNum(1L);
		commentRepository.commentUpdate(vo);
		
		CommentVO commentRead = commentRepository.commentRead(1L); // 수정한 댓글 조회
		log.info(commentRead);
	}
	
	@Ignore
	@Test
	public void getCommentCountForBoard() { // 해당 자유게시글 댓글 수
		Long bno = 1L; // 자유게시글 번호
		Long count = commentRepository.getCommentCountForBoard(bno);
		log.info(bno + "번 자유게시글의 댓글 수 : " + count);
	}
	
	@Ignore
	@Test
	public void getCommentCountForQUESboard() { // 해당 질문게시글 댓글 수
		Long QUESbno = 1L; // 질문게시글 번호
		Long count = commentRepository.getCommentCountForQUESboard(QUESbno);
		log.info(QUESbno + "번 질문게시글의 댓글 수 : " + count);
	}
	
	@Ignore
	@Test
	public void commentReadByNameTest() { // 해당 회원의 이름으로 작성된 모든 게시글의 댓글 조회
		List<CommentVO> commentReadByName = commentRepository.commentReadByName("작성자");
		log.info(commentReadByName);
	}
	
	@Ignore
	@Test
	public void allCommentDeleteByNameTest() { // 해당 회원의 이름으로 작성된 모든 게시글의 댓글 영구 삭제
		Long allCommentDeleteByName = commentRepository.allCommentDeleteByName("작성자");
		log.info("영구삭제된 댓글 수" + allCommentDeleteByName);
	}
	
}
