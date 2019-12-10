
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
        assertEquals(new ArrayList<Integer>(), myTask.getCalculatedHours());
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
        assertEquals(new ArrayList<Integer>(), myTask.getCalculatedHours());
        assertEquals(new ArrayList<Task>(), myTask.getSubtasks());
    }

    @Test
    public void testTaskSetPercentMethodWithoutHoursSet() {
        Task myTask = new Task();
        assertEquals(Integer.valueOf(0), myTask.getPercent());
        myTask.setPercent(Integer.valueOf(25));
        assertEquals(Integer.valueOf(25), myTask.getPercent());
        assertEquals("", myTask.getName());
        assertEquals("", myTask.getDescription());
        assertEquals(Integer.valueOf(0), myTask.getLevel());
        assertEquals(new ArrayList<Integer>(), myTask.getHours());
        assertEquals(new ArrayList<Integer>(), myTask.getCalculatedHours());
        assertEquals(new ArrayList<Task>(), myTask.getSubtasks());
    }

    @Test
    public void testTaskSetPercentMethodWithHoursSet() {
        Task myTask = new Task();
        assertEquals(Integer.valueOf(0), myTask.getPercent());
        myTask.setPercent(Integer.valueOf(25));
        assertEquals(Integer.valueOf(25), myTask.getPercent());

        ArrayList<Integer> expectedHours = new ArrayList<Integer>();
        expectedHours.add(25);
        expectedHours.add(50);
        expectedHours.add(75);
        ArrayList<Integer> inputHours = new ArrayList<Integer>();
        inputHours.add(100);
        inputHours.add(200);
        inputHours.add(300);
        myTask.setHours(inputHours);
        assertEquals(inputHours, myTask.getHours());
        assertEquals(expectedHours, myTask.getCalculatedHours());

        myTask.setPercent(Integer.valueOf(50));
        expectedHours.clear();
        expectedHours.add(50);
        expectedHours.add(100);
        expectedHours.add(150);
        assertEquals(inputHours, myTask.getHours());
        assertEquals(expectedHours, myTask.getCalculatedHours());

        assertEquals("", myTask.getName());
        assertEquals("", myTask.getDescription());
        assertEquals(Integer.valueOf(0), myTask.getLevel());
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
        assertEquals(new ArrayList<Integer>(), myTask.getCalculatedHours());
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
        assertEquals(new ArrayList<Integer>(), myTask.getCalculatedHours());
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

    @Test
    public void testTaskAddSubtaskMethod() {
        Task topTask = new Task();
        topTask.setName("Top Task");
        Task subTask1 = new Task();
        subTask1.setName("SubTask 1");
        Task subTask2 = new Task();
        subTask2.setName("SubTask 2");
        Task subTask3 = new Task();
        subTask3.setName("SubTask 3");

        topTask.addSubtask(subTask1);
        topTask.addSubtask(subTask2);
        topTask.addSubtask(subTask3);

        ArrayList<Task> expectedTasks = new ArrayList<Task>();
        expectedTasks.add(subTask1);
        expectedTasks.add(subTask2);
        expectedTasks.add(subTask3);

        assertEquals(expectedTasks, topTask.getSubtasks());
    }

    @Test
    public void testTaskgetRecursiveSubtasksMethod() {
        Task topTask = new Task();
        topTask.setName("Top Task");
        Task subTask1 = new Task();
        subTask1.setName("SubTask 1");
        Task subTask2 = new Task();
        subTask2.setName("SubTask 2");
        Task subTask3 = new Task();
        subTask3.setName("SubTask 3");

        topTask.addSubtask(subTask1);
        subTask1.addSubtask(subTask2);
        subTask2.addSubtask(subTask3);

        ArrayList<Task> expectedTasks = new ArrayList<Task>();
        expectedTasks.add(topTask);
        expectedTasks.add(subTask1);
        expectedTasks.add(subTask2);
        expectedTasks.add(subTask3);

        assertEquals(expectedTasks, topTask.getRecursiveSubtasks());
    }

    @Test
    public void testTaskgetRecursiveSubtasksMethodWithMultipleLevelsOfHeirarchy() {
        Task topTask = new Task();
        topTask.setName("Top Task");
        Task subTask1 = new Task();
        subTask1.setName("SubTask 1");
        Task subTask1_1 = new Task();
        subTask1_1.setName("SubTask 1_1");
        Task subTask1_2 = new Task();
        subTask1_2.setName("SubTask 1_2");
        Task subTask2 = new Task();
        subTask2.setName("SubTask 2");
        Task subTask2_1 = new Task();
        subTask2_1.setName("SubTask 2_1");
        Task subTask2_1_1 = new Task();
        subTask2_1_1.setName("SubTask 2_1_1");
        Task subTask3 = new Task();
        subTask3.setName("SubTask 3");
        Task subTask3_1 = new Task();
        subTask3_1.setName("SubTask 3_1");
        Task subTask3_1_1 = new Task();
        subTask3_1_1.setName("SubTask 3_1_1");
        Task subTask3_2 = new Task();
        subTask3_2.setName("SubTask 3_2");

        topTask.addSubtask(subTask1);
        subTask1.addSubtask(subTask1_1);
        subTask1.addSubtask(subTask1_2);
        topTask.addSubtask(subTask2);
        subTask2.addSubtask(subTask2_1);
        subTask2_1.addSubtask(subTask2_1_1);
        topTask.addSubtask(subTask3);
        subTask3.addSubtask(subTask3_1);
        subTask3.addSubtask(subTask3_2);
        subTask3_1.addSubtask(subTask3_1_1);

        ArrayList<Task> expectedTasks = new ArrayList<Task>();
        expectedTasks.add(topTask);
        expectedTasks.add(subTask1);
        expectedTasks.add(subTask1_1);
        expectedTasks.add(subTask1_2);
        expectedTasks.add(subTask2);
        expectedTasks.add(subTask2_1);
        expectedTasks.add(subTask2_1_1);
        expectedTasks.add(subTask3);
        expectedTasks.add(subTask3_1);
        expectedTasks.add(subTask3_1_1);
        expectedTasks.add(subTask3_2);

        assertEquals(expectedTasks, topTask.getRecursiveSubtasks());
    }

    public static void main(String args[]) {
        org.junit.runner.JUnitCore.main("TestTask");
    }
}
