import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        ArrayList<String> participantList = new ArrayList();
        ArrayList<String> completionList = new ArrayList();
        
        for(int i=0; i<participant.length; i++)
        {
            participantList.add(participant[i]);
        }
        
        for(int i=0; i<completion.length; i++)
        {
            completionList.add(completion[i]);
        }
        
        Collections.sort(participantList);
        Collections.sort(completionList);
        
        for(int i=0; i<participantList.size(); i++)
        {
            if(i == participantList.size()-1) answer = participantList.get(i);
            else if(!participantList.get(i).equals(completionList.get(i)))
            {
                answer = participantList.get(i);
                break;
            }
        }
        return answer;
    }
}