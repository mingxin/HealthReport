
package com.winon.health.report.process;

import com.winon.health.report.entity.ProfileEntity;
import com.winon.health.report.net.NetworkConnection;


public class ProfileLoader {
	
	public static void initProfile(String userId){
		
	//	String jsonVal = NetworkConnection.post("http://localhost/profile", "userid", userId);
		ProfileEntity.patentInfo.setName("用户名");
		ProfileEntity.patentInfo.setSex("男");
		ProfileEntity.patentInfo.setOffice("心脏科");
		ProfileEntity.hospitalFiles.setBedID("405床");
		ProfileEntity.hospitalFiles.setInDate("2012-12-12");
		ProfileEntity.hospitalFiles.setAreaID("2B");
		
	}
	
//	private class ProfileConver extends ResJSONHandler<PatientInfo>{
//
//		/**
//		 * @param context
//		 */
//		public ProfileConver(Context context) {
//			super(context);
//		}
//		
//	}
	
	
}
