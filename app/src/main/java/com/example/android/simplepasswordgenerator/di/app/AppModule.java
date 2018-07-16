package com.example.android.simplepasswordgenerator.di.app;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private Context mContext;

    public AppModule(Context context) {
        mContext = context;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return mContext;
    }

    @Provides
    @Singleton
    static SharedPreferences provideSharedPreferences(Context context){
        return context.getSharedPreferences("preferences", Context.MODE_PRIVATE);
    }
}
