package com.winon.health.report.process;

import org.json.JSONObject;
import org.json.JSONTokener;

import android.content.Context;
import android.util.Log;

import com.lurencun.android.sdk.HasContext;
import com.winon.health.report.entity.DailyReportEntity;
import com.winon.health.report.net.NetworkConnection;

public class DailyDetailLoader extends HasContext {

	public DailyDetailLoader(Context context) {
		super(context);
	}

	public DailyReportEntity loadByDate(String date){
		//从网络取得病人对应的住院时间的详细数据
		String listJson = NetworkConnection.post("http://localhost/.....", "date", date);
		//String listJson = NetworkConnection.post("http://localhost/.....", new String[]{"date","userid"}, new Object[]{date,111});
		//String listJson = "{jiancha:1100,totalFee:1200,treatmentFee:1000,chinesemedicineFee:1233,westermedicienFee:12345}";
		JSONTokener jsonParser = new JSONTokener(listJson);
		DailyReportEntity entity = new DailyReportEntity();
		try {
			JSONObject json = (JSONObject) jsonParser.nextValue();

			entity.setJiancha(json.getLong("jiancha"));
			entity.setTotal(json.getLong("totalFee"));
			entity.setXiyao(json.getLong("westermedicienFee"));
			entity.setZhiliao(json.getLong("treatmentFee"));
			entity.setZhongyao(json.getLong("chinesemedicineFee"));
			
//			entity.setJiancha(new Random().nextFloat());
//			entity.setTotal(20000);
//			entity.setXiyao(3000);
//			entity.setZhiliao(2000);
//			entity.setZhongyao(300);
		} catch (Exception e) {
			Log.e("ResLoader"," ===> 解释JSON发生异常："+e.getMessage());
		}
		
		return entity;
	}
	
	
}
