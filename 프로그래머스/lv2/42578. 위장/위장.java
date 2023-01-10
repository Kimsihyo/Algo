import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap();
        //옷 종류 별 개수
        for(int i=0; i<clothes.length; i++){
            String clothe_kind = clothes[i][1];
            // System.out.println(clothe_kind);
            map.put(clothe_kind, map.getOrDefault(clothe_kind, 0)+1);
        }
        // 곱하기
        Iterator<Integer> clothe = map.values().iterator();
        while(clothe.hasNext())
            answer *= clothe.next().intValue() + 1;
        
        return answer-1;
    }
}