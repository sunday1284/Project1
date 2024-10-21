package controller;

import dao.BookDao;
import util.Command;
import util.ScanUtil;
import vo.BookVo;

public class AdBookController {
	private BookDao bookservice;
	// 생성자 생성
	BookVo bookvo = new BookVo();
	private static AdBookController controller;

	private AdBookController() {
		bookservice = new BookDao();
	}

	public static AdBookController getInstance() {
		if (controller == null)
			controller = new AdBookController();
		return controller;
	}

	public Command Adinsert() {
		System.out.println("=====도서 추가=========");
		System.out.print("책 코드를 입력하세요:");
		String bookId = ScanUtil.nextLine();
		System.out.print("책 이름을 입력하세요: ");
		String bookName = ScanUtil.nextLine();
		System.out.print("책 출판사를 입력하세요: ");
		String bookPub = ScanUtil.nextLine();
		System.out.print("책 재고를 입력하세요: ");
		int bookStock = ScanUtil.nextInt();
		// 책이 이미 존재하는지 확인
		boolean bookExists = bookservice.checkBookExists(bookId);

		// 책의 존재여부
		if (bookExists) {
			// 기존 책의 재고를 증가시키는 시도
			bookservice.updateBookStock1(bookId);
			System.out.println("기존 책의 재고가 증가되었습니다.");
		} else {
			// 새로운 책 추가
			int insert = bookservice.insertBook(bookId, bookName, bookPub, bookStock);
			if (insert > 0) {
			} else {
			}
		}

		return Command.OPMEM_MU;

	}

	// 관리자가 삭제
	public Command AdDeUpdate() {
		System.out.println("=====도서 삭제=========");
		System.out.print("책 코드를 입력하세요:");
		String bookId = ScanUtil.nextLine();

		// 책의 재고를 1 감소시킴
		bookservice.updateBookStock2(bookId);

		// 재고량이 1이면 책을 삭제
		bookservice.deleteBook(bookId);

		return Command.OPMEM_MU;

	}

	// MEMBER와 BREGISTER 테이블에서 회원 삭제 메서드 호출
	public Command MemBResDelete() {
		System.out.println("=====회원 강제퇴실=========");
		System.out.print("회원 ID를 입력하세요:");
		String memberId = ScanUtil.nextLine();

		// MEMBER와 BREGISTER 테이블에서 회원 삭제
		int result = bookservice.deleteMember(memberId) + bookservice.deleteBRegister(memberId);

		if (result > 0) {
			System.out.println("회원이 강제 퇴실되었습니다."); 
		} else {
			System.out.println("회원 퇴실에 실패했습니다.");
		}

		return Command.OPMEM_MU;
	}

}
