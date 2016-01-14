package com.example.fsantana.meaningfulmotion.Adapters;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.fsantana.meaningfulmotion.Activity.MainActivity;
import com.example.fsantana.meaningfulmotion.Activity.ProfileActivity;
import com.example.fsantana.meaningfulmotion.Beans.Person;
import com.example.fsantana.meaningfulmotion.CustomViews.ImageViewRatioThreeTwo;
import com.example.fsantana.meaningfulmotion.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by fsantana on 13/01/16.
 */
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    /**
     *
     */
    public enum LayoutType {
        LIST_LAYOUT, GRID_LAYOUT
    }

    private final Context mContext;
    private List<Person> mPersonList;
    private boolean viewType = false;
    private LayoutType currentLayout = LayoutType.LIST_LAYOUT;


    /**
     *
     * @param c
     * @param p
     */
    public MyAdapter(Context c, List<Person> p) {
        mContext = c;
        mPersonList = p;
    }


    /**
     *
     * @param layoutType
     */
    public void setLayoutType(LayoutType layoutType) {
        currentLayout = layoutType;
    }


    /**
     *
     * @return
     */
    public LayoutType getLayoutType() {
        return currentLayout;
    }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     * <p/>
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     * <p/>
     * The new ViewHolder will be used to display items of the adapter using
     * {@link #onBindViewHolder(ViewHolder, int, List)}. Since it will be re-used to display
     * different items in the data set, it is a good idea to cache references to sub views of
     * the View to avoid unnecessary {@link View#findViewById(int)} calls.
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     * @see #getItemViewType(int)
     * @see #onBindViewHolder(ViewHolder, int)
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("onCreateViewHolder", "enter");
        View view = null;
        switch (viewType) {
            case 0:
                view =
                        (View) LayoutInflater.from(mContext)
                                .inflate(R.layout.card_item_list, parent, false);
                return new ViewHolderGrid(view);
            case 1:
                view =
                        (View) LayoutInflater.from(mContext)
                                .inflate(R.layout.item_list, parent, false);
                return new ViewHolderList(view);
        }

        return null;
    }


    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     * <p/>
     * Note that unlike {@link ListView}, RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined. For this reason, you should only
     * use the <code>position</code> parameter while acquiring the related data item inside
     * this method and should not keep a copy of it. If you need the position of an item later
     * on (e.g. in a click listener), use {@link ViewHolder#getAdapterPosition()} which will
     * have the updated adapter position.
     * <p/>
     * Override {@link #onBindViewHolder(ViewHolder, int, List)} instead if Adapter can
     * handle effcient partial bind.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case 0:
                ((ViewHolderGrid) holder).mImageView.setImageResource(mPersonList.get(position).getmAvatar());
                ((ViewHolderGrid) holder).mTitle.setText(mPersonList.get(position).getmTitle());
                ((ViewHolderGrid) holder).mSubtitle.setText(mPersonList.get(position).getmSubtitle());
                ((ViewHolderGrid) holder).avatarId = (mPersonList.get(position).getmAvatar());
                ((ViewHolderGrid) holder).title = (mPersonList.get(position).getmTitle());
                ((ViewHolderGrid) holder).subtitle = (mPersonList.get(position).getmSubtitle());
                break;

            case 1:
                ((ViewHolderList) holder).mCircleImageView.setImageResource(mPersonList.get(position).getmAvatar());
                ((ViewHolderList) holder).mTitle.setText(mPersonList.get(position).getmTitle());
                ((ViewHolderList) holder).mSubtitle.setText(mPersonList.get(position).getmSubtitle());
                ((ViewHolderList) holder).avatarId = (mPersonList.get(position).getmAvatar());
                ((ViewHolderList) holder).title = (mPersonList.get(position).getmTitle());
                ((ViewHolderList) holder).subtitle = (mPersonList.get(position).getmSubtitle());
                break;
        }
    }


    /**
     * Returns the total number of items in the data set hold by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return mPersonList.size();
    }


    /**
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        switch (currentLayout) {
            case GRID_LAYOUT:
                return 0;
            case LIST_LAYOUT:
                return 1;
        }
        return 1;
    }


    /**
     *
     */
    public void clearItens() {
        if (getItemCount() > 0) {
            while (!mPersonList.isEmpty()) {
                mPersonList.remove(0);
            }
            notifyItemRangeRemoved(0, mPersonList.size());
        }
    }


    /**
     *
     * @param person
     * @param position
     */
    public void addItem(Person person, int position) {
        if (position < mPersonList.size()) {
            mPersonList.add(position, person);
            notifyItemInserted(position);
        }
    }


    /**
     *
     * @param person
     */
    public void addItem(Person person) {
        mPersonList.add(person);
        notifyItemInserted(mPersonList.size() - 1);
    }


    /**
     *
     */
    public class ViewHolderGrid extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageViewRatioThreeTwo mImageView;
        TextView mTitle;
        TextView mSubtitle;
        int avatarId;
        String title;
        String subtitle;

        public ViewHolderGrid(View itemView) {
            super(itemView);
            mImageView = (ImageViewRatioThreeTwo) itemView.findViewById(R.id.card_item_avatart_imageview);
            mTitle = (TextView) itemView.findViewById(R.id.card_item_list_title_textview);
            mSubtitle = (TextView) itemView.findViewById(R.id.card_item_list_subtitle_textview);
            itemView.setOnClickListener(this);

        }

        /**
         * Called when a view has been clicked.
         *
         * @param v The view that was clicked.
         */
        @Override
        public void onClick(View v) {
            Bundle bundle = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                bundle = ActivityOptions.makeSceneTransitionAnimation((Activity)mContext, itemView,
                        mContext.getString(R.string.transition_avatar)).toBundle();
            }
            Intent intent = new Intent(mContext, ProfileActivity.class);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                intent.putExtra(MainActivity.AVATAR_ID, avatarId );
                intent.putExtra(MainActivity.TITLE_ID, title);
                intent.putExtra(MainActivity.SUBTITLE_ID, subtitle);
                mContext.startActivity(intent, bundle);

            }

        }
    }


    /**
     *
     */
    public class ViewHolderList extends RecyclerView.ViewHolder implements View.OnClickListener {

        CircleImageView mCircleImageView;
        TextView mTitle;
        TextView mSubtitle;
        private int avatarId;
        private String title;
        private String subtitle;

        public ViewHolderList(View itemView) {

            super(itemView);
            mCircleImageView = (CircleImageView) itemView.findViewById(R.id.item_list_avatar_imageview);
            mTitle = (TextView) itemView.findViewById(R.id.item_list_title_textview);
            mSubtitle = (TextView) itemView.findViewById(R.id.item_list_subtitle_textview);
            itemView.setOnClickListener(this);

        }

        /**
         * Called when a view has been clicked.
         *
         * @param v The view that was clicked.
         */
        @Override
        public void onClick(View v) {
            Bundle bundle = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                bundle = ActivityOptions.makeSceneTransitionAnimation((Activity)mContext, itemView,
                        mContext.getString(R.string.transition_avatar)).toBundle();
            }
            Intent intent = new Intent(mContext, ProfileActivity.class);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                intent.putExtra(MainActivity.AVATAR_ID, avatarId );
                intent.putExtra(MainActivity.TITLE_ID, title);
                intent.putExtra(MainActivity.SUBTITLE_ID, subtitle);
                mContext.startActivity(intent, bundle);

            }
        }
    }
}
