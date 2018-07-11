# Tales of Faldoria Build Tools

Mit den `Tales of Faldoria Build Tools` lässt sich der komplette Server Deployment Prozess durch simple Konfigurations Dateien automatisieren. Besonders mächtig werden die Build Tools im Zusammenspiel mit Docker Images.

## Getting Started

Die Build Tools werden wie ein Minecraft Server mit `java -jar` gestartet. Dabei wird Default die `plugins.yml` im aktuellen Verzeichnis eingelesen.

```bash
java -jar ToF-BuildTools.jar
```

### Parameter

Die Build Tools können mit folgenden Parametern ausgeführt werden um z.B. eine Authenzifizierung im Git zu realisieren.

| Parameter | Beschreibung | Beispiel |
| --------- | ------------ | -------- |
| --config \| -c | Gibt den Pfad zu einer alternativen `plugins.yml` Config an. | `--config data/plugins.yml` |
| --output-dir \| -o | Gibt den Pfad an in den die Plugins geladen werden sollen. Default: `plugins/` | `--output-dir mods/` |
| --git-username | Gibt den Git Username für Repos mit Authentifizierung an. | `--git-username Silthus` |
| --git-password | Gibt das Password oder den Auth Token für Git an. | `--git-password foobar` |
| --file-username | Gibt einen User für BASIC Auth beim Download von Files an. | `--file-username Silthus` |
| --file-password | Gibt ein Password für BASIC Auth beim Download von Files an. | `--file-password foorbar` |
| --header \| -h | Fügt dem Download der `.jar` Dateien zusätzliche Header hinzu. Der Header wird beim `:` gesplitted. | `-h PRIVATE-TOKEN: foobar` |

## Konfiguration

Fast alles der Build Tools wird in der `plugins.yml` konfiguriert. Der Pfad und Name der Datei kann mit dem `--config foobar.yml` Parameter geändert werden.

> Alle `.jar` Plugin Dateien werden jedesmal mit der aktuellsten Version überschrieben.

In der Config Datei werden einfach alle benötigten Plugins mit dem Download Pfad zur `.jar` Datei und dem Ort der Konfiguration hinterlegt.

> Plugin Configs von Git Repositories werden mit `git pull` aktualisiert und alle lokalen Änderungen verworfen. Also vorher am besten die Änderungen einchecken.

```yml
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
```