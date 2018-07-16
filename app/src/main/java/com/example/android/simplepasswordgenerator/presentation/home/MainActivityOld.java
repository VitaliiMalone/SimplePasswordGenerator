package com.example.android.simplepasswordgenerator.presentation.home;

public class MainActivityOld {

//    private static final String PASSWORD = "password";
//
//    private String passwordText;
//
//    private TextView passwordLengthTextView;
//    private SeekBar seekBar;
//    private Button generateButton;
//    private TextView passwordTextView;
//    private CheckBox numbersCheckBox;
//    private CheckBox uppercaseCheckBox;
//    private ImageButton copyButton;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);
//
//        if (savedInstanceState != null) {
//            passwordText = savedInstanceState.getString(PASSWORD);
//        }
//
//        passwordLengthTextView = findViewById(R.id.tvPasswordLenght);
//        passwordTextView = findViewById(R.id.tvPassword);
//        seekBar = findViewById(R.id.seekBar);
//        generateButton = findViewById(R.id.btnGenerate);
//        numbersCheckBox = findViewById(R.id.chkNumbers);
//        uppercaseCheckBox = findViewById(R.id.chkUppercase);
//        copyButton = findViewById(R.id.btnCopy);
//
//        passwordLengthTextView.setText("8");
//
//        passwordTextView.setText(passwordText);
//
//        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                if (seekBar.getProgress() == 0) generateButton.setEnabled(false);
//                else generateButton.setEnabled(true);
//                passwordLengthTextView.setText(String.valueOf(progress));
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });
//
//        generateButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                generate();
//            }
//        });
//
//        copyButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
//                ClipData clip = ClipData.newPlainText("password", passwordText);
//                clipboard.setPrimaryClip(clip);
//                Toast.makeText(MainActivityOld.this, R.string.saved_to_clipboard, Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//
//    }
//
//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        outState.putString(PASSWORD, passwordText);
//        super.onSaveInstanceState(outState);
//    }
//
//    public void generate() {
//        Settings password = new Settings();
//        password.setLength(seekBar.getProgress());
//        StringBuilder sb = new StringBuilder(password.getLength());
//        Random random = new Random();
//        String chars = Password.LOWER;
//
//        if (uppercaseCheckBox.isChecked()) chars += Password.UPPER;
//        if (numbersCheckBox.isChecked()) chars += Password.NUMBERS;
//
//        for (int i = 0; i < password.getLength(); i++) {
//            sb.append(chars.charAt(random.nextInt(chars.length())));
//        }
//        passwordText = sb.toString();
//        passwordTextView.setText(passwordText);
//    }
}
