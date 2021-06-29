package com.example.remind_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class Fragment_Note_Kotlin : Fragment() {
    val activity : MainActivity = MainActivity()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view : View = inflater.inflate(R.layout.fragment_note, container, false )

       /* btnAdd.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                var add_Dialog = Dialog(activity)
                add_Dialog.setContentView(R.layout.dialog_note_add)

                var arrayList: List<_Note> = ArrayList()
                var linearLayoutManager = LinearLayoutManager(activity)
                list_Note.adapter =  Adapter_Note_Kotlin(activity, arrayList)
                list_Note.layoutManager = linearLayoutManager

                btnAdd_inDialog.setOnClickListener(object : View.OnClickListener{
                    override fun onClick(p0: View?) {

                    }
                })
            }

        })*/
        return view
    }

}