package Display;

import java.io.IOException;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.gui2.*;
import org.junit.Test;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.bundle.LanternaThemes;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.input.KeyStroke;

import javax.swing.*;

public class Display {
    private final Terminal terminal;
    private final Screen screen;

    public Display() throws IOException, InterruptedException
    {

        terminal = new DefaultTerminalFactory().createTerminal();
        screen = new TerminalScreen(terminal);
    }

    public void Menu() throws IOException, InterruptedException {
        TextGraphics tg = screen.newTextGraphics();
        while (true) {
            tg.putString(0, 1, "-----------------------------------------------------------------------");
            tg.putString(0, 2, "                    the menu of the game");
            tg.putString(0, 3, "                  press enter for start the game.");
            KeyStroke key = terminal.pollInput();
            screen.refresh();
            if (key != null) {
                if (key.getKeyType() == KeyType.Enter) {
                    break;
                }
            }
        }
    }

    public void StartGame() throws IOException, InterruptedException {
        TextGraphics tg = screen.newTextGraphics();
        screen.startScreen();

        int index = 0;
        boolean keepRunning = true;
        while (keepRunning) {
            KeyStroke key = terminal.pollInput();
            if  (key != null) {
                switch (key.getKeyType()) {
                    case Escape:
                        keepRunning = false;
                        break;
                    case ArrowLeft:
                        index += 1;

                    case ArrowRight:
                        index -= 1;

                    case ArrowDown:
                        tg.putString(10, 10, "attack");
                        screen.refresh();
                        break;
                }
            }
            screen.refresh();
        }
        screen.refresh();
        tg.putString(10, 10, "good bey and see you later");
        screen.stopScreen();
    }
}