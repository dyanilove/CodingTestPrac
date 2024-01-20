package lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class solution1 {
	public static void main(String[] args) {
		
//		===================== 코딩 테스트 문제 ======================
//				주제) 1~45 사이 숫자중에 조건에 만족하는 숫자 생성하기
//				=>조건
//				- 숫자범위 : 1~45
//				- 6개 일치 숫자 : 43, 24, 10, 18, 1, 36(고정)
//				- 5개 일치 숫자 : 3개(생성할 숫자들)
//
//				=>결과 (1행은 고정되고, 2~4행의 데이터는 변경됨)
//				1행 => [43, 24, 10, 18, 1, 36]
//				2행 => [36, 24, 15, 18, 1, 43]
//				3행 => [1, 30, 18, 10, 43, 36]
//				4행 => [43, 36, 10, 18, 8, 24]
		
		int[] fixedNum = {43, 24, 10, 18, 1, 36};
		System.out.println("1행 => "+ Arrays.toString(fixedNum));
		
//		문제 1 ) 랜덤 한 숫자 만들기
		int random[] = new int [6];
		
		for(int i = 0; i<random.length; i ++) {
			int num = (int)(Math.random()*45) + 1;
			random[i] = num;
			for(int j = 0; j< i; j++) {
				if(random[i] == random[j]) {
					i--;
					break;
				}
			}
		}
		System.out.println("2행 => "+Arrays.toString(random));		// 1문제 답 출력
		
		
//		문제 2 ) 6개 일치 숫자 : 43, 24, 10, 18, 1, 36(고정) 중에 5개를 무작위로 선별하기
		List<Integer> sameNum = Arrays.asList(43,24,10,18,1,36);
		Collections.shuffle(sameNum);
		List<Integer> fiveNum = sameNum.subList(0, 5);
		System.out.println("3행 => "+fiveNum);
		
		
		
		// 문제 3) 문제2번에서 선택된 숫자들 이외의 것으로 나머지 숫자 생성 하여 한행 완성하기
		List<Integer> extraNum = new ArrayList<>();
		for(int i = 1; i <=45; i ++) {
			if(!fiveNum.contains(i)) {
				extraNum.add(i);
			}
		}
		Collections.shuffle(extraNum);
		List<Integer> remainNum = extraNum.subList(0, 6);
		System.out.println("4행 => " + remainNum);
		
		
		
		// 문제 4 ) 3번에서 생성한 행과 기존의 행 간에 중복 검사하기
		
		
		
		
		
		
		List<Integer> fixedNumbers = Arrays.asList(43, 24, 10, 18, 1, 36);
        List<Integer> selectedNumbers = new ArrayList<>(fixedNumbers);
        Collections.shuffle(selectedNumbers);
        selectedNumbers = selectedNumbers.subList(0, 5);
        
        System.out.println("2행 => " + selectedNumbers);
	}
}
