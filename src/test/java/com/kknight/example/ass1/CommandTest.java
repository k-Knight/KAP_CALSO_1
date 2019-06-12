package com.kknight.example.ass1;

//Java
import java.lang.*;
import java.util.*;
//JTestCase
import org.jtestcase.JTestCase;
import org.jtestcase.JTestCaseException;
import org.jtestcase.TestCaseInstance;
//JUnit
import org.jtestcase.util.MultiKeyHashtable;
import org.junit.Test;
import org.junit.BeforeClass;
import static org.junit.Assert.*;


public class CommandTest {
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

    @BeforeClass static public void loadTestCases () {
        try {
            String dataFile = "./testCases/CommandTest.xml";
            m_jtestcase = new JTestCase(dataFile, "Command");
        } catch (Exception e) {
            e.printStackTrace();
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

                Command result = new Command((String)params.get("command_str"));
                boolean succeed = testCase.assertTestVariable("result", result.toString());
                assertTrue (testCase.getFailureReason(), succeed);
            }
            catch (JTestCaseException e) {
                e.printStackTrace();
                fail("Error in running the test case");
            }
        }
    }

    @Test public void parseAction() {
        if (m_jtestcase == null)
            fail("Error in loading the test cases");

        Vector testCases = getTestCases("parseAction");

        for (int i = 0; i < testCases.size(); i++) {
            TestCaseInstance testCase = (TestCaseInstance)testCases.elementAt(i);
            try {
                HashMap params = testCase.getTestCaseParams();

                String result = Command.parseAction((String)params.get("action_string")).toString();
                boolean succeed = testCase.assertTestVariable("result", result);
                assertTrue (testCase.getFailureReason(), succeed);
            }
            catch (JTestCaseException e) {
                e.printStackTrace();
                fail("Error in running the test case");
            }
        }
    }

    @Test public void CommandConstructor() {
        if (m_jtestcase == null)
            fail("Error in loading the test cases");

        Vector testCases = getTestCases("CommandConstructor");

        for (int i = 0; i < testCases.size(); i++) {
            TestCaseInstance testCase = (TestCaseInstance)testCases.elementAt(i);
            try {
                HashMap params = testCase.getTestCaseParams();

                Command result = new Command((String)params.get("action_string"));

                boolean succeeded =
                    testCase.assertTestVariable("command", result.type.toString()) &&
                    testCase.assertTestVariable("parameter", result.argument) &&
                    testCase.assertTestVariable("error_msg", result.error);

                assertTrue (testCase.getFailureReason(), succeeded);
            }
            catch (JTestCaseException e) {
                e.printStackTrace();
                fail("Error in running the test case");
            }
        }
    }
}
