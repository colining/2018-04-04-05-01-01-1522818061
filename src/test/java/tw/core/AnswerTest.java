package tw.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.model.Record;

import java.util.Arrays;

/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {
    private Answer answer = null;
    @Before
    public void setUp() {
        answer = new Answer();
    }


    @Test
    public void createAnswer() {
        Assert.assertEquals("2 3 4 5", Answer.createAnswer("2 3 4 5").toString());
        Assert.assertEquals("", Answer.createAnswer("").toString());
        Assert.assertEquals("1234", Answer.createAnswer("1234").toString());
    }

    @Test
    public void test_validate_should_not_throw_exception() throws OutOfRangeAnswerException {
        answer.setNumList(Arrays.asList("1", "2", "3", "4","5"));
        answer.validate();
    }

    @Test(expected = NumberFormatException.class)
    public void test_validate_should_throw_exception() throws OutOfRangeAnswerException {
        answer.setNumList(Arrays.asList("1", "2", "3", "4","s"));
        answer.validate();
    }

    @Test
    public void check() {
        answer.setNumList(Arrays.asList("1", "2", "3", "4"));
        Record record = answer.check(answer);
        Assert.assertEquals(4, record.getValue()[0]);
        Assert.assertEquals(0, record.getValue()[1]);
        Answer answer1 = new Answer();
        answer1.setNumList(Arrays.asList("0", "0", "0", "0"));
        record = answer1.check(answer);
        Assert.assertEquals(0, record.getValue()[0]);
        Assert.assertEquals(0, record.getValue()[1]);
    }



    @Test
    public void getIndexOfNum() {
        answer.setNumList(Arrays.asList("1", "2", "3", "4"));
        Assert.assertEquals(1, answer.getIndexOfNum("2"));
        Assert.assertEquals(-1, answer.getIndexOfNum("5"));
    }

}