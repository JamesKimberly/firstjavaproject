package MPView;

import java.util.Scanner;

import MPDAO.MPDAO;
import MPVO.MPVO;

public class MPView {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("영어단어맞추기 게임");
		
		String name = null;
		String id = null;
		String pw = null;
		String phone = null;
		String email = null;
		int MaxScore = 0;
		String id2 = null;
		String pw2 = null;
		
		MPDAO dao = null;
		boolean result = false;
		MPVO vo = null;
		boolean a = true;
		while(a) {
			System.out.println("[1]회원가입...[2]로그인....[3]종료");
			System.out.print("메뉴 선택 : ");
			int menu = sc.nextInt();
			switch(menu) {
			case 1 :
				System.out.println("<회원가입>");
				System.out.print("아이디 : ");
				id=sc.next();
				System.out.print("비밀번호 : ");
				pw=sc.next();
				System.out.print("이름 : ");
				name=sc.next();
				System.out.print("전화번호 : ");
				phone=sc.next();
				System.out.print("메일주소 : ");
				email=sc.next();
				dao = new MPDAO();
				result = dao.insertMP(id, pw, name, phone, email);
				if(result == true) {
					System.out.println("회원가입 성공");
				} else {
					
					System.out.println("회원가입 실패");
				}
				
				break;
			case 2 :
				System.out.println("로그인");
				System.out.print("아이디 입력 : ");
				id2= sc.next();
				System.out.print("비밀번호 입력 :");
				pw2= sc.next();
				
				dao = new MPDAO();
				vo = dao.oneSelectMP(id2, pw2);
				if(vo!=null) {
				if(id2.equals(vo.getId()) && pw2.equals(vo.getPw())) {
						System.out.println("로그인 성공");
						a = false;
						
					}else {
						System.out.println("로그인 실패");
					}
					break;
			
			}
			}
			break;
		}while(a==false) {
			System.out.println("[1]게임시작...[2]랭킹확인...[3]종료");
			int menu2 = sc.nextInt();
			switch(menu2) {
			case 1 : System.out.println("게임 시작");
			int score = 0;
			int life = 5;
			break;
			case 2 : System.out.println("랭킹 확인"); //select USER_ID, USER_NAME, USER_MAXSCORE from USER_INFORMATION order by USER_MAXSCORE desc limit 10
			
			case 3 :
				break;
			}
			
			break;
		}
	}
}
