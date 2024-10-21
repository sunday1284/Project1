package controller;

import java.util.List;

import dao.BReturnDao;
import dao.RentalDao;
import util.Command;
import util.ScanUtil;
import vo.BookVo;
import vo.RentalVo;
import vo.BRegVo;

public class DoubleRController {

	// 도서 대여
	private RentalDao rentalService;
	// 도서 반납
	private BReturnDao breturnService;

	private static DoubleRController controller;

	// ===========================================================================================================

	public static DoubleRController getInstance() {
		if (controller == null)
			controller = new DoubleRController();
		return controller;
	}

	// 도서 대여
	public Command rental() {
		rentalService = new RentalDao();
		BRegVo brvo = (BRegVo) MainController.RegMap.get("logReg"); // 로그인 정보를 가져옴
		String type = (String) MainController.RegMap.get("TYPE");
		System.out.println();
		System.out.println("=======대여하실 도서의 코드 네 자리를 입력해주세요.=======");
		int num = ScanUtil.nextInt("코드 입력 ☞☞");
		String code = type + String.format("%04d", num);

		List<BookVo> bookRentalList = rentalService.getBookRentalList(code);
		System.out.println("========================================================================");
		System.out.println(String.format("%-10s %-20s %-15s %-10s", "책 코드", "제목", "출판사", "재고량"));
		System.out.println("========================================================================");
		for (BookVo rentbook : bookRentalList) {
			System.out.println((String.format("%-10s %-20s %-15s %-10d", rentbook.getBook_id(), rentbook.getBook_name(),
					rentbook.getBook_pub(), rentbook.getBook_stock())));
			if (rentbook.getBook_stock() >= 2) {
				System.out.println("대여가 가능합니다. 대여하시겠습니까?");
				int input = ScanUtil.nextInt("1. 예   2. 아니오.");
				switch (input) {
				case 1:
					System.out.println("아이디를 입력해주세요.");
					String inputMemId = ScanUtil.nextLine("아이디 입력 ☞☞");

					if (inputMemId.equalsIgnoreCase(brvo.getBreg_id())) {
						System.out.println("비밀번호를 입력해주세요.");
						String inputPass = ScanUtil.nextLine("비밀번호 입력 ☞☞");

						if (inputPass.equalsIgnoreCase(brvo.getBreg_pass())) {
							for (int r = 1; r >= 1; r--) {
								System.out.println("인증 되었습니다.");
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}

							// 사용자가 인증되었으면 대여 작업 수행
							int rentResult = rentalService.rentBook(inputMemId, code);
							int stockResult = rentalService.getRentalStock(code);
							if (rentResult > 0) {
								System.out.println("대여가 완료되었습니다.");
								if (stockResult > 0) {

								} else {

								}

							} else {
								System.out.println("대여에 실패했습니다.");
							}
							return Command.REG_HOME;
						} else {
							System.out.println("비밀번호가 올바르지 않습니다. 다시 대여창으로 돌아갑니다.");
							return Command.BOOK_LIST;
						}
					} else {
						System.out.println("입력하신 정보가 올바르지 않습니다. 다시 대여창으로 돌아갑니다.");
						return Command.BOOK_LIST;
					}
				case 2:
					System.out.println("대여 시스템을 종료합니다. 5초 후 메인화면으로 돌아갑니다.");
					for (int i = 5; i >= 1; i--) {
						System.out.println("대여 시스템이 " + i + " 초 후에 종료됩니다.");
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println("대여 시스템이 종료되었습니다. 감사합니다.");
					return Command.REG_HOME;
				}
			} else {
				System.out.println("재고가 부족하여 대여할 수 없습니다.");
				for (int r = 1; r >= 1; r--) {
					System.out.println("도서 대여창으로 이동 중입니다. 잠시만 기다려주세요.");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return Command.BOOK_LIST;
	}

//========================================================================      
	// 도서 반납
	public Command breturn() {
		rentalService = new RentalDao();
		breturnService = new BReturnDao();
		BRegVo brvo = (BRegVo) MainController.RegMap.get("logReg"); // 로그인 정보를 가져옴
		String type = (String) MainController.RegMap.get("TYPE");

		System.out.println();
		System.out.println("=======반납하실 도서의 코드 네 자리를 입력해주세요.=======");
		int num = ScanUtil.nextInt("코드 입력 ☞☞");
		String code = type + String.format("%04d", num);

		List<RentalVo> bookRentalList = breturnService.getBookBreturnList(code);
		System.out.println("==================================================================");
		System.out.println(String.format("%-10s %-10s %-15s %-10s", "책 코드", "대여 코드", "대여 날짜","회원 ID"));
		System.out.println("==================================================================");

		for (RentalVo breturnbook : bookRentalList) {
			System.out.println(String.format("%-10s %-10s %-15s %-10s", breturnbook.getBook_id(),
					breturnbook.getRental_id(), breturnbook.getRental_date().toString(), breturnbook.getMem_id()));
			System.out.println("반납이 가능합니다. 반납하시겠습니까?");
			int input = ScanUtil.nextInt("1. 예   2. 아니오.");
			switch (input) {
			case 1:
				System.out.println("아이디를 입력해주세요.");
				String inputMemId = ScanUtil.nextLine("아이디 입력 ☞☞");
				if (inputMemId.equalsIgnoreCase(brvo.getBreg_id())) {
					System.out.println("비밀번호를 입력해주세요.");
					String inputPass = ScanUtil.nextLine("비밀번호 입력 ☞☞");
					if (inputPass.equalsIgnoreCase(brvo.getBreg_pass())) {
						for (int r = 1; r >= 1; r--) {
							System.out.println("인증 되었습니다.");
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						// 사용자가 인증되었으면 반납 작업 수행
						int returnResult = breturnService.delebreturnBook(inputMemId, code);
						int stockResult = breturnService.bReturnbookStock(code);
						if (returnResult > 0) {
							System.out.println("반납이 완료되었습니다.");
							if (stockResult > 0) {

							} else {

							}
						} else {
							System.out.println("반납에 실패했습니다.");
						}
						return Command.REG_HOME;
					} else {
						System.out.println("비밀번호가 올바르지 않습니다. 다시 반납창으로 돌아갑니다.");
						return Command.BOOK_LIST;
					}
				} else {
					System.out.println("입력하신 정보가 올바르지 않습니다. 다시 반납창으로 돌아갑니다.");
					return Command.BOOK_LIST;
				}
			case 2:
				System.out.println("반납 시스템을 종료합니다. 5초 후 메인화면으로 돌아갑니다.");
				for (int i = 5; i >= 1; i--) {
					System.out.println("반납 시스템이 " + i + " 초 후에 종료됩니다.");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("반납 시스템이 종료되었습니다. 감사합니다.");
				return Command.REG_HOME;
			}
		}

		return Command.REG_HOME;
	}

}
