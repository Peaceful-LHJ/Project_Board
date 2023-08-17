package com.project.repository.comment;

import java.util.List;

import com.project.domain.comment.CommentVO;

public interface CommentRepository {
	
	void boardCommentInsert(CommentVO vo); // 자유게시글 댓글 작성
	
	void questionBoardCommentInsert(CommentVO vo); // 질문게시글 댓글 작성
	
	
	CommentVO commentRead(Long commentNum); // 댓글 단독 검색
	List<CommentVO> commentReadByName(String memberName); // 해당 회원 이름의 사용자가 작성한 모든 댓글 조회
	
	List<CommentVO> boardCommentRead(Long bno); // 자유게시글 댓글 조회
	
	List<CommentVO> questionBoardCommentRead(Long QUESbno); // 질문게시글 댓글 조회
	
	
	Long commentDelete(Long commentNum); // 댓글 단독 영구 삭제
	Long commentListFromBoardDelete(Long bno); // 해당 자유게시물 댓글 모두 영구 삭제
	Long commentListFromQuestionBoardDelete(Long bno); // 해당 질문게시물 댓글 모두 영구 삭제
	
	
	Long commentUpdate(CommentVO vo); // 댓글 수정
	
	
	Long getCommentCountForBoard(Long bno); // 자유게시글 댓글 수
	
	Long getCommentCountForQUESboard(Long QUESbno); // 질문게시글 댓글 수
	
}
