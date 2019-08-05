package IOstreamMethod;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import JavaIO_Byte.MemberDTO;

public class IO2 {
	private static IO2 getIO2 = null;

	public static IO2 getInstance() {
		if (getIO2 == null) {
			getIO2 = new IO2();
		}
		return getIO2;
	}

	private IO2() {
	}

	private FileInputStream fi = null; //
	private FileOutputStream fo = null; // byte 방식으로 jvm에서 외부로 전달하는 객체변수
	private Scanner sc = new Scanner(System.in);

	public void insert(MemberDTO dto) {

		try {
			fo = new FileOutputStream("AccountList2.txt", true);

			String memo = dto.getId() + "/" + dto.getPw();
			if (((int) memo.charAt(memo.length() - 1)) != 10) {
				memo += "\r\n";
			}
			fo.write(memo.getBytes());
			fo.flush();

		} catch (

		Exception e) {
			System.out.println("Exception : " + e);
		} finally {
			try {
				if (fo != null)
					fo.close();
			} catch (Exception e2) {
				System.out.println("Exception : " + e2);
				e2.printStackTrace();
			}
		}
	}

	public ArrayList<MemberDTO> getList() {
		
		ArrayList<MemberDTO> acclist = new ArrayList<>();

		try {
			fi = new FileInputStream("AccountList2.txt");
			int k = 0;
			byte[] readM = new byte[1024];
			while ((k = fi.read(readM)) != -1) {
				
				String readmassage = new String(readM);
				StringTokenizer str = new StringTokenizer(readmassage,"\r\n");
				
				while (str.hasMoreTokens()) {
					
					boolean IDflag = true;
					StringTokenizer stridpw = new StringTokenizer(str.nextToken(),"/");
					
					MemberDTO dto = new MemberDTO();
					while(stridpw.hasMoreTokens()) {
						
						
						if (IDflag) {
							dto.setId(stridpw.nextToken());
							IDflag = !IDflag;
						} else {
							dto.setPw(stridpw.nextToken());
							acclist.add(dto);
							IDflag = !IDflag;
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Exception : " + e);
		} finally {
			try {
				if (fo != null)
					fo.close();
			} catch (Exception e2) {
				System.out.println("Exception : " + e2);
				e2.printStackTrace();
			}
		}
		
		return acclist;
	}
	
	public void modList(ArrayList<MemberDTO> acclist) {
		
		try {
			fo = new FileOutputStream("AccountList2.txt");
			for (int i = 0; i < acclist.size(); i++) {
				MemberDTO dto = acclist.get(i);
				String memo = dto.getId() + "/" + dto.getPw();
				if (((int) memo.charAt(memo.length() - 1)) != 10) {
					memo += "\r\n";
				}
				fo.write(memo.getBytes());
				fo.flush();
			}

		} catch (

		Exception e) {
			System.out.println("Exception : " + e);
		} finally {
			try {
				if (fo != null)
					fo.close();
			} catch (Exception e2) {
				System.out.println("Exception : " + e2);
				e2.printStackTrace();
			}
		}
	}
}
