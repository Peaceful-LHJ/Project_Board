package com.project.repository.member;

import org.apache.ibatis.annotations.Param;

import com.project.domain.member.MemberVO;

public interface MemberRepository { // 회원 기능
	
	MemberVO memberRead(String memberId); // 회원 정보 조회
	
	void memberInsert(MemberVO memberVO); // 회원 가입
	
	void memberUpdate(MemberVO memberVO); // 회원 정보 수정
	
	void memberDelete(String memberId); // 회원 탈퇴
	
	MemberVO selectById(String memberId); // 회원 아이디로 정보 추출
	
	String selectByIdForName(String memberId); // 회원 아이디로 이름 추출
	
	void changePassword( // 비밀번호 변경
			@Param("memberId") String memberId,
			@Param("memberPwd") String memberPwd);
	
	String selectByEmail(String email); // 회원 이메일 선택
	
}