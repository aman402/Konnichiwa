package com.example.android.konnichiwa;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    MediaPlayer.OnCompletionListener MyOnCompletionListener = mp -> releaseMediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        ArrayList<Word> numbers = new ArrayList<>();
        numbers.add(new Word("Naruto Shippuden", "Obito Uchiha", R.drawable.obito, R.raw.uchihamadara));
        numbers.add(new Word("Hunter X Hunter", "Zeno Zoldyck", R.drawable.zeno, R.raw.dragondive ));
        numbers.add(new Word("Naruto Shippuden", "Itachi Uchiha", R.drawable.itachi, R.raw.itachiuchiha));
        numbers.add(new Word("Hokuto no Ken", "Kenshiro", R.drawable.hokuto, R.raw.hokutonoken));
        numbers.add(new Word("JoJo's Bizzare Adventures", "Dio vs Jotaro", R.drawable.dio, R.raw.jojo));

        WordAdapter words = new WordAdapter(this, numbers, R.color.sky_blue);
        ListView listView = findViewById(R.id.words_list);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            releaseMediaPlayer();
            mediaPlayer = MediaPlayer.create(PhrasesActivity.this, words.getItem(position).getMusicId());
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