package at.fabiadam.timers;

public abstract class Timer {
    protected int taskId;

    public abstract void start();

    public abstract void stop();
}
