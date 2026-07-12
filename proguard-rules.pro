# Allgemeine ProGuard-Regeln für Android
-keepattributes *Annotation*
-keepattributes SourceFile,LineNumberTable
-keep public class * extends java.lang.Exception

# Jetpack Compose
-keep class androidx.compose.** { *; }
-keep class androidx.tv.** { *; }

# Kotlin
-keep class kotlin.** { *; }
-keep class kotlinx.** { *; }

# Retrofit
-keep class retrofit2.** { *; }
-keep interface retrofit2.** { *; }
-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}

# OkHttp
-keep class okhttp3.** { *; }
-keep interface okhttp3.** { *; }
-dontwarn okhttp3.**
-dontwarn okio.**

# Hilt
-keep class dagger.hilt.** { *; }
-keep interface dagger.hilt.** { *; }
-keepclasseswithmembers class * {
    @dagger.hilt.* <methods>;
}

# Room
-keep class androidx.room.** { *; }
-keep interface androidx.room.** { *; }

# Media3 / ExoPlayer
-keep class androidx.media3.** { *; }
-keep interface androidx.media3.** { *; }

# Jsoup
-keep class org.jsoup.** { *; }
-keep interface org.jsoup.** { *; }

# Timber
-keep class timber.log.** { *; }
-keep interface timber.log.** { *; }

# App-spezifische Klassen
-keep class com.ohatv.app.** { *; }
-keep interface com.ohatv.app.** { *; }

# Serialization
-keepclassmembers class * {
    @kotlinx.serialization.Serializable <fields>;
}
