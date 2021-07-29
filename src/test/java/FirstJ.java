import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Tag("111")
public class FirstJ {
    @Test
    void name1() throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("Test 1");
    }

    @Test  @Order(2)
    void name2() throws InterruptedException {
        System.out.println("Test 2");
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 5, 10 })
    void checkValue(int number) throws InterruptedException {
        System.out.println(number *2);
//        int expectedValue = number * 3;
//        Assertions.assertEquals(3, expectedValue);
    }
    @RepeatedTest(2)
    @Test @Order(1)
    void name3(RepetitionInfo repetitionInfo) throws InterruptedException {
        System.out.println("Test 3");
        System.out.println(repetitionInfo.getTotalRepetitions());
    }
}
