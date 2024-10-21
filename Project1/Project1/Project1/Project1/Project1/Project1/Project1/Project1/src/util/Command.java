package util;

public enum Command {
	
	HOME, 			// 첫화면
	REG_HOME,		// 로그인 성공 후 화면
	END,			// 종료
	
	// 회원 관련
	LOGIN,			// 로그인
	REGISTER,   	// 회원가입
	
	//관리자 전용
	OPMEM, 	//관리자 로그인
	OPMEM_REG, //관리자 회원가입
	OPMEM_MU, //관리자 메뉴창
	
	// 도서관리
	BOOK_LIST,		// 도서관리 리스트
	BOOK_VIEW,		// 도서 리스트 열람 
	BOOK_RENTAL,	// 도서 대여
	BOOK_BRETURN,	// 도서 반납
	BOOK_BRECODE,
	BOOK_ADD,		//도서 추가
	BOOK_DEL,		//도서 삭제
	//도서 장르
	SCIENCE, //과학
	ADHD,	//심리학
	MUSIC,	//음악
	GOJEON,	//고전
	HISTORY,//역사
	DEVEL,	//자기개발
	FAIRY,	//동화
	POLI,	//정치
	ECO,    //경제
	ALL,     //전체
	
	PASSRE, //비밀번호 중단
	PASS
}

