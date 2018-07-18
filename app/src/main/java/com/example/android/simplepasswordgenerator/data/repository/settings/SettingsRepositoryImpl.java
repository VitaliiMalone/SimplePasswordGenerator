package com.example.android.simplepasswordgenerator.data.repository.settings;

import com.example.android.simplepasswordgenerator.data.model.Settings;
import com.example.android.simplepasswordgenerator.data.repository.settings.local.PasswordStorageLocal;
import com.example.android.simplepasswordgenerator.domain.settings.SettingsRepository;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;

public class SettingsRepositoryImpl implements SettingsRepository {

    private PasswordStorageLocal passwordStorageLocal;

    @Inject
    public SettingsRepositoryImpl(PasswordStorageLocal passwordStorageLocal) {
        this.passwordStorageLocal = passwordStorageLocal;
    }

    @Override
    public Single<Settings> getSettings() {
       return passwordStorageLocal.getPassword();
    }

    @Override
    public Completable saveSettings(Settings settings) {
        return passwordStorageLocal.saveSettings(settings);
    }


}
