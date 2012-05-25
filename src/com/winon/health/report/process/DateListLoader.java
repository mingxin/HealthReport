package com.winon.health.report.process;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import com.lurencun.android.sdk.HasContext;
import com.winon.health.report.entity.ListEntity;

public class DateListLoader extends HasContext{

	public DateListLoader(Context context) {
		super(context);
	}
	public List<ListEntity> search(String date){
		List<ListEntity> date_result = new ArrayList<ListEntity>();
		int size = 20;
		for(int i=0;i<size;i++){
			ListEntity le = new ListEntity();
			le.report_date = date;
			date_result.add(le);
		}
		return date_result;
	}

}
