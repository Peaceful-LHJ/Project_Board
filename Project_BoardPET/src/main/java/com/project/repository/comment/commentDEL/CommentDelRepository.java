package com.project.repository.comment.commentDEL;

import com.project.domain.comment.commentDEL.CommentDelVO;
import com.project.domain.comment.commentDEL.CommentFromDelVO;

public interface CommentDelRepository {
	
	// 댓글을 삭제하여 삭제 테이블로 이동하는 메소드
	void boardCommentDelInsert(Long commentNum); // 자유게시글 댓글 삭제테이블 이동
	void questionBoardCommentDelInsert(Long commentNum); // 질문게시글 댓글 삭제테이블 이동
	
	Long allCommentDelInsertListByName(String memberName); // 해당 회원의 이름으로 작성된 모든 댓글 삭제테이블로 이동
	
	// 댓글은 삭제하지 않았으나, 해당 댓글을 작성한 게시글이 삭제된 경우 적절한 위치로 이동하는 메소드
	void NonBoardCommentDelInsert(Long commentNum); // 삭제된 자유게시글을 참조하는 댓글을 가삭제테이블로 이동
	void NonQuestionBoardCommentDelInsert(Long commentNum); // 삭제된 질문게시글을 참조하는 댓글을 가삭제테이블로 이동
	
	CommentDelVO commentDelRead(Long DELcommentNum); // 삭제된 댓글 조회(관리자 권한)
	
	CommentFromDelVO NoncommentDelRead(Long fromDELcommentNum); // 삭제된 게시글을 참조하는 댓글을 조회(작성자 및 관리자권한)
	
}
