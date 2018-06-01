package com.example.administrator.zijixiangmu;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
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
import com.example.administrator.zijixiangmu.utils.StartactivityUtils;

public class Main4Activity extends BaseActivity<GouWuPresenter, GouWuModel> implements GouWuContract.View, View.OnClickListener {

    private EditText one1;
    private EditText er1;
    private EditText san1;
    private EditText si1;
    private TextView chongxin2;
    private Button mYanZheng;
    private StringBuffer sb;
    private ImageView mImg;

    @Override
    protected void initView() {
        mPresenter.loginYanZheng(App.phone,"0");
        mImg = (ImageView) findViewById(R.id.mImg5);
        mImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        one1 = (EditText) findViewById(R.id.one1);
        er1 = (EditText) findViewById(R.id.er1);
        san1 = (EditText) findViewById(R.id.san1);
        si1 = (EditText) findViewById(R.id.si1);

        one1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().length()==1){
                    er1.requestFocus();
                }
            }
        });
        er1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().length()==1){
                    san1.requestFocus();
                }else{
                    one1.requestFocus();
                }
            }
        });
        san1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().length()==1){
                    si1.requestFocus();
                }else{
                    er1.requestFocus();
                }
            }
        });
        si1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().length()==1){

                }else{
                    san1.requestFocus();
                }
            }
        });

        chongxin2 = (TextView) findViewById(R.id.chongxin2);
        mYanZheng = (Button) findViewById(R.id.mYanZheng);
        mYanZheng.setOnClickListener(this);
        chongxin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.loginYanZheng(App.phone,"0");
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main4;
    }

    @Override
    public void getUrlDataOk(int code) {
        switch (code){
            case 20:
                //todo 验证成功 把输入框的字符串储存起来并跳转至第五个页面
                App.code=sb.toString();
                StartactivityUtils.startactivity(Main4Activity.this,Main5Activity.class);
               // Toast.makeText(this, "验证成功" + App.code, Toast.LENGTH_SHORT).show();
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
            case R.id.mYanZheng:
                String one1String = one1.getText().toString();
                String er1String = er1.getText().toString();
                String san1String = san1.getText().toString();
                String si1String = si1.getText().toString();
                sb = new StringBuffer();
                sb.append(one1String);
                sb.append(er1String);
                sb.append(san1String);
                sb.append(si1String);
                mPresenter.YanzhengYanzheng(App.phone,sb.toString(),"0");
                break;
        }
    }
}
