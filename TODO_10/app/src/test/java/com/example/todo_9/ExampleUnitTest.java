package com.example.todo_9;

import androidx.test.filters.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)
@SmallTest
public class ExampleUnitTest {
    private calculator mCalculator;

    @Before
    public void setUp(){
        mCalculator = new calculator();
    }
    
    @Test
    public void addTwoNumber(){
        double result = mCalculator.add(1d,2d);
        assertThat(result,is(equalTo(3d)));
    }

    @Test
    public void addTwoNumberForNegative(){
        double result = mCalculator.add(1d,-2d);
        assertThat(result,is(equalTo(-1d)));
    }
    @Test
    public void addTwoNumberFloat(){
        double result = mCalculator.add(1.111f,1.111d);
        assertThat(result,is(closeTo(2.222d,0.01)));
    }

    @Test
    public void subTwoNumber(){
        double result = mCalculator.sub(5d,2d);
        assertThat(result,is(equalTo(3d)));
    }
    @Test
    public  void subWorksWithNegativeResults(){
        double result = mCalculator.sub(-5d,-2d);
        assertThat(result,is(equalTo(-3d)));
    }
    @Test
    public void mulTwoNumbers(){
        double result = mCalculator.mul(5d,5d);
        assertThat(result,is(equalTo(25d)));
    }
    @Test
    public void mulTwoNumbersZero(){
        double result = mCalculator.mul(0d,2d);
        assertThat(result,is(equalTo(0d)));
    }
    @Test
    public void divTwoNumbers(){
        double result = mCalculator.div(60d,8d);
        assertThat(result,is(closeTo(7.4999d,0.01)));
    }
    @Test
    public void divTwoNumbersZero(){
        double result = mCalculator.div(0d,8d);
        assertThat(result,is(equalTo(0d)));
    }
    @Test
    public void testDivbyZero(){
        double result = mCalculator.div(3d,0d);
        //assertThat(result,is(equalTo(3d)));
        assertEquals("Number cannot be divide by zero",true, Double.isInfinite(result));
    }


}