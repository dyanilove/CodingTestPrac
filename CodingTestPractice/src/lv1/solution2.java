package lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class solution2 {
	public static void main(String[] args) {
//		===================== 코딩 테스트 문제 ======================
//		주제) 1~45 사이 숫자중에 조건에 만족하는 숫자 생성하기
//		=>조건
//		- 숫자범위 : 1~45
//		- 6개 일치 숫자 : 43, 24, 10, 18, 1, 36(고정)
//		- 5개 일치 숫자 : 3개(생성할 숫자들)
//
//		=>결과 (1행은 고정되고, 2~4행의 데이터는 변경됨)
//		1행 => [43, 24, 10, 18, 1, 36]
//		2행 => [36, 24, 15, 18, 1, 43]
//		3행 => [1, 30, 18, 10, 43, 36]
//		4행 => [43, 36, 10, 18, 8, 24]

		
		List<Integer> fixedNum = Arrays.asList(43, 24, 10, 18, 1, 36);
		
        System.out.println("1행 => " + fixedNum);

        List<List<Integer>> allRows = new ArrayList<>();
        
        allRows.add(fixedNum);

        for (int i = 0; i < 3; i++) {
            List<Integer> MyRow = new ArrayList<>();
            
            while (allRows.contains(MyRow)|| MyRow.isEmpty()) {	// 문제 4) 중복 검사하기
                // 문제 2) 6개 일치 숫자 중(43, 24, 10, 18, 1, 36)에 5개를 무작위로 선별하기
                Collections.shuffle(fixedNum);
                List<Integer> FiveNum = fixedNum.subList(0, 5); 
                
                // 문제 3) 2번에서 선택된 숫자들 이외의 것으로 나머지 숫자 생성
                List<Integer> remainNum = new ArrayList<>();
                
                for (int j = 1; j <= 45; j++) {
                    if (!fixedNum.contains(j)) {  
                    	remainNum.add(j);
                    }
                }
                
                Collections.shuffle(remainNum);
                int remainingNumber = remainNum.get(0);  // 문제 1) 랜덤 한 숫자 가져오기(무작위로 섞은거중에 젤 첫번째 고르는 것이라서 랜덤)
                
                MyRow = new ArrayList<>(FiveNum);
                MyRow.add(remainingNumber);
            }
            
            allRows.add(MyRow);
            
            System.out.println((i+2) + "행 => " + MyRow);
        }
    }

}
