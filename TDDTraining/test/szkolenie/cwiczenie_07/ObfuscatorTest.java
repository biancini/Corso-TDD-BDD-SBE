package szkolenie.cwiczenie_07;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static junit.framework.Assert.assertNotNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;

/**
 * Created by Maciej Łabędzki
 * Date: 20.10.15
 */
public class ObfuscatorTest {

    @Test
    public void shouldReturnNonNullOutput() {

        StubRandomness randomness = new StubRandomness();
        Obfuscator obfuscator = new Obfuscator(new DeleteSpaces(), new PunctuationRemoval(), new RandomPunctuation(randomness), new ReplaceDiacriticalMarks(), new RandomUpperLowerCase(randomness));
        String input = "";
        String output = obfuscator.getText(input);

        assertNotNull(output);
    }

    @Test
    public void shouldCallTransformationsInProperOrder() {

        DeleteSpaces deleteSpaces = mock(DeleteSpaces.class);
        PunctuationRemoval punctuationRemoval = mock(PunctuationRemoval.class);
        RandomPunctuation randomPunctuation = mock(RandomPunctuation.class);
        ReplaceDiacriticalMarks replaceDiacriticalMarks = mock(ReplaceDiacriticalMarks.class);
        RandomUpperLowerCase randomUpperLowerCase = mock(RandomUpperLowerCase.class);

        Obfuscator obfuscator = new Obfuscator(
                deleteSpaces, punctuationRemoval, randomPunctuation, replaceDiacriticalMarks, randomUpperLowerCase);

        InOrder inOrder = Mockito.inOrder(
                deleteSpaces, punctuationRemoval, randomPunctuation, replaceDiacriticalMarks, randomUpperLowerCase);

        obfuscator.getText("something");

        inOrder.verify(deleteSpaces).doDelete("something");
        inOrder.verify(punctuationRemoval).doRemove(anyString());
        inOrder.verify(randomPunctuation).doInsert(anyString());
        inOrder.verify(replaceDiacriticalMarks).doReplace(anyString());
        inOrder.verify(randomUpperLowerCase).doReplace(anyString());
    }

}
