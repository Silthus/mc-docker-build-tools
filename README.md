# Tales of Faldoria Build Tools

These `BuildTools` are mostly copied code from the [`Spigot BuildTools`](https://hub.spigotmc.org/stash/projects/SPIGOT/repos/buildtools/). See the [license](LICENSE.md) for details.

This project aims to fully automate the configuration and deployment of a full [Spigot](https://hub.spigotmc.org/) Minecraft server. It will download plugins and config of plugins based on a simple configuration file.

## Getting Started

Start the Build Tools via `java -jar <JAR-FILE>`. In the defaults it will try to read the `plugins.yml` from the current directory as base config.

```bash
java -jar ToF-BuildTools.jar
```

### Parameters

The Build Tools take the following parameters.

| Parameter | Beschreibung | Beispiel |
| --------- | ------------ | -------- |
| --config / -c | Specify an alternative path to the `plugins.yml` config. | `--config data/plugins.yml` |
| --output-dir / -o | Specify the output directory into which plugins and configs are downloaded. Default: `plugins/` | `--output-dir mods/` |
| --git-username | If using private git repositories you can specify the username. | `--git-username Silthus` |
| --git-password | If using private git repositories you can specify a password or auth-token to download the configs. | `--git-password foobar` |
| --file-username | Allows the specification for BASIC authentication when downloading files. | `--file-username Silthus` |
| --file-password | Allows the specification for BASIC authentication when downloading files. | `--file-password foorbar` |
| --header / -h | Adds additional headers when downloading files. The header will be split at `:`. | `-h PRIVATE-TOKEN: foobar` |
| --configs     | Allows the specification of a suffix for config files. | `--configs .plugin.yml` will use all configs that end with `.plugin.yml` |
| --dir / -d | Optional directory to load configs with the `--configs` suffix from. | `-d /foobar` |

## Configuration

Everything is configured in the `plugins.yml` or the respective configuration files. The path and name can be changed via the `--config foobar.yml` parameter.

> All `.jar` files that are downloaded will be overwriten everytime.

In the config all plugins and their configs are specified by a download url and git repository or download url with a zip file of the config.

> Plugin configs that are downloaded from git repositories will be updated using `git pull`. Remember to commit your changes before updating the configs.

```yml
# Just non-working examples
plugins:
  worldedit:
    fileName: WorldEdit.jar
    fileUrl: https://dev.bukkit.org/projects/worldedit/files/latest
    configType: ZIP
    configUrl: https://pub.faldoria.de/plugin-configs/worldedit.zip
  raidcraft-api:
    fileName: RaidCraft-API.jar
    fileUrl: https://git.faldoria.de/raidcraft/raidcraft-api/-/jobs/artifacts/master/raw/target/RaidCraft-API.jar?job=build
    configType: GIT
    branch: master
    configUrl: https://git.faldoria.de/plugin-configs/rcmobs.git
  custom-path-jar:
    # You can download the plugin into any sub directory you want
    fileName: RaidCraft-API/custom-plugin.jar
    fileUrl: https://foobar.faldoria.de/plugin.jar
    # The config paramters are optional
```