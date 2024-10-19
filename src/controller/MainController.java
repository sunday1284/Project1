package controller;

import java.util.HashMap;
import java.util.Map;

import util.ScanUtil;
import vo.BRegVo;
import util.Command;

public class MainController {
	public static Map<String, Object> RegMap = new HashMap<>();
	private BRegController BregController;
	private SysController sysController;
	private DoubleRController doubleRController;
	private AdBookController adbookController;
//===========================================================================================================
//색상
	public static final String black    = "\u001B[30m" ;
    public static final String red      = "\u001B[31m" ;
    public static final String green    = "\u001B[32m" ;
    public static final String yellow   = "\u001B[33m" ;
    public static final String blue     = "\u001B[34m" ;
    public static final String purple   = "\u001B[35m" ;
    public static final String cyan     = "\u001B[36m" ;
    public static final String white     = "\u001B[37m" ;

    public static final String exit     = "\u001B[0m" ;
	
//===========================================================================================================

	public MainController() {
		BregController = BRegController.getInstance();
		sysController = SysController.getInstance();
		doubleRController = DoubleRController.getInstance();
		adbookController = AdBookController.getInstance();
	}
//===========================================================================================================
	public static void main(String[] args) {
		new MainController().start();
	}// 메인 메서드
	
//===========================================================================================================
	private void start() {
		Command cmd = Command.HOME;
		while (true) {
			switch (cmd) {
			case HOME:
				cmd = home();
				break; // 첫화면
			case REG_HOME:
				cmd = regHome();
				break; // 로그인 성공 후 화면
			case LOGIN:
				cmd = BregController.login();
				break; // 로그인 화면
			case REGISTER:
				cmd = BregController.register();
				break; // 회원가입 화면
			case BOOK_VIEW:
				cmd = BSysList();
				break;
			case ALL:
				cmd = sysController.sysAlList();
				break;
			case DEVEL:
				cmd = sysController.sysDList();
				break;
			case ADHD:
				cmd = sysController.sysAList();
				break;
			case GOJEON:
				cmd = sysController.sysGList();
				break;
			case FAIRY:
				cmd = sysController.sysFList();
				break;
			case HISTORY:
				cmd = sysController.sysHList();
				break;
			case ECO:
				cmd = sysController.sysEList();
				break;
			case MUSIC:
				cmd = sysController.sysMList();
				break;
			case POLI:
				cmd = sysController.sysPList();
				break;
			case SCIENCE:
				cmd = sysController.sysSList();
				break;
			case BOOK_LIST:
				cmd = CodeOfBookRental();
				break;
			case BOOK_RENTAL:
				cmd = doubleRController.rental();
				break;
			case BOOK_BRETURN:
				cmd = CodeOfBookBreturn();
				break;
			case BOOK_BRECODE:
				cmd = doubleRController.breturn();
				break;
			case OPMEM_MU:
				cmd = OpregHome();
				break;
			case BOOK_ADD:
				cmd = adbookController.Adinsert();
				break;
			case BOOK_DEL:
				cmd = adbookController.AdDeUpdate();
				break;
			case END:
				for (int r = 1; r >= 1; r--) {
					System.out.println("프로그램 종료 중... 소요시간 5초");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
//===================================================================================================================            
				for (int i = 5; i >= 1; i--) {
					System.out.println("프로그램이 " + i + " 초 후에 종료됩니다.");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} // catch
				} // for문
				System.out.println("프로그램이 종료되었습니다. 감사합니다.");
				return;
			default:
				cmd = Command.HOME;
			} // switch
		} // while

	}// start 메서드
	
