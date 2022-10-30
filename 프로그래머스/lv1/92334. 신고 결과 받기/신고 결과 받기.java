import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> idxMap = new HashMap<>();
        Map<String, HashSet<String>> map = new HashMap<>();
        
        for(int i=0; i<id_list.length; i++){
            map.put(id_list[i], new HashSet<>());
            idxMap.put(id_list[i], i);
        }
        
        for(String rep : report){
            String[] name = rep.split(" ");
            String fromName = name[0];
            String toName = name[1];
            map.get(toName).add(fromName);
        }
        
        for(int i=0; i<id_list.length; i++){
            HashSet<String> send = map.get(id_list[i]);
            if(send.size() >=k){
                for(String name : send){
                    answer[idxMap.get(name)]++;
                }
            }
            
        }

        return answer;
    }
}