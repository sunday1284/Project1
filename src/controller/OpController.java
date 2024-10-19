package controller;

import dao.BRegDao;
import dao.OpMemDao;
import util.Command;
import util.ScanUtil;
import vo.BRegVo;
import vo.OpMemVo;

public class OpController {
    private OpMemDao opMemService;
    private BRegDao bRegService;

    private static OpController controller;

    private OpController() {
        opMemService = new OpMemDao();
        bRegService = new BRegDao();
    }

    public static OpController getInstance() {
        if (controller == null) controller = new OpController();
        return controller;
    }

    public Command opmem() {
        System.out.println("***** 로그인 후 이용하실 수 있습니다.*****");
        // 관리자 역할 업데이트 호출
       
        System.out.print("관리자 아이디를 입력하세요. ☞☞ ");
        String opMemId = ScanUtil.nextLine();
        System.out.print("관리자 비밀번호를 입력하세요. ☞☞ ");
        String opMemPass = ScanUtil.nextLine();

        for (int r = 1; r >= 1; r--) {
            System.out.println("확인 중입니다. 잠시만 기다려주세요.");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

   	 	OpMemVo opv = new OpMemVo();

        opv.setOpmem_id(opMemId);
        opv.setOpmem_pass(opMemPass);

        OpMemVo OplogVo = opMemService.isAdmin(opv);

        if (OplogVo == null) {
            System.out.println("입력하신 정보가 확인되지 않습니다. 다시 로그인해주세요.");
            return Command.OPMEM;
        } else {
            System.out.println("관리자로 로그인 성공! 편안한 이용 되세요.");
            MainController.OpRegMap.put("Oplog", OplogVo);
            
            return Command.OPMEM_MU;
            
            
        }
        
    }
}
