package com.mewlxy.commontitlebar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mewlxy.library.CommonTitleBar;


public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CommonTitleBar titleBar = (CommonTitleBar) findViewById(R.id.title);
        titleBar.setTitleText("cddddd")
                .setRightImageViewVisibility(false)
                .setRightTextViewVisibility(true)
                .setRightText("测试")
                .setOnLeftClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(), "left click", Toast.LENGTH_SHORT).show();
            }
        }).setOnRightClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(), "right click", Toast.LENGTH_SHORT).show();
            }
        }).setOnSearchClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(), "title click", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
