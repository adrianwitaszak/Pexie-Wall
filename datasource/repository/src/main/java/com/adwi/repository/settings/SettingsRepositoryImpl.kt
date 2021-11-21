package com.adwi.repository.settings

import com.adwi.datasource.local.dao.SettingsDao
import com.adwi.datasource.local.domain.toDomain
import com.adwi.datasource.local.domain.toEntity
import com.adwi.domain.Duration
import com.adwi.domain.Settings
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SettingsRepositoryImpl @Inject constructor(
    private val dao: SettingsDao
) : SettingsRepository {

    override fun getSettings() = dao.getSettings().map { it.toDomain() }

    override suspend fun insertSettings(settings: Settings) {
        dao.insertSettings(settings.toEntity())
    }

    override suspend fun updateLastQuery(query: String) {
        dao.updateLastQuery(query)
    }

    override suspend fun updatePushNotifications(enabled: Boolean) {
        dao.updatePushNotifications(enabled)
    }

    override suspend fun updateNewWallpaperSet(enabled: Boolean) {
        dao.updateNewWallpaperSet(enabled)
    }

    override suspend fun updateWallpaperRecommendations(enabled: Boolean) {
        dao.updateWallpaperRecommendations(enabled)
    }

    override suspend fun updateAutoChangeWallpaper(enabled: Boolean) {
        dao.updateAutoChangeWallpaper(enabled)
    }

    override suspend fun updateDownloadOverWiFi(enabled: Boolean) {
        dao.updateDownloadOverWiFi(enabled)
    }

    override suspend fun updateChangeDurationSelected(durationSelected: Duration) {
        dao.updateChangeDurationSelected(durationSelected)
    }

    override suspend fun updateChangeDurationValue(durationValue: Float) {
        dao.updateChangeDurationValue(durationValue)
    }

    override suspend fun updateAutoHome(enabled: Boolean) {
        dao.updateAutoHome(enabled)
    }

    override suspend fun updateAutoLock(enabled: Boolean) {
        dao.updateAutoLock(enabled)
    }

    override suspend fun resetAllSettings() {
        val settings = Settings.default.toEntity()
        dao.insertSettings(settings)
    }
}