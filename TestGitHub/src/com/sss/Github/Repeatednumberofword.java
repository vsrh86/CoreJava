package com.sss.Github;

public class Repeatednumberofword {
	public static void main(String[] args) {
		String s="sureshv";
		int count=0;
	char a[]=new char[s.length()];

		for(int i=0;i<s.length();i++){
			for(int j=i+1;j<s.length();j++){
				if(a[i]==a[j]){
					 count++;
					System.out.println("the word repeated" +a[i]+count+"times");
				}
			}
		}
	}

}
