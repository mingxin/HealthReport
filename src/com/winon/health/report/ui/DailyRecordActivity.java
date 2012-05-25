package com.winon.health.report.ui;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.lurencun.android.support.ui.BaseActivity;
import com.lurencun.android.support.widget.CommonAdapter;
import com.winon.health.report.R;
import com.winon.health.report.entity.ListEntity;
import com.winon.health.report.menu.DateListAdapter;
import com.winon.health.report.menu.DateListLoader;

public class DailyRecordActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dailyrecord);
		String query = "2012-05-05";
		ListView list = (ListView) findViewById(R.id.date_list);
		TextView total = (TextView)findViewById(R.id.total);
		TextView xiyao = (TextView)findViewById(R.id.xiyao);
		TextView zhongyao = (TextView)findViewById(R.id.zhongyao);
		TextView zhiliao = (TextView)findViewById(R.id.zhiliao);
		TextView jiancha = (TextView)findViewById(R.id.jiancha);
		CommonAdapter<ListEntity> adapter = new DateListAdapter(this);
		final List<ListEntity> data = new DateListLoader(this)
				.search(query);
		adapter.updateDataCache(data);
		list.setAdapter(adapter);
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int pos,
					long id) {
				JSONObject obj = GetJsonObject();  
		        StringBuilder sb = new StringBuilder();  
		        try {  
		            sb.append("total: " + obj.getString("total") + "/n");  
		            sb.append("xiyao: " + obj.getString("xiyao") + "/n");  
		            sb.append("zhongyao: " + obj.getString("zhongyao") + "/n");  
		            sb.append("jiancha: " + obj.getString("jiancha") + "/n"); 
		        } catch (JSONException e) {  
		            e.printStackTrace();  
		        }
			}
		});
//		total.setText("总额：￥"+ money);
//		xiyao.setText("西药费：￥"+ money);
//		zhongyao.setText("中药费：￥"+ money);
//		zhiliao.setText("治疗费：￥"+ money);
//		jiancha.setText("检查费：￥"+ money);
	}
	private JSONObject GetJsonObject() {
		HttpClient client = new DefaultHttpClient();
		StringBuilder builder = new StringBuilder();
		JSONArray jsonArray = null;
		HttpPost post = new HttpPost("http:192.168.1.110:1111");
		//post.setParams(params);
		try {
			HttpResponse response = client.execute(post);
			BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			for (String s = reader.readLine(); s != null; s = reader.readLine()) {
				builder.append(s);
			}
			Log.i("json_str", builder.toString());
			jsonArray = new JSONArray(builder.toString());
			for (int i = 0; i < 2; ++i) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				Log.i("total", jsonObject.getInt("total") + "");
				Log.i("xiyao", jsonObject.getString("xiyao"));
				Log.i("zhongyao", jsonObject.getString("zhongyao"));
				Log.i("zhiliao", jsonObject.getInt("zhiliao") + "");
				Log.i("jiancha", jsonObject.getString("jiancha"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			return jsonArray.getJSONObject(5);
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}

}
