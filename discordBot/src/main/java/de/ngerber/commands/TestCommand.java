package de.ngerber.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class TestCommand implements ICommand
{
    @Override
    public boolean called(String[] args, MessageReceivedEvent event)
    {
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event)
    {
        event.getTextChannel().sendMessage("Hey there").queue();
    }

    @Override
    public void executed(String[] args, MessageReceivedEvent event, boolean performed)
    {

    }


    @Override
    public String help()
    {
        return null;
    }
}
