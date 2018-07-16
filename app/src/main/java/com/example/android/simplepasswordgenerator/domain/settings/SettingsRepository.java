package com.example.android.simplepasswordgenerator.domain.settings;

import com.example.android.simplepasswordgenerator.data.model.Settings;

import io.reactivex.Single;

public interface SettingsRepository {

    Single<Settings> getSettings();

}
