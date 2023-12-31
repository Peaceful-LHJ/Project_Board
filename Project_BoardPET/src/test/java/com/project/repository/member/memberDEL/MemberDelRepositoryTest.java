package com.project.repository.member.memberDEL;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.AppTest;
import com.project.domain.member.memberDEL.MemberDelVO;
import com.project.repository.member.MemberRepository;

import lombok.extern.log4j.Log4j;

@Log4j
public class MemberDelRepositoryTest extends AppTest { // 회원 삭제처리 테스트
	
	@Autowired
	MemberDelRepository memberDelRepository;
	
	@Autowired
	MemberRepository memberRepository;
	
	@Ignore
	@Test
	public void memberDelInsertByIdTest() { // 아이디로 탈퇴테이블 이동
		memberDelRepository.memberDelInsertById("writer");
	}
	
	@Ignore
	@Test
	public void memberDelInsertByNameTest() { // 이름으로 탈퇴테이블 이동
		memberDelRepository.memberDelInsertByName("작성자");
	}
	
	@Ignore
	@Test
	public void memberDelReadByNameTest() { // 이름으로 탈퇴회원 조회
		MemberDelVO memberDelReadByName = memberDelRepository.memberDelReadByName("작성자");
		log.info(memberDelReadByName);
	}
	
	@Ignore
	@Test
	public void memberDelReadByNumberTest() { // 탈퇴한 회원번호로 탈퇴회원 조회
		MemberDelVO memberDelReadByNumber = memberDelRepository.memberDelReadByNumber(1L);
		log.info(memberDelReadByNumber);
	}
	
}
