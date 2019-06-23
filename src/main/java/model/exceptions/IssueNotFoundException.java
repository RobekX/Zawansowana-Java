package model.exceptions;

public class IssueNotFoundException extends RuntimeException {
    public IssueNotFoundException(Integer id) {
        super("Could not find issue " + id);
    }
}
