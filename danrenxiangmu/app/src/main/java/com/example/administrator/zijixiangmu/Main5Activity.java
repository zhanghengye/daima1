package com.example.administrator.zijixiangmu;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.zijixiangmu.base.GouWuContract;
import com.example.administrator.zijixiangmu.base.GouWuModel;
import com.example.administrator.zijixiangmu.base.GouWuPresenter;
import com.example.administrator.zijixiangmu.moban.BaseActivity;
import com.example.administrator.zijixiangmu.utils.MD5Utils;
import com.example.administrator.zijixiangmu.utils.SpUtils;

public class Main5Activity extends BaseActivity<GouWuPresenter, GouWuModel> implements GouWuContract.View, View.OnClickListener {

    private TextView mText;
    private EditText mPsw;
    private Button mBaoCun;
    public static final String psw="[0-9a-zA-Z]{8,32}";
    private String s;
    private ImageView mImg;

    @Override
    protected void initView() {

        mText = (TextView) findViewById(R.id.mText);
        mImg = (ImageView) findViewById(R.id.mImg5);
        mImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mText.setText(App.phone);
        mPsw = (EditText) findViewById(R.id.mPsw);
        mBaoCun = (Button) findViewById(R.id.mBaoCun);
        mBaoCun.setOnClickListener(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main5;
    }

    @Override
    public void getUrlDataOk(int code) {
        switch (code){
            case 100:
                //todo 这应该是跳转到首页 并且把首页的红包隐藏   难点：登陆状态
                SpUtils.setPhone(this,"psw",App.phone,s);
                Toast.makeText(this, "设置成功", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void getUrlDataNo(String str) {
        if(!TextUtils.isEmpty(str)){
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mBaoCun:
                submit();
                break;
        }
    }

    private void submit() {
        // validate
        String mPswString = mPsw.getText().toString().trim();
        if (TextUtils.isEmpty(mPswString)) {
            Toast.makeText(this, "请输入8-32位(数字+字母)的密码", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
            if(mPswString.matches(psw)){
                s = MD5Utils.stringToMD5(mPswString);
                mPresenter.XinMiMa(App.phone, s,App.code);
            }

    }
}
