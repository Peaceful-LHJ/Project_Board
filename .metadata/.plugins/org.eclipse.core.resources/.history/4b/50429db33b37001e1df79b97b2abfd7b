package com.project.repository.comment;

import com.project.domain.comment.commentDEL.CommentDelVO;

public interface CommentDelRepository {
	
	// 댓글을 삭제하여 삭제 테이블로 이동하는 메소드
	CommentDelVO boardCommentDelInsert(Long commentNum); // 자유게시글 댓글 삭제테이블 이동
	CommentDelVO questionBoardCommentDelInsert(Long commentNum); // 질문게시글 댓글 삭제테이블 이동
	
	// 댓글은 삭제하지 않았으나, 해당 댓글을 작성한 게시글이 삭제된 경우 적절한 위치로 이동하는 메소드
	CommentDelVO NonCommentDelInsert(Long commentNum); // 삭제된 게시글을 참조하는 댓글 가삭제테이블로 이동
	
	CommentDelVO commentDelRead(Long commentNum); // 삭제된 댓글 조회(관리자 권한)
	
	CommentDelVO NoncommentDelRead(Long commentNum); // 삭제된 게시글을 참조하는 댓글을 조회(작성자 및 관리자권한)
	
}
