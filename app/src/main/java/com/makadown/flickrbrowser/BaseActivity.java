package com.makadown.flickrbrowser;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by usuario on 30/03/2016.
 */
public class BaseActivity extends AppCompatActivity
{

    public static final String FLICKR_QUERY = "FLICKR_QUERY";
    public static final String PHOTO_TRANSFER = "PHOTO_TRANSFER";

    private Toolbar mToolbar;

    protected Toolbar activateToolbar()
    {
        if( mToolbar == null)
        {
            mToolbar = (Toolbar) findViewById(R.id.app_bar);
            if ( mToolbar != null )
            {
                setSupportActionBar(mToolbar);
            }
        }
        return mToolbar;
    }


    protected Toolbar activateToolbarWithHomeEnabled()
    {
        activateToolbar();
        if( mToolbar!= null )
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        return mToolbar;
    }
}
