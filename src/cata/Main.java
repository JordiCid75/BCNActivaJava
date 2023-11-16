package cata;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] v = {4,0,7,0,3,2,0};
		ArrayList<Integer> r = new ArrayList<Integer>();
		int count = 0;
		for (int i : v) {
			if (i != 0) {
				r.add(i);
			} else
			{
				count++;
			}
		}
		for (int i = 0; i<count;i++) {
			r.add(0);
		}
		System.out.println(r.toString());
	}

}
