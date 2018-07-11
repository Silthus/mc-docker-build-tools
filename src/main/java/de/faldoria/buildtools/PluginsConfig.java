package de.faldoria.buildtools;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class PluginsConfig {

    private Map<String, Plugin> plugins = new HashMap<>();
}
