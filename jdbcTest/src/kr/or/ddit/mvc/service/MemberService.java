package kr.or.ddit.mvc.service;
//asdqs
import java.util.List;

import kr.or.ddit.mvc.dao.MemberDao;
import kr.or.ddit.mvc.vo.MemberVO;

//dao에 있는 것을 가져온다. 각 메서드 마다 리턴값을 dao.안에 있는 메서들르 호출시킨다.
public class MemberService {
	private MemberDao dao; //DAO의 객체변수 선언
	
	
	// 생성자
	public MemberService() {
		dao = new MemberDao(); //DAO객체 생성
	}
	
	/**
	 * insert할 데이터가 저장된 MemberVO객체를 매개변수로 받아서 
	 * 해당 자료를 DB에 insert하는 메서드
	 * 
	 * @param memVo DB에 insert할 자료가 저장된 MemberVO객체
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 * 
	 */
	public int insertMember(MemberVO memVo) {
		return dao.insertMember(memVo);
	}
	
	/**
	 * 회원ID를 매개변수로 받아서 해당 회원 정보를 삭제하는 메서드
	 * @param memId 삭제할 회원ID
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int deleteMember(String memId) {
		
		return dao.deleteMember(memId);
	}
	
	/**
	 * 수정할 자료가 저장될 MemberVO객체를 매개변수로 받아서
	 * 해당 자료를 update하는 메서드
	 * @param memVO 수정할 자료가 저장된 MemberVO객체
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	
	public int updateMember(MemberVO memVO) {
		return dao.updateMember(memVO);
	}
	
	/**
	 * DB의 전체 회원 정보를 가져와서 List에 담아서 변환하는 메서드
	 * 
	 * @return MemberVO객체가 저장된 List객체
	 */
	public List<MemberVO> getAllMember(){
		return dao.getAllMember();
	}
	
	/**
	 * 회원ID를 매개변수로 받아서 해당 회원ID의 개수를 반환한느 메서드
	 * 
	 * @param memId 검색할 회원ID
	 * @return 검색된 회원ID의 갯수 
	 */
	public int getMemberCount(String memId) {
		return dao.getMemberCount(memId);
	}
}
