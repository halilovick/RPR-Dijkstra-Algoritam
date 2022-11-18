package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Expression evaluator test.
 */
public class ExpressionEvaluatorTest {
    /**
     * Test 1. testing basic expressions
     * @throws Exception the exception
     */
    @Test
    void Test1() throws Exception {
        assertEquals(5, ExpressionEvaluator.evaluate("( 2 + 3 )"));
    }

    /**
     * Test 2. testing basic expressions
     * @throws Exception the exception
     */
    @Test
    void Test2() throws Exception {
        assertEquals(12, ExpressionEvaluator.evaluate("( ( 5 * 3 ) - ( 9 / 3 ) )"));
    }

    /**
     * Test 3. testing basic expressions
     * @throws Exception the exception
     */
    @Test
    void Test3() throws Exception {
        assertEquals(101, ExpressionEvaluator.evaluate("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )"));
    }

    /**
     * Test 4. tests if exception will be thrown because number is missing
     * @throws RuntimeException the runtime exception
     */
    @Test
    void Test4() throws RuntimeException {
        Assertions.assertThrows(RuntimeException.class, ()->{
        double a = ExpressionEvaluator.evaluate("( 5 + 63 +  )");
        });
    }

    /**
     * Test 5. tests if exception will be thrown because the expression is not correctly formatted
     * @throws RuntimeException the runtime exception
     */
    @Test
    void Test5() throws RuntimeException{
        Assertions.assertThrows(RuntimeException.class, ()->{
           double a = ExpressionEvaluator.evaluate("(1 + 3 * 2 + (6 / 2) )");
        });
    }

    /**
     * Test 6. tests if exception will be thrown because the expression is not correctly formatted
     * @throws RuntimeException the runtime exception
     */
    @Test
    void Test6() throws RuntimeException{
        Assertions.assertThrows(RuntimeException.class, ()->{
            double a = ExpressionEvaluator.evaluate("( ( ( ( 1 + 2 )");
        });
    }

    /**
     * Test 7. testing operator sqrt
     * @throws Exception the exception
     */
    @Test
    void Test7() throws Exception {
        assertEquals(26, ExpressionEvaluator.evaluate("( 2 * sqrt ( 169 ) )"));
    }

    /**
     * Test 8. tests if exception will be thrown because the expression is not correctly formatted
     * @throws RuntimeException the runtime exception
     */
    @Test
    void Test8() throws RuntimeException{
        Assertions.assertThrows(RuntimeException.class, ()->{
            double a = ExpressionEvaluator.evaluate("( 2    + 2 )");
        });
    }

    /**
     * Test 9. tests if exception will be thrown because the expression is not correctly formatted
     * @throws RuntimeException the runtime exception
     */
    @Test
    void Test9() throws RuntimeException{
        Assertions.assertThrows(RuntimeException.class, ()->{
            double a = ExpressionEvaluator.evaluate("( 1 + 1 + 1 )");
        });
    }

    /**
     * Test 10. testing dividing by zero.
     * @throws RuntimeException the runtime exception
     */
    @Test
    void Test10() throws RuntimeException{
        Assertions.assertThrows(RuntimeException.class, ()->{
            double a = ExpressionEvaluator.evaluate("( 1 / 0 )");
        });
    }
}