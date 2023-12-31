package com.project.service.board;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.domain.attach.BoardAttachVO;
import com.project.domain.board.BoardLikeDTO;
import com.project.domain.board.BoardVO;
import com.project.domain.comment.CommentVO;
import com.project.domain.common.Criteria;
import com.project.repository.attach.BoardAttachRepository;
import com.project.repository.board.BoardLikeRepository;
import com.project.repository.board.BoardRepository;
import com.project.repository.board.boardDEL.BoardDelRepository;
import com.project.repository.comment.CommentRepository;
import com.project.repository.comment.commentDEL.CommentDelRepository;

@Service
public class BoardServiceImpl implements BoardService { // 자유게시글 서비스 구현체
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private BoardDelRepository boardDelRepository;
	
	@Autowired
	private BoardLikeRepository boardLikeRepository;
	
	@Autowired
	private BoardAttachRepository boardAttachRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private CommentDelRepository commentDelRepository;
	
	
	@Override
	public List<BoardVO> getList(Criteria criteria) { // 게시물 목록
		return boardRepository.getList(criteria);
	}

	@Override
	public int totalCount(Criteria criteria) { // 게시물 수
		return boardRepository.getTotalCount(criteria);
	}
	
	@Transactional
	@Override
	public void boardRegister(BoardVO boardVO) { // 자유게시글 작성
		boardRepository.boardInsert(boardVO);
		
		// 첨부파일이 있을때
		if(boardVO.getBoardAttachList() != null) {
			boardVO.getBoardAttachList().forEach(attachFile -> {
				attachFile.setBno(boardVO.getBno());
				boardAttachRepository.boardAttachInsert(attachFile);
			});
		}
	}
	
	@Override
	public BoardVO boardRead(Long bno) { // 자유게시글 조회
		return boardRepository.boardRead(bno);
	}

	@Override
	public boolean boardModify(BoardVO boardVO) { // 자유게시물 수정
		List<BoardAttachVO> boardAttachList = boardVO.getBoardAttachList();
		
		if(boardAttachList != null) { // 첨부파일 삭제
			List<BoardAttachVO> delBoardAttachList = boardAttachList.stream()
					.filter(attach -> attach.getBno() != null).collect(Collectors.toList());
			deleteFiles(delBoardAttachList);
			delBoardAttachList.forEach(boardAttachListDelete -> {
				boardAttachRepository.boardAttachDelete(boardAttachListDelete.getUuid());
			});
			
			// 첨부파일 추가
			boardAttachList.stream()
			.filter(boardAttachListAdd -> boardAttachListAdd.getBno() == null).forEach(boardAttachListAdd -> {
				boardAttachListAdd.setBno(boardVO.getBno());
				boardAttachRepository.boardAttachInsert(boardAttachListAdd);
			});
		}
		return boardRepository.boardUpdate(boardVO) == 1;
	}
	
	private void deleteFiles(List<BoardAttachVO> delBoardAttachList) { // 자유게시물 첨부파일 삭제 메소드
		delBoardAttachList.forEach(boardVO -> {
			File file = new File("C:/project/storage/" + boardVO.getUploadPath(), boardVO.getUuid() + "_" + boardVO.getFileName());
			file.delete();
			if(boardVO.isFileType()) {
				file = new File("C:/project/storage" + boardVO.getUploadPath(), "s_" + boardVO.getUuid() + "_" + boardVO.getFileName());
			}
		});
	}

	@Override
	public boolean boardRemove(Long bno) { // 자유게시글 삭제테이블 이동 및 관련 데이터 처리 후 영구삭제
		List<CommentVO> boardCommentRead = commentRepository.boardCommentRead(bno); // 게시물의 댓글유무 조회
		
		if(boardCommentRead.isEmpty()) { // 댓글이 없는 경우
			boardDelRepository.boardDelInsert(bno); // 게시물 삭제테이블 이동
			boardRepository.boardDelete(bno); // 해당 게시글 영구삭제
		}
		if(boardCommentRead != null) { // 댓글이 있는 경우
			commentDelRepository.NonBoardCommentDelInsert(bno); // 해당 게시글의 댓글 가삭제 테이블 이동
			commentRepository.commentListFromBoardDelete(bno); // 해당 게시글의 댓글 영구삭제 실시
			boardDelRepository.boardDelInsert(bno); // 게시글 삭제테이블 이동
			boardRepository.boardDelete(bno); // 해당 게시글 영구삭제
		}
		return boardRepository.boardDelete(bno) == 1;
	}

	@Override
	public List<BoardAttachVO> getBoardAttachList(Long bno) { // 해당 자유게시물의 첨부파일 모두 불러오기
		return boardAttachRepository.selectByBno(bno);
	}

	@Override
	public BoardAttachVO getBoardAttach(String uuid) { // 해당 자유게시물의 첨부파일 단독으로 불러오기
		return boardAttachRepository.selectByUuid(uuid);
	}
	
	@Transactional
	@Override
	public boolean hitLike(BoardLikeDTO boardLikeDTO) {// 게시물 추천 기능
		BoardLikeDTO result = boardLikeRepository.getBoardLike(boardLikeDTO);
		if(result == null) { // 추천 실행
			boardLikeRepository.boardLikeInsert(boardLikeDTO);
			boardRepository.boardUpdateLikeCnt(boardLikeDTO.getBno(), 1);
			return true;
		} else { // 추천 취소
			boardLikeRepository.boardLikeDelete(boardLikeDTO);
			boardRepository.boardUpdateLikeCnt(boardLikeDTO.getBno(), -1);
			return false;
		}
	}

	@Override
	public Boolean isLike(BoardLikeDTO boardLikeDTO) { // 추천여부 확인
		return boardLikeRepository.getBoardLike(boardLikeDTO) != null;
	}

}
