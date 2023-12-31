package com.project.domain.member;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class MemberVO { // 회원정보
	
	private String memberId;
	private String memberPwd;
	private String memberName;
	private String email;
	private LocalDateTime regDate; // Register Date : 회원가입일
	private LocalDateTime updateDate; // 회원정보 수정일
	private boolean enabled; // 계정 활성화 상태(정지유무)
	
	private List<MemberAuthVO> authList; // 회원 권한 리스트
	
}
