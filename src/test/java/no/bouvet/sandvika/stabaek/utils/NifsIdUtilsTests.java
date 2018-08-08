package no.bouvet.sandvika.stabaek.utils;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NifsIdUtilsTests {

    @Test
    public void getNonCompactId_simpleInteger_getSameInteger(){
        //Arrange
        String inputId = "42";
        String expectedId = "42";

        //Act
        String actualId = NifsIdUtils.getNonCompactIid(inputId);

        //Assert
        Assert.assertEquals(expectedId, actualId);
    }

    @Test
    public void getNonCompactId_tePrefix_intAfterPrefix(){
        //Arrange
        String inputId = "te_42";
        String expectedId = "42";

        //Act
        String actualId = NifsIdUtils.getNonCompactIid(inputId);

        //Assert
        Assert.assertEquals(expectedId, actualId);
    }

    @Test
    public void getNonCompactId_tePrefixAndMiddleC_intAfterPrefixAndMiddleC(){
        //Arrange
        String inputId = "te_c_42";
        String expectedId = "42";

        //Act
        String actualId = NifsIdUtils.getNonCompactIid(inputId);

        //Assert
        Assert.assertEquals(expectedId, actualId);
    }
}
