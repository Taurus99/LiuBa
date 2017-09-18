package com.navinfo.liuba;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.navinfo.liuba.view.ProvinceAndCity;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.activity_register)
public class RegisterActivity extends BaseActivity {
    @ViewInject(R.id.edt_register_userName)
    private EditText edt_userName;
    @ViewInject(R.id.edt_register_userPhone)
    private EditText edt_userPhone;
    @ViewInject(R.id.spn_register_province)
    private Spinner spn_userProvince;
    @ViewInject(R.id.spn_register_city)
    private Spinner spn_userCity;
    @ViewInject(R.id.edt_register_userAddress)
    private EditText edt_address;
    @ViewInject(R.id.edt_register_petNickName)
    private EditText edt_petNickName;
    @ViewInject(R.id.spn_register_petSex)
    private Spinner spn_petSex;
    @ViewInject(R.id.edt_register_petAge)
    private EditText edt_petAge;
    @ViewInject(R.id.spn_register_petKind)
    private Spinner spn_petKind;
    @ViewInject(R.id.edt_register_petHabit)
    private EditText edt_petHabit;
    @ViewInject(R.id.img_register_petImage)
    private ImageView img_petImage;
    @ViewInject(R.id.btn_register_confirm)
    private View btn_register_confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        btn_register_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //初始化省市联动控件
        ProvinceAndCity provinceAndCity = new ProvinceAndCity(RegisterActivity.this, spn_userProvince, spn_userCity);
        //设置性别的可选项
        String[] sexArray=getResources().getStringArray(R.array.sexArray);
        ArrayAdapter sexAdapter = new ArrayAdapter<String>(RegisterActivity.this,
                android.R.layout.simple_spinner_item, sexArray);
        sexAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);// 设置下拉风格
        spn_petSex.setAdapter(sexAdapter);
        spn_petSex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //设置宠物种类的可选项
        String[] kindArray=getResources().getStringArray(R.array.kindArray);
        ArrayAdapter kindAdapter = new ArrayAdapter<String>(RegisterActivity.this,
                android.R.layout.simple_spinner_item, kindArray);
        kindAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);// 设置下拉风格
        spn_petKind.setAdapter(kindAdapter);

    }


}
