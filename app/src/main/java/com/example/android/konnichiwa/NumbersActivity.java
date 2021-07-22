package com.example.android.konnichiwa;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    MediaPlayer.OnCompletionListener MyOnCompletionListener = mp -> releaseMediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        ArrayList<Word> numbers = new ArrayList<>();
        // numbers.add(new Word("zero", "れい (rei)", R.drawable.ic_launcher_background));
        numbers.add(new Word("one", "いち (ichi)", R.drawable.number_one, R.raw.one));
        numbers.add(new Word("two","に (ni)", R.drawable.number_two, R.raw.two));
        numbers.add(new Word("three","さん (san)", R.drawable.number_three, R.raw.three));
        numbers.add(new Word("four","よん (yon)", R.drawable.number_four, R.raw.four));
        numbers.add(new Word("five","ご (go)", R.drawable.number_five, R.raw.five));
        numbers.add(new Word("six","ろく (roku)", R.drawable.number_six, R.raw.six));
        numbers.add(new Word("seven","なな (nana)", R.drawable.number_seven, R.raw.seven));
        numbers.add(new Word("eight","はち (hachi)", R.drawable.number_eight, R.raw.eight));
        numbers.add(new Word("nine","きゅう (kyuu)", R.drawable.number_nine, R.raw.nine));
        numbers.add(new Word("ten","じゅう (juu)", R.drawable.number_ten, R.raw.ten));

        WordAdapter words = new WordAdapter(this, numbers, R.color.orange);
        ListView listView = findViewById(R.id.words_list);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            releaseMediaPlayer();
            mediaPlayer = MediaPlayer.create(NumbersActivity.this, numbers.get(position).getMusicId());
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