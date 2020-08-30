package com.wangp.myaop.design_pattern.behavioral.command;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * classname Staff
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/30 11:10
 **/
public class Staff {

    private List<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void executorCommand() {
        for (Command command : commands) {
            command.execute();
        }
    }
}
