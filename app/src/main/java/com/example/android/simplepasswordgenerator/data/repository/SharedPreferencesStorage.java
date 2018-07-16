package com.example.android.simplepasswordgenerator.data.repository;

import android.content.SharedPreferences;

import com.example.android.simplepasswordgenerator.Constants;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SharedPreferencesStorage {

    private final SharedPreferences sharedPreferences;

    @Inject
    public SharedPreferencesStorage(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public String getPassword() {
        return sharedPreferences.getString(Constants.PASSWORD_KEY, "");
    }

    public void savePassword(String password) {
        sharedPreferences.edit().putString(Constants.PASSWORD_KEY, password).apply();
    }

    public int getPasswordLength() {
        return sharedPreferences.getInt(Constants.PASSWORD_LENGTH_KEY, 8);
    }

    public void savePasswordLength(int passwordLength) {
        sharedPreferences.edit().putInt(Constants.PASSWORD_LENGTH_KEY, passwordLength).apply();
    }

    public boolean getNumbers() {
        return sharedPreferences.getBoolean(Constants.NUMBERS_KEY, false);
    }

    public void saveNumbers(boolean numbers) {
        sharedPreferences.edit().putBoolean(Constants.NUMBERS_KEY, numbers).apply();
    }

    public boolean getUppercase() {
        return sharedPreferences.getBoolean(Constants.UPPERCASE_KEY, false);
    }

    public void saveUppercase(boolean uppercase) {
        sharedPreferences.edit().putBoolean(Constants.UPPERCASE_KEY, uppercase).apply();
    }
}
