package com.hanbit.web.global;

import java.util.Scanner;

import com.hanbit.web.member.User;

public class MainTest {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("역할 ?");
		String role = User.valueOf(s.nextInt()).toString();
		System.out.println("롤 : "+role);
	}
}
