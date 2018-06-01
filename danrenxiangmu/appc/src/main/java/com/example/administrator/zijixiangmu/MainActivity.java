package com.example.administrator.zijixiangmu;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.zijixiangmu.base.GouWuContract;
import com.example.administrator.zijixiangmu.base.GouWuModel;
import com.example.administrator.zijixiangmu.base.GouWuPresenter;
import com.example.administrator.zijixiangmu.moban.BaseActivity;
import com.example.administrator.zijixiangmu.utils.StartactivityUtils;
import com.example.administrator.zijixiangmu.utils.ZhengZe;

public class MainActivity extends BaseActivity<GouWuPresenter, GouWuModel> implements GouWuContract.View, View.OnClickListener {

    private EditText mName;
    private Button mButton;

    @Override
    protected void initView() {

        mName = (EditText) findViewById(R.id.mName);
        mName.setOnClickListener(this);
        mButton = (Button) findViewById(R.id.mButton);
        mButton.setOnClickListener(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mButton:
                submit();
                break;
        }
    }

    private void submit() {
        // validate
        String mNameString = mName.getText().toString().trim();
        if (TextUtils.isEmpty(mNameString)) {
            Toast.makeText(this, "mNameString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if(mNameString.matches(ZhengZe.phone)){
            App.phone=mNameString;
            StartactivityUtils.startactivity(MainActivity.this,Main2Activity.class);
        }
    }

    @Override
    public void getUrlDataOk(int code) {

    }

    @Override
    public void getUrlDataNo(String str) {

    }
}
