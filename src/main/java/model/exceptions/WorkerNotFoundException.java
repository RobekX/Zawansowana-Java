package model.exceptions;

public class WorkerNotFoundException extends RuntimeException {
    public WorkerNotFoundException(Integer id) {
        super("Could not find worker " + id);
    }
}
