package de.faldoria.buildtools;

import lombok.Data;

import java.net.URI;

@Data
public class Plugin {

    private String name;
    private String fileName;
    private String fileUrl;
    private String configUrl;
    private String branch;
    private boolean useToken = false;
    private ConfigType configType = ConfigType.EMPTY;

    public static enum ConfigType {

        GIT,
        ZIP,
        EMPTY
    }
}
