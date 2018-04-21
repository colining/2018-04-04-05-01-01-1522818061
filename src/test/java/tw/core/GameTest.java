package tw.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.generator.AnswerGenerator;
import tw.core.generator.RandomIntGenerator;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在GameTest文件中完成Game中对应的单元测试
 */


public class GameTest {

    private Game game = null;
    @Before
    public void setUp() {
    }

    @Test
    public void test_guess_should_return_4A0B() throws OutOfRangeAnswerException {
        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.generateNums(9, 4)).thenReturn("4 5 6 7");
        AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator);
        game = new Game(answerGenerator);
        Answer answer = new Answer();
        List<String> list = new ArrayList<>();
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        answer.setNumList(list);
        Assert.assertEquals("4A0B", game.guess(answer).getResult());
    }

    @Test
    public void test_guess_should_return_2A2B() throws OutOfRangeAnswerException {
        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.generateNums(9, 4)).thenReturn("4 5 6 7");
        AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator);
        game = new Game(answerGenerator);
        Answer answer = new Answer();
        List<String> list = new ArrayList<>();
        list.add("4");
        list.add("7");
        list.add("6");
        list.add("5");
        answer.setNumList(list);
        Assert.assertEquals("2A2B", game.guess(answer).getResult());
    }

    @Test
    public void checkContinue() throws OutOfRangeAnswerException {
        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.generateNums(9, 4)).thenReturn("4 5 6 7");
        AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator);
        game = new Game(answerGenerator);
        Answer answer = new Answer();
        List<String> list = new ArrayList<>();
        list.add("4");
        list.add("7");
        list.add("6");
        list.add("5");
        answer.setNumList(list);
        game.guess(answer);
        game.guess(answer);
        game.guess(answer);
        game.guess(answer);
        game.guess(answer);
        Assert.assertTrue(game.checkCoutinue());
        game.guess(answer);
        Assert.assertFalse(game.checkCoutinue());

    }

}
