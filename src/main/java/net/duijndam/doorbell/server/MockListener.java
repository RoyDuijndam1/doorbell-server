package net.duijndam.doorbell.server;

import com.pi4j.io.gpio.digital.DigitalInputConfigBuilder;
import com.pi4j.io.gpio.digital.DigitalState;
import com.pi4j.plugin.mock.provider.gpio.digital.MockDigitalInput;

import java.util.Scanner;

public class MockListener extends HardwareListener {

    public MockListener() {
        super();
        startMockListener();
    }

    @Override
    public void setup(DigitalInputConfigBuilder buttonBuilder) {
        buttonBuilder.provider("mock-digital-input");
    }

    /**
     * create a mockListener to test the application with. if you press l in the terminal then it will simulate a
     * doorbell signal
     */
    private void startMockListener() {
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
