package com.winon.health.report.ui;


import java.util.List;

import android.os.Bundle;
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
				// TODO Auto-generated method stub
				
			}
		});
		String money = "500.00";
		total.setText("总额：￥"+ money);
		xiyao.setText("西药费：￥"+ money);
		zhongyao.setText("中药费：￥"+ money);
		zhiliao.setText("治疗费：￥"+ money);
		jiancha.setText("检查费：￥"+ money);
		
	}

}
