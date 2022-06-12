package net.duijndam.doorbell.server;

import com.pi4j.Pi4J;
import com.pi4j.context.Context;
import com.pi4j.io.gpio.digital.DigitalInput;
import com.pi4j.io.gpio.digital.DigitalInputConfigBuilder;
import com.pi4j.io.gpio.digital.DigitalStateChangeListener;
import com.pi4j.io.gpio.digital.PullResistance;


abstract public class HardwareListener {
    private static final Integer PIN_BUTTON = 12;
    private final Context pi4j = Pi4J.newAutoContext();
    protected DigitalInput button;

    public HardwareListener() {
        var buttonBuilder = this.createButtonBuilder();
        this.setup(buttonBuilder);
        this.button = pi4j.create(buttonBuilder);
    }

    /**
     *  create a button that receives the signal from the doorbell
     * @return DigitalInput
     */
    private DigitalInputConfigBuilder createButtonBuilder() {
        return DigitalInput.newConfigBuilder(pi4j)
                .id("button")
                .name("Doorbell")
                .address(PIN_BUTTON)
                .pull(PullResistance.PULL_UP)
                .debounce(3000L);

    }

    abstract void setup(DigitalInputConfigBuilder buttonBuilder);

    public void addListener(DigitalStateChangeListener listener) {
        this.button.addListener(listener);
    }
}
