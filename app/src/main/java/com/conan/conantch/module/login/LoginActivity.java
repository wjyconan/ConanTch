package com.conan.conantch.module.login;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

import com.conan.conantch.R;
import com.conan.conantch.app.BaseActivity;
import com.conan.conantch.config.HttpMethods;
import com.conan.conantch.config.ProgressSubscriber;
import com.conan.conantch.config.SubscriberOnNextListener;
import com.conan.conantch.model.entities.LoginEntity;
import com.conan.conantch.module.main.MainActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A login screen that offers login via email/password.
 * Create by conan on 16/9/29.
 */
public class LoginActivity extends BaseActivity {

    @Bind(R.id.email)
    AutoCompleteTextView mEmailView;
    @Bind(R.id.password)
    EditText mPasswordView;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    private SubscriberOnNextListener<LoginEntity> loginOnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        initView();
        initData();
    }

    //初始化页面
    private void initView() {
        setSupportActionBar(toolbar);

        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });
    }

    //初始化数据请求
    private void initData() {
        loginOnNext = new SubscriberOnNextListener<LoginEntity>() {
            @Override
            public void onNext(LoginEntity loginEntity) {
                if (loginEntity.getRet() == 0) {
                    startActivity(MainActivity.class);
                    finish();
                } else {
                    showLongToast(loginEntity.getMsg());
                }
            }
        };
    }


    /**
     * 判断用户名和密码是否合法,然后进行登录操作
     */
    private void attemptLogin() {

        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (TextUtils.isEmpty(password) || !isPasswordValid(password)) {
            showLongToast(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        } else if (TextUtils.isEmpty(email)) {  // Check for a valid email address.
            showLongToast(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            showLongToast(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {
            //网络请求 登录
            HttpMethods.getInstance().login(new ProgressSubscriber<>(loginOnNext, LoginActivity.this), mEmailView.getText().toString(), mPasswordView.getText().toString());
        }
    }

    /**
     * 检测用户名是否合法
     *
     * @param email 用户名
     * @return 是否合法
     */
    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.length() != 0;
    }

    /**
     * 检测密码格式是否合法
     *
     * @param password 密码
     * @return 是否合法
     */
    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() >= 6 && password.length() < 30;
    }


    @OnClick(R.id.email_sign_in_button)
    public void onClick() {
        attemptLogin();
    }
}

