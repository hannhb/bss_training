//
// DO NOT EDIT THIS FILE.
// Generated using AndroidAnnotations 4.3.1.
// 
// You can create a larger work that contains this file and distribute that work under terms of your choice.
//

package com.beesightsoft.training6.domain;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import com.beesightsoft.training5.R;
import org.androidannotations.api.builder.ActivityIntentBuilder;
import org.androidannotations.api.builder.PostActivityStarter;
import org.androidannotations.api.view.HasViews;
import org.androidannotations.api.view.OnViewChangedListener;
import org.androidannotations.api.view.OnViewChangedNotifier;

public final class SigninActivity_
    extends SigninActivity
    implements HasViews, OnViewChangedListener
{
    private final OnViewChangedNotifier onViewChangedNotifier_ = new OnViewChangedNotifier();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        OnViewChangedNotifier previousNotifier = OnViewChangedNotifier.replaceNotifier(onViewChangedNotifier_);
        init_(savedInstanceState);
        super.onCreate(savedInstanceState);
        OnViewChangedNotifier.replaceNotifier(previousNotifier);
        setContentView(R.layout.activity_signin);
    }

    @Override
    public<T extends View> T internalFindViewById(int id) {
        return ((T) this.findViewById(id));
    }

    private void init_(Bundle savedInstanceState) {
        OnViewChangedNotifier.registerOnViewChangedListener(this);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    @Override
    public void setContentView(View view, LayoutParams params) {
        super.setContentView(view, params);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    public static SigninActivity_.IntentBuilder_ intent(Context context) {
        return new SigninActivity_.IntentBuilder_(context);
    }

    public static SigninActivity_.IntentBuilder_ intent(android.app.Fragment fragment) {
        return new SigninActivity_.IntentBuilder_(fragment);
    }

    public static SigninActivity_.IntentBuilder_ intent(android.support.v4.app.Fragment supportFragment) {
        return new SigninActivity_.IntentBuilder_(supportFragment);
    }

    @Override
    public void onViewChanged(HasViews hasViews) {
        this.responseTextView = hasViews.internalFindViewById(R.id.activity_signin_tv_response);
        this.etTitle = hasViews.internalFindViewById(R.id.activity_signin_et_title);
        this.etBody = hasViews.internalFindViewById(R.id.activity_signin_et_body);
        this.btnPut = hasViews.internalFindViewById(R.id.activity_signin_btn_put);
        this.btnPost = hasViews.internalFindViewById(R.id.activity_signin_btn_post);
        this.btnDelete = hasViews.internalFindViewById(R.id.activity_signin_btn_delete);
        if (this.btnPost!= null) {
            this.btnPost.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    SigninActivity_.this.btnPostClick();
                }
            }
            );
        }
        if (this.btnPut!= null) {
            this.btnPut.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    SigninActivity_.this.btnPut();
                }
            }
            );
        }
        if (this.btnDelete!= null) {
            this.btnDelete.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    SigninActivity_.this.btnDelete();
                }
            }
            );
        }
        initInject();
    }

    public static class IntentBuilder_
        extends ActivityIntentBuilder<SigninActivity_.IntentBuilder_>
    {
        private android.app.Fragment fragment_;
        private android.support.v4.app.Fragment fragmentSupport_;

        public IntentBuilder_(Context context) {
            super(context, SigninActivity_.class);
        }

        public IntentBuilder_(android.app.Fragment fragment) {
            super(fragment.getActivity(), SigninActivity_.class);
            fragment_ = fragment;
        }

        public IntentBuilder_(android.support.v4.app.Fragment fragment) {
            super(fragment.getActivity(), SigninActivity_.class);
            fragmentSupport_ = fragment;
        }

        @Override
        public PostActivityStarter startForResult(int requestCode) {
            if (fragmentSupport_!= null) {
                fragmentSupport_.startActivityForResult(intent, requestCode);
            } else {
                if (fragment_!= null) {
                    fragment_.startActivityForResult(intent, requestCode, lastOptions);
                } else {
                    if (context instanceof Activity) {
                        Activity activity = ((Activity) context);
                        ActivityCompat.startActivityForResult(activity, intent, requestCode, lastOptions);
                    } else {
                        context.startActivity(intent, lastOptions);
                    }
                }
            }
            return new PostActivityStarter(context);
        }
    }
}
