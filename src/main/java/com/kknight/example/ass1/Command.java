package com.kknight.example.ass1;

public class Command {
    public CommandType type;
    public int argument;
    public String error;

    public Command(String commandString) {
        this.error = parseComamnd(commandString);
    }

    @Override
    public String toString() {
        return "Action: " + type.toString() + " Param: " + argument;
    }

    public static CommandType parseAction (String actionStr) {
        switch (actionStr) {
            case "clear": return CommandType.clear;
            case "add": return CommandType.add;
            case "remove": return CommandType.remove;
            case "print": return CommandType.print;
            default: return  CommandType.undefined;
        }
    }

    public String parseComamnd(String cmdStr) {
        argument = 0;
        type = CommandType.undefined;

        if (cmdStr == null || cmdStr.length() == 0) {
            return "Error: no command provided";
        }

        String[] splitted = cmdStr.split("\\s+");
        type = parseAction(splitted[0]);

        if (type == CommandType.undefined) {
            return "Error: unrecognized command";
        }

        if (type != CommandType.clear && type != CommandType.print) {
            if (splitted.length > 1) {
                try {
                    argument = Integer.parseInt(splitted[1]);
                } catch (Exception e) {
                    type = CommandType.undefined;
                    return "Error: cannot parse parameter";
                }
            }
            else {
                type = CommandType.undefined;
                return "Error: missing parameter";
            }
        }

        if (type == CommandType.clear || type == CommandType.print) {
            if (splitted.length > 1) {
                type = CommandType.undefined;
                argument = 0;
                return  "Error: excessive parameter(s)";
            }
        }
        else {
            if (splitted.length > 2) {
                type = CommandType.undefined;
                argument = 0;
                return "Error: excessive parameter(s)";
            }
        }

        return new String();
    }
}
