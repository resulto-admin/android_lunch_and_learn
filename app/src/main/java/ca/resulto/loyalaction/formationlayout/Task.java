package ca.resulto.loyalaction.formationlayout;

/**
 * Created by ttauveron on 25/05/15.
 */
public class Task {

    private String name;
    private Priority priority;
    private int estimatedTime;


    public Task(String name, Priority priority, int estimatedTime) {
        this.name = name;
        this.priority = priority;
        this.estimatedTime = estimatedTime;
    }

    public String getName() {
        return name;
    }

    public Priority getPriority() {
        return priority;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }
}
