package com.winon.health.report.ui;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.ActivityGroup;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

import com.lurencun.android.sdk.res.ResJSONHandler;
import com.winon.health.report.R;
import com.winon.health.report.entity.ProfileEntity;
import com.winon.health.report.entity.TabEntity;
import com.winon.health.report.process.ProfileLoader;

public class MainActivity extends ActivityGroup {
	
	private String userId;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);    
        setContentView(R.layout.main);
        
        userId = getIntent().getStringExtra("userid");
        
        TabHost tabHost = (TabHost)findViewById(R.id.taghost);
        tabHost.setup(getLocalActivityManager());
       
        for(TabEntity te : new TabConfig(this).load(R.array.tabconfig)){
        	TabSpec tab = tabHost.newTabSpec("TAG("+te.title+")");
        	tab.setIndicator(te.title);
        	Intent tabIntent;
			try {
				tabIntent = new Intent(this,Class.forName(te.classpath));
				tab.setContent(tabIntent);
	        	tabHost.addTab(tab);
			} catch (ClassNotFoundException e) {
				Log.e("E","配置文件中classpath指向的类未能找到");
				e.printStackTrace();
			}
        }
        loadProfile();
        
    }
    
    private void loadProfile(){
    	ImageView profile_image = (ImageView)findViewById(R.id.profile_image);
        TextView profile_name = (TextView)findViewById(R.id.profile_name);
        TextView profile_office = (TextView)findViewById(R.id.profile_office);
        TextView profile_gender = (TextView)findViewById(R.id.profile_gender);
        TextView profile_area = (TextView)findViewById(R.id.profile_area);
        TextView profile_date = (TextView)findViewById(R.id.profile_date);
        TextView profile_bed = (TextView)findViewById(R.id.profile_bed);
       
        profile_image.setImageResource(R.drawable.profile);
        
        //从服务器中根据用户ID读取并初始化病人的信息
        ProfileLoader.initProfile(userId);
        
        //显示
        profile_name.setText("姓名："+ProfileEntity.patentInfo.getName());
        profile_office.setText("科室："+ProfileEntity.patentInfo.getOffoce());
        profile_gender.setText("性别："+ProfileEntity.patentInfo.getSex());
        profile_area.setText("病区："+ProfileEntity.hospitalFiles.getAreaID());
        profile_date.setText("入院日期："+ProfileEntity.hospitalFiles.getInDate());
        profile_bed.setText("床位："+ProfileEntity.hospitalFiles.getBedID());
    }
    

    //对配置文件进行解释
    private class TabConfig extends ResJSONHandler<TabEntity>{

		public TabConfig(Context context) {
			super(context);
		}

		@Override
		protected TabEntity convert(JSONObject json) throws JSONException {
			TabEntity te = new TabEntity();
			te.classpath = json.getString("classpath");
			te.title = json.getString("title");
			return te;
		}
    	
    }
}