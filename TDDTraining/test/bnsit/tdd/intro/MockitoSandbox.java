package bnsit.tdd.intro;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class MockitoSandbox {
	
	@Mock
	private List<String> animals;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldVerifyInvocations() {
		animals.add("lion");
		animals.add("dog");
		animals.clear();
		
		verify(animals).add("lion");
		verify(animals).add("dog");
		verify(animals).clear();
	}

	@Test(expected = RuntimeException.class)
	public void shouldThrowException() {
		when(animals.size()).thenThrow(new RuntimeException("broken"));
		
		animals.size();
	}
	
	@Test
	public void shOouldStubAnyInvocation() {
		when(animals.get(anyInt())).thenReturn("sample element");
		
		assertEquals("sample element", animals.get(Integer.MAX_VALUE));
	}
}