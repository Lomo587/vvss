package tasks.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class TaskListTest {
    private ArrayTaskList R;

    @Mock
    private Task T;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        R = new ArrayTaskList();
    }

    @Test
    void RepoTest1()
    {
        R.add(T);
        assertEquals(R.size(),1);
    }

    @Test
    void RepoTest2()
    {
        R.add(T);
        assertEquals(R.getAll().toArray()[0],T);
    }
}
