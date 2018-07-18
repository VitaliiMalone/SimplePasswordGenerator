package com.example.android.simplepasswordgenerator.domain.settings;

import com.example.android.simplepasswordgenerator.data.model.Settings;
import com.example.android.simplepasswordgenerator.presentation.home.password.viewmodel.PasswordViewModel;

public class SettingsMapper {

    public static Settings map(PasswordViewModel viewModel) {
        Settings settings = new Settings();
        settings.setPassword(viewModel.getPassword());
        settings.setPasswordLength(viewModel.getSbPasswordLength());
        settings.setNumbers(viewModel.isNumbers());
        settings.setUppercase(viewModel.isUppercase());
        return settings;
    }
}
