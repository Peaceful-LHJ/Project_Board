package com.project.service.member;

import java.util.Map;

import com.project.domain.member.MemberVO;

public interface MemberService { // 회원 서비스 인터페이스
	
	void memberJoin(MemberVO vo); // 회원가입 서비스
	
	void memberModify(MemberVO vo); // 회원 정보 수정 서비스
	
	MemberVO memberRead(String memberId); // 회원 정보 보기 서비스
	
	void memberWithdraw(String memberId); // 회원 탈퇴 서비스
	
	void changePassword(Map<String, String> memberMap); // 비밀번호 변경 서비스
	
}
