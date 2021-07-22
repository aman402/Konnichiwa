package com.example.android.konnichiwa;

public class Word {

    private final String defaultTranslation;
    private final String japaneseTranslation;
    private final int imageResourceId;
    private final int musicId;

    public Word(String defTranslation, String japTranslation, int imgResourceId, int mId) {
        defaultTranslation = defTranslation;
        japaneseTranslation = japTranslation;
        imageResourceId = imgResourceId;
        musicId = mId;
    }

    public int getMusicId() {
        return musicId;
    }

    public String getDefaultTranslation() {
        return defaultTranslation;
    }

    public String getJapaneseTranslation() {
        return japaneseTranslation;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

}
