package pokergame;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class FaceValueTest
{
    @Test
    public void givenEnumDeclarationOrderExpectRanking()
    {
        FaceValue[] a = FaceValue.values();
        FaceValue[] b = Arrays.copyOfRange(a, 1, a.length);

        for (int i = 0; i < a.length - 1; i++)
        {
            Assert.assertTrue(a[i] + " should be less than " + b[i], a[i].compareTo(b[i]) < 0);
        };
    }

    @Test
    public void givenEnumDeclarationOrderExpectRanking2()
    {
        FaceValue[] a = FaceValue.values();
        FaceValue[] b = Arrays.copyOfRange(a, 0, a.length - 1);

        for (int i = 1; i < a.length; i++)
        {
            Assert.assertTrue(a[i] + " should be greater than " + b[i - 1], a[i].compareTo(b[i - 1]) > 0);
        };
    }

    @Test
    public void givenEnumDeclarationOrderExpectRanking3()
    {
        FaceValue[] a = FaceValue.values();
        FaceValue[] b = Arrays.copyOfRange(a, 0, a.length);

        for (int i = 0; i < a.length; i++)
        {
            Assert.assertTrue(a[i] + " should be equal to " + b[i], a[i].compareTo(b[i]) == 0);
        };
    }
}
