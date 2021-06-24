package com.example.remind_app.Adapter;

import android.app.Notification;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.remind_app.Objects.Note;
import com.example.remind_app.R;

import java.util.List;

public class Adapter_Note extends RecyclerView.Adapter {
    private Context context; //Giao diện.
    private List<Note> listNote;



    public Adapter_Note(Context context, List<Note> listNote) {
        this.context = context;
        this.listNote = listNote;
    }


    //Tạo ra đối tượng view Holder, Chứa view hiển thị
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View note_view = inflater.inflate(R.layout.item_note, parent, false);
        ViewHolder viewHolder = new ViewHolder(note_view);
        return viewHolder;
    }

    // Xây dựng item List:
    public class ViewHolder extends RecyclerView.ViewHolder{
        private View itemView;
        public ImageView imgItem;
        public TextView txtItemContent, txtItemDetail;
        public ViewHolder(View itemView) {
            super(itemView);
            imgItem = itemView.findViewById(R.id.imgItem);
            txtItemContent = itemView.findViewById(R.id.txtItemContent);
            txtItemDetail = itemView.findViewById(R.id.txtItemDetail);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Note note = listNote.get(position);
        ((ViewHolder) holder).txtItemContent.setText(note.content);
        ((ViewHolder) holder).txtItemDetail.setText(note.detail);
    }

    //Số phần tử của dữ liệu
    @Override
    public int getItemCount() {
        return listNote.size();
    }
}
