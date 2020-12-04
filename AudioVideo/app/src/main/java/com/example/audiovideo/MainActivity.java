package com.example.audiovideo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class MainActivity extends Activity  implements View.OnClickListener{
    Button jc01, jc02, jc03, jc04, jv01;
    Bundle bdl;
    Intent itn;
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        jc01 = (Button) findViewById(R.id.xbt1);
        jc02 = (Button) findViewById(R.id.xbt2);
        jc03 = (Button) findViewById(R.id.xbt3);
        jc04 = (Button) findViewById(R.id.xbt4);
        jv01 = (Button) findViewById(R.id.xbt5);
        jc01.setOnClickListener(this);
        jc02.setOnClickListener(this);
        jc03.setOnClickListener(this);
        jc04.setOnClickListener(this);
        jv01.setOnClickListener(this);

    }

    public void onClick(View v){
        String tipo = "";
        Button b = (Button)v;
        int nombreCancion = 0;
        if(v.getId() == R.id.xbt5) {
            tipo = "video";
        }
        else{
            if (v.getId() == R.id.xbt1) {
                nombreCancion = 1;
            }
            if (v.getId() == R.id.xbt2) {
                nombreCancion = 2;
            }
            if (v.getId() == R.id.xbt3) {
                nombreCancion = 3;
            }
            if (v.getId() == R.id.xbt4) {
                nombreCancion = 4;
            }
            tipo = "cancion";
        }

        itn = new Intent( MainActivity.this, SecondaryClass.class);
        bdl = new Bundle();
        bdl.putString("TIPO", tipo);
        bdl.putString("NOMBRE", b.getText().toString());
        bdl.putInt("NOMBRECANCION",nombreCancion);
        itn.putExtras(bdl);
        startActivity(itn);

    }
}