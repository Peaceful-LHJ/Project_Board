package com.project.repository.comment;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.AppTest;

import lombok.extern.log4j.Log4j;

@Log4j
public class CommentDelRepositoryTest extends AppTest {
	
	@Autowired
	CommentDelRepository commentDelRepository;
	
	@Autowired
	CommentRepository commentRepository;
	
	@Test
	public void boardCommentDelInsert() {
		commentDelRepository.boardCommentDelInsert(1L);
	}

}
