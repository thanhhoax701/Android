package com.example.b9_tranthanhhoa_b1908387;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DisplayAudioList extends AppCompatActivity {
    Button backAudio;
    ListView lvAudio;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_audio_list);
        TextView txtChon = findViewById(R.id.txtShow);

        // Trở về của Audio
        backAudio = findViewById(R.id.btnAudioTrove);
        backAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        // Danh sách bài hát
        lvAudio = findViewById(R.id.lvAudio);
        ArrayList<String> listaudio = new ArrayList<String>();
        ArrayAdapter<String> adapteraudio = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaudio);
        lvAudio.setAdapter(adapteraudio);
        // lay cac cot nhu trong bang projection
        String[] projection = new String[]{
                MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.DISPLAY_NAME,
                MediaStore.Audio.Media.DURATION};
        Cursor cursor = getApplicationContext().getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, projection,
                null, null, "LOWER(" + MediaStore.Audio.Media.TITLE + ") ASC");
        int count = 0;
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            String ds = "count: " + count
                    + "\n_id: " + cursor.getString(0)
                    + "\n artist: " + cursor.getString(1)
                    + "\ntitle: " + cursor.getString(2)
                    + "\ndata: " + cursor.getString(3)
                    + "\ndisplay name: " + cursor.getString(4)
                    + "\nduration: " + cursor.getString(5)
                    + "\n--------------------------";
            listaudio.add(ds);
            adapteraudio.notifyDataSetChanged();
            // Phát nhạc
            lvAudio.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                    txtChon.setText(listaudio.get(i));
//                    Toast.makeText(DisplayAudioList.this, listaudio.get(i), Toast.LENGTH_SHORT).show();
//                    Intent intentPlayAudio = new Intent(DisplayAudioList.this, PlayAudio.class);
//                    startActivity(intentPlayAudio);
                    startActivity(new Intent(DisplayAudioList.this, PlayAudio.class)
                    .putExtra("songsList", ds));
                }
            });
            // log toan bo danh sach bai hat ra logcat
            Log.d("ListMusic",
                    "\ncount: " + count + "\n_id: " + cursor.getString(0)
                            + "\n artist: " + cursor.getString(1) + "\ntitle: "
                            + cursor.getString(2) + "\ndata: "
                            + cursor.getString(3) + "\ndisplay name: "
                            + cursor.getString(4) + "\n duration: "
                            + cursor.getString(5)
                            + "\n--------------------------");
            cursor.moveToNext();
            count++;
        }
        cursor.close();
    }
}