package com.winon.health.report.ui;

import java.util.List;

import android.os.Bundle;
import android.widget.GridView;

import com.lurencun.android.support.ui.BaseActivity;
import com.winon.health.report.R;
import com.winon.health.report.entity.CombinRecordEntity;
import com.winon.health.report.process.CombinRecordLoader;
import com.winon.health.report.process.GridViewAdapter;

public class CombinedRecordActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.combined);
		
		GridView gridView = (GridView)findViewById(R.id.combined_grid);
		List<CombinRecordEntity> data = new CombinRecordLoader().load();
		GridViewAdapter adapter = new GridViewAdapter(this);
		adapter.updateDataCache(data);
		gridView.setAdapter(adapter);
	}
	
	
}
