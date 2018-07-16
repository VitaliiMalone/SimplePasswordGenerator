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
    public Completable savePasswordLength(int passwordLength) {
        sharedPreferencesStorage.savePasswordLength(passwordLength);
        return Completable.complete();
    }

    @Override
    public Completable saveNumbers(boolean numbers) {
        sharedPreferencesStorage.saveNumbers(numbers);
        return Completable.complete();
    }

    @Override
    public Completable saveUppercase(boolean uppercase) {
        sharedPreferencesStorage.saveUppercase(uppercase);
        return Completable.complete();
    }

    @Override
    public Completable savePassword(String password) {
        sharedPreferencesStorage.savePassword(password);
        return Completable.complete();
    }
}
