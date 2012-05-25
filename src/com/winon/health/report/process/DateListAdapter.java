package com.winon.health.report.process;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lurencun.android.support.widget.CommonAdapter;
import com.winon.health.report.R;
import com.winon.health.report.entity.ListEntity;

public class DateListAdapter extends CommonAdapter<ListEntity>{

	public DateListAdapter(Context context) {
		super(context);
	}

	@Override
	protected View createView(LayoutInflater inflater, ListEntity data,
			int position, View convertView, ViewGroup parent) {
		LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.date_cell, null);
		TextView title = (TextView)layout.findViewById(R.id.date_title);
		
		//2012-12-12设置列表时间
		title.setTag(data.report_date);
		
		title.setText(data.report_date);
		return layout;
	}

}