	//===========================================================================================================
	private Command home() {

		System.out.println("\r\n"+cyan
				+ "          _____                  _______                  _____                    _____                  _______                  _____                   _____                    _____                    _____          \r\n"
				+ "         /\\    \\                /::\\    \\                /\\    \\                  /\\    \\                /::\\    \\                /\\    \\                 /\\    \\                  /\\    \\                  /\\    \\         \r\n"
				+ "        /::\\    \\              /::::\\    \\              /::\\    \\                /::\\    \\              /::::\\    \\              /::\\    \\               /::\\____\\                /::\\    \\                /::\\____\\        \r\n"
				+ "       /::::\\    \\            /::::::\\    \\            /::::\\    \\              /::::\\    \\            /::::::\\    \\            /::::\\    \\             /:::/    /               /::::\\    \\              /::::|   |        \r\n"
				+ "      /::::::\\    \\          /::::::::\\    \\          /::::::\\    \\            /::::::\\    \\          /::::::::\\    \\          /::::::\\    \\           /:::/   _/___            /::::::\\    \\            /:::::|   |        \r\n"
				+ "     /:::/\\:::\\    \\        /:::/~~\\:::\\    \\        /:::/\\:::\\    \\          /:::/\\:::\\    \\        /:::/~~\\:::\\    \\        /:::/\\:::\\    \\         /:::/   /\\    \\          /:::/\\:::\\    \\          /::::::|   |        \r\n"
				+ "    /:::/  \\:::\\    \\      /:::/    \\:::\\    \\      /:::/__\\:::\\    \\        /:::/__\\:::\\    \\      /:::/    \\:::\\    \\      /:::/  \\:::\\    \\       /:::/   /::\\____\\        /:::/__\\:::\\    \\        /:::/|::|   |        \r\n"
				+ "   /:::/    \\:::\\    \\    /:::/    / \\:::\\    \\     \\:::\\   \\:::\\    \\      /::::\\   \\:::\\    \\    /:::/    / \\:::\\    \\    /:::/    \\:::\\    \\     /:::/   /:::/    /       /::::\\   \\:::\\    \\      /:::/ |::|   |        \r\n"
				+ "  /:::/    / \\:::\\    \\  /:::/____/   \\:::\\____\\  ___\\:::\\   \\:::\\    \\    /::::::\\   \\:::\\    \\  /:::/____/   \\:::\\____\\  /:::/    / \\:::\\    \\   /:::/   /:::/   _/___    /::::::\\   \\:::\\    \\    /:::/  |::|   | _____  \r\n"
				+ " /:::/    /   \\:::\\ ___\\|:::|    |     |:::|    |/\\   \\:::\\   \\:::\\    \\  /:::/\\:::\\   \\:::\\    \\|:::|    |     |:::|    |/:::/    /   \\:::\\ ___\\ /:::/___/:::/   /\\    \\  /:::/\\:::\\   \\:::\\    \\  /:::/   |::|   |/\\    \\ \r\n"
				+ "/:::/____/     \\:::|    |:::|____|     |:::|    /::\\   \\:::\\   \\:::\\____\\/:::/__\\:::\\   \\:::\\____\\:::|____|     |:::|    /:::/____/  ___\\:::|    |:::|   /:::/   /::\\____\\/:::/  \\:::\\   \\:::\\____\\/:: /    |::|   /::\\____\\\r\n"
				+ "\\:::\\    \\     /:::|____|\\:::\\    \\   /:::/    /\\:::\\   \\:::\\   \\::/    /\\:::\\   \\:::\\   \\::/    /\\:::\\    \\   /:::/    /\\:::\\    \\ /\\  /:::|____|:::|__/:::/   /:::/    /\\::/    \\:::\\  /:::/    /\\::/    /|::|  /:::/    /\r\n"
				+ " \\:::\\    \\   /:::/    /  \\:::\\    \\ /:::/    /  \\:::\\   \\:::\\   \\/____/  \\:::\\   \\:::\\   \\/____/  \\:::\\    \\ /:::/    /  \\:::\\    /::\\ \\::/    / \\:::\\/:::/   /:::/    /  \\/____/ \\:::\\/:::/    /  \\/____/ |::| /:::/    / \r\n"
				+ "  \\:::\\    \\ /:::/    /    \\:::\\    /:::/    /    \\:::\\   \\:::\\    \\       \\:::\\   \\:::\\    \\       \\:::\\    /:::/    /    \\:::\\   \\:::\\ \\/____/   \\::::::/   /:::/    /            \\::::::/    /           |::|/:::/    /  \r\n"
				+ "   \\:::\\    /:::/    /      \\:::\\__/:::/    /      \\:::\\   \\:::\\____\\       \\:::\\   \\:::\\____\\       \\:::\\__/:::/    /      \\:::\\   \\:::\\____\\      \\::::/___/:::/    /              \\::::/    /            |::::::/    /   \r\n"
				+ "    \\:::\\  /:::/    /        \\::::::::/    /        \\:::\\  /:::/    /        \\:::\\   \\::/    /        \\::::::::/    /        \\:::\\  /:::/    /       \\:::\\__/:::/    /               /:::/    /             |:::::/    /    \r\n"
				+ "     \\:::\\/:::/    /          \\::::::/    /          \\:::\\/:::/    /          \\:::\\   \\/____/          \\::::::/    /          \\:::\\/:::/    /         \\::::::::/    /               /:::/    /              |::::/    /     \r\n"
				+ "      \\::::::/    /            \\::::/    /            \\::::::/    /            \\:::\\    \\               \\::::/    /            \\::::::/    /           \\::::::/    /               /:::/    /               /:::/    /      \r\n"
				+ "       \\::::/    /              \\::/____/              \\::::/    /              \\:::\\____\\               \\::/____/              \\::::/    /             \\::::/    /               /:::/    /               /:::/    /       \r\n"
				+ "        \\::/____/                ~~                     \\::/    /                \\::/    /                ~~                     \\::/____/               \\::/____/                \\::/    /                \\::/    /        \r\n"
				+ "         ~~                                              \\/____/                  \\/____/                                                                 ~~                       \\/____/                  \\/____/         \r\n"
				+ "                                                                                                                                                                                                                            \r\n"
				+exit+"");
		System.out.println("\t1. 로그인 \t2. 회원가입 \t0. 프로그램 종료");
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.print("번호 입력 ☞☞ ");

		int input = ScanUtil.nextInt();

		switch (input) {
		case 1:
			return Command.LOGIN;
		case 2:
			return Command.REGISTER;
		case 0:
			return Command.END;
		}

		return Command.HOME;
	} // home 메서드
	
//===========================================================================================================
	private Command regHome() {
		BRegVo logRegVo = (BRegVo) MainController.RegMap.get("logReg");
		if (logRegVo == null) {
			return Command.HOME;
		}
		System.out.println();
		System.out.println(logRegVo.getBreg_name() + "님 반갑습니다.");
		System.out.println("아래 메뉴에서 작업할 번호를 선택하세요.");
		System.out.println();
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("\t1. 도서 리스트 \t2. 도서 대여 \t3. 도서 반납 \t0. 로그아웃");
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------");
		int input = ScanUtil.nextInt("번호 선택 ☞☞ ");

		switch (input) {
		case 1:
			return Command.BOOK_VIEW;
		case 2:
			return Command.BOOK_LIST;
		case 3:
			return Command.BOOK_BRETURN;
		case 0:
			MainController.RegMap.clear();
			System.out.println("로그아웃 되었습니다. 이용해주셔서 감사합니다.");
			return Command.HOME;
		}
		return Command.REG_HOME;

	}
	private Command OpregHome() {
		BRegVo logRegVo = (BRegVo) MainController.RegMap.get("logReg");
		
		if (logRegVo == null) {
			return Command.HOME;
		}
		System.out.println();
		System.out.println(logRegVo.getBreg_name() + "관리자님 반갑습니다.");
		System.out.println("아래 메뉴에서 작업할 번호를 선택하세요.");
		System.out.println();
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("\t1. 도서 리스트 \t2. 도서 추가 \t3. 도서 삭제 \t0. 로그아웃");
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------");
		int input = ScanUtil.nextInt("번호 선택 ☞☞ ");

		switch (input) {
		case 1:
			return Command.BOOK_VIEW;
		case 2:
			return Command.BOOK_ADD;
		case 3:
			return Command.BOOK_DEL;
		case 0:
			MainController.RegMap.clear();
			System.out.println("로그아웃 되었습니다. 이용해주셔서 감사합니다.");
			return Command.HOME;
		}
		return Command.OPMEM_MU;

	}
	private Command BSysList() { // BOOK_VIEW

		System.out.println();
		System.out.println("원하시는 도서의 구분을 선택해주세요.");
		System.out.println();
		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(" 1. 고전 문학 2. 과학  3. 심리학  4. 동화  5. 정치  6. 경제  7. 자기개발  8. 역사 9. 음악  10. 전체  0. 로그아웃");
		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------------------");
		int input = ScanUtil.nextInt("번호 선택 ☞☞ ");

		switch (input) {
		case 1:
			return Command.GOJEON;
		case 2:
			return Command.SCIENCE;
		case 3:
			return Command.ADHD;
		case 4:
			return Command.FAIRY;
		case 5:
			return Command.POLI;
		case 6:
			return Command.ECO;
		case 7:
			return Command.DEVEL;
		case 8:
			return Command.HISTORY;
		case 9:
			return Command.MUSIC;
		case 10: 
			return Command.ALL;
		case 0:
			MainController.RegMap.clear();
			System.out.println("로그아웃 되었습니다. 이용해주셔서 감사합니다.");
			return Command.HOME;
		}

		return Command.BOOK_VIEW;
	}
	// ===========================================================================================================

