package com.example.android.simplepasswordgenerator.di.app;

import com.example.android.simplepasswordgenerator.data.repository.settings.SettingsRepositoryImpl;
import com.example.android.simplepasswordgenerator.domain.settings.SettingsRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Singleton
    @Provides
    public SettingsRepository provideSettingsRepository(SettingsRepositoryImpl settingsRepository) {
        return settingsRepository;
    }
}
