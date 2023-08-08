package com.project.repository.member;

import org.apache.ibatis.annotations.Param;

import com.project.domain.member.MemberVO;

public interface MemberRepository {
	
	MemberVO memberRead(String memberId);
	
	void memberInsert(MemberVO vo);
	
	void memberUpdate(MemberVO vo);
	
	MemberVO selectById(String memberId);
	
	void changePassword(
			@Param("memberId") String memberId,
			@Param("memberPwd") String memberPwd);
	
	String selectByEmail(String email);
	
}
