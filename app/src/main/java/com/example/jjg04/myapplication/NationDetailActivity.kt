package com.example.jjg04.myapplication

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_nation_detail.*
import java.io.InputStream
import java.io.InputStreamReader

/**
 * Created by jjg04 on 2018-03-05.
 */
class NationDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val nation = intent.getStringExtra(EXTRA_NATION_NAME)
        setContentView(R.layout.activity_nation_detail)
        val data:NationDetailData? = getDataFromName(nation)
        img_flag.setBackgroundColor(getColor(nation))
        initView(data)
    }

    companion object {
        val EXTRA_NATION_NAME = "nation_name"
    }

    private fun getDataFromName(selected:String):NationDetailData? {
        val gson:Gson = GsonBuilder().create()
        val inputStream:InputStream = assets.open("nation_data.json")
        val reader:InputStreamReader = InputStreamReader(inputStream)
        val detailData = gson.fromJson(reader, GsonData::class.java)
        for(data in detailData.data) if(selected.equals(data.name)) return data
        return null
    }

    private fun getColor(selected: String):Int {
        var color:Int = 0
        when(selected) {
            "벨기에" -> color = Color.parseColor("#ff0000")
            "아르헨티나" -> color = Color.parseColor("#00ff00")
            "브라질" -> color = Color.parseColor("#0000ff")
            "캐나다" -> color = Color.parseColor("#666600")
            "중국" -> color = Color.parseColor("#006666")
            else -> color = Color.parseColor("#ffffff")
        }
        return color
    }

    private fun initView(data:NationDetailData?) {
        txt_name.text = data?.name
        capital.text = data?.capital
        volume.text = data?.volume
        weather.text = data?.weather
        language.text = data?.language
        location.text = data?.location
    }

}