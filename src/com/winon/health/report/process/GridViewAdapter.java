package com.winon.health.report.process;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lurencun.android.support.widget.CommonAdapter;
import com.winon.health.report.R;
import com.winon.health.report.entity.CombinRecordEntity;

public class GridViewAdapter extends CommonAdapter<CombinRecordEntity>{

		public GridViewAdapter(Context context) {
			super(context);
		}

		@Override
		protected View createView(LayoutInflater inflater,
				CombinRecordEntity data, int position, View convertView,
				ViewGroup parent) {
			
			View gridCellView =  inflater.inflate(R.layout.combined_cell, null);
			
			TextView nameView = (TextView) gridCellView.findViewById(R.id.combined_cell_name);
			nameView.setText(CombinRecordEntity.prifexs[0]+":"+data.name);
			
			TextView standardView = (TextView) gridCellView.findViewById(R.id.combined_cell_standard);
			standardView.setText(CombinRecordEntity.prifexs[1]+":"+data.standard);
			
			TextView countView = (TextView) gridCellView.findViewById(R.id.combined_cell_count);
			countView.setText(CombinRecordEntity.prifexs[2]+":"+data.count);
			
			TextView priceView =(TextView) gridCellView.findViewById(R.id.combined_cell_unit_price);
			priceView.setText(CombinRecordEntity.prifexs[3]+data.unitPrice);
			
			TextView totalView = (TextView) gridCellView.findViewById(R.id.combined_cell_total);
			totalView.setText(CombinRecordEntity.prifexs[4]+data.total);
			
			return gridCellView;
		}
		
	}