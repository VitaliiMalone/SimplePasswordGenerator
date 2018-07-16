package com.example.android.simplepasswordgenerator.data.repository.settings.local;

import com.example.android.simplepasswordgenerator.data.model.Settings;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface PasswordStorage {

    Single<Settings> getPassword();

    Completable savePasswordLength(int passwordLength);

    Completable saveNumbers(boolean numbers);

    Completable saveUppercase(boolean uppercase);

    Completable savePassword(String password);

}
