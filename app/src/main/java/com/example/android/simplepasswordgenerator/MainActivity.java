package com.example.android.simplepasswordgenerator;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String PASSWORD = "password";

    private String passwordText;

    private TextView passwordLengthTextView;
    private SeekBar seekBar;
    private Button generateButton;
    private TextView passwordTextView;
    private CheckBox numbersCheckBox;
    private CheckBox uppercaseCheckBox;
    private ImageButton copyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            passwordText = savedInstanceState.getString(PASSWORD);
        }

        passwordLengthTextView = findViewById(R.id.password_length_textView);
        passwordTextView = findViewById(R.id.password_textView);
        seekBar = findViewById(R.id.seekBar);
        generateButton = findViewById(R.id.generate_button);
        numbersCheckBox = findViewById(R.id.numbers_checkBox);
        uppercaseCheckBox = findViewById(R.id.uppercase_checkBox);
        copyButton = findViewById(R.id.copy_button);

        passwordLengthTextView.setText("8");

        passwordTextView.setText(passwordText);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (seekBar.getProgress() == 0) generateButton.setEnabled(false);
                else generateButton.setEnabled(true);
                passwordLengthTextView.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generate();
            }
        });

        copyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("password", passwordText);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(MainActivity.this, R.string.saved_to_clipboard, Toast.LENGTH_SHORT).show();

            }
        });


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(PASSWORD, passwordText);
        super.onSaveInstanceState(outState);
    }

    public void generate() {
        Password password = new Password();
        password.setLength(seekBar.getProgress());
        StringBuilder sb = new StringBuilder(password.getLength());
        Random random = new Random();
        String chars = Password.LOWER;

        if (uppercaseCheckBox.isChecked()) chars += Password.UPPER;
        if (numbersCheckBox.isChecked()) chars += Password.NUMBERS;

        for (int i = 0; i < password.getLength(); i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        passwordText = sb.toString();
        passwordTextView.setText(passwordText);
    }
}
