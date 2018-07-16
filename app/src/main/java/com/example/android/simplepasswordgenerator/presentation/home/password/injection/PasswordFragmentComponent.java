package com.example.android.simplepasswordgenerator.presentation.home.password.injection;

import com.example.android.simplepasswordgenerator.di.fragment.FragmentScope;
import com.example.android.simplepasswordgenerator.presentation.home.password.PasswordContract;
import com.example.android.simplepasswordgenerator.presentation.home.password.PasswordFragment;
import com.example.android.simplepasswordgenerator.presentation.home.password.PasswordPresenter;

import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@FragmentScope
@Subcomponent(modules = {PasswordFragmentComponent.PasswordModule.class})
public interface PasswordFragmentComponent extends AndroidInjector<PasswordFragment> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<PasswordFragment> {

    }

    @Module
    class PasswordModule {

        @Provides
        PasswordContract.Presenter providePresenter(PasswordPresenter presenter) {
            return presenter;
        }
    }
}
