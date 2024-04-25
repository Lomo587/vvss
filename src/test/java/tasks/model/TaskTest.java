package tasks.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.controller.NewEditController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    private Task task;

    @BeforeEach
    void setUp() {
        try {
            task=new Task("new task",Task.getDateFormat().parse("2023-02-12 10:10"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testTaskCreation() throws ParseException {
       assert task.getTitle() == "new task";
       assert task.getFormattedDateStart().equals(task.getDateFormat().format(Task.getDateFormat().parse("2023-02-12 10:10")));
    }
    @Test
    void testTaskCreation2() throws Exception {
        NewEditController ctr = new NewEditController();
        SimpleDateFormat sdf = Task.getDateFormat();

        Task t1 = ctr.makeTask("sala", sdf.parse("2011-11-11 11:00"), sdf.parse("2012-12-12 12:00"), 2);
        assertEquals(t1.getTitle(), "sala");
    }


    @AfterEach
    void tearDown() {
    }
}