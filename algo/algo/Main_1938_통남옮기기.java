package algo;
import java.io.*;
import java.util.*;


public class Main_1938_통남옮기기 {

	
	public static void main(String[] args) throws Exception {
		int[][] goods = {{25400, 2},{10000, 1},{31600, 1}};
		int[][] coupons = {{5, 3},{23, 2},{11, 2},{9, 5}};
		int total_discount = 0;
		//큰 값으로 정렬하자 
		Arrays.sort(goods, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
		Arrays.sort(coupons, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
                // 내림자순 정렬을 하고 싶다면 o2와 o1의 위치를 바꿔줍니다
            }
        });
		//물건이 없어질 때 까지 반복할거 + 총 금액 구하자
		int goods_acount=0; //물건 갯수
		double total_acount =0; // 물건 총액
		for (int i = 0; i < goods.length; i++) {
			goods_acount += goods[i][1];
			total_acount += (goods[i][0] * goods[i][1]);
		}
		while(goods_acount > 0) {
			int pick_goods=0;
			int pick_coupon=0;
			//쿠폰 꺼내자
			for (int i = 0; i < goods.length; ) {
				if(goods[i][1] != 0) {
					goods[i][1] -= 1; //한개 빼
					pick_goods = goods[i][0];// 물거 꺼내
					
				}else {
					i++;
					continue;
				}
				//쿠폰 꺼내자
				boolean no_coupon = false;
				for (int j = 0; j < coupons.length; j++) {
					if(coupons[j][1] != 0) {
						pick_coupon = coupons[j][0];
						coupons[j][1] -= 1;
					    j=0;
					    no_coupon = false;
						break ;
					}
					//여길 온다면 쿠폰이 없는것 
					no_coupon =true;
				}
				//계산 하자
				if(!no_coupon) {
					total_discount += (double)pick_goods*((double)pick_coupon/100);
				}
				goods_acount--;
				if(goods_acount == 0) break;
			}
		}
		System.out.println((int)total_acount-(int)total_discount);
	}

}
