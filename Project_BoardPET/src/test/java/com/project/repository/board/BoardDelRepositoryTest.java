package com.project.repository.board;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.AppTest;
import com.project.domain.board.BoardVO;
import com.project.domain.board.boardDEL.BoardDelVO;

import lombok.extern.log4j.Log4j;

@Log4j
public class BoardDelRepositoryTest extends AppTest {
	
	@Autowired
	BoardDelRepository boardDelRepository;
	
	@Test
	public void boardDelInsertTest() { // 자유게시글 삭제 테이블 이동 및 해당 자유게시글 테이블 자료 삭제
		boardDelRepository.boardDelInsert(1L);
	}

}
