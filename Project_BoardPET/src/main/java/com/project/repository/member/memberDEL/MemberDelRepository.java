package com.project.repository.member.memberDEL;

import com.project.domain.member.memberDEL.MemberDelVO;

public interface MemberDelRepository {
	
	void memberDelInsertById(String memberId); // 아이디로 회원 탈퇴 테이블로 이동
	void memberDelInsertByName(String memeberName); // 이름으로 회원 탈퇴 테이블로 이동
	
	MemberDelVO memberDelReadByName(String memberName); // 탈퇴한 회원 이름으로 조회
	
	MemberDelVO memberDelReadByNumber(Long DELmemberNum); // 탈퇴한 회원 번호로 조회
	
}
