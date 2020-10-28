package algo;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main_숨바꼭질 {
	public static Stack<Integer> stack;
	public static String res;
	public static boolean v[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int me = Integer.parseInt(s[0]);
		you = Integer.parseInt(s[1]);

		if (me == you) {
//         System.out.println(0+"\n"+me);
			System.out.println(0);
			return;
		}

		list = new ArrayList<>();
		list.add(me);

		stack = new Stack<>();
		stack.push(me);

		min = Integer.MAX_VALUE;
		v = new boolean[1000000];
		dfs(me, stack, 0);
		System.out.println(min);
//      System.out.println(res);
	} // main 끝

	public static int you, min;
	public static ArrayList<Integer> list;
//   private static void dfs(int me, ArrayList<Integer> list,int time) {

	private static void dfs(int me, Stack<Integer> stack, int time) {
		v[me] = true;
		if (time > min)
			return;
		if (me < 0)
			return;
		if (me == you) {
			if (time < min) {
				min = time;
				res = "";
				Stack<Integer> copy = new Stack<>();
				for (int c : stack) {
					res = c + " " + res;
				}
			}
			return;
		}

			// 순간이동
			int telpo = 2 * me;
			if (me * 2 < you * 2 && !v[telpo]) {
				v[telpo] = true;
				stack.push(telpo);
				dfs(telpo, stack, time + 1);
				stack.pop();
//               v[telpo]=false;
			}
			if (me + 1 < you * 2 && !v[me + 1]) {
				// 우로 이동
				v[me + 1] = true;
				stack.push(me + 1);
				dfs(me + 1, stack, time + 1);
				stack.pop();
//               v[me+1]=false;
			}
			if (me - 1 >= 0 && !v[me - 1]) {
				// 좌로 이동
				v[me - 1] = true;
				stack.push(me - 1);
				dfs(me - 1, stack, time + 1);
				stack.pop();
//               v[me-1]=false;
			}

		
	}

}