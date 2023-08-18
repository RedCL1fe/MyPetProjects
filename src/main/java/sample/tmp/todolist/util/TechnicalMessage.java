package sample.tmp.todolist.util;

public enum TechnicalMessage {
    DELETEMESSAGE("Task deleted!");

    private final String message;

    TechnicalMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
