package com.project.service.member;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.domain.member.MemberAuthVO;
import com.project.domain.member.MemberVO;
import com.project.exception.PasswordMisMatchException;
import com.project.repository.member.MemberAuthRepository;
import com.project.repository.member.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService { // 회원 서비스 구현체
	
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	MemberAuthRepository memberAuthRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Transactional
	@Override
	public void memberJoin(MemberVO vo) { // 회원가입
		vo.setMemberPwd(passwordEncoder.encode(vo.getMemberPwd()));
		MemberAuthVO memberAuthVO = new MemberAuthVO(vo.getMemberId(), "ROLE_MEMBER");
		memberRepository.memberInsert(vo);
		memberAuthRepository.authInsert(memberAuthVO);
	}

	@Override
	public void memberModify(MemberVO vo) { // 회원정보 수정
		memberRepository.memberUpdate(vo);
	}

	@Override
	public MemberVO memberRead(String memberId) { // 회원정보 보기
		return memberRepository.selectById(memberId);
	}
	
	@Transactional
	@Override
	public void changePassword(Map<String, String> memberMap) { // 비밀번호 변경
		String memberId = memberMap.get("memberId");
		String newPassword = memberMap.get("newPassword"); // 새 비밀번호
		String currentPassword = memberMap.get("currentPassword"); // 현제 비밀번호
		MemberVO vo = memberRepository.selectById(memberId);
		if(!passwordEncoder.matches(currentPassword, vo.getMemberPwd())) {
			throw new PasswordMisMatchException();
		}
		memberRepository.changePassword(memberId, passwordEncoder.encode(newPassword));
	}

}
