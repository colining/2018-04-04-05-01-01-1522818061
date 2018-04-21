package tw.controllers;

import org.junit.Before;
import org.junit.Test;
import tw.commands.GuessInputCommand;
import tw.core.Answer;
import tw.core.Game;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.generator.AnswerGenerator;
import tw.core.generator.RandomIntGenerator;
import tw.views.GameView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * 在GameControllerTest文件中完成GameController中对应的单元测试
 */
public class GameControllerTest {
    private GameController gameController = null;
    private Game game = null;
    private AnswerGenerator answerGenerator = null;
    private RandomIntGenerator randomIntGenerator = null;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        randomIntGenerator = new RandomIntGenerator();
        answerGenerator = new AnswerGenerator(randomIntGenerator);
        game = new Game(answerGenerator);
        GameView view = new GameView();
        gameController = new GameController(game, view);
        System.setOut(new PrintStream(outContent));

    }

    @Test
    public void beginGame() {
        try {
            gameController.beginGame();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(systemOut()).isEqualTo("------Guess Number Game, You have 6 chances to guess!  ------\n");
    }

    @Test
    public void play_success() throws IOException, OutOfRangeAnswerException {
        GuessInputCommand guessInputCommand = mock(GuessInputCommand.class);
        Answer answer = new Answer();
        answer.setNumList(Arrays.asList("1", "2", "3", "4"));
        when(guessInputCommand.input()).thenReturn(answer);

        randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.generateNums(9, 4)).thenReturn("1 2 3 4");
        answerGenerator = new AnswerGenerator(randomIntGenerator);
        game = new Game(answerGenerator);
        GameView view = new GameView();
        gameController = new GameController(game, view);
        gameController.play(guessInputCommand);
        assertThat(systemOut()).isEqualTo("Guess Result: 4A0B\n" +
                "Guess History:\n" +
                "[Guess Numbers: 1 2 3 4, Guess Result: 4A0B]\n" +
                "Game Status: success\n");
    }


    @Test
    public void play_fail() throws IOException, OutOfRangeAnswerException {
        GuessInputCommand guessInputCommand = mock(GuessInputCommand.class);
        Answer answer = new Answer();
        answer.setNumList(Arrays.asList("1", "2", "3", "4"));
        when(guessInputCommand.input()).thenReturn(answer);

        randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.generateNums(9, 4)).thenReturn("2 3 4 5");
        answerGenerator = new AnswerGenerator(randomIntGenerator);
        game = new Game(answerGenerator);
        GameView view = new GameView();
        gameController = new GameController(game, view);
        gameController.play(guessInputCommand);
        assertThat(systemOut()).isEqualTo("Guess Result: 0A3B\n" +
                "Guess History:\n" +
                "[Guess Numbers: 1 2 3 4, Guess Result: 0A3B]\n" +
                "Guess Result: 0A3B\n" +
                "Guess History:\n" +
                "[Guess Numbers: 1 2 3 4, Guess Result: 0A3B]\n" +
                "[Guess Numbers: 1 2 3 4, Guess Result: 0A3B]\n" +
                "Guess Result: 0A3B\n" +
                "Guess History:\n" +
                "[Guess Numbers: 1 2 3 4, Guess Result: 0A3B]\n" +
                "[Guess Numbers: 1 2 3 4, Guess Result: 0A3B]\n" +
                "[Guess Numbers: 1 2 3 4, Guess Result: 0A3B]\n" +
                "Guess Result: 0A3B\n" +
                "Guess History:\n" +
                "[Guess Numbers: 1 2 3 4, Guess Result: 0A3B]\n" +
                "[Guess Numbers: 1 2 3 4, Guess Result: 0A3B]\n" +
                "[Guess Numbers: 1 2 3 4, Guess Result: 0A3B]\n" +
                "[Guess Numbers: 1 2 3 4, Guess Result: 0A3B]\n" +
                "Guess Result: 0A3B\n" +
                "Guess History:\n" +
                "[Guess Numbers: 1 2 3 4, Guess Result: 0A3B]\n" +
                "[Guess Numbers: 1 2 3 4, Guess Result: 0A3B]\n" +
                "[Guess Numbers: 1 2 3 4, Guess Result: 0A3B]\n" +
                "[Guess Numbers: 1 2 3 4, Guess Result: 0A3B]\n" +
                "[Guess Numbers: 1 2 3 4, Guess Result: 0A3B]\n" +
                "Guess Result: 0A3B\n" +
                "Guess History:\n" +
                "[Guess Numbers: 1 2 3 4, Guess Result: 0A3B]\n" +
                "[Guess Numbers: 1 2 3 4, Guess Result: 0A3B]\n" +
                "[Guess Numbers: 1 2 3 4, Guess Result: 0A3B]\n" +
                "[Guess Numbers: 1 2 3 4, Guess Result: 0A3B]\n" +
                "[Guess Numbers: 1 2 3 4, Guess Result: 0A3B]\n" +
                "[Guess Numbers: 1 2 3 4, Guess Result: 0A3B]\n" +
                "Game Status: fail\n");
    }

    private String systemOut() {
        return outContent.toString();
    }
}