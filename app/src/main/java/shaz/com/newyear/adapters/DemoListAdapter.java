package shaz.com.newyear.adapters;

import android.app.Activity;
import android.content.Context;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import shaz.com.newyear.R;


/**
 * @author shahbaz
 * Adapter to show the list of tickets.
 */
public class DemoListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /**
     * The M item click listener.
     */
    OnItemClickListener mItemClickListener;
    private Context mContext;

    /**
     * The Inner holder.
     */
    RecyclerView.ViewHolder innerHolder;
    private Activity activity;
    private String[] titles = {"Nainital", "Haldwani", "Kausani","Rani Khet","Dehradun","Delhi"};
     private int[] drawables = {R.drawable.one, R.drawable.two, R.drawable.three ,R.drawable.four ,R.drawable.five ,R.drawable.six};

    OnItemClickListener onItemClickListener;
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_demo_list, parent, false);
        return new ViewHolder(view);
    }




    /**
     * Instantiates a new View leader board adapter.
     *
     * @param context  the context
     * @param activity the activity
     */
    public DemoListAdapter(Context context, Activity activity, OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
        this.mContext = context;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder)holder;
        viewHolder.mIvTabImage.setImageResource(drawables[position]);
        viewHolder.mTvTabName.setText(""+titles[position]);

    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    /**
     * The type View holder.
     */
// This class  improves scrolling and performance by avoiding findViewById() for each cell.
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mIvTabImage;
        private TextView mTvTabName;
        private CardView mParent;


        /**
         * Instantiates a new View holder.
         *
         * @param itemView the item view
         */
        public ViewHolder(View itemView) {
            super(itemView);

            mIvTabImage = itemView.findViewById(R.id.ivTabImage);
            mTvTabName = itemView.findViewById(R.id.tvTabName);
            mParent = itemView.findViewById(R.id.parent);
            mParent.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {

                mItemClickListener.onItemClick(itemView, getPosition());
            }
        }
    }

    /**
     * The interface On item click listener.
     */
    public interface OnItemClickListener {
        /**
         * On item click.
         *
         * @param view     the view
         * @param position the position
         */
        void onItemClick(View view, int position);

    }



    /**
     * Sets on item click listener.
     *
     * @param mItemClickListener the m item click listener
     */
    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }


}
