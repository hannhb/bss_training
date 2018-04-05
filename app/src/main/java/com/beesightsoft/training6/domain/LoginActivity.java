package com.beesightsoft.training6.domain;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.beesightsoft.training6.factory.DaggerApplicationComponent;
import com.beesightsoft.training6.service.model.RestCommentService;
import com.beesightsoft.training5.R;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@SuppressLint("Registered")
@EActivity(R.layout.activity_login)
public class LoginActivity extends AppCompatActivity {

    @ViewById(R.id.activity_login_tv_content)
    protected TextView tvContent;

    @Inject
    protected RestCommentService restCommentService;

    @AfterInject
    void afterInject() {
        DaggerApplicationComponent.builder()
                .build()
                .inject(this);
    }

    @SuppressLint("SetTextI18n")
    @AfterViews
    void afterView() {
        restCommentService.getCommentsUseRx()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(comments -> {
                    tvContent.setText("Rx Dagger success: " + comments.size() + " items");
                }, throwable -> {
                    tvContent.setText("Rx failed: " + throwable.getMessage());
                });
    }

    /*IMPLEMENT PUT, POST, DELETE WITH RETROFIT IN OTHER ACTIVITY*/

    /*
    //Get Comments use Rx
    private void getCommentUseRx() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RestCommentService restCommentService = retrofit.create(RestCommentService.class);

        restCommentService.getCommentsUseRx()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(comments -> {
                    tvContent.setText("Rx success: " + comments.size() + " items");
                }, throwable -> {
                    tvContent.setText("Rx failed: " + throwable.getMessage());
                });
    }*/

    /*
    --> Use retrofit in default way
    @Background
    protected void getComments(Retrofit retrofit) {
        RestCommentService restCommentService = retrofit.create(RestCommentService.class);
        Call<List<Comment>> call = restCommentService.getComments();

        try {
            List<Comment> comments = call.execute().body();
            showComments(comments);
        } catch (IOException e) {
            e.printStackTrace();
            tvContent.setText("Error");
        }
    }

    @UiThread
    protected  void showComments(List<Comment> comments) {
        tvContent.setText("Success: " + comments.size() + " items");
    }*/
}
