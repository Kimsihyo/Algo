

public class 연습장 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      String str = "xyZA";
      String str2 = "ABCxy";
      
      int index = 0;
      
      int fstr2i = 0;
      int fstri =0;
      int ftempi = 0;
      int ftempindex =0;
      boolean find = false;
      k:for(int i=0; i<str.length(); i++) {
         if(str.charAt(i)==str2.charAt(index)) {
            fstr2i = i;
            fstri = index;
//            //저장용 
            ftempi = i;
            ftempindex = index;
               find = false;
               while(ftempi<str.length() && ftempindex<str2.length() &&
                     str.charAt(ftempi) == str2.charAt(ftempindex)
                     ) {
                  if(str.charAt(str.length()-1)==str2.charAt(ftempindex) && str.length()-1 == ftempi) {
                     find = true;
                     break k;
                  }

                  ftempi +=1;
                  ftempindex +=1;
            }
         }   
      }

      String fans2 = "";
      if(find == true) { //확인할 수 있다는 뜻
         for(int i=0; i<fstr2i; i++)
            fans2+=str.charAt(i);
         for(int i=0; i<str2.length(); i++)
            fans2+=str2.charAt(i);
      }

      index = 0;
      int str2i = 0;
      int stri =0;
      int tempi = 0;
      int tempindex =0;
      find = false;
      k:for(int i=0; i<str2.length(); i++) {
         if(str2.charAt(i)==str.charAt(index)) {
            str2i = i;
            stri = index;
            tempi = i;
            tempindex = index;
               find = false;
               while(tempi<str2.length() && tempindex<str.length() &&
                     str2.charAt(tempi) == str.charAt(tempindex)
                     ) {
                  if(str2.charAt(str2.length()-1)==str.charAt(tempindex) &&  str2.length()-1 == tempi) {
                     find = true;
                     break k;
                  }

                  tempi +=1;
                  tempindex +=1;
            }
         }   
      }

      String ans2 = "";
      if(find == true) { //확인할 수 있다는 뜻
         for(int i=0; i<str2i; i++)
            ans2+=str2.charAt(i);
         for(int i=0; i<str.length(); i++)
            ans2+=str.charAt(i);
      }
////         
//      System.out.println(ans2);
      
      
      
      
      if(fans2.length()>ans2.length())
         System.out.println(ans2);
      else
         System.out.println(fans2);
      
      
   }

}