package com.example.android.simplepasswordgenerator.domain.password;

import java.util.Random;

public class Password {

    public static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    public static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERS = "0123456789";

    private int length;
    private boolean upper;
    private boolean numbers;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isUpper() {
        return upper;
    }

    public void setUpper(boolean upper) {
        this.upper = upper;
    }

    public boolean isNumbers() {
        return numbers;
    }

    public void setNumbers(boolean numbers) {
        this.numbers = numbers;
    }

    public String generatePassword() {
        Password password = new Password();

        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        String chars = Password.LOWER;
        if (upper) chars += UPPER;
        if (numbers) chars += NUMBERS;
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }
}
