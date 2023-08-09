package com.project.service.member;

import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.project.AppTest;
import com.project.domain.member.MemberVO;
import com.project.repository.member.MemberRepository;

public class MemberServiceImplTest extends AppTest {
	
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
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
	
	@Ignore
	@Test
	public void memberModifyTest() { // 회원 정보 수정 테스트
		MemberVO selectById = memberRepository.selectById("admin");
		if(selectById != null) {
			selectById.setMemberName("관리자");
			memberService.memberModify(selectById);
		}
		System.out.println("존재하지 않는 회원입니다.");
	}
	
	@Ignore
	@Test
	public void memberReadTest() { // 회원 정보 보기 테스트
		MemberVO memberRead = memberService.memberRead("user");
		System.out.println(memberRead);
	}
	
	@Ignore
	@Test
	public void changePasswordTest() {
		String memberId = "user";
		String newPassword = "1111";
		String currentPassword = "1234";
		
		MemberVO vo = new MemberVO();
		vo.setMemberPwd(passwordEncoder.encode(currentPassword));
		
		Map<String, String> memberMap = new HashMap<>();
		memberMap.put("memberId", memberId);
		memberMap.put("newPassword", newPassword);
		memberMap.put("currentPassword", currentPassword);
		
		memberService.changePassword(memberMap);
		
	}
	
}
