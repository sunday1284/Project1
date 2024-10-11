package kr.or.ddit.enumTest;

/*
 *  enum(열거형) ==> 서로 관련있는 상수들의 집합을 나타낸다.
 *  		   ==> 클래스처럼 보이게 하는 상수
 *  - 작성 방법
 *  	1) 클래스처럼 독립된 java파일에 만들 수 있다.
 *  	2) 하나의 java 파일에 클래스와 같이 만들 수 있다.
 *  	3) 클래스의 내부에 내부 클래스처럼 만들 수 있다.
 *  
 *   - 열거형 선언하기
 *   형식) enum 열거형이름 {상수명1, 상수명2, 상수명3, ....}
 *   
 *   
 */
public class EnumTest {
	public enum Color { RED, GREEN, BLUE }
	public enum Count { ONE, TWO, THREE }
	
	public static void main(String[] args) {
		//열거형 변수 선언 및 초기화 하기
		Color mycol; //변수 선언
		mycol = Color.RED; //초기화
		
		Count mycnt = Count.ONE; //변수선언+초기화
		
		
		System.out.println("mycol : " +mycol);
		System.out.println("mycnt : " +mycnt.name());
		
		//mycol = Color.GREEN;
		
		//열거형 데이터를 if문으로 비교할 때는 '=='연산자를 사용한다.
		if(mycol == Color.GREEN) {
			System.out.println("GREEN이 맞다.");
		}else {
			System.out.println("GREEN이 아니다.");
		}
		
		//열거형을 switch문에서 비교하기 
		// case옆에  '상수명'만 기술해야 한다.
		switch(mycol) {
			case RED :
				System.out.println("RED입니다."); break;
			case GREEN :
				System.out.println("그린이네요...."); break;	
			case BLUE : 
				System.out.println("파랑이군요!!"); break;
//			case Color.BLUE :  //case 열거형이름.상수명 : ==> 이것은 사용 불가
//			 	break;
		}
		
		
	}

}
