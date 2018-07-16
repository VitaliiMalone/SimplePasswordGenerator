package com.example.android.simplepasswordgenerator.presentation.home;

import android.os.Bundle;

import com.example.android.simplepasswordgenerator.R;
import com.example.android.simplepasswordgenerator.presentation.home.common.BaseActivity;
import com.example.android.simplepasswordgenerator.presentation.home.password.PasswordFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainContainer, PasswordFragment.newInstance())
                .commit();
    }
}
