
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

import static junit.framework.Assert.assertEquals;

public class StateCensusAnalyserTest {

    /*
    * Test method for checking data correct or not
    * */
    @Test
    public void countingContacts() throws IOException, CensusAnalyserException {
        StateCensusAnalyser obj = new StateCensusAnalyser();
        String FILE_PATH="C:\\Users\\kmoha\\IdeaProjects\\Indian-Census\\src\\IndiaStateCensusData (3).csv";
        int times =obj.loadIndianStateCodeData(FILE_PATH);
        assertEquals(29,times);
    }
/*
* Test method to check method throwing exception when given wrong file path
* */

    @Test
    public void givingWrongFilePathThrowsException() {
        try {
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            stateCensusAnalyser.loadIndianStateCodeData("wrong path");
        } catch (CensusAnalyserException e) {
            assertEquals(e.type, CensusAnalyserException.ExceptionType.CENSUS_FILE_INCORRECT);
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
     * Test method to check method throwing exception when given wrong file format
     * */
    @Test
    public void givingWrongFileThrowsException(){
        try {
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            stateCensusAnalyser.loadIndianStateCodeData("wrong path");
        } catch (CensusAnalyserException e) {
            assertEquals(CensusAnalyserException.ExceptionType.CENSUS_INCORRECT_FILE_FORMAT,e.type);
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
     * Test method to check method throwing exception when given wrong delimeter
     * */
    @Test
    public void givingWrongDelimeterThrowsException(){
        try {
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            stateCensusAnalyser.loadIndianStateCodeData("wrong path");
        } catch (CensusAnalyserException e) {
            assertEquals(CensusAnalyserException.ExceptionType.CENSUS_WRONG_DELIMITER,e.type);
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
     * Test method to check method throwing exception when given wrong Header
     * */
    @Test
    public void givingWrongCSVHeaderThrowsException(){
        try {
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            stateCensusAnalyser.loadIndianStateCodeData("wrong path");
        } catch (CensusAnalyserException e) {
            assertEquals(CensusAnalyserException.ExceptionType.CENSUS_WRONG_HEADER,e.type);
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}