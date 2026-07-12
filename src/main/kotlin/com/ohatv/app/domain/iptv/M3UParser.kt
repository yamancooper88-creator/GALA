package com.ohatv.app.domain.iptv

import timber.log.Timber

class M3UParser {

    data class M3UChannel(
        val name: String,
        val url: String,
        val logo: String? = null,
        val group: String? = null,
        val tvgId: String? = null
    )

    /**
     * Parst eine M3U-Playlist und extrahiert Kanäle
     */
    fun parseM3U(content: String): List<M3UChannel> {
        val channels = mutableListOf<M3UChannel>()
        val lines = content.split("\n")

        var currentName = ""
        var currentLogo: String? = null
        var currentGroup: String? = null
        var currentTvgId: String? = null

        for (line in lines) {
            val trimmedLine = line.trim()

            when {
                trimmedLine.startsWith("#EXTINF:") -> {
                    // Extrahiere Metadaten aus der EXTINF-Zeile
                    val metaData = parseExtinf(trimmedLine)
                    currentName = metaData.name
                    currentLogo = metaData.logo
                    currentGroup = metaData.group
                    currentTvgId = metaData.tvgId
                }
                trimmedLine.isNotEmpty() && !trimmedLine.startsWith("#") -> {
                    // Dies ist die URL-Zeile
                    if (currentName.isNotEmpty()) {
                        channels.add(
                            M3UChannel(
                                name = currentName,
                                url = trimmedLine,
                                logo = currentLogo,
                                group = currentGroup,
                                tvgId = currentTvgId
                            )
                        )
                        // Zurücksetzen für den nächsten Kanal
                        currentName = ""
                        currentLogo = null
                        currentGroup = null
                        currentTvgId = null
                    }
                }
            }
        }

        Timber.d("Parsed ${channels.size} channels from M3U")
        return channels
    }

    private fun parseExtinf(line: String): ExtinfMetadata {
        var name = ""
        var logo: String? = null
        var group: String? = null
        var tvgId: String? = null

        // Extrahiere den Namen (nach dem letzten Komma)
        val lastCommaIndex = line.lastIndexOf(",")
        if (lastCommaIndex != -1) {
            name = line.substring(lastCommaIndex + 1).trim()
        }

        // Extrahiere tvg-logo
        val logoMatch = Regex("""tvg-logo="([^"]*)"""").find(line)
        if (logoMatch != null) {
            logo = logoMatch.groupValues[1]
        }

        // Extrahiere group-title
        val groupMatch = Regex("""group-title="([^"]*)"""").find(line)
        if (groupMatch != null) {
            group = groupMatch.groupValues[1]
        }

        // Extrahiere tvg-id
        val tvgIdMatch = Regex("""tvg-id="([^"]*)"""").find(line)
        if (tvgIdMatch != null) {
            tvgId = tvgIdMatch.groupValues[1]
        }

        return ExtinfMetadata(
            name = name,
            logo = logo,
            group = group,
            tvgId = tvgId
        )
    }

    private data class ExtinfMetadata(
        val name: String,
        val logo: String?,
        val group: String?,
        val tvgId: String?
    )
}
