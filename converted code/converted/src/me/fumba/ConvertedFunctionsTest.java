package me.fumba;

/**
 * Junit test - Conversion of COBOL programs to Java.
 * 
 * @author fumba chibaka
 *
 */
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.Before;
import org.junit.Test;

public class ConvertedFunctionsTest {
	private BufferedReader sample_data;
	private BufferedReader blank_data;

	@Before
	public void setup() {
		try {
			System.out.println(System.getProperty("user.dir"));
			sample_data = new BufferedReader(new FileReader("sample_data.txt"));
			blank_data = new BufferedReader(new FileReader("blank_data.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testValidateUserInput() throws FileNotFoundException {
		assertEquals(null, ConvertedFunctions.validateUserInput(1, blank_data));
		assertEquals(null, ConvertedFunctions.validateUserInput(0, blank_data));

		assertEquals("1", ConvertedFunctions.validateUserInput(1, sample_data));
		assertEquals("12", ConvertedFunctions.validateUserInput(2, sample_data));
		assertEquals(null, ConvertedFunctions.validateUserInput(4, sample_data));
	}

	@Test
	public void testPatternChecker() {
		assertEquals(true, ConvertedFunctions.patternChecker(ConvertedFunctions.vowelPattern, "a"));
		assertEquals(true, ConvertedFunctions.patternChecker(ConvertedFunctions.vowelPattern, "e"));
		assertEquals(true, ConvertedFunctions.patternChecker(ConvertedFunctions.vowelPattern, "i"));
		assertEquals(true, ConvertedFunctions.patternChecker(ConvertedFunctions.vowelPattern, "o"));
		assertEquals(true, ConvertedFunctions.patternChecker(ConvertedFunctions.vowelPattern, "u"));
		assertEquals(false, ConvertedFunctions.patternChecker(ConvertedFunctions.vowelPattern, "b"));
		assertEquals(false, ConvertedFunctions.patternChecker(ConvertedFunctions.vowelPattern, "!"));

		assertEquals(true, ConvertedFunctions.patternChecker(ConvertedFunctions.consonantPattern, "b"));
		assertEquals(true, ConvertedFunctions.patternChecker(ConvertedFunctions.consonantPattern, "d"));
		assertEquals(true, ConvertedFunctions.patternChecker(ConvertedFunctions.consonantPattern, "g"));
		assertEquals(true, ConvertedFunctions.patternChecker(ConvertedFunctions.consonantPattern, "h"));
		assertEquals(true, ConvertedFunctions.patternChecker(ConvertedFunctions.consonantPattern, "z"));
		assertEquals(false, ConvertedFunctions.patternChecker(ConvertedFunctions.consonantPattern, "a"));
		assertEquals(false, ConvertedFunctions.patternChecker(ConvertedFunctions.consonantPattern, "!"));

		assertEquals(true, ConvertedFunctions.patternChecker(ConvertedFunctions.operatorPattern, "+"));
		assertEquals(true, ConvertedFunctions.patternChecker(ConvertedFunctions.operatorPattern, "*"));
		assertEquals(false, ConvertedFunctions.patternChecker(ConvertedFunctions.operatorPattern, "z"));
	}

	@Test
	public void testExtractStudentDetails() {
		String input = "1234567CHIBAKA FCCS55M";
		StudentDetails studentDts = ConvertedFunctions.extractStudentDetails(input);
		assertEquals(1234567, studentDts.getStudentId());
		assertEquals("CHIBAKA ", studentDts.getSurname());
		assertEquals("FC", studentDts.getInitials());
		assertEquals("CS55", studentDts.getCourseCode());
		assertEquals("M", studentDts.getGender());

		input = null;
		studentDts = ConvertedFunctions.extractStudentDetails(input);
		assertEquals(0, studentDts.getStudentId());
		assertEquals(null, studentDts.getSurname());
		assertEquals(null, studentDts.getInitials());
		assertEquals(null, studentDts.getCourseCode());
		assertEquals(null, studentDts.getGender());
	}

}
