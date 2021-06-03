package eu.ensup.etablissementscolaire;

import eu.ensup.etablissementscolaire.exception.etudiantExceptions.GetEtudiantServiceException;
import eu.ensup.etablissementscolaire.exceptions.DaoException;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.hamcrest.Matchers.equalTo;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */

@ExtendWith(MockitoExtension.class)
public class ServiceTest
{

    @Mock
    List mockedList;

    @Test
    public void mockArrayList() {
        mockedList.add("one");
        Mockito.verify(mockedList).add("one");
        MatcherAssert.assertThat(0, equalTo(spyList.size()) );
    }

    @Spy
    ArrayList spyList = new ArrayList();
    @Test
    public void spyArrayList() {
        spyList.add("one");
        Mockito.verify(spyList).add("one");

        MatcherAssert.assertThat(1, equalTo(spyList.size()) );
    }


}