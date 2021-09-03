package de.ngerber.listener;

import de.ngerber.commands.ICommand;
import de.ngerber.core.Command;
import de.ngerber.core.CommandParser;
import de.ngerber.data.Constants;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class CommandListener extends ListenerAdapter
{
    private HashMap<String, ICommand> commands;

    public CommandListener(HashMap<String, ICommand> commands)
    {
        this.commands = commands;
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event)
    {
        if(event.getMessage().getContentRaw().startsWith(Constants.prefix)
                && event.getMessage().getAuthor().getId() != event.getJDA().getSelfUser().getId())
        {
            handleCommand(CommandParser.parse(event.getMessage().getContentRaw(), event));
        }
    }

    private void handleCommand(Command cmd)
    {
        if(commands.containsKey(cmd.getInvoke()))
        {
            boolean performed = commands.get(cmd.getInvoke()).called(cmd.getArgs(), cmd.getEvent());
            if (performed)
                commands.get(cmd.getInvoke()).action(cmd.getArgs(),cmd.getEvent());
            commands.get(cmd.getInvoke()).executed(cmd.getArgs(), cmd.getEvent(), performed);
        }
    }
}
