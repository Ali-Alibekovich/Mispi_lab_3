package tests;

import Commands.Invoker;
import Commands.Receiver;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MySuperCoolTest {
    static Invoker invoker;
    static Receiver receiver;

    @Before
    public void init() {
        invoker = new Invoker();
        receiver = new Receiver(invoker);
    }

    @Test
    public void historyTest() {
        invoker.executeCommand(new String[]{"clear"});
        invoker.executeCommand(new String[]{"info"});
        invoker.executeCommand(new String[]{"info"});
        invoker.executeCommand(new String[]{"help"});
        assertArrayEquals(new String[]{"clear", "info", "info", "help"}, invoker.getCommandHistory());
    }
}
