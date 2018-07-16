package com.example.android.simplepasswordgenerator.data.repository.settings;

import com.example.android.simplepasswordgenerator.data.model.Settings;
import com.example.android.simplepasswordgenerator.data.repository.SharedPreferencesStorage;
import com.example.android.simplepasswordgenerator.domain.settings.SettingsRepository;

import javax.inject.Inject;

import io.reactivex.Single;

public class SettingsRepositoryImpl implements SettingsRepository {

    private SharedPreferencesStorage sharedPreferencesStorage;

    @Inject
    public SettingsRepositoryImpl(SharedPreferencesStorage sharedPreferencesStorage) {
        this.sharedPreferencesStorage = sharedPreferencesStorage;
    }

    @Override
    public Single<Settings> getSettings() {
        Settings settings = new Settings();

        settings.setPasswordLength(sharedPreferencesStorage.getPasswordLength());
        settings.setUppercase(sharedPreferencesStorage.getUppercase());
        settings.setNumbers(sharedPreferencesStorage.getNumbers());
        settings.setPassword(sharedPreferencesStorage.getPassword());

        return Single.just(settings);
    }

}
