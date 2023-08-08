package com.project.domain.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberAuthVO { // 회원 권한정보
	
	private String memberId;
	private String auth; // 회원 권한
	
}
