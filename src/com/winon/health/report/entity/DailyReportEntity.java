/**
 * Copyright (C) 2012  HealthReport
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.winon.health.report.entity;

/**
 * 
 * @author cfuture.chenyoca [桥下一粒砂] (chenyoca@gmail.com)
 * @date 2012-5-25
 */
public class DailyReportEntity {
	private float xiyao;
	private float zhongyao;
	private float zhiliao;
	private float jiancha;
	private float total;
	public float getXiyao() {
		return xiyao;
	}
	public void setXiyao(float xiyao) {
		this.xiyao = xiyao;
	}
	public float getZhongyao() {
		return zhongyao;
	}
	public void setZhongyao(float zhongyao) {
		this.zhongyao = zhongyao;
	}
	public float getZhiliao() {
		return zhiliao;
	}
	public void setZhiliao(float zhiliao) {
		this.zhiliao = zhiliao;
	}
	public float getJiancha() {
		return jiancha;
	}
	public void setJiancha(float jiancha) {
		this.jiancha = jiancha;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
}
