package controller;

import java.util.List;

import dao.BookDao;
import util.Command;
import util.ScanUtil;
import vo.BRegVo;
import vo.BookVo;

public class SysController {

	private BookDao bookService;
	private static SysController controller;

	public static SysController getInstance() {
		if (controller == null)
			controller = new SysController();
		return controller;
	}

	public Command sysAlList() {
	    bookService = new BookDao();
	    List<BookVo> bookAlList = bookService.getBookAlList();
	    System.out.println("=====================================================");
	    System.out.println("책 코드\t제목                               출판사");
	    System.out.println("=====================================================");
	    for (BookVo albook : bookAlList) {
	        System.out.printf("%-7s%-25s\t%-10s\n", albook.getBook_id(), albook.getBook_name(), albook.getBook_pub());
	    }
	    System.out.println("=============================================================");
	    System.out.println("1. 이전으로 돌아가기. 2. 메뉴화면으로 돌아가기.");

	    // 현재 사용자의 역할을 확인
	    BRegVo logRegVo = (BRegVo) MainController.RegMap.get("logReg");
	    if (logRegVo != null && "ADMIN".equalsIgnoreCase(logRegVo.getRole())) {
	        System.out.println("3. 관리자 메뉴화면으로 돌아가기");
	    }
	    System.out.println("=============================================================");

	    int input = ScanUtil.nextInt("입력 ☞☞ ");
	    switch (input) {
	        case 1:
	            return Command.BOOK_VIEW;
	        case 2:
	            return Command.REG_HOME;
	        case 3:
	            if (logRegVo != null && "ADMIN".equalsIgnoreCase(logRegVo.getRole())) {
	                return Command.OPMEM_MU;  // 관리자인 경우에만 3번 선택 가능
	            } else {
	                System.out.println("잘못된 입력입니다. 다시 시도해 주세요.");
	                return Command.ALL;
	            }
	        default:
	            System.out.println("잘못된 입력입니다. 다시 시도해 주세요.");
	            return Command.ALL;
	    }
	}


	public Command sysAList() {
		bookService = new BookDao();
		List<BookVo> abookList = bookService.getABookList();

		System.out.println("=====================================================");
		System.out.println("책 코드\t제목                               출판사");
		System.out.println("=====================================================");
		for (BookVo abook : abookList) {
			System.out.printf("%-7s%-25s\t%-10s\n", abook.getBook_id(), abook.getBook_name(), abook.getBook_pub());
		} // for 문
		System.out.println("=============================================================");
	    System.out.println("1. 이전으로 돌아가기. 2. 메뉴화면으로 돌아가기.");

	    // 현재 사용자의 역할을 확인
	    BRegVo logRegVo = (BRegVo) MainController.RegMap.get("logReg");
	    if (logRegVo != null && "ADMIN".equalsIgnoreCase(logRegVo.getRole())) {
	        System.out.println("3. 관리자 메뉴화면으로 돌아가기");
	    }
	    System.out.println("=============================================================");

	    int input = ScanUtil.nextInt("입력 ☞☞ ");
	    switch (input) {
	        case 1:
	            return Command.BOOK_VIEW;
	        case 2:
	            return Command.REG_HOME;
	        case 3:
	            if (logRegVo != null && "ADMIN".equalsIgnoreCase(logRegVo.getRole())) {
	                return Command.OPMEM_MU;  // 관리자인 경우에만 3번 선택 가능
	            } else {
	                System.out.println("잘못된 입력입니다. 다시 시도해 주세요.");
	                return Command.ADHD;
	            }
	        default:
	            System.out.println("잘못된 입력입니다. 다시 시도해 주세요.");
	            return Command.ADHD;
	    }

	} // 심리학 리스트

