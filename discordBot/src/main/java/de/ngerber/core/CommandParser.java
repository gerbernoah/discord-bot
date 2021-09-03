package de.ngerber.core;

import de.ngerber.data.Constants;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CommandParser
{
    public static Command parse(String raw, MessageReceivedEvent event)
    {
        String beheaded = raw.replaceFirst(Constants.prefix,"");
        String[] splitBeheaded = beheaded.split(" ");
        String invoke = splitBeheaded[0];
        String[] args = new String[splitBeheaded.length - 1];
        for (int i = 0; i < args.length; i++)
        {
            args[i] = splitBeheaded [i + 1];
        }

        return new Command(raw, args, invoke, event);
    }
}
