package tasks.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tasks.model.ArrayTaskList;
import tasks.model.Task;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSR {

    @Mock
    private Task T;


    private ArrayTaskList R;

    private TasksService S;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        R=new ArrayTaskList();
        S=new TasksService(R);
    }

    @Test
    void Test1()
    {
        S.add(T);
        assertEquals(S.getObservableList().size(),1);

    }

    @Test
    void Test2()
    {
        S.add(T);
        assertEquals(S.getObservableList().toArray()[0],T);

    }
}