	public Command sysHList() {
		bookService = new BookDao();
		List<BookVo> hbookList = bookService.getHBookList();

		System.out.println("=====================================================");
		System.out.println("책 코드\t제목                               출판사");
		System.out.println("=====================================================");
		for (BookVo hbook : hbookList) {

			System.out.printf("%-7s%-25s\t%-10s\n", hbook.getBook_id(), hbook.getBook_name(), hbook.getBook_pub());
		} // for 문

		System.out.println("=============================================================");
	    System.out.println("1. 이전으로 돌아가기. 2. 메뉴화면으로 돌아가기.");

	    // 현재 사용자의 역할을 확인
	    BRegVo logRegVo = (BRegVo) MainController.RegMap.get("logReg");
	    if (logRegVo != null && "ADMIN".equalsIgnoreCase(logRegVo.getRole())) {
	        System.out.println("3. 관리자 메뉴화면으로 돌아가기");
	    }
	    System.out.println("=============================================================");

	    int input = ScanUtil.nextInt("입력 ☞☞ ");
	    switch (input) {
	        case 1:
	            return Command.BOOK_VIEW;
	        case 2:
	            return Command.REG_HOME;
	        case 3:
	            if (logRegVo != null && "ADMIN".equalsIgnoreCase(logRegVo.getRole())) {
	                return Command.OPMEM_MU;  // 관리자인 경우에만 3번 선택 가능
	            } else {
	                System.out.println("잘못된 입력입니다. 다시 시도해 주세요.");
	                return Command.HISTORY;
	            }
	        default:
	            System.out.println("잘못된 입력입니다. 다시 시도해 주세요.");
	            return Command.HISTORY;
	    }

	}// 역사 리스트

	public Command sysFList() {
		bookService = new BookDao();
		List<BookVo> fbookList = bookService.getFBookList();

		System.out.println("=====================================================");
		System.out.println("책 코드\t제목                               출판사");
		System.out.println("=====================================================");
		for (BookVo fbook : fbookList) {

			System.out.printf("%-7s%-25s\t%-10s\n", fbook.getBook_id(), fbook.getBook_name(), fbook.getBook_pub());
		} // for 문

		System.out.println("=============================================================");
	    System.out.println("1. 이전으로 돌아가기. 2. 메뉴화면으로 돌아가기.");

	    // 현재 사용자의 역할을 확인
	    BRegVo logRegVo = (BRegVo) MainController.RegMap.get("logReg");
	    if (logRegVo != null && "ADMIN".equalsIgnoreCase(logRegVo.getRole())) {
	        System.out.println("3. 관리자 메뉴화면으로 돌아가기");
	    }
	    System.out.println("=============================================================");

	    int input = ScanUtil.nextInt("입력 ☞☞ ");
	    switch (input) {
	        case 1:
	            return Command.BOOK_VIEW;
	        case 2:
	            return Command.REG_HOME;
	        case 3:
	            if (logRegVo != null && "ADMIN".equalsIgnoreCase(logRegVo.getRole())) {
	                return Command.OPMEM_MU;  // 관리자인 경우에만 3번 선택 가능
	            } else {
	                System.out.println("잘못된 입력입니다. 다시 시도해 주세요.");
	                return Command.FAIRY;
	            }
	        default:
	            System.out.println("잘못된 입력입니다. 다시 시도해 주세요.");
	            return Command.FAIRY;
	    }

	} // 동화 리스트

	public Command sysPList() {
		bookService = new BookDao();
		List<BookVo> pbookList = bookService.getPBookList();

		System.out.println("=====================================================");
		System.out.println("책 코드\t제목                               출판사");
		System.out.println("=====================================================");
		for (BookVo pbook : pbookList) {

			System.out.printf("%-7s%-25s\t%-10s\n", pbook.getBook_id(), pbook.getBook_name(), pbook.getBook_pub());
		} // for 문

		System.out.println("=============================================================");
	    System.out.println("1. 이전으로 돌아가기. 2. 메뉴화면으로 돌아가기.");

	    // 현재 사용자의 역할을 확인
	    BRegVo logRegVo = (BRegVo) MainController.RegMap.get("logReg");
	    if (logRegVo != null && "ADMIN".equalsIgnoreCase(logRegVo.getRole())) {
	        System.out.println("3. 관리자 메뉴화면으로 돌아가기");
	    }
	    System.out.println("=============================================================");

	    int input = ScanUtil.nextInt("입력 ☞☞ ");
	    switch (input) {
	        case 1:
	            return Command.BOOK_VIEW;
	        case 2:
	            return Command.REG_HOME;
	        case 3:
	            if (logRegVo != null && "ADMIN".equalsIgnoreCase(logRegVo.getRole())) {
	                return Command.OPMEM_MU;  // 관리자인 경우에만 3번 선택 가능
	            } else {
	                System.out.println("잘못된 입력입니다. 다시 시도해 주세요.");
	                return Command.POLI;
	            }
	        default:
	            System.out.println("잘못된 입력입니다. 다시 시도해 주세요.");
	            return Command.POLI;
	    }

	} // 정치 리스트

