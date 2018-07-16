package com.example.android.simplepasswordgenerator.presentation.home.password;

import android.util.Log;

import com.example.android.simplepasswordgenerator.data.model.Settings;
import com.example.android.simplepasswordgenerator.domain.password.PasswordInteractor;
import com.example.android.simplepasswordgenerator.domain.settings.SettingsInteractor;
import com.example.android.simplepasswordgenerator.presentation.home.password.viewmodel.PasswordViewModel;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class PasswordPresenter implements PasswordContract.Presenter {

    private static final String TAG = "PasswordPresenter";

    private PasswordContract.View view;
    private SettingsInteractor settingsInteractor;
    private PasswordInteractor passwordInteractor;

    private CompositeDisposable compositeDisposable;

    @Inject
    public PasswordPresenter(SettingsInteractor settingsInteractor, PasswordInteractor passwordInteractor) {
        this.settingsInteractor = settingsInteractor;
        this.passwordInteractor = passwordInteractor;
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void attachView(PasswordContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        compositeDisposable.dispose();
        view = null;
    }

    @Override
    public void onGeneratePasswordClick(PasswordViewModel model) {
        compositeDisposable.add(passwordInteractor.generatePassword(model)
            .subscribe(
                    password -> view.setPassword(password),
                    throwable -> Log.e(TAG, "onGeneratePasswordClick: ", throwable))
        );
    }

    @Override
    public void onCopyClick(String password) {
        view.copyToClipboard(password);
        view.showPasswordCopiedToast();
    }

    public void getPasswordViewModel() {
        compositeDisposable.add(settingsInteractor.getSettings()
                .map(this::map)
                .subscribe(
                        viewModel -> view.setViewModel(viewModel),
                        throwable -> Log.e(TAG, "getPasswordViewModel: ", throwable))
        );
    }

    private PasswordViewModel map(Settings settings) {
        PasswordViewModel passwordViewModel = new PasswordViewModel();

        passwordViewModel.setSbPasswordLength(settings.getPasswordLength());
        passwordViewModel.setNumbers(settings.isNumbers());
        passwordViewModel.setUppercase(settings.isUppercase());
        passwordViewModel.setPassword(settings.getPassword());

        return passwordViewModel;
    }
}
