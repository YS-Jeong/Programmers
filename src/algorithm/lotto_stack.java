package algorithm;

import java.util.Stack;

public class lotto_stack {
	public static void main(String[] args) {		
		int [] lottos = {44, 1, 0, 0, 31, 25};
		int [] win_nums = {31, 10, 45, 1, 6, 19};
		
		solution(lottos, win_nums);
	}
	
    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int max = 0, min = 0; // 일치하는 번호의 최고, 최저 개수  
        int cnt = 0; // 낙서된 숫자의 개수
        
        int maxRank = 0, minRank = 0;
        
        Stack<Integer> s = new Stack<>(); // 내 번호 
        
        int i = 0;
        // 자신의 로또 번호 스택에 넣기!! 
        while(i < lottos.length) {
        	s.push(lottos[i]);
        	
        	// 낙서된 번호 개수 카운트 
        	if(lottos[i]==0) 
        		cnt ++;
        	
        	i++;
        }
        
        i = 0;
        
        // 당첨 결과와 비교해서 일치하는 번호의 최소 개수 구하기!!
        while(i < win_nums.length) {
        	if(s.contains(win_nums[i])==true)
        		min++; 
        	i++;
        }
        
        // 일치하는 번호의 최대 개수는 최소 개수 + 낙서된 숫자의 개수!!
        max = cnt + min;
        
        // 로또 등수로 바꿔주기
        if(max == 6) 
        	maxRank = 1;
        else if(max == 5)
        	maxRank = 2;
        else if(max == 4)
        	maxRank = 3;
        else if(max == 3)
        	maxRank = 4;
        else if(max == 2)
        	maxRank = 5;
        else 
        	maxRank = 6;
        
        if(min == 6) 
        	minRank = 1;
        else if(min == 5)
        	minRank = 2;
        else if(min == 4)
        	minRank = 3;
        else if(min == 3)
        	minRank = 4;
        else if(min == 2)
        	minRank = 5;
        else 
        	minRank = 6;
        
        System.out.println(maxRank+", "+minRank);
        answer[0] = maxRank;
        answer[1] = minRank;
        
        return answer;
    }
}
