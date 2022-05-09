package net.duijndam.doorbell.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Config {
    private final Path configPath;
    public URI serverUri;

    public Config(Path configPath) throws Exception {
        this.configPath = configPath;
        try {
            if(Files.exists(configPath) && Files.isRegularFile(configPath)) {
                load();
            } else {
                create();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void create() throws IOException {
        Properties props = new Properties();
        OutputStream output = Files.newOutputStream(configPath);

        props.setProperty("URI", "localhost");

        props.store(output, null);
        output.close();
    }

    private void load() throws Exception {
        Properties props = new Properties();

        InputStream input = Files.newInputStream(configPath);
        props.load(input);

        var prop = props.getProperty("URI");
        if (prop == null) {
            throw new Exception("'URI' property not set correctly");
        }

        serverUri = new URI(prop);

    }

}


