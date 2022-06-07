//package net.duijndam.doorbell.server;
//
//
//import com.pi4j.io.gpio.digital.DigitalState;
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.io.ByteArrayInputStream;
//import java.io.InputStream;
//import java.net.URISyntaxException;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.util.Objects;
//
//public class HardwareListener_Test {
//
//    @Test
//    public void hardware_test() {
//        boolean listenerCall = false;
//        MockListener mock = new MockListener();
//        mock.addListener(event -> {
//            Assert.fail();
//            Assert.assertEquals(event.state(), DigitalState.LOW);
//        });
//        InputStream in = new ByteArrayInputStream("l".getBytes(StandardCharsets.UTF_8));
//        System.setIn(in);
//    }
//
//    @Test
//    public void properties_test() throws URISyntaxException {
//        var path = Path.of("src/test/resources/broken-config.properties");
//
//        try {
//            new Config(path);
//            Assert.fail();
//        } catch (Exception e) {
//            Assert.assertEquals(e.getMessage(), "'URI' property not set correctly");
//        }
//    }
//}
