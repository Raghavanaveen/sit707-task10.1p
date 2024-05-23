package sit707_week2;

import java.util.HashMap;
import java.util.Map;

public class OnTrack {
    private Map<Integer, Map<Integer, String>> tasks;
    private Map<Integer, Map<Integer, String>> feedback;

    public OnTrack() {
        this.tasks = new HashMap<>();
        this.feedback = new HashMap<>();
    }

    public String submitTask(int studentId, int taskId, String taskDescription) {
        tasks.putIfAbsent(studentId, new HashMap<>());
        tasks.get(studentId).put(taskId, taskDescription);
        return "Task submitted successfully.";
    }

    public String getTask(int studentId, int taskId) {
        if (tasks.containsKey(studentId) && tasks.get(studentId).containsKey(taskId)) {
            return tasks.get(studentId).get(taskId);
        }
        return "Task not found.";
    }

    public String provideFeedback(int studentId, int taskId, String feedbackText) {
        feedback.putIfAbsent(studentId, new HashMap<>());
        feedback.get(studentId).put(taskId, feedbackText);
        return "Feedback provided successfully.";
    }

    public String getFeedback(int studentId, int taskId) {
        if (feedback.containsKey(studentId) && feedback.get(studentId).containsKey(taskId)) {
            return feedback.get(studentId).get(taskId);
        }
        return "Feedback not found.";
    }
}
