package tasks.services;

import org.junit.jupiter.api.*;
import tasks.controller.NewEditController;
import tasks.model.Task;
import tasks.model.TasksOperations;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilterTasksTest {

    //se testeaza TasksOperations.incoming
    NewEditController ctr = new NewEditController();
    SimpleDateFormat sdf = Task.getDateFormat();
    Task t1 = new Task("task1", sdf.parse("2011-11-11 11:00"), sdf.parse("2012-12-12 12:00"), 2);
    Task t2 = new Task("task2", sdf.parse("2012-11-11 11:00"), sdf.parse("2013-12-12 12:00"), 2);

    public FilterTasksTest() throws Exception {
    }

    @Test
    public void Test1() throws Exception {
        List<Task> l=new ArrayList<>();
        l.add(t1);
        l.add(t2);
        TasksOperations tasksOps = new TasksOperations(l);
        Iterable<Task> filtered =tasksOps.incoming(sdf.parse("2009-11-11 11:00"),sdf.parse("2010-12-12 11:00"));
        int counter = 0;
        for (Object i : filtered) {
            counter++;
        }
        System.out.println(counter);
        assertEquals(counter,0);
    }
    @Test
    public void Test2() throws Exception {
        List<Task> l=new ArrayList<>();
        l.add(t1);
        l.add(t2);
        TasksOperations tasksOps = new TasksOperations(l);
        Iterable<Task> filtered =tasksOps.incoming(sdf.parse("2010-11-10 11:00"),sdf.parse("2011-12-12 11:00"));
        int counter = 0;
        for (Object i : filtered) {
            counter++;
        }
        System.out.println(counter);
        assertEquals(counter,1);
    }
    @Test
    public void Test3() throws Exception {
        List<Task> l=new ArrayList<>();
        l.add(t1);
        l.add(t2);
        TasksOperations tasksOps = new TasksOperations(l);
        Iterable<Task> filtered =tasksOps.incoming(sdf.parse("2011-11-10 11:00"),sdf.parse("2014-12-13 11:00"));
        int counter = 0;
        for (Object i : filtered) {
            counter++;
        }
        System.out.println(counter);
        assertEquals(counter,2);
    }
}
