package com.example.miwokapp;

public class Word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResource;
    private int mAudioResourceId;
    private static final int NO_IMAGE_PROVIDED=-1;
    public Word(String mDefaultTranslation,String mMiwokTranslation)
    {
        this.mDefaultTranslation=mDefaultTranslation;
        this.mMiwokTranslation=mMiwokTranslation;
    }
    public Word(String mDefaultTranslation,String mMiwokTranslation,int AudioResourceId)
    {
        this.mDefaultTranslation=mDefaultTranslation;
        this.mMiwokTranslation=mMiwokTranslation;
        this.mAudioResourceId=mAudioResourceId;
    }

    public Word(String mDefaultTranslation,String mMiwokTranslation,int mImageResource,int mAudioResourceId)
    {
        this.mDefaultTranslation=mDefaultTranslation;
        this.mMiwokTranslation=mMiwokTranslation;
        this.mImageResource=mImageResource;
        this.mAudioResourceId=mAudioResourceId;
    }
    public String getmDefaultTranslation()
    {
        return mDefaultTranslation;
    }

    public String getmMiwokTranslation()
    {
        return mMiwokTranslation;
    }

    public int getmImageResource(){
        return mImageResource;
    }

    public boolean hasImage() {
        return mImageResource!=NO_IMAGE_PROVIDED;
    }

    public int getmAudioResourceId() {
        return mAudioResourceId;
    }
}
