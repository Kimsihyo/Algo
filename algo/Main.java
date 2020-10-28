import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {

	static int N, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, count;
	static int[] nums, ops, pOps;
	static boolean[] checked;
	static HashSet<String> set = new HashSet<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		count =0 ;
		String[] str = br.readLine().split(" ");
		nums = new int[N];
		for(int i=0; i<N; ++i) {
			nums[i] = Integer.parseInt(str[i]);
		}
		
		str = br.readLine().split(" ");
		ops = new int[N-1];
		pOps = new int[N-1];
		int index = 0;
		for(int i=0; i<4; ++i) {
			for(int j=0; j<Integer.parseInt(str[i]); ++j) {
				ops[index++] = i;
			}
		}
		
		checked = new boolean[N-1];
		permutation(0);
		
		System.out.println(max);
		System.out.println(min);
		System.out.println(count);
		
	}
	
	static void permutation(int index) {
		
		if(index==(N-1)) {
			count ++;
			if(!set.contains(Arrays.toString(pOps))) {
				set.add(Arrays.toString(pOps));
				int result = nums[0];
				for(int i=0; i<N-1; ++i) {
					switch(pOps[i]) {
					case 0: result+=nums[i+1]; break;
					case 1: result-=nums[i+1]; break;
					case 2: result*=nums[i+1]; break;
					case 3: result/=nums[i+1]; break;
					}
				}
				if(result<min) min = result;
				if(result>max) max = result;
			}
			return;
		}
		
		for(int i=0; i<N-1; ++i) {
			
			if(checked[i]) continue;
			
			pOps[index] = ops[i];
			checked[i] = true;
			permutation(index+1);
			checked[i] = false;
			
		}
		
	}

}