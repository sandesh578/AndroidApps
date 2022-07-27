package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

public class MainActivity extends AppCompatActivity {
    String[] items;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView)findViewById(R.id.list);

        runtimePermission();
    }
    public void runtimePermission()
    {
        Dexter.withActivity(this)
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                          display();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();
                    }
                }).check();
    }
    public ArrayList<File> findSongs(File file)
    {
        ArrayList<File> songsArrayList=new ArrayList<File>();

        File[] files=file.listFiles();
        for(File singleFile:files)
        {
            if(singleFile.isDirectory()&&singleFile.isHidden())
            {
                songsArrayList.addAll(findSongs(singleFile));
            }
            else
            {
                if(singleFile.getName().endsWith(".mp3")||singleFile.getName().endsWith(".wav"))
                {
                    songsArrayList.add(singleFile);
                }
            }
        }
        return songsArrayList;
    }

    void display()
    {
        final ArrayList<File> arrayList=findSongs(Environment.getExternalStorageDirectory());
        items= new String[arrayList.size()];
        for(int i=0;i<arrayList.size();i++)
        {
            items[i]=arrayList.get(i).getName().toString().replace(".mp3","").replace(".wav","");
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String songName=listView.getItemAtPosition(position).toString();

                startActivity(new Intent(getApplicationContext(),PlayActivity.class)
                        .putExtra("songs",arrayList)
                        .putExtra("songName",songName)
                        .putExtra("pos",position)
                );
            }
        });

    }

}