package psnc.maciej.s4d;

import scala.Console;

/**
 * Created by Maciej Łabędzki
 * Date: 21.10.15
 */
public class RealConsoleDriver implements ConsoleDriver {
    @Override
    public void println(String s) {
        Console.println(s);
    }

    @Override
    public void print(String s) {
        Console.print(s);
    }

    @Override
    public String readLine() {
        return Console.readLine();
    }
}
