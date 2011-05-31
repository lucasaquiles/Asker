package com.akser.ui;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;

public class MainTabs extends TabActivity implements TabContentFactory, OnTabChangeListener {

	TabHost tabHost;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		tabHost = getTabHost();
		
		buildTab("myAsks", "Minhas Asks", new Intent(this,MyAskTab.class));
		buildTab("myAsks", "Asks", new Intent(this,AskTab.class));
		buildTab("sendMessage", "Perguntar", new Intent(this,Send.class));
	}
	
	public void buildTab(String tag, String indicator, Intent i){
		
		TabSpec tab = tabHost.newTabSpec(tag);
		tab.setIndicator(indicator);
		tab.setContent(i);
		tabHost.addTab(tab);
		
	}
	
	@Override
	public void onTabChanged(String tabId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public View createTabContent(String tag) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
