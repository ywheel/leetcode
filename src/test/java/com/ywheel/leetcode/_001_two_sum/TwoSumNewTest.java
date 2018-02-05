package com.ywheel.leetcode._001_two_sum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ywheel on 2018/2/5.
 */
public class TwoSumNewTest {
    private TwoSumNew twoSumNew;

    @Before
    public void setup() {
        twoSumNew = new TwoSumNew();
    }

    @Test
    public void test() {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] expect = {0, 1};
        int[] result = twoSumNew.twoSum(numbers, target);
        Assert.assertArrayEquals(expect, result);
    }

}
