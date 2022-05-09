package net.duijndam.doorbell.server;

import com.pi4j.Pi4J;
import com.pi4j.io.gpio.digital.DigitalInput;
import com.pi4j.io.gpio.digital.DigitalStateChangeListener;
import com.pi4j.io.gpio.digital.PullResistance;

abstract public class HardwareListener {
    private static final Integer PIN_BUTTON = 12 ;
    protected DigitalInput button;

    public HardwareListener(String provider) {
        this.button = this.createButton(provider);
        this.setup();
    }

    /**
     *  create a button that recieves the signal from the doorbell
     * @param provider
     * @return DigitalInput
     */
    private DigitalInput createButton(String provider) {
        var pi4j = Pi4J.newAutoContext();

        var buttonConfig = DigitalInput.newConfigBuilder(pi4j)
                .id("button")
                .name("Doorbell")
                .address(PIN_BUTTON)
                .pull(PullResistance.PULL_UP)
                .debounce(3000L)
                .provider(provider);
        return pi4j.create(buttonConfig);
    }

    abstract void setup();

    public void addListener(DigitalStateChangeListener listener) {
        this.button.addListener(listener);
    }
}
