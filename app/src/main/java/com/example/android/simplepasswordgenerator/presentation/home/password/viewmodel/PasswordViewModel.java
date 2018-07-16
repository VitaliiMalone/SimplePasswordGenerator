package com.example.android.simplepasswordgenerator.presentation.home.password.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.android.simplepasswordgenerator.BR;

public class PasswordViewModel extends BaseObservable {

    private int sbPasswordLength;
    private String passwordLength;
    private boolean numbers;
    private boolean uppercase;
    private String password;

    @Bindable
    public int getSbPasswordLength() {
        return sbPasswordLength;
    }

    public void setSbPasswordLength(int sbPasswordLength) {
        this.sbPasswordLength = sbPasswordLength;
        notifyPropertyChanged(BR.passwordLength);
    }

    @Bindable
    public String getPasswordLength() {
        return String.valueOf(sbPasswordLength);
    }

    public void setPasswordLength() {
        this.passwordLength = String.valueOf(sbPasswordLength);
        notifyPropertyChanged(BR.passwordLength);
    }

    @Bindable
    public boolean isNumbers() {
        return numbers;
    }

    public void setNumbers(boolean numbers) {
        this.numbers = numbers;
        notifyPropertyChanged(BR.numbers);
    }

    @Bindable
    public boolean isUppercase() {
        return uppercase;
    }

    public void setUppercase(boolean uppercase) {
        this.uppercase = uppercase;
        notifyPropertyChanged(BR.uppercase);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }
}
