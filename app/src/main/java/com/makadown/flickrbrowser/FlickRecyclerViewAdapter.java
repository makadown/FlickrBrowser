package com.makadown.flickrbrowser;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by usuario on 29/03/2016.
 */
public class FlickRecyclerViewAdapter extends RecyclerView.Adapter<FlickrImageViewHolder>
{

    private String LOG_TAG = FlickRecyclerViewAdapter.class.getSimpleName();
    private List<Photo> mPhotosList;
    private Context mContext;

    public FlickRecyclerViewAdapter(List<Photo> mPhotosList, Context mContext) {
        this.mPhotosList = mPhotosList;
        this.mContext = mContext;
    }

    /**
     * En este m&eacute;todo se invoca el layout de browse.xml y se infla al contexto del parent.
     * En este proyecto sería invocado desde el mainActvity
     * */
    @Override
    public FlickrImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from( parent.getContext() ).inflate(R.layout.browse, null);
        FlickrImageViewHolder flickrImageViewHolder = new FlickrImageViewHolder(view);
        return flickrImageViewHolder ;
    }

    @Override
    public void onBindViewHolder(FlickrImageViewHolder holder, int position)
    {
         Photo photoItem = mPhotosList.get(position);

        Log.v(LOG_TAG, "Procesando " + photoItem.getTitle() +  " -- >  " + Integer.toString(position) );
        Picasso.with(mContext).load(photoItem.getImage())
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(holder.thumbnail);

        holder.title.setText(photoItem.getTitle() );
    }

    @Override
    public int getItemCount() {
        return (null != mPhotosList? mPhotosList.size(): 0 );
    }

    public FlickRecyclerViewAdapter(Context context , List<Photo> mPhotosList)
    {
        mContext = context;
        this.mPhotosList = mPhotosList;

    }

    public void loadNewData(List<Photo> newPhotos  )
    {
        mPhotosList= newPhotos;
        notifyDataSetChanged();
    }

    public Photo getPhoto(int position)
    {
        return (  null!= mPhotosList ? mPhotosList.get(position) : null );
    }
}
