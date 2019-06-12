package com.kknight.example.ass1;

//Java
import java.lang.*;
import java.util.*;
//JTestCase
import org.jtestcase.JTestCase;
import org.jtestcase.JTestCaseException;
import org.jtestcase.TestCaseInstance;
//JUnit
import org.junit.Test;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

public class IntListTest {
    private static JTestCase m_jtestcase = null;

    private static Vector getTestCases(String methodName) {
        if (m_jtestcase == null)
            fail("Error in loading the test cases");

        Vector testCases = null;

        try {
            testCases = m_jtestcase.getTestCasesInstancesInMethod(methodName);

            if (testCases == null)
                fail("Test cases have not defined");
        } catch (JTestCaseException e) {
            e.printStackTrace();
            fail("Error in the test cases format");
        }

        return testCases;
    }

    private static IntList createIntList(Vector<Integer> items) {
        IntList intList = new IntList();
        for (int j = 0; j < items.size(); j++)
            intList.add(items.get(j));

        return intList;
    }

    @BeforeClass static public void loadTestCases () {
        try {
            String dataFile = "./testCases/IntListTest.xml";
            m_jtestcase = new JTestCase(dataFile, "IntList");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test public void add() {
        if (m_jtestcase == null)
            fail("Error in loading the test cases");

        Vector testCases = getTestCases("add");

        for (int i = 0; i < testCases.size(); i++) {
            TestCaseInstance testCase = (TestCaseInstance)testCases.elementAt(i);
            try {
                HashMap params = testCase.getTestCaseParams();

                Vector<Integer> contents = (Vector<Integer>)params.get("contents");
                IntList intList = new IntList();
                boolean successful = true;

                for (int j = 0; j < contents.size(); j++)
                    successful &= intList.add(contents.get(j));

                boolean succeed =
                    testCase.assertTestVariable("length", intList.length()) &&
                    testCase.assertTestVariable("cum_result", successful);
                assertTrue (testCase.getFailureReason(), succeed);
            }
            catch (JTestCaseException e) {
                e.printStackTrace();
                fail("Error in running the test case");
            }
        }
    }

    @Test public void clear() {
        if (m_jtestcase == null)
            fail("Error in loading the test cases");

        Vector testCases = getTestCases("clear");

        for (int i = 0; i < testCases.size(); i++) {
            TestCaseInstance testCase = (TestCaseInstance)testCases.elementAt(i);
            try {
                HashMap params = testCase.getTestCaseParams();

                IntList intList = createIntList((Vector<Integer>)params.get("contents"));
                boolean result = intList.clear();

                boolean succeed = testCase.assertTestVariable("length", intList.length());
                assertTrue (testCase.getFailureReason(), succeed && result);
            }
            catch (JTestCaseException e) {
                e.printStackTrace();
                fail("Error in running the test case");
            }
        }
    }

    @Test public void remove() {
        if (m_jtestcase == null)
            fail("Error in loading the test cases");

        Vector testCases = getTestCases("remove");

        for (int i = 0; i < testCases.size(); i++) {
            TestCaseInstance testCase = (TestCaseInstance)testCases.elementAt(i);
            try {
                HashMap params = testCase.getTestCaseParams();

                IntList intList = createIntList((Vector<Integer>)params.get("contents"));
                boolean result = intList.remove(new Integer((int)params.get("rm_item")));

                boolean succeed =
                    testCase.assertTestVariable("length", intList.length()) &&
                    testCase.assertTestVariable("result", result);

                assertTrue (testCase.getFailureReason(), succeed);
            }
            catch (JTestCaseException e) {
                e.printStackTrace();
                fail("Error in running the test case");
            }
        }
    }

    @Test public void toStringTest() {
        if (m_jtestcase == null)
            fail("Error in loading the test cases");

        Vector testCases = getTestCases("toString");

        for (int i = 0; i < testCases.size(); i++) {
            TestCaseInstance testCase = (TestCaseInstance)testCases.elementAt(i);
            try {
                HashMap params = testCase.getTestCaseParams();

                IntList intList = createIntList((Vector<Integer>)params.get("contents"));

                boolean succeed = testCase.assertTestVariable("result", intList.toString());
                assertTrue (testCase.getFailureReason(), succeed);
            }
            catch (JTestCaseException e) {
                e.printStackTrace();
                fail("Error in running the test case");
            }
        }
    }
}