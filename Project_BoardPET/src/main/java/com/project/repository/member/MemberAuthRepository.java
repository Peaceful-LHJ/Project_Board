package com.project.repository.member;

import com.project.domain.member.MemberAuthVO;

public interface MemberAuthRepository {
	
	void authInsert(MemberAuthVO vo);
	
}
