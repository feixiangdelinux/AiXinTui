package com.example.aixintui.receiver;

import com.ixintui.pushsdk.SdkConstants;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class PushReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		String action = intent.getAction();
		// 透传消息
		if (action.equals(SdkConstants.MESSAGE_ACTION)) {
			String msg = intent.getStringExtra(SdkConstants.MESSAGE);
			String extra = intent.getStringExtra(SdkConstants.ADDITION);

		} else if (action.equals(SdkConstants.RESULT_ACTION)) {
			String cmd = intent.getStringExtra(SdkConstants.COMMAND);
			int code = intent.getIntExtra(SdkConstants.CODE, 0);
			if (code != 0) {
				String error = intent.getStringExtra(SdkConstants.ERROR);
			} else {

			}
			// 返回用户的是用户的token
			String extra = intent.getStringExtra(SdkConstants.ADDITION);
			if (extra != null) {
				// 返回token之后,发送给我们自己的服务器
			}
			// 点击通知,通过消息类型,进行不同的跳转或数据逻辑处理
		} else if (action.equals(SdkConstants.NOTIFICATION_CLICK_ACTION)) {
			String msg = intent.getStringExtra(SdkConstants.MESSAGE);
			// 自己添加的内容
			Log.e("charge", msg);

		}
	}

}
