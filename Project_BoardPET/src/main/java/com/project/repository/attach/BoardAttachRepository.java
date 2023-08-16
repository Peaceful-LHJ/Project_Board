package com.project.repository.attach;

import java.util.List;

import com.project.domain.attach.BoardAttachVO;

public interface BoardAttachRepository {
	
	void boardAttachInsert(BoardAttachVO attachVO);
	
	void boardAttachDelete(String uuid);
	
	List<BoardAttachVO> selectByBno(Long bno);
	
	BoardAttachVO selectByUuid(String uuid);
	
}
