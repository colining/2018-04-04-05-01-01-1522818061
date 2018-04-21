package tw.core;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tw.core.generator.RandomIntGenerator;

/**
 * 在RandomIntGeneratorTest文件中完成RandomIntGenerator中对应的单元测试
 */
public class RandomIntGeneratorTest {
    RandomIntGenerator randomIntGenerator = null;
    @Before
    public void setup() {
        randomIntGenerator = new RandomIntGenerator();
    }

    @Test
    public void generateNums_numberOfNeed() {
        Assert.assertEquals(7, randomIntGenerator.generateNums(9, 4).length());
        Assert.assertEquals(17, randomIntGenerator.generateNums(9, 9).length());
    }
}