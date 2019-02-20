package com.android.executandovideo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class PlayerActivity extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        videoView = findViewById(R.id.videoViewId);

        //Esconde a statusBar e barra de navegação
        //getWindow - recupera um objeto de dela; getDecorView - recupera objeto que nos permite manipular componentes de tela
        View decorView = getWindow().getDecorView();

        //exibir em tela cheia
        int uiOpcoes = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility( uiOpcoes );

        //Esconder a ActionBar
        getSupportActionBar().hide();

        //Executar o video
        //setMediaController permite que vc defina quais vão ser os controladores desse video
        videoView.setMediaController( new MediaController(this));

        //setVideoPath permite que você defina o caminho / local do video em execução
        videoView.setVideoPath("android.resource://" +getPackageName() + "/" + R.raw.video);

        //para executar o video
        videoView.start();
    }
}
