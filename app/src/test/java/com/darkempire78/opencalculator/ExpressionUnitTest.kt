package com.darkempire78.opencalculator

import org.junit.Assert.assertEquals
import org.junit.BeforeClass
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExpressionUnitTest {
    @Test
    fun percentage_isCorrect() {
        var result = calculate("100*95%")
        assertEquals(95.0, result, 0.0)

        result = calculate("(10*10)*95%")
        assertEquals(95.0, result, 0.0)

        result = calculate("100*100%")
        assertEquals(100.0, result, 0.0)

        result = calculate("100*100/100*100%")
        assertEquals(100.0, result, 0.0)
    }

    @Test
    fun addition_isCorrect() {
        var result = calculate("1+1")
        assertEquals(2.0, result, 0.0)

        result = calculate("(1+1)+1")
        assertEquals(3.0, result, 0.0)
    }

    @Test
    fun subtraction_isCorrect() {
        var result = calculate("1-1")
        assertEquals(0.0, result, 0.0)

        result = calculate("1-1-1")
        assertEquals(-1.0, result, 0.0)
    }

    private fun calculate(input: String) = calculator.evaluate(expression.getCleanExpression(input), false)

    companion object {
        private lateinit var expression: Expression
        private lateinit var calculator: Calculator

        @BeforeClass
        @JvmStatic fun setup() {
            expression = Expression()
            calculator = Calculator()
        }
    }
}