	private Command CodeOfBookRental() {
		System.out.println();
		System.out.println("================대여하실 도서의 장르를 선택해주세요.===================");
		System.out.println(
				"-------------------------------------------------------------------------------------------------");
		System.out.println(" 1. 고전 문학 2. 과학  3. 심리학  4. 동화  5. 정치  6. 경제  7. 자기개발  8. 역사 9. 음악  0. 메뉴화면으로..");
		System.out.println(
				"-------------------------------------------------------------------------------------------------");
		int input = ScanUtil.nextInt("번호 선택 ☞☞ ");

		String type = null;
		switch (input) {
		case 1:
			type = "g";
			break;
		case 2:
			type = "s";
			break;
		case 3:
			type = "a";
			break;
		case 4:
			type = "f";
			break;
		case 5:
			type = "p";
			break;
		case 6:
			type = "e";
			break;
		case 7:
			type = "d";
			break;
		case 8:
			type = "h";
			break;
		case 9:
			type = "m";
			break;
		case 0:
			return Command.REG_HOME;
		}

		if (type == null) {
			System.out.println("입력이 제대로 되지 않았습니다. 다시 입력해주세요.");
			return Command.BOOK_LIST;
		}
		RegMap.put("TYPE", type);
		return Command.BOOK_RENTAL;
	}
	private Command CodeOfBookBreturn() {
		System.out.println();
		System.out.println("================반납하실 도서의 장르를 선택해주세요.===================");
		System.out.println(
				"-------------------------------------------------------------------------------------------------");
		System.out.println(" 1. 고전 문학 2. 과학  3. 심리학  4. 동화  5. 정치  6. 경제  7. 자기개발  8. 역사 9. 음악  0. 메뉴화면으로..");
		System.out.println(
				"-------------------------------------------------------------------------------------------------");
		int input = ScanUtil.nextInt("번호 선택 ☞☞ ");

		String type = null;
		switch (input) {
		case 1:
			type = "g";
			break;
		case 2:
			type = "s";
			break;
		case 3:
			type = "a";
			break;
		case 4:
			type = "f";
			break;
		case 5:
			type = "p";
			break;
		case 6:
			type = "e";
			break;
		case 7:
			type = "d";
			break;
		case 8:
			type = "h";
			break;
		case 9:
			type = "m";
			break;
		case 0:
			return Command.REG_HOME;
		}

		if (type == null) {
			System.out.println("입력이 제대로 되지 않았습니다. 다시 입력해주세요.");
			return Command.BOOK_BRETURN;
		}
		RegMap.put("TYPE", type);
		return Command.BOOK_BRECODE;
	}
} // 컨트롤러 클래스
