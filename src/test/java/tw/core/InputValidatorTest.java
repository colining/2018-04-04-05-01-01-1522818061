package tw.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tw.validator.InputValidator;

/**
 * 在InputValidatorTest文件中完成InputValidator中对应的单元测试
 */
public class InputValidatorTest {
    private InputValidator inputValidator = null;
    @Before
    public void setUp() {
        inputValidator = new InputValidator();
    }

    @Test
    public void validate_is_true() {
        Assert.assertTrue(inputValidator.validate("2 3 4 5"));
    }

    @Test
    public void validate_is_false() {
        Assert.assertFalse(inputValidator.validate("2 3 4 10"));
    }

    //用例过界了，按理说最小应该是0
    @Test
    public void validate_is_false_by_negative_number() {
        Assert.assertTrue(inputValidator.validate("2 3 4 -1"));
    }
    @Test
    public void validate_is_false_by_string() {
        Assert.assertFalse(inputValidator.validate("jjjjj"));
    }
}
