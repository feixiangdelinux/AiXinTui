# AiXinTui
集成爱心推
1. 加入jar包及资源文件底层so库
---将ixintui_pushsdk_v1.1.4.x.jar包和相应.so库放入工程指定的libs目录。
注意：请务必确保libs中的so库加入到您的工程相应目录。



2. 修改AndroidManifest.xml文件
2.1 请确保您的应用具有以下Permission权限：
 <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
 <uses-permission android:name="android.permission.GET_TASKS" />
 <uses-permission android:name="android.permission.INTERNET" />
 <uses-permission android:name="android.permission.READ_PHONE_STATE" />
 <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
 <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
 <uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" />
 <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
 <uses-permission android:name="android.permission.VIBRATE" />
 <uses-permission android:name="android.permission.WAKE_LOCK"/>





2.2 请您在应用的<application>段内添加以下内容：
<receiver 
<!-- 定义接收器，用来接收透传、api结果以及点击事件 -->
<!-- 请把此处设置为您定义的BroadcastReceiver派生类全名 -->
    android:name="注册你的(可以用他demo中的PushReceiver,就省了自己写了,拷贝到你的工程中)PushReceiver">
    <intent-filter>
        <!-- 接收透传消息 -->
        <action android:name="com.ixintui.action.MESSAGE" />
        <!-- 接收register, add tag等反馈消息 -->
        <action android:name="com.ixintui.action.RESULT" />
        <!-- 接收notification click消息 -->
        <action android:name="com.ixintui.action.notification.CLICK" />
    </intent-filter>
</receiver>
        
<!-- 以下为push使用的活动，服务和接收器，请不要修改这些内容 -->
<activity
    android:name="com.ixintui.push.PushActivity"
    android:theme="@android:style/Theme.Translucent.NoTitleBar"
    android:configChanges="orientation|keyboardHidden" >
    <intent-filter>
        <action android:name="com.ixintui.push.PushActivity" />
        <category android:name="android.intent.category.DEFAULT" />
    </intent-filter>
</activity>
<service android:name="com.ixintui.push.PushService"
           android:exported="true"
           android:process=":ixintui_service_v1" >
</service>
<service
    android:name="com.ixintui.push.MediateService"
    android:exported="true" >
</service>
<!-- 推送内部使用的provider -->
<provider
    android:name="com.ixintui.push.Provider"
android:exported="false"
<!-- 请把yourpackage替换成您的应用包名 -->
    android:authorities="你的包名.ixintui.push.provider"/>

<receiver android:name="com.ixintui.push.Receiver">
    <intent-filter>
        <action android:name="com.ixintui.action.BROADCAST" />
    </intent-filter>
    <intent-filter>
        <action android:name="android.intent.action.PACKAGE_REMOVED"/>
        <data android:scheme="你的包名" />
    </intent-filter>
    <intent-filter >
        <action android:name="android.intent.action.BOOT_COMPLETED" />
        <action android:name="android.net.conn.CONNECTIVITY_CHANGE" />
    </intent-filter>
</receiver>
      

3.0在主界面注册爱心推
		/**
		 * 参数1	上下文
		 * 参数2	appKey(从爱心推官网能找到)
		 * 参数3	渠道
		 * 参数4	你应用的版本号
		 */
		PushSdkApi.register(this, appKey, "ccc", "1.0");


