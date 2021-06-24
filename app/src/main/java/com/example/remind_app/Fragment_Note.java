package com.example.remind_app;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.remind_app.Adapter.Adapter_Note;
import com.example.remind_app.Objects.Note;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Fragment_Note extends Fragment {
    Button btnNote;
    FloatingActionButton btnAdd;
    Dialog add_Dialog;
    RecyclerView list_Note;
    Adapter_Note adapter_note;
    ArrayList<Note> arrayList;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_note, container, false);

        //ánh xạ các id
        anhxa(view);
        BUTTON_ADD();

        arrayList = new ArrayList<Note>();


        adapter_note = new Adapter_Note(getActivity(), arrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        list_Note.setAdapter(adapter_note);
        list_Note.setLayoutManager(linearLayoutManager);



        return view;
    }

    void anhxa(View view){
        btnAdd = view.findViewById(R.id.btnAdd);
        list_Note = view.findViewById(R.id.list_Note);
    }

    private void BUTTON_ADD() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add_Dialog = new Dialog(getActivity());
                add_Dialog.setContentView(R.layout.dialog_note_add);

                EditText editItemContent = add_Dialog.findViewById(R.id.editItemContent);
                EditText editItemDetail = add_Dialog.findViewById(R.id.editItemDetail);
                Button btnAdd_inDialog = add_Dialog.findViewById(R.id.btnAdd_inDialog);

                btnAdd_inDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        arrayList.add(new Note("",
                                editItemContent.getText().toString(),
                                editItemDetail.getText().toString()));
                        Toast.makeText(getActivity(), "Đã thêm thành công", Toast.LENGTH_SHORT).show();
                        add_Dialog.dismiss();
                        adapter_note.notifyDataSetChanged();


                    }
                });

                add_Dialog.show();
            }
        });
    }

//    void BUTTON_NOTE(){
//        btnNote.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), MainActivity2.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intent);
//            }
//        });
//    }


}
