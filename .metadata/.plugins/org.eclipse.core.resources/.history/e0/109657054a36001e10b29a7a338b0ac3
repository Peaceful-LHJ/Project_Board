package com.project.service.member;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.AppTest;
import com.project.domain.member.MemberVO;
import com.project.repository.member.MemberRepository;

public class MemberServiceImplTest extends AppTest {
	
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	MemberService memberService;
	
	@Ignore
	@Test
	public void memberJoinTest() { // 회원가입 테스트
		MemberVO vo = new MemberVO();
		vo.setMemberId("user");
		vo.setMemberPwd("1234");
		vo.setMemberName("사용자");
		vo.setEmail("user@test.com");
		memberService.memberJoin(vo);
	}
	
	@Test
	public void memberModifyTest() {
		MemberVO vo = new MemberVO();
		vo.setMemberId("admin");
		vo.setMemberName("사용자");
		memberService.memberModify(vo);
	}
	
}
