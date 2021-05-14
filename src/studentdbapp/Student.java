package studentdbapp;

import java.util.Scanner;

public class Student {
	private String name;
	private int gradeYear;
	private String studentID;
	private String courses = "";
	private int tuitionBalance = 0;
	private static int costOfCourse = 600;
	private static int id = 1000;
	
	//생성자 : 학생의 이름과 학년
	public Student() {
		Scanner s = new Scanner(System.in);
		System.out.print("학생 이름을 입력 : ");
		this.name = s.next();
		
		System.out.print("1-1학년\n2-2학년\n3-3학년\n4-4학년\n학생의 학년을 입력 :");
		this.gradeYear = s.nextInt();
		
		setStudentID();
		
	}
	
	//ID 생성
	private void setStudentID() {
		//학년과 ID
		id++;
		this.studentID =  gradeYear + "" +id;   
	}
	
	//강의 등록
	public void enroll() {
		do {
			System.out.print("수강할 강의 입력 (Q 입력시 종료): ");
			Scanner s = new Scanner(System.in);
			String course = s.nextLine();
			if(!course.equals("Q")) {
				courses = courses + "\n" + course;
				tuitionBalance = tuitionBalance +costOfCourse;
			}
			else {
				break;
			}
		}while(1 != 0);
	}
	
	//잔액 확인
	public void viewBalance() {
		System.out.println("당신의 잔액은: "+ tuitionBalance +"원");
	}
	
	//수업료 납입
	public void payTuition() {
		viewBalance();
		System.out.print("지불 금액을 입력 :");
		Scanner s = new Scanner(System.in);
		int payment = s.nextInt();
		tuitionBalance = tuitionBalance - payment;
		System.out.println(payment + "원 입금이 확인되었습니다.");
		viewBalance();
	}
	
	//현 상태
	public String toString() {
		return "이름: "+ name +
				"\n학년: "+gradeYear +
				"\n학번: "+studentID + 
				"\n신청된강의: "+courses+
				"\n잔액: "+tuitionBalance;
	}
}




