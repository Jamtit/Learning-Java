package swed.itacademy.project;

public class UnknownShapeException extends Exception{
    private String message;

    public UnknownShapeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
