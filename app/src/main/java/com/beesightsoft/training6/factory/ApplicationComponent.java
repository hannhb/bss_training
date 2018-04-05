package com.beesightsoft.training6.factory;

import com.beesightsoft.training6.domain.LoginActivity;

import dagger.Component;

@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void inject(LoginActivity loginActivity);
}
