package com.beesightsoft.training6.factory;

import com.beesightsoft.training6.domain.LoginActivity;
import com.beesightsoft.training6.domain.LoginActivity_MembersInjector;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerApplicationComponent implements ApplicationComponent {
  private ApplicationModule applicationModule;

  private DaggerApplicationComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static ApplicationComponent create() {
    return new Builder().build();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.applicationModule = builder.applicationModule;
  }

  @Override
  public void inject(LoginActivity loginActivity) {
    injectLoginActivity(loginActivity);
  }

  private LoginActivity injectLoginActivity(LoginActivity instance) {
    LoginActivity_MembersInjector.injectRestCommentService(
        instance,
        Preconditions.checkNotNull(
            applicationModule.provideRestCommentService(
                Preconditions.checkNotNull(
                    applicationModule.provideRetrofit(),
                    "Cannot return null from a non-@Nullable @Provides method")),
            "Cannot return null from a non-@Nullable @Provides method"));
    return instance;
  }

  public static final class Builder {
    private ApplicationModule applicationModule;

    private Builder() {}

    public ApplicationComponent build() {
      if (applicationModule == null) {
        this.applicationModule = new ApplicationModule();
      }
      return new DaggerApplicationComponent(this);
    }

    public Builder applicationModule(ApplicationModule applicationModule) {
      this.applicationModule = Preconditions.checkNotNull(applicationModule);
      return this;
    }
  }
}
