package com.example.administrator.zijixiangmu;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.zijixiangmu.base.GouWuContract;
import com.example.administrator.zijixiangmu.base.GouWuModel;
import com.example.administrator.zijixiangmu.base.GouWuPresenter;
import com.example.administrator.zijixiangmu.moban.BaseActivity;
import com.example.administrator.zijixiangmu.utils.SpUtils;
import com.example.administrator.zijixiangmu.utils.StartactivityUtils;
import com.github.glomadrian.codeinputlib.CodeInput;

import java.util.Arrays;

public class Main3Activity extends BaseActivity<GouWuPresenter, GouWuModel> implements GouWuContract.View {

    private TextView chongXin;
    private TextView mima;
    private EditText one;
    private EditText er;
    private EditText san;
    private EditText si;
    private ImageView mImg;
    private TextView p;

    @Override
    protected void initView() {
        mImg = (ImageView) findViewById(R.id.mImg3);
        mImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        p = (TextView) findViewById(R.id.phoneNum_tv);
        p.setText("短信验证码发送到"+App.phone);
        one = (EditText) findViewById(R.id.one);
        er = (EditText)findViewById(R.id.er);
        san =(EditText) findViewById(R.id.san);
        si = (EditText)findViewById(R.id.si);
        one.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                    if(editable.toString().length()==1){
                        er.requestFocus();
                    }
            }
        });
        er.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().length()==1){
                    san.requestFocus();
                }else{
                    one.requestFocus();
                }
            }
        });
        san.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                    if(editable.toString().length()==1){
                        si.requestFocus();
                    }else{
                        er.requestFocus();
                    }
            }
        });
        si.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().length()==1){
                    String s = one.getText().toString();
                    String er1 = er.getText().toString();
                    String san1 = san.getText().toString();
                    String si1 = si.getText().toString();
                    StringBuffer sb = new StringBuffer();
                    sb.append(s);
                    sb.append(er1);
                    sb.append(san1);
                    sb.append(si1);
                    mPresenter.loginYanZhengDenglu(App.phone,sb.toString());
                }else{
                    san.requestFocus();
                }
            }
        });

        chongXin = (TextView) findViewById(R.id.chongXin);
        mima = (TextView) findViewById(R.id.mima);
        chongXin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.loginYanZheng(App.phone,"3");
            }
        });
        mima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main3;
    }

    @Override
    public void getUrlDataOk(int code) {
        switch (code) {
            case 11:
                //todo 验证成功跳转到首页界面
              //  StartactivityUtils.startactivity(Main3Activity.this,null);
                SpUtils.setPhone(this,"psw",App.phone,"bbb");
                Toast.makeText(this, "跳转成功", Toast.LENGTH_SHORT).show();
                break;
            case 10:
                Toast.makeText(this, "验证码发送成功", Toast.LENGTH_SHORT).show();
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
