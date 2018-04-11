package com.beesightsoft.training6.domain;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.beesightsoft.training5.R;
import com.beesightsoft.training6.factory.RetrofitClient;
import com.beesightsoft.training6.service.model.Post;
import com.beesightsoft.training6.service.model.RestPostService;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@EActivity(R.layout.activity_signin)
public class SigninActivity extends AppCompatActivity {

    @ViewById(R.id.activity_signin_tv_response)
    TextView responseTextView;

    @ViewById(R.id.activity_signin_et_title)
    EditText etTitle;

    @ViewById(R.id.activity_signin_et_body)
    EditText etBody;

    @ViewById(R.id.activity_signin_btn_put)
    Button btnPut;

    @ViewById(R.id.activity_signin_btn_post)
    Button btnPost;

    @ViewById(R.id.activity_signin_btn_delete)
    Button btnDelete;

    @Inject
    RestPostService restPostService;

    @AfterViews
    void initInject() {
        restPostService = RetrofitClient.getAPIService(RetrofitClient.provideRetrofit());
    }

    @Click(R.id.activity_signin_btn_post)
    void btnPostClick() {
        String title = etTitle.getText().toString().trim();
        String body = etBody.getText().toString().trim();
        if(!TextUtils.isEmpty(title) && !TextUtils.isEmpty(body)) {
            sendPost(title,body);
        }
    }

    @Click(R.id.activity_signin_btn_put)
    void btnPut() {
        String title = etTitle.getText().toString().trim();
        String body = etBody.getText().toString().trim();
        if(!TextUtils.isEmpty(title) && !TextUtils.isEmpty(body)) {
            updatePost(title,body);
        }
    }

    @Click(R.id.activity_signin_btn_delete)
    void btnDelete() {
        deletePost();
    }

    public void deletePost() {
        restPostService.deletePost(1).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                int n = response.code();
                Toast.makeText(SigninActivity.this,"deleted object", Toast.LENGTH_SHORT).show();
                if(response.isSuccessful()) {
                    showResponse(response.body().toString());
                    Log.i("tag", "delete submitted to API." + response.body().toString());
                    Toast.makeText(SigninActivity.this,"deleted object", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.e("tag", "Unable to submit delete to API.");
            }
        });
    }

    public void updatePost(String title, String body) {
        restPostService.updatePost(1, title, body, 1).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if(response.isSuccessful()) {
                    showResponse(response.body().toString());
                    Log.i("tag", "post submitted to API." + response.body().toString());

                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.e("tag", "Unable to submit post to API.");
            }
        });
    }

    public void sendPost(String title, String body) {
        restPostService.savePost(title, body, 1).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if(response.isSuccessful()) {
                    showResponse(response.body().toString());
                    Log.i("tag", "post submitted to API." + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.e("tag", "Unable to submit post to API.");
            }
        });
    }

    public void showResponse(String response) {
        if(responseTextView.getVisibility() == View.GONE) {
            responseTextView.setVisibility(View.VISIBLE);
        }
        responseTextView.setText(response);
    }

   /* public void sendPostRxJava(String title, String body) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RestPostService restPostService = retrofit.create(RestPostService.class);
        // RxJava
       apiService.savePostRxJava(title, body, 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Post>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Post post) {
                        showResponse(post.toString());
                    }
                });
    }*/
}
