package f.dev.exampletagdf.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import f.dev.exampletagdf.R;
import f.dev.exampletagdf.interfaces.OnItemClickListener;
import f.dev.exampletagdf.utils.GuestModel;

/**
 * Created by sati on 30/06/2015.
 */
public class GuestsAdapter extends RecyclerView.Adapter<GuestsAdapter.GuestViewHolder> {

    private List<GuestModel> guestModels;
    private LayoutInflater layoutInflater;
    private OnItemClickListener onItemClickListener;

    public GuestsAdapter(Context context, List<GuestModel> guestModels) {
        layoutInflater = LayoutInflater.from(context);
        this.guestModels = guestModels;

    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public GuestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemVIew = layoutInflater.inflate(R.layout.item_guest, parent, false);

        return new GuestViewHolder(itemVIew);
    }

    @Override
    public void onBindViewHolder(GuestViewHolder holder, int position) {
        holder.setViewPosition(position);
        holder.setGuest(guestModels.get(position));
    }

    @Override
    public int getItemCount() {
        return guestModels.size();
    }

    public class GuestViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @Bind(R.id.imageViewGuest)
        CircleImageView imageViewGuest;

        @Bind(R.id.textViewNamgGuest)
        TextView textViewNamgGuest;


        private View itemView;

        public GuestViewHolder(View itemView) {
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


        public void setGuest(GuestModel guestModel) {
            imageViewGuest.setImageResource(guestModel.getIdImage());
            textViewNamgGuest.setText(guestModel.getIdName());
        }
    }
}
