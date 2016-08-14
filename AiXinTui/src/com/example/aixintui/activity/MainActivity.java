                     package com.example.aixintui.activity;

import com.example.aixintui.R;
import com.example.aixintui.R.layout;
import com.ixintui.pushsdk.PushSdkApi;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
	private int appKey = 1563671565;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/**
		 * 参数1	上下文
		 * 参数2	appKey(从爱心推官网能找到)
		 * 参数3	渠道
		 * 参数4	你应用的版本号
		 */
		PushSdkApi.register(this, appKey, "ccc", "1.1");
	}

}
