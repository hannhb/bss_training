package com.beesightsoft.training6.factory;

import com.beesightsoft.training6.service.model.RestCommentService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvideRestCommentServiceFactory
    implements Factory<RestCommentService> {
  private final ApplicationModule module;

  private final Provider<Retrofit> retrofitProvider;

  public ApplicationModule_ProvideRestCommentServiceFactory(
      ApplicationModule module, Provider<Retrofit> retrofitProvider) {
    this.module = module;
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public RestCommentService get() {
    return Preconditions.checkNotNull(
        module.provideRestCommentService(retrofitProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<RestCommentService> create(
      ApplicationModule module, Provider<Retrofit> retrofitProvider) {
    return new ApplicationModule_ProvideRestCommentServiceFactory(module, retrofitProvider);
  }

  public static RestCommentService proxyProvideRestCommentService(
      ApplicationModule instance, Retrofit retrofit) {
    return instance.provideRestCommentService(retrofit);
  }
}
