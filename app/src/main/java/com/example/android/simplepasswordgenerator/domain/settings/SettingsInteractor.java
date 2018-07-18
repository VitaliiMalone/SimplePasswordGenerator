package com.example.android.simplepasswordgenerator.domain.settings;

import com.example.android.simplepasswordgenerator.data.model.Settings;
import com.example.android.simplepasswordgenerator.domain.base.BaseInteractor;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;

public class SettingsInteractor extends BaseInteractor {

    private SettingsRepository settingsRepository;

    @Inject
    public SettingsInteractor(SettingsRepository settingsRepository) {
        this.settingsRepository = settingsRepository;
    }

    public Single<Settings> getSettings() {
        return settingsRepository.getSettings().compose(applySingleSchedulers());
    }

    public Completable saveSettings(Settings settings) {
        return settingsRepository.saveSettings(settings).compose(applyCompletableSchedulers());
    }
}
