package StepikTasks.Stepik6.S6_4.S6_4_4;

public abstract class Mail<T> {
    private final String from;
    private final String to;
    private final T content;

    public Mail(String from, String to, T content) {
        this.from = from;
        this.to = to;
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public T getContent() {
        return content;
    }
}
