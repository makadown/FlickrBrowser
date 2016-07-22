package com.makadown.flickrbrowser;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ViewPhotoDetailsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_details);
        activateToolbarWithHomeEnabled();

        Intent intent = getIntent();
        Photo photo = (Photo) intent.getSerializableExtra(PHOTO_TRANSFER);

        ImageView photo_image = (ImageView) findViewById(R.id.photo_image);
        TextView photo_author = (TextView) findViewById(R.id.photo_autor);
        TextView photo_title= (TextView) findViewById(R.id.photo_title);
        TextView photo_tags= (TextView) findViewById(R.id.photo_tags);

        photo_author.setText( photo.getAuthor() );
        photo_title.setText( "Title: "+ photo.getTitle() );
        photo_tags.setText( "Tags: " + photo.getTags() );

        //Toast.makeText( this, photo.getLink() , Toast.LENGTH_LONG).show();

        Picasso.with(this).load(photo.getLink())
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(photo_image);

    }


}
