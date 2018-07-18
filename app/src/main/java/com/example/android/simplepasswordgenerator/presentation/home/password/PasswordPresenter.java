package com.example.android.simplepasswordgenerator.presentation.home.password;

import android.util.Log;

import com.example.android.simplepasswordgenerator.domain.password.PasswordInteractor;
import com.example.android.simplepasswordgenerator.domain.settings.SettingsInteractor;
import com.example.android.simplepasswordgenerator.domain.settings.SettingsMapper;
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
                .doAfterSuccess(s ->  saveSettings(model))
                .subscribe(
                        password -> view.setPassword(password),
                        throwable -> Log.e(TAG, "onGeneratePasswordClick: ", throwable))
        );
    }

    @Override
    public void saveSettings(PasswordViewModel model) {
        compositeDisposable.add(settingsInteractor.saveSettings(SettingsMapper.map(model))
                .subscribe(
                        () -> Log.d(TAG, "saveSettings: success!"),
                        Throwable::printStackTrace));
    }

    @Override
    public void onCopyClick(String password) {
        view.copyToClipboard(password);
        view.showPasswordCopiedToast();
    }

    public void getPasswordViewModel() {
        compositeDisposable.add(settingsInteractor.getSettings()
                .map(PasswordViewModel::new)
                .subscribe(
                        viewModel -> view.setViewModel(viewModel),
                        throwable -> Log.e(TAG, "getPasswordViewModel: ", throwable))
        );
    }


}
