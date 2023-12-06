package com.nosetr._20231108;

public class Main {

	public boolean checkPosition(String expString, String actString) {
		
		StringBuilder stringBuilder = new StringBuilder();
		int i = 0;
		while (actString.length() > 0) {
			
		}
		
		return false;
	}
	
	/**
	 * LRRLUUUUDD
	 * @param string
	 * @return boolean
	 */
	public boolean firstPosition(String string) {
		int x = 0;
		int y = 0;
		
		for (char c : string.toCharArray()) {
			switch (c) {
				case 'R' -> x++;
				case 'L' -> x--;
				case 'U' -> y++;
				case 'D' -> y--;
			}
		}
		return x == 0 && y == 0;
	}
	
	public boolean countChars(String string) {
		return false;
		
	}

}
