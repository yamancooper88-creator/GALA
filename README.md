# OhaTV - Android TV Streaming App

Eine hochperformante Android TV App für die Nokia Streaming Box 8010, die IPTV (M3U) und einen spezialisierten Browser mit Video-Erkennung kombiniert.

## Anforderungen

- **Zielgerät:** Nokia Streaming Box 8010
- **Betriebssystem:** Android TV 14 (API Level 34)
- **CPU-Architektur:** `armeabi-v7a` (32-Bit)
- **RAM:** 4 GB
- **Speicher:** ca. 24 GB

## Funktionalität

### IPTV-Player
- M3U-Playlist-Unterstützung
- Live-TV-Kanäle
- Resume-Funktion (Fortsetzen an der letzten Position)
- Geschwindigkeitskontrolle (1.0x bis 1.25x in 0.05er Schritten)
- Hardwarebeschleunigung (Mali-G31 MP2 GPU)

### Browser mit Video-Erkennung
- Spezialisierter Browser für Seiten wie oha.to
- Automatische Video-Erkennung und -Auflösung
- Ad-Blocking auf HTTP-Ebene
- Intelligente Skalierung (Zoom-Out-Funktion)
- Keine Standard-WebView – maximale Performance

### Android TV Optimierungen
- Native Android TV App
- Fernbedienungsfreundlichkeit (D-Pad Navigation)
- Landscape-Modus
- Ressourcensparsamkeit
- Ohne Root-Berechtigungen

## Technologie-Stack

- **Programmiersprache:** Kotlin
- **UI-Framework:** Jetpack Compose for TV
- **Architekturmuster:** MVVM
- **Medienwiedergabe:** AndroidX Media3 / ExoPlayer
- **Netzwerk:** Retrofit + OkHttp
- **HTML-Parsing:** Jsoup
- **Datenbank:** Room
- **Dependency Injection:** Hilt
- **Asynchrone Verarbeitung:** Kotlin Coroutines
- **Logging:** Timber

## Projektstruktur

```
OhaTV/
├── build.gradle.kts                 # Gradle-Konfiguration
├── settings.gradle.kts              # Gradle-Einstellungen
├── proguard-rules.pro               # ProGuard-Regeln für Minification
├── src/
│   └── main/
│       ├── AndroidManifest.xml      # App-Manifest
│       ├── kotlin/
│       │   └── com/ohatv/app/
│       │       ├── MainActivity.kt   # Hauptaktivität
│       │       ├── di/
│       │       │   └── AppModule.kt  # Hilt-Module
│       │       ├── data/
│       │       │   ├── db/
│       │       │   │   ├── OhaTVDatabase.kt
│       │       │   │   ├── dao/
│       │       │   │   │   ├── PlaybackProgressDao.kt
│       │       │   │   │   └── ChannelDao.kt
│       │       │   │   └── entity/
│       │       │   │       ├── PlaybackProgressEntity.kt
│       │       │   │       └── ChannelEntity.kt
│       │       │   └── network/
│       │       │       └── OhaTVApiService.kt
│       │       ├── domain/
│       │       │   ├── video/
│       │       │   │   └── VideoLinkResolver.kt
│       │       │   └── iptv/
│       │       │       └── M3UParser.kt
│       │       └── ui/
│       │           ├── screens/
│       │           │   └── MainScreen.kt
│       │           └── theme/
│       │               ├── Theme.kt
│       │               └── Typography.kt
│       └── res/
│           └── (Ressourcen: Layouts, Strings, etc.)
└── README.md                        # Diese Datei
```

## Build und Deployment

### Voraussetzungen
- Android SDK (API Level 34)
- Gradle 8.0+
- Kotlin 1.9.10+

### Build-Befehl
```bash
./gradlew assembleRelease
```

Die APK wird unter `build/outputs/apk/release/` generiert.

### Installation auf Nokia Streaming Box 8010
```bash
adb install build/outputs/apk/release/app-release.apk
```

## Performance-Optimierungen

1. **armeabi-v7a Architektur:** Die App wird ausschließlich für 32-Bit kompiliert, um optimal auf der Nokia Streaming Box 8010 zu laufen.
2. **Kein Standard-WebView:** Stattdessen wird ein spezialisierter Browser mit HTML-Parsing (Jsoup) verwendet.
3. **Ad-Blocking:** HTTP-Interceptoren blockieren Werbe-Domains auf Netzwerk-Ebene.
4. **Hardwarebeschleunigung:** Volle Nutzung der Mali-G31 MP2 GPU für Video-Decoding.
5. **Ressourcensparsamkeit:** Optimiertes Speichermanagement für 4 GB RAM.

## Nächste Schritte

1. Detaillierte Implementierung des Video-Link-Resolvers für Mixdrop und Doodstream.
2. Entwicklung der IPTV-Player-UI mit Jetpack Compose for TV.
3. Implementierung des spezialisierten Browsers.
4. Testing und Optimierung auf der Nokia Streaming Box 8010.

## Lizenz

Proprietary - Nur für den Benutzer bestimmt.

---

**Erstellt von:** Manus AI  
**Datum:** 2026-07-12
