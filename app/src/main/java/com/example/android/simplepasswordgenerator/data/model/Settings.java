package com.example.android.simplepasswordgenerator.data.model;

public class Settings {
    private int passwordLength;
    private boolean numbers;
    private boolean uppercase;
    private String password;

    public int getPasswordLength() {
        return passwordLength;
    }

    public void setPasswordLength(int passwordLength) {
        this.passwordLength = passwordLength;
    }

    public boolean isNumbers() {
        return numbers;
    }

    public void setNumbers(boolean numbers) {
        this.numbers = numbers;
    }

    public boolean isUppercase() {
        return uppercase;
    }

    public void setUppercase(boolean uppercase) {
        this.uppercase = uppercase;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
