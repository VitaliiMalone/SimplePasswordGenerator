package com.example.android.simplepasswordgenerator.data.repository.settings.local;

import com.example.android.simplepasswordgenerator.data.model.Settings;
import com.example.android.simplepasswordgenerator.data.repository.SharedPreferencesStorage;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;

public class PasswordStorageLocal implements PasswordStorage {

    private SharedPreferencesStorage sharedPreferencesStorage;

    @Inject
    public PasswordStorageLocal(SharedPreferencesStorage sharedPreferencesStorage) {
        this.sharedPreferencesStorage = sharedPreferencesStorage;
    }

    @Override
    public Single<Settings> getPassword() {
        Settings settings = new Settings();
        settings.setPasswordLength(sharedPreferencesStorage.getPasswordLength());
        settings.setNumbers(sharedPreferencesStorage.getNumbers());
        settings.setUppercase(sharedPreferencesStorage.getUppercase());
        settings.setPassword(sharedPreferencesStorage.getPassword());

        return Single.just(settings);
    }

    @Override
    public Completable saveSettings(Settings settings) {
        sharedPreferencesStorage.savePasswordLength(settings.getPasswordLength());
        sharedPreferencesStorage.saveNumbers(settings.isNumbers());
        sharedPreferencesStorage.saveUppercase(settings.isUppercase());
        sharedPreferencesStorage.savePassword(settings.getPassword());

        return Completable.complete();
    }


}
