package prac2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.IOException;

public class Main {

	public static void q1() {
		
		// eclipse-jee-2021-03-R-win32-x86_64.zip 복사하기
		// 복사할 파일명은 eclipse.zip
		
		File src = new File("c:\\GDJ\\installer", "eclipse-jee-2021-03-R-win32-x86_64.zip");
		File cpy = new File("c:\\GDJ\\installer", "eclipse.zip");
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			
			bis = new BufferedInputStream(new FileInputStream(src));
			bos = new BufferedOutputStream(new FileOutputStream(cpy));
			
			byte[] b = new byte[1024];	// 1KB
			int readByte = 0;
			
			while((readByte = bis.read(b)) != -1) {
				bos.write(b, 0, readByte);
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bos != null) bos.close();
				if(bis != null) bis.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	public static void q2() {
		
		// c:\gdj\installer에 있는 eclipse를 c:\storage로 이동하기.
		
		// 1. 폴더가 없으면 폴더 생성하기
		File dir = new File("c:\\storage");
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		
		
		// 2. c:\gdj\installer에 있는 eclipse c:\storage로 복사
		File src = new File("c:\\GDJ\\installer", "eclipse.zip");
		File dst = new File("c:\\storage", src.getName());	// 같은 이름을 가져오겠다.
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			
			bis = new BufferedInputStream(new FileInputStream(src));
			bos = new BufferedOutputStream(new FileOutputStream(dst));
			
			byte[] b = new byte[1024];	// 1KB
			int readByte = 0;
			
			while((readByte = bis.read(b)) != -1) {
				bos.write(b, 0, readByte);
			}
			
			if(bos != null) bos.close();
			if(bis != null) bis.close();
			
			// 원본과 복사본의 크기가 동일하면 원본을 제거
			if(src.length() == dst.length()) {
				src.deleteOnExit();
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		q2();

	}

}