	public Command sysEList() {
		bookService = new BookDao();
		List<BookVo> ebookList = bookService.getEBookList();

		System.out.println("=====================================================");
		System.out.println("책 코드\t제목                               출판사");
		System.out.println("=====================================================");
		for (BookVo ebook : ebookList) {

			System.out.printf("%-7s%-25s\t%-10s\n", ebook.getBook_id(), ebook.getBook_name(), ebook.getBook_pub());
		} // for 문

		System.out.println("=============================================================");
	    System.out.println("1. 이전으로 돌아가기. 2. 메뉴화면으로 돌아가기.");

	    // 현재 사용자의 역할을 확인
	    BRegVo logRegVo = (BRegVo) MainController.RegMap.get("logReg");
	    if (logRegVo != null && "ADMIN".equalsIgnoreCase(logRegVo.getRole())) {
	        System.out.println("3. 관리자 메뉴화면으로 돌아가기");
	    }
	    System.out.println("=============================================================");

	    int input = ScanUtil.nextInt("입력 ☞☞ ");
	    switch (input) {
	        case 1:
	            return Command.BOOK_VIEW;
	        case 2:
	            return Command.REG_HOME;
	        case 3:
	            if (logRegVo != null && "ADMIN".equalsIgnoreCase(logRegVo.getRole())) {
	                return Command.OPMEM_MU;  // 관리자인 경우에만 3번 선택 가능
	            } else {
	                System.out.println("잘못된 입력입니다. 다시 시도해 주세요.");
	                return Command.ECO;
	            }
	        default:
	            System.out.println("잘못된 입력입니다. 다시 시도해 주세요.");
	            return Command.ECO;
	    }

	} // 경제 리스트

	public Command sysSList() {
		bookService = new BookDao();
		List<BookVo> sbookList = bookService.getSBookList();

		System.out.println("=====================================================");
		System.out.println("책 코드\t제목                               출판사");
		System.out.println("=====================================================");
		for (BookVo sbook : sbookList) {

			System.out.printf("%-7s%-25s\t%-10s\n", sbook.getBook_id(), sbook.getBook_name(), sbook.getBook_pub());
		} // for 문

		System.out.println("=============================================================");
	    System.out.println("1. 이전으로 돌아가기. 2. 메뉴화면으로 돌아가기.");

	    // 현재 사용자의 역할을 확인
	    BRegVo logRegVo = (BRegVo) MainController.RegMap.get("logReg");
	    if (logRegVo != null && "ADMIN".equalsIgnoreCase(logRegVo.getRole())) {
	        System.out.println("3. 관리자 메뉴화면으로 돌아가기");
	    }
	    System.out.println("=============================================================");

	    int input = ScanUtil.nextInt("입력 ☞☞ ");
	    switch (input) {
	        case 1:
	            return Command.BOOK_VIEW;
	        case 2:
	            return Command.REG_HOME;
	        case 3:
	            if (logRegVo != null && "ADMIN".equalsIgnoreCase(logRegVo.getRole())) {
	                return Command.OPMEM_MU;  // 관리자인 경우에만 3번 선택 가능
	            } else {
	                System.out.println("잘못된 입력입니다. 다시 시도해 주세요.");
	                return Command.SCIENCE;
	            }
	        default:
	            System.out.println("잘못된 입력입니다. 다시 시도해 주세요.");
	            return Command.SCIENCE;
	    }

	} // 과학 리스트

