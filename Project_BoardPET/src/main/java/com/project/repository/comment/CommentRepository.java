package com.project.repository.comment;

import java.util.List;

import com.project.domain.comment.CommentVO;

public interface CommentRepository {
	
	void boardCommentInsert(CommentVO vo); // 자유게시글 댓글 작성
	
	void questionBoardCommentInsert(CommentVO vo); // 질문게시글 댓글 작성
	
	
	CommentVO commentRead(Long commentNum); // 댓글 단독 검색
	
	List<CommentVO> boardCommentRead(Long bno); // 자유게시글 댓글 조회
	
	List<CommentVO> questionBoardCommentRead(Long QUESbno); // 질문게시글 댓글 조회
	
	
	Long commentDelete(Long rno); // 댓글 삭제
	
	
	Long commentUpdate(CommentVO vo); // 댓글 수정
	
	
	Long getCommentCountForBoard(Long bno); // 자유게시글 댓글 수
	
	Long getCommentCountForQUESboard(Long QUESbno); // 질문게시글 댓글 수
	
}
