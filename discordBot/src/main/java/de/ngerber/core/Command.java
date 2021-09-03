package de.ngerber.core;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Command
{
    private final String raw;
    private final String[] args;
    private final String invoke;
    private final MessageReceivedEvent event;

    public Command(String raw, String[] args, String invoke, MessageReceivedEvent event)
    {
        this.raw = raw;
        this.args = args;
        this.invoke = invoke;
        this.event = event;
    }

    public String getRaw()
    {
        return raw;
    }

    public String[] getArgs()
    {
        return args;
    }

    public String getInvoke()
    {
        return invoke;
    }

    public MessageReceivedEvent getEvent()
    {
        return event;
    }
}
