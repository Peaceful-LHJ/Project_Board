package com.project.repository.member;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.AppTest;
import com.project.domain.member.MemberVO;

import lombok.extern.log4j.Log4j;

@Log4j
public class MemberRepositoryTest extends AppTest {
	
	@Autowired
	MemberRepository memberRepository;
	
	@Ignore
	@Test
	public void memberReadTest() {
		MemberVO vo = memberRepository.memberRead("admin");
		System.out.println(vo);
	}
	
	@Ignore
	@Test
	public void memberInsertTest() {
		MemberVO vo = new MemberVO();
		vo.setMemberId("user");
		vo.setMemberPwd("1234");
		vo.setMemberName("사용자");
		vo.setEmail("user@test.com");
		System.out.println(vo);
	}

}
