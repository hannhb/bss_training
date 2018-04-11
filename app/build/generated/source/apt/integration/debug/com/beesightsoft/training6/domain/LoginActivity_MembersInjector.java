package com.beesightsoft.training6.domain;

import com.beesightsoft.training6.service.model.RestCommentService;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class LoginActivity_MembersInjector implements MembersInjector<LoginActivity> {
  private final Provider<RestCommentService> restCommentServiceProvider;

  public LoginActivity_MembersInjector(Provider<RestCommentService> restCommentServiceProvider) {
    this.restCommentServiceProvider = restCommentServiceProvider;
  }

  public static MembersInjector<LoginActivity> create(
      Provider<RestCommentService> restCommentServiceProvider) {
    return new LoginActivity_MembersInjector(restCommentServiceProvider);
  }

  @Override
  public void injectMembers(LoginActivity instance) {
    injectRestCommentService(instance, restCommentServiceProvider.get());
  }

  public static void injectRestCommentService(
      LoginActivity instance, RestCommentService restCommentService) {
    instance.restCommentService = restCommentService;
  }
}
