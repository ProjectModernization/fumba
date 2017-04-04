package me.fumba;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Conversion of COBOL programs to Java.
 * 
 * @author fumba chibaka
 *
 */
public class ConvertedFunctions {

	public final static Pattern vowelPattern = Pattern.compile("[aeiou]");
	public final static Pattern consonantPattern = Pattern.compile("[a-z&&[^aeiou]]");
	public final static Pattern digitPattern = Pattern.compile("[0-9]");
	public final static Pattern operatorPattern = Pattern.compile("[+*]");

	/**
	 * An example program demonstrating the use of condition names (level 88's).
	 * The PERFOM and EVALUATE verbs are also used.
	 */
	private static void conditions() {
		System.out.println("Enter lower case character or digit. No Data ends.");
		String userInput = readUserInput(1);
		while (userInput != null) {
			if (patternChecker(vowelPattern, userInput)) {
				System.out.printf("The letter %s is a vowel.\n", userInput);
				userInput = readUserInput(1);
			}
			if (patternChecker(consonantPattern, userInput)) {
				System.out.printf("The letter %s is a consonant.\n", userInput);
				userInput = readUserInput(1);
			}
			if (patternChecker(digitPattern, userInput)) {
				System.out.printf("%s is a digit.\n", userInput);
				userInput = readUserInput(1);
			} else {
				userInput = null;
			}
		}
		System.out.println("Problems Found");
	}

	/**
	 * Converted function from COBOL program.
	 */
	private static void iterateIf() {
		String num1;
		String num2;
		String operator;
		int result;
		for (int count = 0; count < 3; count++) {
			System.out.println("-----------\nEnter  First number :");
			num1 = readUserInput(1);
			if (!patternChecker(digitPattern, num1)) {
				System.out.println("Problem Found - not a digit");
				continue;
			}
			System.out.println("Enter  Second  number :");
			num2 = readUserInput(1);
			if (!patternChecker(digitPattern, num2)) {
				System.out.println("Problem Found - not a digit");
				continue;
			}
			System.out.println("Enter  operator ( + or *) :");
			operator = readUserInput(1);
			if (!patternChecker(operatorPattern, operator)) {
				System.out.println("Problem Found - not an operator");
				continue;
			}
			if ("+".equals(operator)) {
				result = Integer.parseInt(num1) + Integer.parseInt(num2);
			} else {
				result = Integer.parseInt(num1) * Integer.parseInt(num2);
			}
			System.out.printf("Result is = %d\n", result);
		}
	}

	/**
	 * Illustrates how the first format of the PERFORM may be used to change the
	 * flow of control through a program. Use the output of this program to get
	 * an understanding of how this format of the PERFORM works.
	 */
	private static void perform() {
		topLevel();
		twoLevelsDown();
		oneLevelDown();
		threeLevelsDown();
	}

