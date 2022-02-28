package book;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewlinearlayoutmanagerhorizontalcardview.R;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private List<Book> mListBook;

    public void setData (List<Book> list) {
        this.mListBook = list;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Book book = mListBook.get(position);
        if (book == null) {
            return;
        }

        holder.tvTime.setText(book.getTime());
        holder.tvTemp.setText(book.getTemp());
        holder.imgIcon.setImageResource(book.getResourceId());
        holder.tvSpeed.setText(book.getSpeed());
    }

    @Override
    public int getItemCount() {
        if (mListBook != null) {
            return mListBook.size();
        }
        return 0;
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgIcon;
        private TextView tvTime, tvTemp, tvSpeed;


        public BookViewHolder(@NonNull View itemView) {
            super(itemView);

            imgIcon = (ImageView) itemView.findViewById(R.id.img_icon);
            tvTime = (TextView) itemView.findViewById(R.id.tv_time);
            tvTemp = (TextView) itemView.findViewById(R.id.tv_temp);
            tvSpeed = (TextView) itemView.findViewById(R.id.tv_speed);
        }
    }
}
