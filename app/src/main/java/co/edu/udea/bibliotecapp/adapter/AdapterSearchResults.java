package co.edu.udea.bibliotecapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import co.edu.udea.bibliotecapp.R;
import co.edu.udea.bibliotecapp.activity.ActivityMain;
import co.edu.udea.bibliotecapp.activity.DetailActivity;
import co.edu.udea.bibliotecapp.data.Libro;

/**
 * Created by cristian on 12/06/2016.
 */
public class AdapterSearchResults extends RecyclerView.Adapter<AdapterSearchResults.ViewHolderSearchResults> {

    private LayoutInflater mLayoutInflater;
    private ArrayList<Libro> listBooks = new ArrayList<>();
    private Context mContext;

    public AdapterSearchResults(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
        mContext = context;
    }

    public void setBooksList(ArrayList<Libro> listBooks) {
        this.listBooks = listBooks;
        if (listBooks == null || listBooks.isEmpty()) {
            notifyItemRangeChanged(0, 0);
        } else {
            notifyItemRangeChanged(0, listBooks.size());
        }
    }

    @Override
    public ViewHolderSearchResults onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.book, parent, false);
        ViewHolderSearchResults viewHolder = new ViewHolderSearchResults(view);
        viewHolder.setContext(mContext);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolderSearchResults holder, int position) {
        Libro currentBook = listBooks.get(position);
        holder.book = currentBook;
        holder.textTitle.setText(currentBook.getTitulo());
        holder.textAuthor.setText(currentBook.getAutores());
    }

    @Override
    public int getItemCount() {
        return listBooks == null ? 0 : listBooks.size();
    }

    static class ViewHolderSearchResults extends RecyclerView.ViewHolder {

        private ImageView imageBook;
        private TextView textTitle;
        private TextView textAuthor;
        private Context context;
        View.OnClickListener listener;
        private Libro book;

        public ViewHolderSearchResults(View itemView) {
            super(itemView);

            imageBook = (ImageView) itemView.findViewById(R.id.imageBook);
            textTitle = (TextView) itemView.findViewById(R.id.textTitle);
            textAuthor = (TextView) itemView.findViewById(R.id.textAuthor);

        }

        public void setContext(Context c) {
            context = c;
            listener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("BOOK_IMAGE", book.getImage_url());
                    intent.putExtra("TITLENO", book.getTitleno());
                    context.startActivity(intent);
                }
            };
            imageBook.setOnClickListener(listener);
            textTitle.setOnClickListener(listener);
            textAuthor.setOnClickListener(listener);
        }
    }


}
