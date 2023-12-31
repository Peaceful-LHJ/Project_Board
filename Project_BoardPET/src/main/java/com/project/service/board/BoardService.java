package com.project.service.board;

import java.util.List;

import com.project.domain.attach.BoardAttachVO;
import com.project.domain.board.BoardLikeDTO;
import com.project.domain.board.BoardVO;
import com.project.domain.common.Criteria;

public interface BoardService {
	
	List<BoardVO> getList(Criteria criteria); // 목록
	
	int totalCount(Criteria criteria); // 게시물 수
	
	void boardRegister(BoardVO boardVO); // 자유게시글 작성
	
	BoardVO boardRead(Long bno); // 자유게시글 조회
	
	boolean boardModify(BoardVO boardVO); // 자유게시글 수정
	
	boolean boardRemove(Long bno); // 자유게시글 삭제처리
	
	List<BoardAttachVO> getBoardAttachList(Long bno); // 해당 자유게시글 첨부파일 모두 불러오기 
	
	BoardAttachVO getBoardAttach(String uuid); // 자유게시글 해당 첨부파일 불러오기
	
	boolean hitLike(BoardLikeDTO boardLikeDTO); // 추천실행
	
	Boolean isLike(BoardLikeDTO boardLikeDTO); // 추천여부
	
}