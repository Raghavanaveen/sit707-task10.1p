// OnTrackTest.java

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OnTrackTest {
    private OnTrack onTrack;

    @Before
    public void setUp() {
        onTrack = new OnTrack();
    }

    @Test
    public void testSubmitTask() {
        assertEquals("Task submitted successfully.", onTrack.submitTask(1, 101, "Write an essay"));
        assertEquals("Write an essay", onTrack.getTask(1, 101));
    }

    @Test
    public void testGetTaskNotFound() {
        assertEquals("Task not found.", onTrack.getTask(1, 101));
    }

    @Test
    public void testProvideFeedback() {
        onTrack.submitTask(1, 101, "Write an essay");
        assertEquals("Feedback provided successfully.", onTrack.provideFeedback(1, 101, "Good work!"));
        assertEquals("Good work!", onTrack.getFeedback(1, 101));
    }

    @Test
    public void testGetFeedbackNotFound() {
        assertEquals("Feedback not found.", onTrack.getFeedback(1, 101));
    }
}
