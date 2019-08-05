package JavaIO_Byte;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

import Util.IOstreamUtil;

public class Main {

	FileInputStream fi = null; 	//
	FileOutputStream fo = null;	// byte ������� jvm���� �ܺη� �����ϴ� ��ü����
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
		System.out.println("�޴�");
		System.out.println("1. ȸ�� ����");
		System.out.println("2. ȸ�� ����Ʈ");
		System.out.println("3. ��й�ȣ ����");
		System.out.println("4. ȸ�� ����");
		System.out.println("��ȣ �����ϼ���");
	}
}
