package tests;

import Collection.CollectionManager;
import Commands.Invoker;
import Commands.Receiver;
import Commands.SpecificCommands.Clear;
import Commands.SpecificCommands.Help;
import Commands.SpecificCommands.Info;
import jdk.jfr.Name;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

@Name("Test1")
public class MySuperCoolTest {
    static Invoker invoker;
    static Receiver receiver;

    @Before
    public void init() {
        invoker = new Invoker();
        receiver = new Receiver(invoker);
        CollectionManager.initializeCollection();
    }

    @Test
    public void historyTest() {
        invoker.register("help", new Help(receiver));
        invoker.register("info", new Info(receiver));
        invoker.register("clear", new Clear(receiver));
        invoker.executeCommand(new String[]{"clear"});
        invoker.executeCommand(new String[]{"info"});
        invoker.executeCommand(new String[]{"info"});
        invoker.executeCommand(new String[]{"help"});
        invoker.executeCommand(new String[]{"help"});
        invoker.executeCommand(new String[]{"help"});
        invoker.executeCommand(new String[]{"help"});
        String[] commands = {"clear", "info", "info", "help", "help", "help", "help"};
        assertArrayEquals(commands, invoker.getCommandHistory());
    }
}
