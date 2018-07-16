package com.example.android.simplepasswordgenerator;

import android.app.Activity;
import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.example.android.simplepasswordgenerator.di.app.AppModule;
import com.example.android.simplepasswordgenerator.di.app.DaggerAppComponent;
import com.example.android.simplepasswordgenerator.di.app.DataModule;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class App extends MultiDexApplication implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> mAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .dataModule(new DataModule())
                .create(this)
                .inject(this);
    }

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }


    @Override
    public AndroidInjector<Activity> activityInjector() {
        return mAndroidInjector;
    }
}
