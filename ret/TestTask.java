
import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class TestTask {

    @Test
    public void testTaskCreation() {
        Task myTask = new Task();
        assertEquals("", myTask.getName());
        assertEquals("", myTask.getDescription());
        assertEquals(Integer.valueOf(0), myTask.getPercent());
        assertEquals(Integer.valueOf(0), myTask.getLevel());
        assertEquals(new ArrayList<Integer>(), myTask.getHours());
        assertEquals(new ArrayList<Integer>(), myTask.getCalculatedHours());
        assertEquals(new ArrayList<Task>(), myTask.getSubtasks());
    }

    @Test
    public void testTaskSetNameMethod() {
        Task myTask = new Task();
        assertEquals("", myTask.getName());
        myTask.setName("Name");
        assertEquals("Name", myTask.getName());
        assertEquals("", myTask.getDescription());
        assertEquals(Integer.valueOf(0), myTask.getPercent());
        assertEquals(Integer.valueOf(0), myTask.getLevel());
        assertEquals(new ArrayList<Integer>(), myTask.getHours());
        assertEquals(new ArrayList<Task>(), myTask.getSubtasks());
    }

    @Test
    public void testTaskSetDescriptionMethod() {
        Task myTask = new Task();
        assertEquals("", myTask.getDescription());
        myTask.setDescription("This is a description");
        assertEquals("This is a description", myTask.getDescription());
        assertEquals("", myTask.getName());
        assertEquals(Integer.valueOf(0), myTask.getPercent());
        assertEquals(Integer.valueOf(0), myTask.getLevel());
        assertEquals(new ArrayList<Integer>(), myTask.getHours());
        assertEquals(new ArrayList<Task>(), myTask.getSubtasks());
    }

    @Test
    public void testTaskSetPercentMethod() {
        Task myTask = new Task();
        assertEquals(Integer.valueOf(0), myTask.getPercent());
        myTask.setPercent(Integer.valueOf(25));
        assertEquals(Integer.valueOf(25), myTask.getPercent());
        assertEquals("", myTask.getName());
        assertEquals("", myTask.getDescription());
        assertEquals(Integer.valueOf(0), myTask.getLevel());
        assertEquals(new ArrayList<Integer>(), myTask.getHours());
        assertEquals(new ArrayList<Task>(), myTask.getSubtasks());
    }

    @Test
    public void testTaskSetLevelMethod() {
        Task myTask = new Task();
        assertEquals(Integer.valueOf(0), myTask.getLevel());
        myTask.setLevel(Integer.valueOf(5));
        assertEquals(Integer.valueOf(5), myTask.getLevel());
        assertEquals("", myTask.getName());
        assertEquals("", myTask.getDescription());
        assertEquals(Integer.valueOf(0), myTask.getPercent());
        assertEquals(new ArrayList<Integer>(), myTask.getHours());
        assertEquals(new ArrayList<Task>(), myTask.getSubtasks());
    }

    @Test
    public void testTaskSetHoursMethodWithPercentEqualToZero() {
        Task myTask = new Task();
        ArrayList<Integer> expectedHours = new ArrayList<Integer>();
        expectedHours.add(0);
        expectedHours.add(0);
        expectedHours.add(0);
        ArrayList<Integer> inputHours = new ArrayList<Integer>();
        inputHours.add(100);
        inputHours.add(200);
        inputHours.add(300);
        myTask.setHours(inputHours);
        assertEquals(inputHours, myTask.getHours());
        assertEquals(expectedHours, myTask.getCalculatedHours());

        assertEquals(Integer.valueOf(0), myTask.getLevel());
        assertEquals("", myTask.getName());
        assertEquals("", myTask.getDescription());
        assertEquals(Integer.valueOf(0), myTask.getPercent());
        assertEquals(new ArrayList<Task>(), myTask.getSubtasks());
    }

    @Test
    public void testTaskSetHoursMethodWithPercentEqualTo33() {
        Task myTask = new Task();
        myTask.setPercent(33);

        ArrayList<Integer> expectedHours = new ArrayList<Integer>();
        expectedHours.add(33);
        expectedHours.add(66);
        expectedHours.add(99);
        ArrayList<Integer> inputHours = new ArrayList<Integer>();
        inputHours.add(100);
        inputHours.add(200);
        inputHours.add(300);
        myTask.setHours(inputHours);
        assertEquals(inputHours, myTask.getHours());
        assertEquals(expectedHours, myTask.getCalculatedHours());

        assertEquals(Integer.valueOf(0), myTask.getLevel());
        assertEquals("", myTask.getName());
        assertEquals("", myTask.getDescription());
        assertEquals(Integer.valueOf(33), myTask.getPercent());
        assertEquals(new ArrayList<Task>(), myTask.getSubtasks());
    }

    @Test
    public void testTaskSetHoursMethodWithPercentEqualTo50() {
        Task myTask = new Task();
        myTask.setPercent(50);

        ArrayList<Integer> expectedHours = new ArrayList<Integer>();
        expectedHours.add(50);
        expectedHours.add(100);
        expectedHours.add(150);
        ArrayList<Integer> inputHours = new ArrayList<Integer>();
        inputHours.add(100);
        inputHours.add(200);
        inputHours.add(300);
        myTask.setHours(inputHours);
        assertEquals(inputHours, myTask.getHours());
        assertEquals(expectedHours, myTask.getCalculatedHours());

        assertEquals(Integer.valueOf(0), myTask.getLevel());
        assertEquals("", myTask.getName());
        assertEquals("", myTask.getDescription());
        assertEquals(Integer.valueOf(50), myTask.getPercent());
        assertEquals(new ArrayList<Task>(), myTask.getSubtasks());
    }

    @Test
    public void testTaskSetHoursMethodWithPercentEqualTo100() {
        Task myTask = new Task();
        myTask.setPercent(100);

        ArrayList<Integer> expectedHours = new ArrayList<Integer>();
        expectedHours.add(100);
        expectedHours.add(200);
        expectedHours.add(300);
        ArrayList<Integer> inputHours = new ArrayList<Integer>();
        inputHours.add(100);
        inputHours.add(200);
        inputHours.add(300);
        myTask.setHours(inputHours);
        assertEquals(inputHours, myTask.getHours());
        assertEquals(expectedHours, myTask.getCalculatedHours());

        assertEquals(Integer.valueOf(0), myTask.getLevel());
        assertEquals("", myTask.getName());
        assertEquals("", myTask.getDescription());
        assertEquals(Integer.valueOf(100), myTask.getPercent());
        assertEquals(new ArrayList<Task>(), myTask.getSubtasks());
    }

    public static void main(String args[]) {
        org.junit.runner.JUnitCore.main("TestTask");
    }
}
