package com.example.android.simplepasswordgenerator.presentation.home.password;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.android.simplepasswordgenerator.R;
import com.example.android.simplepasswordgenerator.databinding.FragmentPasswordBinding;
import com.example.android.simplepasswordgenerator.presentation.home.common.BaseFragment;
import com.example.android.simplepasswordgenerator.presentation.home.common.BasePresenter;
import com.example.android.simplepasswordgenerator.presentation.home.password.viewmodel.PasswordViewModel;

import javax.inject.Inject;

public class PasswordFragment extends BaseFragment<FragmentPasswordBinding>
        implements PasswordContract.View {

    private static final String TAG = "PasswordFragment";

    @Inject
    PasswordPresenter presenter;

    public static PasswordFragment newInstance() {
        return new PasswordFragment();
    }

    @Override
    public BasePresenter getPresenter() {
        return presenter;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_password;
    }

    @Override
    protected void initView() {
        Log.d(TAG, "initView: started");
        presenter.attachView(this);
        getBinding().setPresenter(presenter);
        presenter.getPasswordViewModel();
    }

    @Override
    public void setViewModel(PasswordViewModel viewModel) {
        getBinding().setViewModel(viewModel);
    }

    @Override
    public void setPassword(String password) {
        getBinding().getViewModel().setPassword(password);
    }

    @Override
    public void copyToClipboard(String password) {
        ClipboardManager clipboard = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("password", password);
        clipboard.setPrimaryClip(clip);
    }

    @Override
    public void showPasswordCopiedToast() {
        Toast.makeText(getContext(), R.string.saved_to_clipboard, Toast.LENGTH_SHORT).show();
    }
}
