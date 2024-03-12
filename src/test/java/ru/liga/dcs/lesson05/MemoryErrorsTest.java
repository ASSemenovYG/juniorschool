package ru.liga.dcs.lesson05;

import junit.framework.TestCase;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MemoryErrorsTest extends TestCase {

    private final MemoryErrors memoryErrors = new MemoryErrors();

    public void testCreateOomError() {
        Throwable thrown = catchThrowable(memoryErrors::createOomError);
        assertThat(thrown).isInstanceOf(OutOfMemoryError.class);
    }

    public void testCreateStackOverflowError() {
        Throwable thrown = catchThrowable(memoryErrors::createStackOverflowError);
        assertThat(thrown).isInstanceOf(StackOverflowError.class);
    }
}