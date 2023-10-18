package QA_A_test_project;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringAnalyzerTest {

    @ParameterizedTest
    @MethodSource("testCases")
    public void testPrintStringPairs(TestCase testCase) {
        assertEquals(testCase.expectedOutput, captureSystemOutput(() -> StringAnalyzer.printStringPairs(testCase.input)));
    }

    private static Stream<TestCase> testCases() {
        return Stream.of(
                new TestCase(new String[]{"qwe", "wqe", "qwee", "a", "a"}, "eqw = 0, 1" + System.lineSeparator() + "a = 3, 4" + System.lineSeparator()),
                new TestCase(new String[]{"abc", "cab", "bca"}, "abc = 0, 1, 2" + System.lineSeparator()),
                new TestCase(new String[]{"xyz", "zyx", "yxz", "zxy"}, "xyz = 0, 1, 2, 3" + System.lineSeparator()),
                new TestCase(new String[]{"123", "123", "123", "123"}, "123 = 0, 1, 2, 3" + System.lineSeparator()),
                new TestCase(new String[]{"aaa", "aaa", "aaa", "aaa", "aaa", "aaa"}, "aaa = 0, 1, 2, 3, 4, 5" + System.lineSeparator())

        );

    }

    public static class TestCase {
        String[] input;
        String expectedOutput;

        TestCase(String[] input, String expectedOutput) {
            this.input = input;
            this.expectedOutput = expectedOutput;
        }
    }

    private static String captureSystemOutput(Runnable runnable) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        runnable.run();
        System.setOut(originalOut);
        return outputStream.toString();
    }
}