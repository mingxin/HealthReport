package com.winon.health.report.process;

import java.util.ArrayList;
import java.util.List;

import com.winon.health.report.entity.CombinRecordEntity;

public class CombinRecordLoader {
	
	public List<CombinRecordEntity> load(){
		List<CombinRecordEntity> list = new ArrayList<CombinRecordEntity>();
		for(int i=0;i<32;i++){
			CombinRecordEntity e = new CombinRecordEntity();
			e.count = 20;
			e.name = "Drop("+i+")";
			e.standard = "ISO9002";
			e.total = 1000;
			e.unitPrice = 13.02f;
			list.add(e);
			
		}
		return list;
	}
}
