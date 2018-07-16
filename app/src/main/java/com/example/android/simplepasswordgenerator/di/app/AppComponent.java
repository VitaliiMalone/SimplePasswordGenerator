package com.example.android.simplepasswordgenerator.di.app;

import com.example.android.simplepasswordgenerator.App;
import com.example.android.simplepasswordgenerator.di.activity.ActivityBindingsModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AppModule.class,
        ActivityBindingsModule.class,
        AndroidSupportInjectionModule.class,
        DataModule.class
})
public interface AppComponent extends AndroidInjector<App> {
    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<App> {

        public abstract Builder appModule(AppModule module);

        public abstract Builder dataModule(DataModule module);

    }
}
