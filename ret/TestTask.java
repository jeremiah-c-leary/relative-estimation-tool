
import org.junit.*;
import static org.junit.Assert.*;

//import Task.*;

public class TestTask {

    @Test
    public void testTaskCreation() {
        Task myTask = new Task();
        assertEquals("", myTask.getName());
        assertEquals("", myTask.getDescription());
        assertEquals(Integer.valueOf(0), myTask.getPercent());
        assertEquals(Integer.valueOf(0), myTask.getLevel());
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

    }
    public static void main(String args[]) {
        org.junit.runner.JUnitCore.main("TestTask");
    }
}
