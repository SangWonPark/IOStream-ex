package Util;

import java.util.ArrayList;
import java.util.Scanner;

import IOstreamMethod.IO2;
import JavaIO_Byte.MemberDTO;

public class IOstreamUtil {
	private IO2 getIO2 = null;
	private ArrayList<MemberDTO> dtoList = new ArrayList<>();
	private Scanner sc = new Scanner(System.in);
	private static IOstreamUtil getIOstreamUtil = null;
	public static IOstreamUtil getInstance() {
		if (getIOstreamUtil == null) {
			getIOstreamUtil = new IOstreamUtil();
		}
		return getIOstreamUtil;
	}
	private IOstreamUtil() {
		getIO2 = IO2.getInstance();
		dtoList = getIO2.getList();
	}
	
	
	public void addAcc() {
		MemberDTO dto = new MemberDTO();
		String id = null;
		String pw;
		boolean IDchk = false;
		while (!IDchk) {
			System.out.println("ID를 입력하세요");
			id = sc.nextLine();
			IDchk = true;
			for (int i = 0; i < dtoList.size(); i++) {
				MemberDTO comparedto = dtoList.get(i);
				if (id.equals(comparedto.getId())) {
					IDchk = false;
				}
			}
		}
		
		System.out.println("PW를 입력하세요");
		pw = sc.nextLine();
		
		dto.setId(id);
		dto.setPw(pw);
		
		getIO2.insert(dto);
		dtoList = getIO2.getList();
	}
	
	public void showList() {
		for (int i = 0; i < dtoList.size(); i++) {
			MemberDTO dto = dtoList.get(i);
			System.out.println(i+"번 고객\n"+"ID : "+dto.getId()+"\t"+dto.getPw());
		}
	}
	
	public void modAcc() {
		String id;
		System.out.println("ID를 입력하세요");
		id = sc.nextLine();
		
		for (int i = 0; i < dtoList.size(); i++) {
			MemberDTO tempDto = dtoList.get(i);
			if (id.equals(tempDto.getId())) {
				
				System.out.println("변경할 PW를 입력하세요");
				tempDto.setPw(sc.nextLine());
				getIO2.modList(dtoList);
				dtoList = getIO2.getList();
				break;
			}
		}
	}
	
	public void delAcc() {
		String id;
		System.out.println("삭제할 ID를 입력하세요");
		id = sc.nextLine();
		
		for (int i = 0; i < dtoList.size(); i++) {
			MemberDTO dto = dtoList.get(i);
			if (id.equals(dto.getId())) {
				dtoList.remove(dto);
				getIO2.modList(dtoList);
				dtoList = getIO2.getList();
				break;
			}
		}
	}
}
