package JavaIO_Byte;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

import Util.IOstreamUtil;

public class Main {

	FileInputStream fi = null; 	//
	FileOutputStream fo = null;	// byte 방식으로 jvm에서 외부로 전달하는 객체변수
	Scanner sc = new Scanner(System.in);
	IOstreamUtil io = null;
	
	Main() {
		io = IOstreamUtil.getInstance();
		boolean endFlag = false;

		while (!endFlag) {
			menu();
			int idx = sc.nextInt();
			sc.nextLine();

			switch (idx) {
			case 1:
				io.addAcc();
				break;
			case 2:
				io.showList();
				break;
			case 3:
				io.modAcc();
				break;
			case 4:
				io.delAcc();
				break;
			default:
				break;
			}
		}
	}

	private void menu() {
		System.out.println("메뉴");
		System.out.println("1. 회원 가입");
		System.out.println("2. 회원 리스트");
		System.out.println("3. 비밀번호 수정");
		System.out.println("4. 회원 삭제");
		System.out.println("번호 선택하세요");
	}
}
