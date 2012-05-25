package com.winon.health.report.ui;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.lurencun.android.support.ui.BaseActivity;
import com.winon.health.report.R;
import com.winon.health.report.entity.CombinRecordEntity;
import com.winon.health.report.process.CombinRecordLoader;
import com.winon.health.report.process.GridViewAdapter;

public class DetailRecordActivity extends BaseActivity {

	private static String startdate = null;
	private static String enddate = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detailrecord);
		
		//时间控件
		final TextView start_date = (TextView)findViewById(R.id.start_date);
		final TextView end_date = (TextView)findViewById(R.id.end_date);
        final ImageButton start_btn = (ImageButton)findViewById(R.id.start_btn);
        final ImageButton end_btn = (ImageButton)findViewById(R.id.end_btn);
        final Button search_btn = (Button)findViewById(R.id.search_btn);
        final Calendar cd = Calendar.getInstance();
        Date date = new Date();
        cd.setTime(date);
        
        start_btn.setOnClickListener(new OnClickListener(){
     	   public void onClick(View v) {
     	     new DatePickerDialog(DetailRecordActivity.this, new OnDateSetListener(){
     	      public void onDateSet(DatePicker view, int year,
     	        int monthOfYear, int dayOfMonth) {
     	    	  Date date = new Date(year-1900,monthOfYear,dayOfMonth);
     	    	  SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
     	    	  startdate = format.format(date);
     	    	 start_date.setText(startdate);
     	      	}
     	      },
     	      cd.get(Calendar.YEAR), 
     	      cd.get(Calendar.MONTH),
     	      cd.get(Calendar.DAY_OF_MONTH)).show();
     	   }
     	  });
        
        end_btn.setOnClickListener(new OnClickListener(){
      	   public void onClick(View v) {
      	     new DatePickerDialog(DetailRecordActivity.this, new OnDateSetListener(){
      	      public void onDateSet(DatePicker view, int year,
      	        int monthOfYear, int dayOfMonth) {
      	    	  Date date = new Date(year-1900,monthOfYear,dayOfMonth);
      	    	  SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
      	    	  enddate = format.format(date);
      	    	 end_date.setText(enddate);
      	    	 
      	      	}
      	      },
      	      cd.get(Calendar.YEAR), 
      	      cd.get(Calendar.MONTH),
      	      cd.get(Calendar.DAY_OF_MONTH)).show();
      	   }
      	  });
        search_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(!startdate.equals(null)&&!startdate.equals("")){
      	    		System.out.println(startdate);
      	    	 }else{
      				Toast toast = Toast.makeText(getApplicationContext(),
      						"请输入开始日期", Toast.LENGTH_SHORT);
      				toast.setGravity(Gravity.CENTER, 0, 0);
      				toast.show();
      			}
				if(!startdate.equals(null)&&!startdate.equals("")){
					System.out.println(enddate);
      	    	 }
			}
		});
        
        GridView gridView = (GridView)findViewById(R.id.combined_grid);
		List<CombinRecordEntity> data = new CombinRecordLoader().load();
		GridViewAdapter adapter = new GridViewAdapter(this);
		adapter.updateDataCache(data);
		gridView.setAdapter(adapter);
		
		
	}

}
