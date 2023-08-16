package com.project.service.member;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.domain.member.MemberAuthVO;
import com.project.domain.member.MemberVO;
import com.project.exception.PasswordMisMatchException;
import com.project.repository.board.AnswerRepository;
import com.project.repository.board.BoardRepository;
import com.project.repository.board.QuestionBoardRepository;
import com.project.repository.board.boardDEL.AnswerDelRepository;
import com.project.repository.board.boardDEL.BoardDelRepository;
import com.project.repository.board.boardDEL.QuestionBoardDelRepository;
import com.project.repository.comment.CommentDelRepository;
import com.project.repository.comment.CommentRepository;
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
	
	@Autowired
	BoardRepository boardRepository;
	
	@Autowired
	BoardDelRepository boardDelRepository;
	
	@Autowired
	QuestionBoardRepository questionBoardRepository;
	
	@Autowired
	QuestionBoardDelRepository questionBoardDelRepository;
	
	@Autowired
	AnswerRepository answerRepository;
	
	@Autowired
	AnswerDelRepository answerDelRepository;
	
	@Autowired
	CommentRepository commentRepository;
	
	@Autowired
	CommentDelRepository commentDelRepository;
	
	
	
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

	@Override
	public void memberWithdraw(String memberId) { // 회원 탈퇴 서비스
		String userName = memberRepository.selectByIdForName(memberId); // 해당 아이디의 회원 이름 추출
		
		// 회원 삭제전 무결성 검사 (작성한 자유게시글, 질문글, 답글, 댓글 유무 조회 -> 모두 작성되지 않은 경우)
		if(boardRepository.boardReadByName(userName).isEmpty()
				&& questionBoardRepository.questionBoardReadByName(userName).isEmpty()
				&& answerRepository.answerReadByName(userName).isEmpty()
				&& commentRepository.commentReadByName(userName).isEmpty()) {
			
			memberRepository.memberDelete(memberId); // 회원 탈퇴 처리
			
		} else {
			boardDelRepository.boardDelInsertListByName(userName);
			
		}
	}

}
