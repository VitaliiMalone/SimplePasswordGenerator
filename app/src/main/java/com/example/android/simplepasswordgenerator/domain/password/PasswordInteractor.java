package com.example.android.simplepasswordgenerator.domain.password;

import com.example.android.simplepasswordgenerator.domain.base.BaseInteractor;
import com.example.android.simplepasswordgenerator.presentation.home.password.viewmodel.PasswordViewModel;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
@Singleton
public class PasswordInteractor extends BaseInteractor {

    @Inject
    public PasswordInteractor() {
    }

    public Single<String> generatePassword(PasswordViewModel model) {
        Password password = new Password();

        password.setLength(model.getSbPasswordLength());
        password.setNumbers(model.isNumbers());
        password.setUpper(model.isUppercase());

        return Single.just(password.generatePassword()).compose(applySingleSchedulers());
    }
}
