package controller;

import dao.BRegDao;
import util.Command;
import util.ScanUtil;
import vo.BRegVo;
import vo.MemberVo;

public class BRegController {
	private BRegDao BRegService;

	private static BRegController controller;

	private BRegController() {
		BRegService = BRegDao.getInstance();
	}

	public static BRegController getInstance() {
		if (controller == null)
			controller = new BRegController();
		return controller;
	}

	public Command register() {
		System.out.println("*****회원가입 후 이용하실 수 있습니다.*****");
		System.out.println();
		System.out.print("사용하실 아이디를 입력하세요. ☞☞ ");
		String bregId = ScanUtil.nextLine();
		System.out.print("사용하실 비밀번호를 입력하세요. ☞☞ ");
		String bregPass = ScanUtil.nextLine();
		System.out.print("이름을 입력해주세요. ☞☞ ");
		String bregName = ScanUtil.nextLine();
		System.out.print("회원 전화번호를 입력해주세요. ☞☞ ");
		String bregNum = ScanUtil.nextLine();
		System.out.print("회원 역할을 입력해주세요 (예: USER, ADMIN). ☞☞ ");
		String role = ScanUtil.nextLine();

		for (int r = 1; r >= 1; r--) {
			System.out.println("확인 중입니다. 잠시만 기다려주세요.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();

		// 아이디 중복 확인 생략
		// 비밀번호 확인 생략
		// 정규표현식(유효성 검사) 생략

		BRegVo bregVo = new BRegVo();
		bregVo.setBreg_id(bregId);
		bregVo.setBreg_pass(bregPass);
		bregVo.setBreg_name(bregName);
		bregVo.setBreg_num(bregNum);
		bregVo.setRole(role); // ROLE 설정

		int result = BRegService.insertBREG(bregVo);

		if (result > 0) {
			System.out.println("회원가입 성공!");

			MemberVo memberVo = new MemberVo();
			memberVo.setMem_id(bregId);
			memberVo.setMem_pass(bregPass);
			memberVo.setMem_name(bregName);
			memberVo.setMem_num(bregNum);
			memberVo.setRole(role);

			int memResult = BRegService.insertBREG1(memberVo);
			if (memResult > 0) {
				// 추가적인 성공 처리
			} else {
				// 추가적인 실패 처리
			}
		} else {
			System.out.println("회원가입 실패!");
		}

		return Command.HOME;
	}

	public Command login() {
		System.out.println("***** 로그인 후 이용하실 수 있습니다.*****");
		System.out.print("아이디를 입력하세요. ☞☞ ");
		String bregId = ScanUtil.nextLine();
		System.out.print("비밀번호를 입력하세요. ☞☞ ");
		String bregPass = ScanUtil.nextLine();

		for (int r = 1; r >= 1; r--) {
			System.out.println("확인 중입니다. 잠시만 기다려주세요.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		BRegVo bregVo = new BRegVo();
		bregVo.setBreg_id(bregId);
		bregVo.setBreg_pass(bregPass);

		BRegVo logRegVo = BRegService.getBReg(bregVo);

		if (logRegVo == null) {
			System.out.println("입력하신 정보가 확인되지 않습니다. 다시 로그인해주세요.");
			return Command.LOGIN;
		} else {
			System.out.println("로그인 성공! 편안한 이용 되세요.");
			MainController.RegMap.put("logReg", logRegVo);
			String role = logRegVo.getRole();
		if ("ADMIN".equalsIgnoreCase(role)) {
			return Command.OPMEM_MU; // 관리자 홈 화면으로 이동
		} else {
			return Command.REG_HOME; // 일반 사용자 홈 화면으로 이동
		}

	}
  }
	
}
