package com.example.android.konnichiwa;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ColorActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    MediaPlayer.OnCompletionListener MyOnCompletionListener = mp -> releaseMediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        ArrayList<Word> numbers = new ArrayList<>();
        numbers.add(new Word("black", "黒 (kuro)", R.drawable.color_black, R.raw.black));
        numbers.add(new Word("white", "白 (shiro)", R.drawable.color_white, R.raw.white));
        numbers.add(new Word("red","赤 (aka)", R.drawable.color_red, R.raw.red));
        // numbers.add(new Word("blue","青 (ao)"), );
        numbers.add(new Word("yellow","黄色 (kiiro)", R.drawable.color_mustard_yellow, R.raw.yellow));
        // numbers.add(new Word("light green","黄緑 (kkimidori)"));
        numbers.add(new Word("green","緑 (midori)", R.drawable.color_green, R.raw.green));
        numbers.add(new Word("brown","茶色 (chairo)", R.drawable.color_brown, R.raw.brown));
        numbers.add(new Word("grey","灰色 (haiiro)", R.drawable.color_gray, R.raw.grey));
        // numbers.add(new Word("light blue", "水色 (mizuiro)"));

        WordAdapter words = new WordAdapter(this, numbers, R.color.purple_basic);
        ListView listView = findViewById(R.id.words_list);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            releaseMediaPlayer();
            mediaPlayer = MediaPlayer.create(ColorActivity.this, words.getItem(position).getMusicId());
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(MyOnCompletionListener);
        });
        listView.setAdapter(words);
    }
    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}