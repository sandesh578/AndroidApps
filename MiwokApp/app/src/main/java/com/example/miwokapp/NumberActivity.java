package com.example.miwokapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class NumberActivity extends AppCompatActivity {
    private MediaPlayer mp;
    private AudioManager am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener=new AudioManager.OnAudioFocusChangeListener() {
            @Override
            public void onAudioFocusChange(int focusChange) {
                if(focusChange==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT||focusChange==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK)
                {
                    mp.pause();
                    mp.seekTo(0);
                }
                else if(focusChange==AudioManager.AUDIOFOCUS_GAIN)
                {
                    mp.start();
                }
                else if(focusChange==AudioManager.AUDIOFOCUS_LOSS)
                {
                    releaseMediaPlayer();
                }
            }
        };

        MediaPlayer.OnCompletionListener mCompletionListener=new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                releaseMediaPlayer();
            }
        };
        final ArrayList<Word> words=new ArrayList<Word>();


        words.add(new Word("one","ek",R.mipmap.ic_launcher,R.raw.ek));
        words.add(new Word("two","dui",R.mipmap.ic_launcher,R.raw.dui));
        words.add(new Word("three","tin",R.mipmap.ic_launcher,R.raw.tin));
        words.add(new Word("four","char",R.mipmap.ic_launcher,R.raw.xar));
        words.add(new Word("five","pach",R.mipmap.ic_launcher,R.raw.panch));
        words.add(new Word("six","xa",R.mipmap.ic_launcher,R.raw.xa));
        words.add(new Word("seven","sat",R.mipmap.ic_launcher,R.raw.sat));
        words.add(new Word("eight","eath",R.mipmap.ic_launcher,R.raw.eath));
        words.add(new Word("nine","nau",R.mipmap.ic_launcher,R.raw.nau));
        words.add(new Word("ten","thus",R.mipmap.ic_launcher,R.raw.das));

        WordAdapter ad=new WordAdapter(this, words,R.color.category_colors);

        ListView lv=(ListView)findViewById(R.id.list);
        //GridView lv=(GridView)findViewById(R.id.list);
        lv.setAdapter(ad);

        ImageView img=(ImageView)findViewById(R.id.playbtn);

       /* img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Word word=words.get(position);
                //mp=MediaPlayer.create(NumberActivity.this,word.getmAudioResourceId());
                mp.start();
                mp.setOnCompletionListener(mCompletionListener);
            }
        });*/

       lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // Toast.makeText(NumberActivity.this, "List item is clicked", Toast.LENGTH_SHORT).show();
                releaseMediaPlayer();
                Word word=words.get(position);
                mp=MediaPlayer.create(NumberActivity.this,word.getmAudioResourceId());
                mp.start();
                mp.setOnCompletionListener(mCompletionListener);
            }
            });

    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer()
    {
        if(mp!=null)
        {
            mp.release();
        }
        else
        {
            mp=null;
        }
    }
}
