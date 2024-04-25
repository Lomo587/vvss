package tasks.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tasks.model.ArrayTaskList;
import tasks.model.Task;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSRE {

    private Task T;


    private ArrayTaskList R;

    private TasksService S;

    @BeforeEach
    public void setup() throws ParseException {
        T=new Task("new task",Task.getDateFormat().parse("2023-02-12 10:10"));
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
