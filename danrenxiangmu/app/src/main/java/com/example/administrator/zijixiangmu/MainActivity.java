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
import com.example.administrator.zijixiangmu.utils.SpUtils;
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
            String psw = (String) SpUtils.getPhone(this, "psw", mNameString, "aa");
            if(psw.equals("aa")){
                StartactivityUtils.startactivity(MainActivity.this,Main2Activity.class);
            }else{
                //todo 第二次登陆直接跳转到首页
                mPresenter.loginPas(mNameString,psw);
            }
        }
    }

    @Override
    public void getUrlDataOk(int code) {
        switch (code){
            case 0:
                //todo 请求成功跳转首页
                Toast.makeText(this, "不是第一次登陆", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void getUrlDataNo(String str) {
        //todo 请求失败返回错误信息
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
