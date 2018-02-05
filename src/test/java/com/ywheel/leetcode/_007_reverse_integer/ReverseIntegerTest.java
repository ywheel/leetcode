package com.ywheel.leetcode._007_reverse_integer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ywheel on 2018/2/5.
 */
public class ReverseIntegerTest {

    private ReverseInteger reverseInteger;

    @Before
    public void setup() {
        reverseInteger = new ReverseInteger();
    }

    @Test
    public void test1() {
        int input = 123;
        Assert.assertEquals(321, reverseInteger.reverse(input));
    }

    @Test
    public void test2() {
        int input = -123;
        Assert.assertEquals(-321, reverseInteger.reverse(input));
    }

    @Test
    public void test3() {
        int input = 120;
        Assert.assertEquals(21, reverseInteger.reverse(input));
    }

    @Test
    public void test4() {
        int input = 1534236469;
        Assert.assertEquals(0, reverseInteger.reverse(input));
    }

    @Test
    public void test5() {
        int input = 1463847412;
        Assert.assertEquals(2147483641, reverseInteger.reverse(input));
    }
}
