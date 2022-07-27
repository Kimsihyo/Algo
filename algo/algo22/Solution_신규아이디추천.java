package algo22;

import java.util.*;

public class Solution_신규아이디추천 {

	public static void main(String[] args) {
		solution("z-+.^.");
	}

	public static String solution(String new_id) {
		String answer = "";
		if (new_id.equals(""))
			return "a";
		new_id = new_id.toLowerCase();

		String[] arr = new_id.split("");
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < arr.length; i++) {
			if (list.size() >= 15) {
				System.out.println("길이 15이상 자르기");
				break;
			} else if (i >= 1 && arr[i - 1].equals(".") && arr[i].equals(".")) {
				System.out.println("연속된 . 삭제");
				continue;
			} else if (arr[i].equals(".") && i == 0) {
				System.out.println("첫글자 . 삭제");
				continue;
			} else if (arr[arr.length - 1].equals(".") && i == arr.length - 1) {
				System.out.println("마지막글자 . 삭제");
				continue;
			}
			if (arr[i].equals("a"))
				list.add(arr[i]);
			else if (arr[i].equals("a"))
				list.add(arr[i]);
			else if (arr[i].equals("b"))
				list.add(arr[i]);
			else if (arr[i].equals("c"))
				list.add(arr[i]);
			else if (arr[i].equals("d"))
				list.add(arr[i]);
			else if (arr[i].equals("e"))
				list.add(arr[i]);
			else if (arr[i].equals("f"))
				list.add(arr[i]);
			else if (arr[i].equals("g"))
				list.add(arr[i]);
			else if (arr[i].equals("h"))
				list.add(arr[i]);
			else if (arr[i].equals("i"))
				list.add(arr[i]);
			else if (arr[i].equals("j"))
				list.add(arr[i]);
			else if (arr[i].equals("k"))
				list.add(arr[i]);
			else if (arr[i].equals("l"))
				list.add(arr[i]);
			else if (arr[i].equals("m"))
				list.add(arr[i]);
			else if (arr[i].equals("n"))
				list.add(arr[i]);
			else if (arr[i].equals("o"))
				list.add(arr[i]);
			else if (arr[i].equals("p"))
				list.add(arr[i]);
			else if (arr[i].equals("q"))
				list.add(arr[i]);
			else if (arr[i].equals("r"))
				list.add(arr[i]);
			else if (arr[i].equals("s"))
				list.add(arr[i]);
			else if (arr[i].equals("t"))
				list.add(arr[i]);
			else if (arr[i].equals("u"))
				list.add(arr[i]);
			else if (arr[i].equals("v"))
				list.add(arr[i]);
			else if (arr[i].equals("w"))
				list.add(arr[i]);
			else if (arr[i].equals("x"))
				list.add(arr[i]);
			else if (arr[i].equals("y"))
				list.add(arr[i]);
			else if (arr[i].equals("z"))
				list.add(arr[i]);
			else if (arr[i].equals("0"))
				list.add(arr[i]);
			else if (arr[i].equals("1"))
				list.add(arr[i]);
			else if (arr[i].equals("2"))
				list.add(arr[i]);
			else if (arr[i].equals("3"))
				list.add(arr[i]);
			else if (arr[i].equals("4"))
				list.add(arr[i]);
			else if (arr[i].equals("5"))
				list.add(arr[i]);
			else if (arr[i].equals("6"))
				list.add(arr[i]);
			else if (arr[i].equals("7"))
				list.add(arr[i]);
			else if (arr[i].equals("8"))
				list.add(arr[i]);
			else if (arr[i].equals("9"))
				list.add(arr[i]);
			else if (arr[i].equals("."))
				list.add(arr[i]);
			else if (arr[i].equals("-"))
				list.add(arr[i]);
			else if (arr[i].equals("_"))
				list.add(arr[i]);

		}
		if (arr.length >= 15 && list.get(list.size() - 1) == ".") {
			list.remove(list.size() - 1);
		}
		
		
		if (list.size() <= 2) {
			while (new_id.length() <= 2) {
				list.add(list.get(list.size()));
			}
		} 
		int size = list.size();
		for (int i = 0; i < size; i++) {
			answer += list.get(i);
		}
		System.out.println(answer);
		return answer;

	}
}
