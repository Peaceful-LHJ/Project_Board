package com.project.repository.board.boardDEL;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.AppTest;
import com.project.domain.board.AnswerVO;
import com.project.domain.board.boardDEL.AnswerFromDelVO;
import com.project.domain.board.boardDEL.QuestionBoardDelVO;
import com.project.domain.comment.CommentVO;
import com.project.domain.comment.commentDEL.CommentFromDelVO;
import com.project.repository.board.AnswerRepository;
import com.project.repository.board.QuestionBoardRepository;
import com.project.repository.comment.CommentRepository;
import com.project.repository.comment.commentDEL.CommentDelRepository;

import lombok.extern.log4j.Log4j;

@Log4j
public class QuestionBoardDelRepositoryTest extends AppTest {
	
	@Autowired
	AnswerDelRepository answerDelRepository;
	
	@Autowired
	AnswerRepository answerRepository;
	
	@Autowired
	CommentDelRepository commentDelRepository;
	
	@Autowired
	CommentRepository commentRepository;
	
	@Autowired
	QuestionBoardDelRepository questionBoardDelRepository;
	
	@Autowired
	QuestionBoardRepository questionBoardRepository;
	
	@Ignore
	@Test
	public void questionBoardDelInsertTest() { // 질문게시글 삭제테이블 이동 및 남은 데이터 처리 테스트
		log.info("===== 테스트 시작 =====");
		Long QUESbno = 3L; // 삭제할 질문게시판 번호
		
		log.info("===== 댓글유무 조회 실시 =====");
		List<CommentVO> questionBoardCommentRead = commentRepository.questionBoardCommentRead(QUESbno); // 게시물의 댓글유무 조회
		
		if(questionBoardCommentRead.isEmpty()) { // 댓글이 없는 경우
			log.info("===== 댓글없음 =====");
			
			log.info("===== 답글유무 조회 실시 =====");
			List<AnswerVO> answerListRead = answerRepository.answerListRead(QUESbno);
			log.info("조회된 답글 : " + answerListRead);
			
			if(answerListRead.isEmpty()) { // 답글이 없는경우
				log.info("===== 조회된 답글이 없습니다! =====");
				
				log.info("===== 게시물 삭제테이블 이동 실시 =====");
				Long questionBoardDelInsert = questionBoardDelRepository.questionBoardDelInsert(QUESbno); // 게시물 삭제테이블 이동
				
				if(questionBoardDelInsert == null) { // 게시물 삭제테이블 이동 실패시
					log.info("데이터 삭제 테이블 이동 실패!!");
					log.info("===== 테스트를 중지합니다 =====");
					return;
				} else { // 게시물 삭제테이블 이동 성공시
					log.info("게시물 삭제테이블 이동완료!");
				}
				log.info("===== 게시물 삭제테이블 이동 성공여부 확인 실시 =====");
				QuestionBoardDelVO questionBoardDelRead = questionBoardDelRepository.questionBoardDelRead(QUESbno); // 게시물 삭제테이블 정상 이동여부 확인
				
				if(questionBoardDelRead == null) { // 정상적인 이동이 이뤄지지 않은 경우
					log.info("게시물 삭제 테이블 이동 실패!!");
					log.info("===== 테스트를 중지합니다 =====");
					return;
				} else if(questionBoardDelRead != null) { // 정상적으로 이동이 성공한 경우
					log.info("게시물 삭제 테이블 이동 성공!");
					
					log.info("===== 게시물 영구삭제 실시 =====");
					questionBoardRepository.questionBoardDelete(QUESbno);
					log.info("게시물 영구삭제성공!");
				}
				log.info("===== 테스트 종료 =====");
				return;
			}
			
			if(answerListRead != null) { // 답글이 존재하는 경우
				log.info("===== 답글이 존재합니다! =====");
				
				log.info("===== 해당 답글 가삭제 테이블 이동 실시 =====");
				answerDelRepository.NonAnswerDelInsert(QUESbno);
				
				log.info("===== 해당 답글 가삭제 테이블 이동 여부 확인 실시 =====");
				AnswerFromDelVO nonAnswerDelRead = answerDelRepository.NonAnswerDelRead(QUESbno);
				
				if(nonAnswerDelRead == null) { // 답글 가삭제 테이블 이동 실패시
					log.info("답글 가삭제 테이블 이동 실패!!");
					log.info("===== 테스트를 중지합니다 =====");
					return;
				}
				
				log.info("답글 가삭제 테이블 이동 성공!");
				
				log.info("===== 해당 게시글 원본 답글 영구삭제 실시 =====");
				answerRepository.answerListDelete(QUESbno);
				log.info("답글 영구 삭제 완료!");
				
				log.info("===== 게시물 삭제테이블 이동 실시 =====");
				Long questionBoardDelInsert = questionBoardDelRepository.questionBoardDelInsert(QUESbno); // 게시물 삭제테이블 이동
				
				if(questionBoardDelInsert == null) {
					log.info("데이터 가삭제 테이블 이동 실패!!");
					log.info("===== 테스트를 중지합니다 =====");
					return;
				}
				log.info("데이터 가삭제 테이블 이동 완료!");
				
				log.info("===== 게시물 삭제테이블 이동 여부 확인 실시 =====");
				QuestionBoardDelVO questionBoardDelRead = questionBoardDelRepository.questionBoardDelRead(QUESbno);
				
				if(questionBoardDelRead == null) { // 정상적인 이동이 이뤄지지 않은 경우
					log.info("게시물 삭제 테이블 이동 실패!!");
					log.info("===== 테스트를 중지합니다 =====");
					return;
				} else if(questionBoardDelRead != null) { // 정상적으로 이동이 성공한 경우
					log.info("게시물 삭제 테이블 이동 성공!");
					log.info("===== 게시물 영구삭제 실시 =====");
					questionBoardRepository.questionBoardDelete(QUESbno);
					log.info("게시물 영구삭제성공!");
				}
				log.info("===== 테스트 종료 =====");
				return;
			}
		}
		
		if(questionBoardCommentRead != null) { // 댓글이 있는 경우
			log.info("===== 댓글있음 =====");
			
			log.info("===== 댓글 가삭제 테이블 이동 실시 =====");
			commentDelRepository.NonQuestionBoardCommentDelInsert(QUESbno); // 댓글 가삭제 테이블 이동
			
			log.info("===== 댓글 가삭제 테이블 정상 이동여부 확인실시 =====");
			CommentFromDelVO commentFromDelVO = commentDelRepository.NoncommentDelRead(QUESbno); // 댓글 가삭제 테이블 정상이동 조회
			if(commentFromDelVO == null) { // 정상적인 이동이 이뤄지지 않은 경우
				log.info("댓글 가삭제 테이블 이동 실패!!");
				log.info("===== 테스트를 중지합니다 =====");
				return;
			}
			log.info("댓글 가삭제 테이블 이동 성공!");
			
			log.info("===== 댓글 영구삭제 실시 =====");
			commentRepository.commentListFromQuestionBoardDelete(QUESbno);
			log.info("댓글 영구삭제성공!");
			
			log.info("===== 답글유무 조회 실시 =====");
			List<AnswerVO> answerListRead = answerRepository.answerListRead(QUESbno);
			log.info("조회된 답글 : " + answerListRead);
			
			if(answerListRead.isEmpty()) { // 답글이 없는경우
				log.info("===== 조회된 답글이 없습니다! =====");
				
				log.info("===== 게시물 삭제테이블 이동 실시 =====");
				Long questionBoardDelInsert = questionBoardDelRepository.questionBoardDelInsert(QUESbno); // 게시물 삭제테이블 이동
				
				if(questionBoardDelInsert == null) { // 게시물 삭제테이블 이동 실패시
					log.info("데이터 삭제 테이블 이동 실패!!");
					log.info("===== 테스트를 중지합니다 =====");
					return;
				} else { // 게시물 삭제테이블 이동 성공시
					log.info("게시물 삭제테이블 이동완료!");
				}
				log.info("===== 게시물 삭제테이블 이동 성공여부 확인 실시 =====");
				QuestionBoardDelVO questionBoardDelRead = questionBoardDelRepository.questionBoardDelRead(QUESbno); // 게시물 삭제테이블 정상 이동여부 확인
				
				if(questionBoardDelRead == null) { // 정상적인 이동이 이뤄지지 않은 경우
					log.info("게시물 삭제 테이블 이동 실패!!");
					log.info("===== 테스트를 중지합니다 =====");
					return;
				} else if(questionBoardDelRead != null) { // 정상적으로 이동이 성공한 경우
					log.info("게시물 삭제 테이블 이동 성공!");
					
					log.info("===== 게시물 영구삭제 실시 =====");
					questionBoardRepository.questionBoardDelete(QUESbno);
					log.info("게시물 영구삭제성공!");
				}
				log.info("===== 테스트 종료 =====");
				return;
			}
			
			if(answerListRead != null) { // 답글이 존재하는 경우
				log.info("===== 답글이 존재합니다! =====");
				
				log.info("===== 해당 답글 가삭제 테이블 이동 실시 =====");
				answerDelRepository.NonAnswerDelInsert(QUESbno);
				
				log.info("===== 해당 답글 가삭제 테이블 이동 여부 확인 실시 =====");
				AnswerFromDelVO nonAnswerDelRead = answerDelRepository.NonAnswerDelRead(QUESbno);
				
				if(nonAnswerDelRead == null) { // 답글 가삭제 테이블 이동 실패시
					log.info("답글 가삭제 테이블 이동 실패!!");
					log.info("===== 테스트를 중지합니다 =====");
					return;
				}
				
				log.info("답글 가삭제 테이블 이동 성공!");
				
				log.info("===== 해당 게시글 원본 답글 영구삭제 실시 =====");
				answerRepository.answerListDelete(QUESbno);
				log.info("답글 영구 삭제 완료!");
				
				log.info("===== 게시물 삭제테이블 이동 실시 =====");
				Long questionBoardDelInsert = questionBoardDelRepository.questionBoardDelInsert(QUESbno); // 게시물 삭제테이블 이동
				
				if(questionBoardDelInsert == null) {
					log.info("데이터 가삭제 테이블 이동 실패!!");
					log.info("===== 테스트를 중지합니다 =====");
					return;
				}
				log.info("데이터 가삭제 테이블 이동 완료!");
				
				log.info("===== 게시물 삭제테이블 이동 여부 확인 실시 =====");
				QuestionBoardDelVO questionBoardDelRead = questionBoardDelRepository.questionBoardDelRead(QUESbno);
				
				if(questionBoardDelRead == null) { // 정상적인 이동이 이뤄지지 않은 경우
					log.info("게시물 삭제 테이블 이동 실패!!");
					log.info("===== 테스트를 중지합니다 =====");
					return;
				} else if(questionBoardDelRead != null) { // 정상적으로 이동이 성공한 경우
					log.info("게시물 삭제 테이블 이동 성공!");
					log.info("===== 게시물 영구삭제 실시 =====");
					questionBoardRepository.questionBoardDelete(QUESbno);
					log.info("게시물 영구삭제성공!");
				}
				log.info("===== 테스트 종료 =====");
				return;
			}
		}
	}
	
	@Ignore
	@Test
	public void questionBoardDelReadTest() { // 삭제한 질문게시글 조회
		Long QUESbno = 1L;
		QuestionBoardDelVO questionBoardDelRead = questionBoardDelRepository.questionBoardDelRead(QUESbno);
		log.info(questionBoardDelRead);
	}
	
	@Ignore
	@Test
	public void questionBoardDelInsertByNameTest() {
		Long questionBoardDelInsertByName = questionBoardDelRepository.questionBoardDelInsertByName("작성자");
		log.info("해당 회원의 삭제된 질문글 수 : " + questionBoardDelInsertByName);
	}

}
