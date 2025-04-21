package com.mycompany.app;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SqrtTest {
    private static final double DELTA = 0.00000001;
    private Sqrt sqrt;

    @Before
    public void setUp() {
        sqrt = new Sqrt(4.0);
    }

    @Test
    public void testSqrtConstructor() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(4.0, sqrt.arg, DELTA);
    }

    @Test
    public void testAverage() {
        assertEquals(2.0, sqrt.average(1.0, 3.0), DELTA);
    }

    @Test
    public void testAverageWithZero() {
        assertEquals(1.0, sqrt.average(0.0, 2.0), DELTA);
    }

    @Test
    public void testGoodTrue() {
        assertTrue(sqrt.good(2.0, 4.0));
    }

    @Test
    public void testGoodFalse() {
        assertFalse(sqrt.good(3.0, 4.0));
    }

    @Test
    public void testImprove() {
        assertEquals(2.5, sqrt.improve(4.0, 4.0), DELTA);
    }

    @Test
    public void testImproveSqrt2() {
        assertEquals(1.5, sqrt.improve(1.0, 2.0), DELTA);
    }

    @Test
    public void testIterConverged() {
        assertEquals(2.0, sqrt.iter(2.0, 4.0), DELTA);
    }

    @Test
    public void testIterNotConverged() {
        assertEquals(2.0, sqrt.iter(4.0, 4.0), DELTA);
    }

    @Test
    public void testCalcSimple() {
        assertEquals(2.0, sqrt.calc(), DELTA);
    }

    @Test
    public void testCalcZero() {
        Sqrt sqrtZero = new Sqrt(0.0);
        assertEquals(0.0, sqrtZero.calc(), DELTA);
    }

    @Test
    public void testCalcOne() {
        Sqrt sqrtOne = new Sqrt(1.0);
        assertEquals(1.0, sqrtOne.calc(), DELTA);
    }

    @Test
    public void testCalcComplex() {
        Sqrt sqrtComplex = new Sqrt(2.0);
        assertEquals(Math.sqrt(2.0), sqrtComplex.calc(), DELTA);
    }

    @Test
    public void testCalcNegativeThrowsException() {
        Sqrt sqrtNegative = new Sqrt(-1.0);
        try {
            sqrtNegative.calc();
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Cannot calculate square root of negative number", e.getMessage());
        }
    }

    @Test
    public void testCalcLargeNumber() {
        Sqrt sqrtLarge = new Sqrt(1e10);
        assertEquals(Math.sqrt(1e10), sqrtLarge.calc(), DELTA * 1e5);
    }
}