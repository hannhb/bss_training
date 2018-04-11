package com.beesightsoft.training6.factory;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvideRetrofitFactory implements Factory<Retrofit> {
  private final ApplicationModule module;

  public ApplicationModule_ProvideRetrofitFactory(ApplicationModule module) {
    this.module = module;
  }

  @Override
  public Retrofit get() {
    return Preconditions.checkNotNull(
        module.provideRetrofit(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Retrofit> create(ApplicationModule module) {
    return new ApplicationModule_ProvideRetrofitFactory(module);
  }

  public static Retrofit proxyProvideRetrofit(ApplicationModule instance) {
    return instance.provideRetrofit();
  }
}
