package com.example.mediaplayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

public class PlayActivity extends AppCompatActivity {
    ImageView i1,i2,i3;
    TextView tv;
    SeekBar sb;
    MediaPlayer mp;
    int position;

    String sname;

    Thread updateSeekBar;
    ArrayList<File> mySongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        mp=new MediaPlayer();

        i1=(ImageView)findViewById(R.id.play);
        i2=(ImageView)findViewById(R.id.skip_next);
        i3=(ImageView)findViewById(R.id.skip_back);

        tv=(TextView)findViewById(R.id.songs);

        sb=(SeekBar)findViewById(R.id.seekbar);

        getSupportActionBar().setTitle("Now Playing");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        updateSeekBar=new Thread()
        {
            @Override
            public void run() {
                int totalDuration=mp.getDuration();
                int currPosition=0;

                while(currPosition<totalDuration)
                {
                    try {
                        sleep(500);
                        currPosition=mp.getCurrentPosition();
                        sb.setProgress(currPosition);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }

                if(mp!=null)
                {
                    mp.stop();
                    mp.release();
                }
                Intent i=getIntent();
                Bundle bundle=i.getExtras();

                mySongs=(ArrayList)bundle.getParcelableArrayList("songs");

                sname=mySongs.get(position).getName();

                String songName=i.getStringExtra("songname");
                tv.setText(songName);
                tv.setSelected(true);

                position=bundle.getInt("pos",0);

                Uri u= Uri.parse(mySongs.get(position).toString());

                mp=MediaPlayer.create(getApplicationContext(),u);
                mp.start();
                sb.setProgress(mp.getDuration());

                updateSeekBar.start();
                sb.getProgressDrawable().setColorFilter(getResources().getColor(R.color.color_primary), PorterDuff.Mode.MULTIPLY);
                sb.getThumb().setColorFilter(getResources().getColor(R.color.color_primary),PorterDuff.Mode.MULTIPLY);

                sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                      mp.seekTo(sb.getProgress());
                    }
                });
            }
        };
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sb.setMax(mp.getDuration());

                if(mp.isPlaying())
                {
                    i1.setImageResource(R.drawable.pause);
                    mp.pause();
                }
                else
                {
                    i1.setImageResource(R.drawable.play);
                    mp.start();
                }
            }
        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                mp.release();
                position=(position+1)%mySongs.size();

                Uri u=Uri.parse(mySongs.get(position).toString());

                mp=MediaPlayer.create(getApplicationContext(),u);
                sname=mySongs.get(position).getName();
                tv.setText(sname);
                mp.start();
            }
        });

        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                mp.release();
                position=(position-1)<0?(mySongs.size()-1):(position-1);

                Uri u=Uri.parse(mySongs.get(position).toString());

                mp=MediaPlayer.create(getApplicationContext(),u);
                sname=mySongs.get(position).getName();
                tv.setText(sname);
                mp.start();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home)
        {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }


}