package tasks.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import tasks.model.ArrayTaskList;
import tasks.model.Task;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ServiceTest {

    @Mock
    private Task T;

    @Mock
    private ArrayTaskList R;

    private TasksService S;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        S=new TasksService(R);
    }

    @Test
    public void Test1()
    {
        S.getIntervalInHours(T);
        verify(T, times(1)).getRepeatInterval();
    }

    @Test
    public void Test2()
    {
        Mockito.when(R.getAll()).thenReturn(Arrays.asList(T));
        assertEquals(S.getObservableList().size(),1);
    }
}
