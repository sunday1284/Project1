package service;

import dao.BookDao;
import dao.MemberDao;
import dao.BRegDao;
import dao.RentalDao;
import vo.BookVo;
import vo.MemberVo;
import vo.BRegVo;

import java.util.List;

import dao.BReturnDao;

public class Service {
	private BookDao bookdao;
	private MemberDao memberdao;
	private BRegDao bregdao;
	private RentalDao rentaldao;
	private BReturnDao breturndao;

	// 생성자
	public Service() {
		// DAO객체 생성
		bookdao = new BookDao();
		memberdao = new MemberDao();
		bregdao = new BRegDao();
		rentaldao = new RentalDao();
		breturndao = new BReturnDao();
	}

	/**
	 * 
	 * @return bookList를 보여줌
	 */
	public List<BookVo> getSbookList() {
		return bookdao.getSBookList();
	}

	public List<BookVo> getFbookList() {
		return bookdao.getFBookList();
	}

	public List<BookVo> getAbookList() {
		return bookdao.getABookList();
	}

	public List<BookVo> getGbookList() {
		return bookdao.getGBookList();
	}

	public List<BookVo> getPbookList() {
		return bookdao.getPBookList();
	}

	public List<BookVo> getEbookList() {
		return bookdao.getEBookList();
	}

	public List<BookVo> getHbookList() {
		return bookdao.getHBookList();
	}

	public List<BookVo> getDbookList() {
		return bookdao.getDBookList();
	}

	public List<BookVo> getMbookList() {
		return bookdao.getMBookList();
	}

	/**
	 * 
	 * @return memberList를 보여줌
	 */
	public List<MemberVo> getMemberList() {
		return memberdao.getMemberList();
	}

	// 회원정보 등록을 위한 메서드
	public int insertRegDao(BRegVo bregVo) {
		return bregdao.insertBREG(bregVo);
	}

	public int insertRegDao2(MemberVo bregVo1) {
		return bregdao.insertBREG1(bregVo1);

	}

	
	

	// 도서 대여 메서드 호출
	public int rentBook(String memId, String bookId) {
		return rentaldao.rentBook(memId, bookId);
	}

	// 도서 반납 메서드 호출
	public int breturnBook(String memId, String bookId, String rentalId) {
		return breturndao.breturnBook(memId, bookId, rentalId);
	}

	public int delebreturnBook(String memId, String bookId) {
		return breturndao.delebreturnBook(memId, bookId);
	}

	
	public int insertBook(String bookId, String bookName, String bookPub, int bookStock) {
		return bookdao.insertBook(bookId, bookName, bookPub, bookStock);
	}
	//책 재고량 유무 확인
	public boolean checkBookExists(String bookId) {
		return bookdao.checkBookExists(bookId);
	}
	
	public int updateBookStock1(String bookId)  {
		return bookdao.updateBookStock1(bookId);
	}
	public int deleteBook(String bookId) {
		return bookdao.deleteBook(bookId);
	}
	public int updateBookStock2(String bookId)  {
		return bookdao.updateBookStock2(bookId);
	}
	
	 // MEMBER와 BREGISTER 테이블에서 회원 삭제
    public int deleteMemberAndBRegister(String memberId) {
        return bookdao.deleteMember(memberId)+bookdao.deleteBRegister(memberId);
    }
	
}
