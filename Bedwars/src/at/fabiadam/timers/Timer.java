package at.fabiadam.timers;

public abstract class Timer {
    //Nothing to see here, just the abstract class for any Timer
    protected int taskId;

    public abstract void start();

    public abstract void stop();
}
