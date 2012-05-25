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
import com.winon.health.report.entity.DailyReportEntity;
import com.winon.health.report.entity.ListEntity;
import com.winon.health.report.process.DailyDetailLoader;
import com.winon.health.report.process.DateListAdapter;
import com.winon.health.report.process.DateListLoader;

public class DailyRecordActivity extends BaseActivity {

	private TextView totalTextView;
	private TextView xiyaoTextView;
	private TextView zhongyaoTextView;
	private TextView zhiliaoTextView;
	private TextView jianchaTextView;
	
	private DailyDetailLoader loader;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dailyrecord);
		String query = "2012-05-05";
		ListView list = (ListView) findViewById(R.id.date_list);
		totalTextView = (TextView)findViewById(R.id.total);
		xiyaoTextView = (TextView)findViewById(R.id.xiyao);
		zhongyaoTextView = (TextView)findViewById(R.id.zhongyao);
		zhiliaoTextView = (TextView)findViewById(R.id.zhiliao);
		jianchaTextView = (TextView)findViewById(R.id.jiancha);
		
		loader = new DailyDetailLoader(this);
		
		CommonAdapter<ListEntity> adapter = new DateListAdapter(this);
		final List<ListEntity> data = new DateListLoader(this).search(query);
		adapter.updateDataCache(data);
		list.setAdapter(adapter);
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int pos,
					long id) {
				//取出列表时间
				String date = (String) view.getTag();
				DailyReportEntity entity = loader.loadByDate(date);
				
				totalTextView.setText("总额：￥"+ entity.getTotal());
				xiyaoTextView.setText("西药费：￥"+ entity.getXiyao());
				zhongyaoTextView.setText("中药费：￥"+ entity.getZhongyao());
				zhiliaoTextView.setText("治疗费：￥"+ entity.getZhiliao());
				jianchaTextView.setText("检查费：￥"+ entity.getJiancha());
			}
		});
	}
}
