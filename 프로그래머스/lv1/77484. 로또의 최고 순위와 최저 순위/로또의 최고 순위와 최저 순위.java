import java.util.*;


class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        // 로또 번호에서 0을 제외한 숫자를 매칭해봄 
        // 0을 당첨번호로 생각할지 말지 결정
        
        int cnt = 0;
        int cntZero = 0;
        for(int i=0; i<lottos.length; i++)
        {
            if(lottos[i] == 0) 
            {
                cntZero++;
                continue;
            }
            
            for(int j=0; j<win_nums.length; j++)
            {
                if(lottos[i] == win_nums[j])
                {
                    cnt++;
                    break;
                }
            }
            
        }
        int ansMin = 0;
        if(cnt == 6) ansMin = 1;
        else if(cnt == 5) ansMin = 2;
        else if(cnt == 4) ansMin = 3;
        else if(cnt == 3) ansMin = 4;
        else if(cnt == 2) ansMin = 5;
        else if(cnt == 1) ansMin = 6;
        else ansMin = 6;
        
        int ansMax = 0;
        cntZero += cnt;
        if(cntZero == 6) ansMax = 1;
        else if(cntZero == 5) ansMax = 2;
        else if(cntZero == 4) ansMax = 3;
        else if(cntZero == 3) ansMax = 4;
        else if(cntZero == 2) ansMax = 5;
        else if(cntZero == 1) ansMax = 6;
        else ansMax = 6;
        System.out.print(ansMax);
        System.out.print(ansMin);
        answer[0] = ansMax;
        answer[1] = ansMin;
        return answer;
    }
//     public static int lotto(int cnt, int cntZero){
//         int tempcnt = cnt;
           
        
//         return 0;
//     }
}