package tw.core.generator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tw.core.exception.OutOfRangeAnswerException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在AnswerGeneratorTest文件中完成AnswerGenerator中对应的单元测试
 */
public class AnswerGeneratorTest {
    @Before
    public void setUp() {
    }

    @Test
    public void generate() throws OutOfRangeAnswerException {
        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.generateNums(9, 4)).thenReturn("2 4 8 9");
        AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator);
        Assert.assertEquals("2 4 8 9", answerGenerator.generate().toString());
    }
}

