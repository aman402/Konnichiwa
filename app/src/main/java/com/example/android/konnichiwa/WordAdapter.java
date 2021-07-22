package com.example.android.konnichiwa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    private final int background_color;

    public WordAdapter(Context context, ArrayList<Word> wordList, int c)
    {
        super(context, 0, wordList);
        background_color = c;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);

        LinearLayout L2 = listItemView.findViewById(R.id.L2);
        L2.setBackgroundResource(background_color);

        TextView tv = listItemView.findViewById(R.id.japanese_word);
        tv.setText(currentWord.getJapaneseTranslation());

        tv = listItemView.findViewById(R.id.default_word);
        tv.setText(currentWord.getDefaultTranslation());

        ImageView iv = listItemView.findViewById(R.id.word_icon);
        iv.setImageResource(currentWord.getImageResourceId());

        iv = listItemView.findViewById(R.id.play_button);
        iv.setImageResource(R.drawable.baseline_play_arrow_white_24dp);

        return listItemView;
    }
}