	public Command sysGList() {
		bookService = new BookDao();
		List<BookVo> gbookList = bookService.getGBookList();

		System.out.println("=====================================================");
		System.out.println("책 코드\t제목                               출판사");
		System.out.println("=====================================================");
		for (BookVo gbook : gbookList) {

			System.out.printf("%-7s%-25s\t%-10s\n", gbook.getBook_id(), gbook.getBook_name(), gbook.getBook_pub());
		} // for 문

		System.out.println("=============================================================");
	    System.out.println("1. 이전으로 돌아가기. 2. 메뉴화면으로 돌아가기.");

	    // 현재 사용자의 역할을 확인
	    BRegVo logRegVo = (BRegVo) MainController.RegMap.get("logReg");
	    if (logRegVo != null && "ADMIN".equalsIgnoreCase(logRegVo.getRole())) {
	        System.out.println("3. 관리자 메뉴화면으로 돌아가기");
	    }
	    System.out.println("=============================================================");

	    int input = ScanUtil.nextInt("입력 ☞☞ ");
	    switch (input) {
	        case 1:
	            return Command.BOOK_VIEW;
	        case 2:
	            return Command.REG_HOME;
	        case 3:
	            if (logRegVo != null && "ADMIN".equalsIgnoreCase(logRegVo.getRole())) {
	                return Command.OPMEM_MU;  // 관리자인 경우에만 3번 선택 가능
	            } else {
	                System.out.println("잘못된 입력입니다. 다시 시도해 주세요.");
	                return Command.GOJEON;
	            }
	        default:
	            System.out.println("잘못된 입력입니다. 다시 시도해 주세요.");
	            return Command.GOJEON;
	    }

	} // 고전 리스트

	public Command sysMList() {
		bookService = new BookDao();
		List<BookVo> mbookList = bookService.getMBookList();

		System.out.println("=====================================================");
		System.out.println("책 코드\t제목                               출판사");
		System.out.println("=====================================================");
		for (BookVo mbook : mbookList) {

			System.out.printf("%-7s%-25s\t%-10s\n", mbook.getBook_id(), mbook.getBook_name(), mbook.getBook_pub());
		} // for 문

		System.out.println("=============================================================");
	    System.out.println("1. 이전으로 돌아가기. 2. 메뉴화면으로 돌아가기.");

	    // 현재 사용자의 역할을 확인
	    BRegVo logRegVo = (BRegVo) MainController.RegMap.get("logReg");
	    if (logRegVo != null && "ADMIN".equalsIgnoreCase(logRegVo.getRole())) {
	        System.out.println("3. 관리자 메뉴화면으로 돌아가기");
	    }
	    System.out.println("=============================================================");

	    int input = ScanUtil.nextInt("입력 ☞☞ ");
	    switch (input) {
	        case 1:
	            return Command.BOOK_VIEW;
	        case 2:
	            return Command.REG_HOME;
	        case 3:
	            if (logRegVo != null && "ADMIN".equalsIgnoreCase(logRegVo.getRole())) {
	                return Command.OPMEM_MU;  // 관리자인 경우에만 3번 선택 가능
	            } else {
	                System.out.println("잘못된 입력입니다. 다시 시도해 주세요.");
	                return Command.MUSIC;
	            }
	        default:
	            System.out.println("잘못된 입력입니다. 다시 시도해 주세요.");
	            return Command.MUSIC;
	    }

	} // 음악 리스트

	public Command sysDList() {
		bookService = new BookDao();
		List<BookVo> dbookList = bookService.getDBookList();

		System.out.println("=====================================================");
		System.out.println("책 코드\t제목                               출판사");
		System.out.println("=====================================================");
		for (BookVo dbook : dbookList) {

			System.out.printf("%-7s%-25s\t%-10s\n", dbook.getBook_id(), dbook.getBook_name(), dbook.getBook_pub());
		} // for 문
		System.out.println("=============================================================");
	    System.out.println("1. 이전으로 돌아가기. 2. 메뉴화면으로 돌아가기.");

	    // 현재 사용자의 역할을 확인
	    BRegVo logRegVo = (BRegVo) MainController.RegMap.get("logReg");
	    if (logRegVo != null && "ADMIN".equalsIgnoreCase(logRegVo.getRole())) {
	        System.out.println("3. 관리자 메뉴화면으로 돌아가기");
	    }
	    System.out.println("=============================================================");

	    int input = ScanUtil.nextInt("입력 ☞☞ ");
	    switch (input) {
	        case 1:
	            return Command.BOOK_VIEW;
	        case 2:
	            return Command.REG_HOME;
	        case 3:
	            if (logRegVo != null && "ADMIN".equalsIgnoreCase(logRegVo.getRole())) {
	                return Command.OPMEM_MU;  // 관리자인 경우에만 3번 선택 가능
	            } else {
	                System.out.println("잘못된 입력입니다. 다시 시도해 주세요.");
	                return Command.DEVEL;
	            }
	        default:
	            System.out.println("잘못된 입력입니다. 다시 시도해 주세요.");
	            return Command.DEVEL;
	    }

	} // 자기개발 리스트

}
