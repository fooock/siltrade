package com.fooock.core;

import com.fooock.core.exception.NotANumberException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class NumberTest {

    @Test(expected = NotANumberException.class)
    public void testSumThrowException() throws Exception {
        new Number("123.134234").sum(null);
    }

    @Test(expected = NotANumberException.class)
    public void testMinusThrowException() throws Exception {
        new Number("9.2340234").minus(null);
    }

    @Test
    public void testSum() throws Exception {
        final Number n1 = new Number("1.233");
        final Number n2 = new Number("11.2");
        final Number expected = new Number("12.433");
        assertEquals(expected, n1.sum(n2));
    }

    @Test
    public void testMinus() throws Exception {
        final Number n1 = new Number("112.23356");
        final Number n2 = new Number("11.122");
        final Number expected = new Number("101.11156");
        assertEquals(expected, n1.minus(n2));
    }

    @Test
    public void testSumByZero() throws Exception {
        final Number n1 = new Number("0.00");
        final Number n2 = new Number("0.0");
        final Number expected = new Number("0");
        assertEquals(expected, n1.sum(n2));
    }

    @Test
    public void testMinusByZero() throws Exception {
        final Number n1 = new Number("0.00");
        final Number n2 = new Number("0.0");
        final Number expected = new Number("0.0");
        assertEquals(expected, n1.minus(n2));
    }
}
