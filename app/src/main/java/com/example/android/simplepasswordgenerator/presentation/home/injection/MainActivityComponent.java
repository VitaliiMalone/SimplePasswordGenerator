package com.example.android.simplepasswordgenerator.presentation.home.injection;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.android.simplepasswordgenerator.di.activity.ActivityScope;
import com.example.android.simplepasswordgenerator.presentation.home.MainActivity;
import com.example.android.simplepasswordgenerator.presentation.home.password.PasswordFragment;
import com.example.android.simplepasswordgenerator.presentation.home.password.injection.PasswordFragmentComponent;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@ActivityScope
@Subcomponent(modules = {
        MainActivityComponent.MainActivityModule.class,
        MainActivityComponent.FragmentBindingsModule.class})

public interface MainActivityComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {
    }

    @Module
    class MainActivityModule {
        @Provides
        AppCompatActivity provideActivity(MainActivity activity) {
            return activity;
        }
    }

    @Module(subcomponents = {
        PasswordFragmentComponent.class
    })
    abstract class FragmentBindingsModule {
        @Binds
        @IntoMap
        @FragmentKey(PasswordFragment.class)
        public abstract AndroidInjector.Factory<? extends Fragment> homeFragmentComponentBuilder(PasswordFragmentComponent.Builder builder);

    }
}
