package com.pages;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MethodRepeatedVowels {
	public static void main(String[] args) {
		mostRepeatedVowel("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaAAllleeeeeeeEEEEEEEEEEooooOOOuucccccccccccccccccccccccccccccccccccc");
	}

	public static void mostRepeatedVowel(String str) {
		Map<Character, Integer> dupMap = new HashMap<Character, Integer>();
		char[] chrs = str.toCharArray();
		for (Character ch : chrs) {
			if (Character.toLowerCase(ch) == 'a' || Character.toLowerCase(ch) == 'e' || Character.toLowerCase(ch) == 'i'
					|| Character.toLowerCase(ch) == 'o' || Character.toLowerCase(ch) == 'u') {
				if (dupMap.containsKey(Character.toLowerCase(ch))) {
					dupMap.put(Character.toLowerCase(ch), dupMap.get(Character.toLowerCase(ch)) + 1);
				} else {
					dupMap.put(Character.toLowerCase(ch), 1);
				}
			}
		}
				
		Object vowel = Collections.max(dupMap.entrySet(), Map.Entry.comparingByValue()).getKey();
        Object noOfTimes = Collections.max(dupMap.entrySet(), Map.Entry.comparingByValue()).getValue();
        System.out.println("The following vowel '" + vowel + "' is the most repeated one and count is " + noOfTimes );
	}
}
