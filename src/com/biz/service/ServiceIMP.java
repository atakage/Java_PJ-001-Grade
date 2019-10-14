package com.biz.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import com.biz.grade.ScoreVO;
import com.biz.student.StudentVO;

public class ServiceIMP implements Service {

	Scanner scan;
	List<StudentVO> list;
	List<ScoreVO> scList;
	Random rd;
	int intstNumCount = 0;

	public ServiceIMP() {

		scan = new Scanner(System.in);
		list = new ArrayList<StudentVO>();
		scList = new ArrayList<ScoreVO>();

	}

	@Override
	public void stInput() {
		// TODO Auto-generated method stub

		while (true) {

			++intstNumCount;

			System.out.println("===학생 등록===");
			System.out.println("학번:" + intstNumCount);
			String strstNum = intstNumCount + "";
			System.out.print("이름:");

			String strstName = scan.nextLine();
			System.out.print("전화번호(11자리):"); // 전화번호 스플릿 "-"

			String strstTel = scan.nextLine();
			System.out.print("주소:");
			String strstAddr = scan.nextLine();
			System.out.print("학과:");
			String strstDept = scan.nextLine();

			int intstGrade = 0;

			try {

				System.out.print("학년:"); // 정수입력 예외처리
				intstGrade = Integer.valueOf(scan.nextLine());

			} catch (Exception e) {
				// TODO: handle exception

				System.out.println("학년은 숫자로만 입력");

				while (true) {

					System.out.println("학년 다시 입력(종료는 -1)");

					try {

						intstGrade = Integer.valueOf(scan.nextLine());
						if (intstGrade == -1)
							break;
						break;
					} catch (Exception e2) {
						// TODO: handle exception
					}

				}
			}

			StudentVO vo = new StudentVO();

			vo.setStrStNum(strstNum);
			vo.setStrStName(strstName);
			vo.setStrstTel(strstTel);
			vo.setStrstAddr(strstAddr);
			vo.setStrstDept(strstDept);
			vo.setIntstGrade(intstGrade);

			list.add(vo);
			System.out.println(strstName + " 의 정보 등록 완료");

			System.out.println("학생 계속 등록하려면 아무 키나...(종료는 end)");
			String strInputNext = scan.nextLine();

			if (strInputNext.equalsIgnoreCase("end"))
				break;
			else
				continue;

		}

	}

	@Override
	public void stList() {
		// TODO Auto-generated method stub

		System.out.println("학생명부");
		System.out.println("=======================");
		System.out.println("학번\t이름\t전화번호\t주소\t학과\t학년");
		System.out.println("=======================");

		int size = list.size();

		for (int i = 0; i < size; i++) {
			System.out.printf("%04d\t", Integer.valueOf(list.get(i).getStrStNum()));
			System.out.printf("%s\t", list.get(i).getStrStName());
			System.out.printf("%s\t", list.get(i).getStrstTel());
			System.out.printf("%s\t", list.get(i).getStrstAddr());
			System.out.printf("%s\t", list.get(i).getStrstDept());
			System.out.printf("%d\n", list.get(i).getIntstGrade());

		}
		System.out.println();

	}

	public void gdInput() {

		rd = new Random();
		scList = new ArrayList<ScoreVO>();

		int size = list.size();

		for (int i = 0; i < size; i++) {

			ScoreVO vo = new ScoreVO();

			vo.setIntscKor(rd.nextInt(51) + 50);
			vo.setIntscEng(rd.nextInt(51) + 50);
			vo.setIntscMath(rd.nextInt(51) + 50);
			vo.setIntscTotal(vo.getIntscKor() + vo.getIntscEng() + vo.getIntscMath());
			vo.setIntscAvg(vo.getIntscTotal() / 3);

			rankEx();
			scList.add(vo);
		}

	}

	@Override
	public void gdList() {
		// TODO Auto-generated method stub

		System.out.println("점수표");
		System.out.println("========================");
		System.out.println("학번\t국어\t영어\t수학\t총점\t평균\t석차");
		System.out.println("=======================");

		int size = scList.size();

		for (int i = 0; i < size; i++) {

			System.out.printf("%04d\t", Integer.valueOf(list.get(i).getStrStNum()));
			System.out.printf("%d\t", scList.get(i).getIntscKor());
			System.out.printf("%d\t", scList.get(i).getIntscEng());
			System.out.printf("%d\t", scList.get(i).getIntscMath());
			System.out.printf("%d\t", scList.get(i).getIntscTotal());
			System.out.printf("%d\t", scList.get(i).getIntscAvg());
			System.out.printf("%d\n", scList.get(i).getIntscRank());
			// 석차

		}

	}

	public void serachStudent() {

		System.out.println("---학번으로 검색---");
		System.out.print("학번 입력(0제외 입력):");
		String searchVal = scan.nextLine();

		int size = list.size();

		for (int i = 0; i < size; i++) {

			if (searchVal.equals(list.get(i).getStrStNum())) {

				System.out.println("학번\t이름\t전화번호\t주소\t학과\t학년");
				System.out.println("=======================");
				System.out.printf("%04d\t", Integer.valueOf(list.get(i).getStrStNum()));
				System.out.printf("%s\t", list.get(i).getStrStName());
				System.out.printf("%s\t", list.get(i).getStrstTel());
				System.out.printf("%s\t", list.get(i).getStrstAddr());
				System.out.printf("%s\t", list.get(i).getStrstDept());
				System.out.printf("%d\n", list.get(i).getIntstGrade());

			} else {
				System.out.println("검색 결과 없음");
				

			}

		}

	}

	public void rankEx() {

		int size = scList.size();

		int rank = 1;

		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {

				if (scList.get(i).getIntscTotal() < scList.get(j).getIntscTotal()) {

				}

			}
		}

	}

}
