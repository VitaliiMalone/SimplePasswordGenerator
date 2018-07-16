package com.example.android.simplepasswordgenerator.presentation.home.password;

import com.example.android.simplepasswordgenerator.presentation.home.common.BasePresenter;
import com.example.android.simplepasswordgenerator.presentation.home.password.viewmodel.PasswordViewModel;

public interface PasswordContract {

    interface View {

        void copyToClipboard(String password);

        void showPasswordCopiedToast();

        void setViewModel(PasswordViewModel viewModel);

        void setPassword(String password);
    }

    interface Presenter extends BasePresenter<View> {

        void onGeneratePasswordClick(PasswordViewModel model);

        void onCopyClick(String password);
    }
}
