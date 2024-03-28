package tasks.controller;

import org.junit.jupiter.api.Test;
import tasks.model.Task;
import tasks.controller.NewEditController;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {
    private String descriere;
    private int interval;

    @Test
    public void testCreateTaskECP() throws Exception {
        NewEditController ctr = new NewEditController();
        SimpleDateFormat sdf = Task.getDateFormat();

        Task t1 = ctr.makeTask("sala", sdf.parse("2011-11-11 11:00"), sdf.parse("2012-12-12 12:00"), 2);
        assertEquals(t1.getTitle(), "sala");

        assertThrows(Exception.class, () -> {
            Task t2 = ctr.makeTask(" ", sdf.parse("2011-11-11 11:00"), sdf.parse("2012-12-12 12:00"), 2);
        });

        assertThrows(Exception.class, () -> {
            Task t3 = ctr.makeTask("sala", sdf.parse("2011-11-11 11:00"), sdf.parse("2012-12-12 12:00"), -2);
        });

        assertThrows(Exception.class, () -> {
            Task t4 = ctr.makeTask(" ", sdf.parse("2011-11-11 11:00"), sdf.parse("2012-12-12 12:00"), -2);
        });
    }

    @Test
    public void testCreateTaskBVA() throws Exception {
        NewEditController ctr = new NewEditController();
        SimpleDateFormat sdf = Task.getDateFormat();

        Task t2 = ctr.makeTask("sala", sdf.parse("2011-11-11 11:00"), sdf.parse("2012-12-12 12:00"), 2);
        assertEquals(t2.getTitle(), "sala");

        assertThrows(Exception.class, () -> {
            Task t1 = ctr.makeTask(" ", sdf.parse("2011-11-11 11:00"), sdf.parse("2012-12-12 12:00"), 2);
        });

        assertThrows(Exception.class, () -> {
            Task t3 = ctr.makeTask("sala", sdf.parse("2011-11-11 11:00"), sdf.parse("2012-12-12 12:00"), -1);
        });

        Task t4 = ctr.makeTask("sala", sdf.parse("2011-11-11 11:00"), sdf.parse("2012-12-12 12:00"), 1);
        assertEquals(t4.getRepeatInterval(), 1);
    }
}