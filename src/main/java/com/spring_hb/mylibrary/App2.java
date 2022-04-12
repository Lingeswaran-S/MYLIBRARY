package com.spring_hb.mylibrary;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class App2 {
	public static void main(String[] args) throws ParseException {
//		System.out.println("App 2");
//		String str = "mnjf78768@#76";
//		char[] cs = str.toCharArray();
//		for (char c : cs) {
//			if(!Character.isLetter(c) & !Character.isDigit(c)) {
//				System.out.println(c+"Special");
//			}
//			else {
//				System.out.println(c+"Not");
//			}
//			
		
//		}
		
		Scanner scanner=new Scanner(System.in);
		String dateFormatMode="dd/MM/yyyy";
		SimpleDateFormat dateFormat=new SimpleDateFormat(dateFormatMode);
		System.out.println("date ?");
		Date parse = dateFormat.parse(scanner.next());
		System.out.println(parse);
	
		

	}

}
