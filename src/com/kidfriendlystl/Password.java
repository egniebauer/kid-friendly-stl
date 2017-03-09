package com.kidfriendlystl;

import java.util.Scanner;

import org.mindrot.jbcrypt.BCrypt;

public class Password {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Password and Salt Generator");
		System.out.println();
		System.out.println("Enter password to hash:");
		System.out.print(">_");
		String password = in.nextLine();
		System.out.println();
		System.out.println("Here is the salt:");
		// Generate salt
		String salt = BCrypt.gensalt();
		System.out.println("> " + salt);
		System.out.println();
		System.out.println("Here is the hash:");
		// Hash a password for the first time
		String hashed = BCrypt.hashpw(password, salt);
		System.out.println("> " + hashed);
		System.out.println(" ");
		System.out.print("Let's verify your password. ");
		System.out.println("Please reenter the password you wanted hashed:");
		System.out.print(">_");
		String candidate = in.nextLine();
		System.out.println(" ");
		
		// Check plaintext password matches one that has been previously hashed
		if (BCrypt.checkpw(candidate, hashed)) {
			System.out.println("It matches");
		}
		else {
			System.out.println("It does not match");
		}
		
		in.close();
	}

}
