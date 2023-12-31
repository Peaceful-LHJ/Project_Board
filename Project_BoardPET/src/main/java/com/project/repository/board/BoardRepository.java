package com.project.repository.board;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.project.domain.board.BoardVO;
import com.project.domain.common.Criteria;

public interface BoardRepository { // 자유게시글 기능
	
	List<BoardVO> getList(Criteria criteria); 
	
	void boardInsert(BoardVO vo); // 자유게시글 작성
	
	BoardVO boardRead(Long bno); // 자유게시글 조회
	List<Long> selectBoardBnoByName(String memberName); // 해당 회원의 이름으로 작성된 모든 자유게시글 번호 추출
	
	List<BoardVO> boardReadByName(String memberName); // 회원 이름으로 해당 회원이 작성한 모든 자유게시글 조회
	
	Long boardDelete(Long bno); // 자유게시글 영구삭제
	Long boardDeleteListByName(String memberName); // 해당 회원의 이름으로 작성된 모든 자유게시글 영구삭제
	
	Long boardUpdate(BoardVO vo); // 자유게시글 수정
	
	int getTotalCount(Criteria criteria);
	
	void boardUpdateCommentCnt(@Param("bno") Long bno, @Param("amount") int amount); // 자유게시글 댓글 수
	
	void boardUpdateLikeCnt(@Param("bno") Long bno, @Param("amount") int amount); // 자유게시글 추천 수
	
}
