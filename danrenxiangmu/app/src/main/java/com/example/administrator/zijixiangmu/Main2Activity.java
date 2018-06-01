package com.example.administrator.zijixiangmu;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.zijixiangmu.base.GouWuContract;
import com.example.administrator.zijixiangmu.base.GouWuModel;
import com.example.administrator.zijixiangmu.base.GouWuPresenter;
import com.example.administrator.zijixiangmu.moban.BaseActivity;
import com.example.administrator.zijixiangmu.utils.MD5Utils;
import com.example.administrator.zijixiangmu.utils.SpUtils;
import com.example.administrator.zijixiangmu.utils.StartactivityUtils;

public class Main2Activity extends BaseActivity<GouWuPresenter, GouWuModel> implements GouWuContract.View, View.OnClickListener {

    private TextView m2Phone;
    private EditText m2Psw;
    private TextView mDuanXin;
    private TextView mChongZhi;
    private Button m2Button;
    private String s;

    @Override
    protected void initView() {
        m2Phone = (TextView) findViewById(R.id.m2Phone);
        m2Phone.setText(App.phone);
        m2Psw = (EditText) findViewById(R.id.m2Psw);
        mDuanXin = (TextView) findViewById(R.id.mDuanXin);
        mChongZhi = (TextView) findViewById(R.id.mChongZhi);
        mChongZhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo 这个页面直接跳转到图四注册页面
                StartactivityUtils.startactivity(Main2Activity.this,Main4Activity.class);
            }
        });
        m2Button = (Button) findViewById(R.id.m2Button);
        m2Button.setOnClickListener(this);
        mDuanXin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.loginYanZheng(App.phone,"3");
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main2;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.m2Button:
                submit();
                break;
        }
    }

    private void submit() {
        // validate
        String m2PswString = m2Psw.getText().toString();
        if (TextUtils.isEmpty(m2PswString)) {
            Toast.makeText(this, "m2PswString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        // TODO validate success, do something
        s = MD5Utils.stringToMD5(m2PswString);
        mPresenter.loginPas(App.phone, s);

    }

    @Override
    public void getUrlDataOk(int code) {
        switch (code){
            case 0:
                //todo 这个是通过密码请求登陆结果
               // StartactivityUtils.startactivity(Main2Activity.this,null);
                SpUtils.setPhone(this,"psw",App.phone,s);
                Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
               // finish();
                break;
            case 10:
                //todo 获取验证码并跳转到第三个用验证码登陆页面
                StartactivityUtils.startactivity(Main2Activity.this,Main3Activity.class);
                break;
        }
    }

    @Override
    public void getUrlDataNo(String str) {
        if(!TextUtils.isEmpty(str)){
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        }
    }
}
