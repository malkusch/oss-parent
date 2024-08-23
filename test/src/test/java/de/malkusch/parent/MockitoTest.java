package de.malkusch.parent;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MockitoTest {

    interface AnyClass {
        void doSomething();
    }

    @Test
    public void shouldMock() {
        var mock = mock(AnyClass.class);
        mock.doSomething();
        verify(mock).doSomething();
    }
}
