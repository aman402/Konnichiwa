package com.example.android.konnichiwa;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    MediaPlayer.OnCompletionListener MyOnCompletionListener = mp -> releaseMediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        ArrayList<Word> numbers = new ArrayList<>();
        numbers.add(new Word("father", "お父さん (otousan)", R.drawable.family_father, R.raw.father));
        numbers.add(new Word("mother", "お母さん (okaasan)", R.drawable.family_mother, R.raw.mother));
        numbers.add(new Word("son", "息子 (musuko)", R.drawable.family_son, R.raw.son));
        numbers.add(new Word("daughter", "娘 (musume)", R.drawable.family_daughter, R.raw.daughter));
        numbers.add(new Word("older sister","お姉さん (oneesan)", R.drawable.family_older_sister, R.raw.older_sister));
        numbers.add(new Word("older brother","お兄さん (oniisan)", R.drawable.family_older_brother, R.raw.older_brother));
        numbers.add(new Word("younger sister","妹 (imouto)", R.drawable.family_younger_sister, R.raw.younger_sister));
        numbers.add(new Word("younger brother","弟 (otouto)", R.drawable.family_younger_brother, R.raw.younger_brother));
        // numbers.add(new Word("husband","夫 (otto)"));
        // numbers.add(new Word("wife","妻 (tsuma)"));
        numbers.add(new Word("grandfather","おじいさん (ojiisan)", R.drawable.family_grandfather, R.raw.grandfather));
        numbers.add(new Word("grandmother","おばあさん (obaasan)", R.drawable.family_grandmother, R.raw.grandmother));

        WordAdapter words = new WordAdapter(this, numbers, R.color.green);
        ListView listView = findViewById(R.id.words_list);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            releaseMediaPlayer();
            mediaPlayer = MediaPlayer.create(FamilyActivity.this, numbers.get(position).getMusicId());
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