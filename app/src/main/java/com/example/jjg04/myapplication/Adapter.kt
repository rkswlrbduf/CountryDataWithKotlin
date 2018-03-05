package com.example.jjg04.myapplication

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by jjg04 on 2018-03-05.
 */

data class NationDetailData(val name:String,
                            val capital:String,
                            val location:String,
                            val volume:String,
                            val weather:String,
                            val language:String)

data class GsonData(val data:ArrayList<NationDetailData>)

data class NationData (
        var color:Int,
        var name:String,
        var capital:String
)

class MyViewHolder(view:View) : RecyclerView.ViewHolder(view)  {
    val img_flag = view.findViewById<ImageView>(R.id.img_flag)
    val txt_name = view.findViewById<TextView>(R.id.text_name)
    val txt_capital = view.findViewById<TextView>(R.id.capital)
}

class Adapter(val context: Context, val items:List<NationData>) : RecyclerView.Adapter<MyViewHolder>() {

    private var onItemClickListener: View.OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        val mainView : View = LayoutInflater.from(context).inflate(R.layout.row, parent, false)
        mainView.setOnClickListener(onItemClickListener)
        return MyViewHolder(mainView)
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        holder?.img_flag?.setBackgroundColor(items[position].color)
        holder?.txt_name?.text = items[position].name
        holder?.txt_capital?.text = items[position].capital
    }

    override fun getItemCount(): Int = items.size

    fun setOnItemClickListener(l:View.OnClickListener){
        onItemClickListener = l
    }

}