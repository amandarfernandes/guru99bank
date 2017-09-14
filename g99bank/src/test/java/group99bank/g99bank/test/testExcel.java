package group99bank.g99bank.test;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.Test;

import group99bank.g99bank.resources.Base;

public class testExcel extends Base {
	
	@Test
	public void testEF() throws IOException {
		getUserData(FILE_NAME,SHEET_NAME);
	}
}
