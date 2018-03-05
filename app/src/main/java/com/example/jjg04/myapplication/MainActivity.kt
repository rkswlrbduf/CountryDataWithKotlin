package com.example.jjg04.myapplication

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview.layoutManager = LinearLayoutManager(this)

        val adapter = Adapter(this, listOf(
                NationData(Color.parseColor("#ff0000"), "벨기에", "브뤼쉘"),
                NationData(Color.parseColor("#00ff00"), "아르헨티나", "부에노스아이레스"),
                NationData(Color.parseColor("#0000ff"), "브라질", "브라질리아"),
                NationData(Color.parseColor("#666600"), "캐나다", "오타와"),
                NationData(Color.parseColor("#006666"), "중국", "베이징")
        ))

        adapter.setOnItemClickListener(this)
        recyclerview.adapter = adapter

    }

    override fun onClick(v: View?) {
        val textView = v?.findViewById<TextView>(R.id.text_name)
        val name = textView?.text?:"NONE"
        val intent = Intent(this, NationDetailActivity::class.java)
        intent.putExtra(NationDetailActivity.EXTRA_NATION_NAME, name)
        startActivity(intent)
    }
}