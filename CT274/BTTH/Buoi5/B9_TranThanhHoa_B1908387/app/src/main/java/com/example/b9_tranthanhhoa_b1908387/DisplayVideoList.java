package com.example.b9_tranthanhhoa_b1908387;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class DisplayVideoList extends AppCompatActivity {
    Button backVideo;
    ListView lvVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_video_list);
        // Trở về của Video
        backVideo = findViewById(R.id.btnVideoTrove);
        backVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        lvVideo = findViewById(R.id.lvVideo);
        ArrayList<Bitmap> list4 = new ArrayList<Bitmap>();
        ArrayAdapter<Bitmap> adapter4 = new ArrayAdapter<Bitmap>(this, android.R.layout.simple_list_item_1, list4);
        lvVideo.setAdapter(adapter4);

        ContentResolver cr = getContentResolver();
        String[] proj = {BaseColumns._ID};
        Cursor c = cr.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, proj,
                null, null, null);
        if (c.moveToFirst()) {
            do {
                int id = c.getInt(0);
                Bitmap b = MediaStore.Video.Thumbnails.getThumbnail(cr, id,
                        MediaStore.Video.Thumbnails.MINI_KIND, null);
                Log.d("*****My Thumbnail*****", "onCreate bitmap " + b);
                list4.add(b);
                adapter4.notifyDataSetChanged();
            }
            while (c.moveToNext());
        }

        lvVideo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                    txtChon.setText(listaudio.get(i));
                Toast.makeText(DisplayVideoList.this, "Hay quá ta", Toast.LENGTH_SHORT).show();
            }
        });

        c.close();
    }

    public static Bitmap retriveVideoFrameFromVideo(String videoPath) throws Throwable {
        Bitmap bitmap = null;
        MediaMetadataRetriever mediaMetadataRetriever = null;
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(videoPath, new HashMap<String, String>());
            // mediaMetadataRetriever.setDataSource(videoPath);
            bitmap = mediaMetadataRetriever.getFrameAtTime();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Throwable("Exception in retriveVideoFrameFromVideo(String videoPath)" + e.getMessage());
        } finally {
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
        }
        return bitmap;
    }

}