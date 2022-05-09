package net.duijndam.doorbell.server;

import com.pi4j.io.gpio.digital.DigitalState;
import com.pi4j.plugin.mock.provider.gpio.digital.MockDigitalInput;

import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class MockListener extends HardwareListener{


    public MockListener() {
        super("mock-digital-input");
    }

    /**
     * create a mockListener to test the application with. if you press l in the terminal then the it will simulate a
     * doorbell signal
     */
    @Override
    public void setup() {
        var mock = (MockDigitalInput)button;
        Thread thread = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            while(scanner.hasNext()) {
                String text = scanner.nextLine();
                if(text.equals("l")) {
                    mock.mockState(DigitalState.HIGH);
                    mock.mockState(DigitalState.LOW);
                }
            }
        });

        thread.start();

    }

}