	/**
	 * Uses the ACCEPT and DISPLAY verbs to accept a student record from the
	 * user and display some of the fields. Also shows how the ACCEPT may be
	 * used to get the system date and time.
	 * 
	 * The YYYYMMDD in ACCEPT CurrentDate from DATE YYYYMMDD is a format command
	 * that ensures that the date contains a 4 digit year. If not used, the year
	 * supplied by the system will only contain two digits which may cause a
	 * problem in the year 2000.
	 */
	private static void accept() {
		System.out.println("Enter student details using templete below");
		System.out.println("Enter - ID, Surname, Intials, CourseCode, Gender");
		System.out.println("SSSSSSSNNNNNNNNIICCCCG");
		String userInput = readUserInput(22); // 1234567CHIBAKA FCCS55M
		if (userInput != null) {
			StudentDetails studentDetails = extractStudentDetails(userInput);
			System.out.printf("Name is %s %s\n", studentDetails.getInitials(), studentDetails.getSurname());

			Calendar calendar = Calendar.getInstance();
			System.out.println(String.format("Date  is %02d %02d %04d", calendar.get(Calendar.DATE),
					calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR)));

			System.out.println(String.format("Today is day %03d of the year", calendar.get(Calendar.DAY_OF_YEAR)));

			System.out.println(
					String.format("The time is %02d:%02d", calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE)));
		} else {
			System.out.println("Problem found - input character count is not 22. ");
		}
	}

	/**
	 * Extract student details from string and assign to object.
	 * 
	 * @param userInput
	 * @return
	 */
	public static StudentDetails extractStudentDetails(String userInput) {
		StudentDetails studentDetails = new StudentDetails();
		int index = 0;
		if (userInput != null) {
			studentDetails.setStudentId(Integer.parseInt(userInput.substring(0, index += 7)));
			studentDetails.setSurname(userInput.substring(index, index += 8));
			studentDetails.setInitials(userInput.substring(index, index += 2));
			studentDetails.setCourseCode(userInput.substring(index, index += 4));
			studentDetails.setGender(userInput.substring(index, ++index));
		}
		return studentDetails;
	}

	/**
	 * Converted COBOL code
	 */
	private static void shortest() {
		System.out.println("I did it");
	}

	/**
	 * Example program using accept, display and multiply to get two sample
	 * digit numbers from the user and multiply them together.
	 */
	private static void multiplier() {
		String num1;
		String num2;
		int result;
		System.out.println("Enter  First number :");
		num1 = readUserInput(1);
		if (!patternChecker(digitPattern, num1)) {
			System.out.println("Problem Found - not a digit");
			return;
		}
		System.out.println("Enter  Second  number :");
		num2 = readUserInput(1);
		if (!patternChecker(digitPattern, num2)) {
			System.out.println("Problem Found - not a digit");
			return;
		}
		result = Integer.parseInt(num1) * Integer.parseInt(num2);
		System.out.printf("Result is = %d\n", result);
	}

	/**
	 * 3 Levels Down
	 */
	private static void threeLevelsDown() {
		System.out.println("Now in threeLevelsDown");
	}

	/**
	 * 1 Level Down
	 */
	private static void oneLevelDown() {
		System.out.println("Now in oneLevelDown");
		twoLevelsDown();
		System.out.println("Back in oneLevelDown");
	}

	/**
	 * 2 Levels Down
	 */
	private static void twoLevelsDown() {
		System.out.println("Now in twoLevels down");
		threeLevelsDown();
		System.out.println("Back in twoLevelsDown");
	}

	/**
	 * Top Level
	 */
	private static void topLevel() {
		System.out.println("In toplevel. Starting to run program");
		oneLevelDown();
		System.out.println("Back in topLevel");
	}

	/**
	 * Read user input
	 */
	private static String readUserInput(int charCount) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		return validateUserInput(charCount, reader);
	}

	/**
	 * Helper function for readUserInput
	 * 
	 * @param charCount
	 * @param reader
	 * @return
	 */
	public static String validateUserInput(int charCount, BufferedReader reader) {
		String userInput = null;
		try {
			userInput = reader.readLine();
			if (charCount < 1 || userInput == null || userInput.length() != charCount) {
				return null;
			}
		} catch (IOException e) {
			return null;
		}
		return userInput;
	}

	/**
	 * Checks for match in pattern.
	 * 
	 * @param pattern
	 * @param userInput
	 * @return
	 */
	public static boolean patternChecker(Pattern pattern, CharSequence userInput) {
		if (pattern != null && userInput != null) {
			Matcher matcher = pattern.matcher(userInput);
			if (matcher.find()) {
				return true;
			}
		}
		return false;
	}

	public static void main(String args[]) {

		// 2CONDITIONS.CBL
		conditions();

		// 2ITELIF.CBL
		iterateIf();

		// 2PERFORM1
		perform();

		// ACCEPT.CBL
		accept();

		// SHORTEST.CBL
		shortest();

		// MULTIPLIER.CBL
		multiplier();

	}

}
