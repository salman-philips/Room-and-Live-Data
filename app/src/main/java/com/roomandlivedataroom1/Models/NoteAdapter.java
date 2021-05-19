package com.roomandlivedataroom1.Models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.roomandlivedataroom1.NoteActivity;
import com.roomandlivedataroom1.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.MyNoteAdapterViewHolder> {

    List<NoteEntity> noteEntityList;
    Context noteActivityContext;

    public NoteAdapter(List<NoteEntity> noteEntityList, Context noteActivityContext) {
        this.noteEntityList = noteEntityList;
        this.noteActivityContext = noteActivityContext;
    }

    @NonNull
    @Override
    public MyNoteAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(noteActivityContext).inflate(R.layout.note_item, parent, false);
        return new MyNoteAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyNoteAdapterViewHolder holder, int position) {
        NoteEntity noteEntity = noteEntityList.get(position);
        TextView textView=(TextView)holder.textView;
        textView.setText(noteEntity.getText());
    }

    @Override
    public int getItemCount() {
        return noteEntityList.size();
    }


    public class MyNoteAdapterViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.noteText)
        TextView textView;
        @BindView(R.id.fabEdit)
        FloatingActionButton floatingActionButtonEdit;

        public MyNoteAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
