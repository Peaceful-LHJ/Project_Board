package com.project.controller.board;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.domain.attach.BoardAttachVO;
import com.project.domain.board.BoardLikeDTO;
import com.project.domain.board.BoardVO;
import com.project.domain.common.Criteria;
import com.project.domain.common.Pagination;
import com.project.service.board.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	// 게시물 목록창
	@GetMapping("/board/list")
	public void list(Model model, Criteria criteria) {
		model.addAttribute("list", boardService.getList(criteria));
		model.addAttribute("p", new Pagination(criteria, boardService.totalCount(criteria)));
	}
	
	// 게시물 첨부파일 리스트
	@GetMapping("/board/getBoardAttachList")
	@ResponseBody
	public ResponseEntity<List<BoardAttachVO>> getBoardAttachList(Long bno) {
		return new ResponseEntity<List<BoardAttachVO>>(boardService.getBoardAttachList(bno), HttpStatus.OK);
	}
	
	// 게시물 첨부파일 정보 리스트
	@GetMapping("/board/getBoardAttachFileInfo")
	@ResponseBody
	public ResponseEntity<BoardAttachVO> getBoardAttachFileInfo(String uuid) {
		return new ResponseEntity<>(boardService.getBoardAttach(uuid), HttpStatus.OK);
	}
	
	// 게시물 조회
	@GetMapping("/board/get")
	public void boardRead(Long bno, Model model, Criteria criteria) {
		model.addAttribute("board", boardService.boardRead(bno));
	}
	
	// 게시물 수정창
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/board/modify")
	public void boardModify(Long bno, Model model, Criteria criteria, Authentication authentication) {
		BoardVO boardVO = boardService.boardRead(bno);
		String username = authentication.getName(); // 인증된 사용자의 계정
		String writer = boardVO.getWriter();
		
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities(); // 인증된 사용자의 권한목록
		boolean isAdmin = authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN")); // 등급을 검사할때 new SimpleGrantedAuthority로 type을 변환해야한다.
		
		if(!writer.equals(username) && !isAdmin) { // 인증된 사용자의 계정과 글쓴이가 다르고 관리자가 아닌경우
			// AccessDenied 예외발생
			throw new AccessDeniedException("작성자와 현재 사용자와 계정이 일치하지 않습니다");
		}
		model.addAttribute("board", boardVO);
	}
	
	// 게시물 등록창
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/board/register")
	public void register() {}
	
	// 게시물 등록 실행
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/board/register")
	public String boardRegister(BoardVO boardVO, RedirectAttributes rttr) {
		boardService.boardRegister(boardVO);
		rttr.addFlashAttribute("result", boardVO.getBno()); // ${result}
		rttr.addFlashAttribute("operation", "register");
		return "redirect:/board/list";
	}
	
	// 게시물 수정
	@PreAuthorize("isAuthenticated() and principal.username == #boardVO.writer or hasRole('ROLE_ADMIN')")
	@PostMapping("/board/modify")
	public String boardModify(BoardVO boardVO, RedirectAttributes rttr, Criteria criteria) {
		if(boardService.boardModify(boardVO)) {
			rttr.addFlashAttribute("result", boardVO.getBno());
			rttr.addFlashAttribute("operation", "modify");
		}
		return "redirect:/board/list"+criteria.getListLink();
	}
	
	// 게시물 삭제
	@PreAuthorize("isAuthenticated() and principal.username == #boardVO.writer or hasRole('ROLE_ADMIN')")
	@PostMapping("/board/remove")
	public String boardRemove(Long bno, RedirectAttributes rttr, Criteria criteria, String writer) {
		if(boardService.boardRemove(bno)) {
			rttr.addFlashAttribute("result", bno);
			rttr.addFlashAttribute("operation", "remove");
		}
		return "redirect:/board/list"+criteria.getListLink();
	}
	
	// 게시물 추천 
	@PreAuthorize("isAuthenticated()")
	@PostMapping(value = "/board/like", produces = "plain/text; charset=utf-8")
	public ResponseEntity<String> hitLike(BoardLikeDTO boardLikeDTO) {
		String message = boardLikeDTO.getBno() +"번 ";
		if(boardService.hitLike(boardLikeDTO)) {
			message += "게시글 추천을 하였습니다."; 
		} else {
			message += "게시글 추천을 취소하였습니다.";
		}
		return new ResponseEntity<String>(message ,HttpStatus.OK);
	}
	
	@PostMapping(value = "/board/islike")
	@ResponseBody
	public ResponseEntity<Boolean> isLike(BoardLikeDTO boardLikeDTO){
		return new ResponseEntity<Boolean>(boardService.isLike(boardLikeDTO), HttpStatus.OK);
	}
	
}
