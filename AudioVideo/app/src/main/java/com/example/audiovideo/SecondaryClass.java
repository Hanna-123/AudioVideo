package com.example.audiovideo;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.widget.*;
public class SecondaryClass extends Activity {
    TextView jtv1;
    Bundle bdl;
    MediaPlayer mp;
    VideoView vvw;
    Uri uri;
    MediaController mcr;
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.second_activity);
        jtv1 = (TextView)findViewById(R.id.xtv1);
        bdl = getIntent().getExtras();
        String nombre = bdl.getString("NOMBRE");
        String tipo = bdl.getString("TIPO");
        int nombreCancion = bdl.getInt("NOMBRECANCION");
        jtv1.append("Reproduciendo: "+ nombre);
        if (nombreCancion == 1){
            reproducir(R.raw.adele_hello);
        }
        if (nombreCancion == 2){
            reproducir(R.raw.ahhh);
        }
        if (nombreCancion == 3){
            reproducir(R.raw.aplauso);
        }
        if (nombreCancion == 4){
            reproducir(R.raw.you_got_it);
        }
        if (nombreCancion == 0){
            vvw = (VideoView) findViewById(R.id.xvv1);
            uri = Uri.parse("android.resource://com.example.audiovideo/"+
                    R.raw.this_is_love);
            mcr = new MediaController(this);
            vvw.setMediaController(mcr);
            vvw.setVideoURI(uri);
            vvw.start();

        }

    }
    void reproducir(int cancion){
        if(mp != null) mp.release();
        mp = MediaPlayer.create(this, cancion);
        mp.seekTo(0);
        mp.start();

    }
    public void onPause(){
        super.onPause();
        if(mp != null)
            mp.release();
    }
}
