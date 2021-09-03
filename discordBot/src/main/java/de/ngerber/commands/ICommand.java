package de.ngerber.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public interface ICommand
{
    boolean called(String[] args, MessageReceivedEvent event);
    void action(String[] args, MessageReceivedEvent event);
    void executed(String[] args, MessageReceivedEvent event, boolean performed);
    String help();
}
