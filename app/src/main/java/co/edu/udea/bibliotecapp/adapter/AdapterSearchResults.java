package co.edu.udea.bibliotecapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import co.edu.udea.bibliotecapp.R;
import co.edu.udea.bibliotecapp.data.Libro;

/**
 * Created by cristian on 12/06/2016.
 */
public class AdapterSearchResults extends RecyclerView.Adapter<AdapterSearchResults.ViewHolderSearchResults> {

    private LayoutInflater mLayoutInflater;
    private ArrayList<Libro> listBooks = new ArrayList<>();

    public AdapterSearchResults(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
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
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolderSearchResults holder, int position) {
        Libro currentBook = listBooks.get(position);
        holder.textTitle.setText(currentBook.getTitulo());
        holder.textAuthor.setText(currentBook.getAutores());

    }

    @Override
    public int getItemCount() {
        return listBooks==null ? 0: listBooks.size();
    }

    static class ViewHolderSearchResults extends RecyclerView.ViewHolder {

        private ImageView imageBook;
        private TextView textTitle;
        private TextView textAuthor;

        public ViewHolderSearchResults(View itemView) {
            super(itemView);

            imageBook = (ImageView) itemView.findViewById(R.id.imageBook);
            textTitle = (TextView) itemView.findViewById(R.id.textTitle);
            textAuthor = (TextView) itemView.findViewById(R.id.textAuthor);

        }
    }
}
