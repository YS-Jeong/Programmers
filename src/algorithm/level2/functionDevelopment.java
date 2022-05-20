package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class functionDevelopment {
	public static void main(String[] args) {
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		
		solution(progresses, speeds);
	}
	
	public static int[] solution(int[] progresses, int[] speeds) {

        int[] leftOver = new int[progresses.length];
        int[] day = new int[progresses.length];
         
        for(int i = 0; i < progresses.length; i++) {
        	// 잔여 업무량 
        	leftOver[i] = 100 - progresses[i];
        	
        	// 작업별 소요되는 일 수 계산
        	if(leftOver[i] % speeds[i] == 0) {
        		day[i] = leftOver[i] / speeds[i];
        	} else if(leftOver[i] % speeds[i] != 0)
        		day[i] = leftOver[i] / speeds[i] + 1;
        }                     
        
        ArrayList<Integer> cnt = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < day.length; i++) {
        	// 큐가 비어 있으면 작업 할당
        	if(q.isEmpty()) {
            	q.offer(day[i]);
            // 가장 먼저 들어온 작업의 소요일 수가 새로 들어오는 작업의 소요일 수보다 작다면 큐에 삽
            } else if(q.peek() >= day[i]) {
            	q.offer(day[i]);
            // 반대라면 큐의 사이즈를 체크하고 큐를 비운 다음, 새로 들어오는 작업을 삽입해준다.
            } else if(q.peek() < day[i]) {        		
            	cnt.add(q.size());
            	q.clear();
            	q.offer(day[i]);            
            }//end if-1...
        }//end for-loop...
        
        // 마지막에 남아있는 작업체크
        cnt.add(q.size());    
        
        int[] answer = new int[cnt.size()];
       
        for(int i = 0; i < cnt.size(); i++)
        	answer[i] = cnt.get(i);
   
        return answer;
    }
}