package f.dev.exampletagdf.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import f.dev.exampletagdf.R;
import f.dev.exampletagdf.interfaces.OnItemClickListener;

/**
 * Created by sati on 30/06/2015.
 */
public class SessionsAdapter extends RecyclerView.Adapter<SessionsAdapter.SessionViewHolder> {

    private LayoutInflater layoutInflater;
    private OnItemClickListener onItemClickListener;

    public SessionsAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);

    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public SessionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = layoutInflater.inflate(R.layout.item_session, parent, false);


        return new SessionViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(SessionViewHolder holder, int position) {
        holder.setViewPosition(position);
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class SessionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @Bind(R.id.imageViewTitleSession)
        ImageView imageViewTitleSession;

        @Bind(R.id.textViewTitleSession)
        TextView textViewTitleSession;

        @Bind(R.id.textViewDescriptionSession)
        TextView textViewDescriptionSession;

        private View itemView;

        public SessionViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            this.itemView.setOnClickListener(this);
            ButterKnife.bind(this, this.itemView);
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClick(v, (int) v.getTag());
        }


        public void setViewPosition(int position) {
            itemView.setTag(position);
        }


    }
}
