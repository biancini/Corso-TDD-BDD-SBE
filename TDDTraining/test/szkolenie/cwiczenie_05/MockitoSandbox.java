package szkolenie.cwiczenie_05;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by Maciej Łabędzki
 * Date: 20.10.15
 */
public class MockitoSandbox {


    @Mock
    List fieldMock;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this.getClass());
    }

    @Test
    public void shouldCheckBehaviour() {

        List<String> animals = mock(List.class);

        animals.add("dog");
        animals.add("cat");
        animals.clear();
        InOrder inOrder = inOrder(animals);

        inOrder.verify(animals).add("dog");
        inOrder.verify(animals).add("cat");
        inOrder.verify(animals).clear();
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowException() {

        List<String> animals = mock(List.class);

        when(animals.size()).thenThrow(RuntimeException.class);
    }

    @Test
    public void shouldTakeAnyArgument() {

        List<String> animals = mock(List.class);
        when(animals.get(anyInt())).thenReturn("dog");

        assertEquals("dog", animals.get(44));
    }

    @Test
    public void shouldMockAnnotatedField() {

        when(this.fieldMock.get(0)).thenReturn("result");

        assertEquals("result", this.fieldMock.get(0));
    }
}
