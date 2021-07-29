import org.junit.jupiter.api.*;

public class TestSecond {
    @BeforeAll
    static void BeforeAll() throws InterruptedException {
//        Thread.sleep(4000);
        System.out.println("Before all");
    }

    @Test  @Disabled
    void nameAAA2() throws InterruptedException {
//        Thread.sleep(4000);
        System.out.println("Test AAA 2");
    }
    @Test
    void nameAAA3() throws InterruptedException {
//        Thread.sleep(4000);
        System.out.println("Test AAA 3");
    }

    @AfterAll
    static void nameAfterAll() throws InterruptedException {
//        Thread.sleep(4000);
        System.out.println("After all");
    }
}
