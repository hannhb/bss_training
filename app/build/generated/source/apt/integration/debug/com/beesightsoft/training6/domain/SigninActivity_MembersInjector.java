package com.beesightsoft.training6.domain;

import com.beesightsoft.training6.service.model.RestPostService;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SigninActivity_MembersInjector implements MembersInjector<SigninActivity> {
  private final Provider<RestPostService> restPostServiceProvider;

  public SigninActivity_MembersInjector(Provider<RestPostService> restPostServiceProvider) {
    this.restPostServiceProvider = restPostServiceProvider;
  }

  public static MembersInjector<SigninActivity> create(
      Provider<RestPostService> restPostServiceProvider) {
    return new SigninActivity_MembersInjector(restPostServiceProvider);
  }

  @Override
  public void injectMembers(SigninActivity instance) {
    injectRestPostService(instance, restPostServiceProvider.get());
  }

  public static void injectRestPostService(
      SigninActivity instance, RestPostService restPostService) {
    instance.restPostService = restPostService;
  }
}
