package com.project.repository.attach;

import java.util.UUID;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.AppTest;
import com.project.domain.attach.BoardAttachVO;

import lombok.extern.log4j.Log4j;

@Log4j
public class BoardAttachRepositoryTest extends AppTest {
	
	@Autowired
	BoardAttachRepository boardAttachRepository;
	
	@Ignore
	@Test
	public void boardAttachInsertTest() {
		BoardAttachVO boardAttachVO = new BoardAttachVO();
		boardAttachVO.setBno(1L);
		boardAttachVO.setFileName("test02.txt");
		boardAttachVO.setFileType(false);
		boardAttachVO.setUploadPath("c:/upload");
		String uuid = UUID.randomUUID().toString();
		boardAttachVO.setUuid(uuid);
		boardAttachRepository.boardAttachInsert(boardAttachVO);
	}
	
	@Ignore
	@Test
	public void selectByBnoTest() {
		boardAttachRepository.selectByBno(1L)
			.forEach(file -> log.info(file));
	}
	
	@Ignore
	@Test
	public void boardAttachDeleteTest() {
		// 데이터베이스에 저장된 uuid값을 참고
		String uuid = "08c43df8-a144-43d1-aada-aeb451db95e8";
		boardAttachRepository.boardAttachDelete(uuid);
	}

}
