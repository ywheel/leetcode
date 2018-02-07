package com.ywheel.leetcode._008_string_to_integer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ywheel on 2018/2/7.
 */
public class StringToIntegerTest {

    private StringToInteger stringToInteger;

    @Before
    public void setup() {
        stringToInteger = new StringToInteger();
    }

    @Test
    public void test() {
        Assert.assertEquals(123, stringToInteger.myAtoi("123"));
        Assert.assertEquals(-123, stringToInteger.myAtoi("-123"));
        Assert.assertEquals(Integer.MIN_VALUE, stringToInteger.myAtoi("-2147483648"));
    }
}
