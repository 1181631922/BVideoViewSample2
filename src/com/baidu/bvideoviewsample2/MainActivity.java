package com.baidu.bvideoviewsample2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	private final String TAG = "MainActivity";
	private Button mPlayBtn;
	private EditText mSourceET;
	private String url;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initUI();
	}
	
	void initUI(){
		url="http://pl.youku.com/playlist/m3u8?ts=1436146520&keyframe=0&vid=XMjcwNjYwNTIw&type=mp4&ep=cCaXHEiJUMsB7CvXjz8bbyjiIH9eXJZ3rEzC%2F4gLR8VAMa%2FQkTbSzw%3D%3D&sid=243614651988712840d8a&token=8838&ctype=12&ev=1&oip=1931268481";
		mPlayBtn = (Button)findViewById(R.id.playBtn);
		mSourceET = (EditText)findViewById(R.id.getET);
		//mSourceET.setText("http://devimages.apple.com/iphone/samples/bipbop/gear4/prog_index.m3u8");
		mSourceET.setText(url);
		mPlayBtn.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id = v.getId();
		switch(id){
		case R.id.playBtn:
			/**
			 * 鎾斁涓�釜瑙嗛
			 */
			playVideo();
			break;
		default:
			break;
		}
	}
	
	private void playVideo(){
		String source = mSourceET.getText().toString();
			if(source == null || source.equals("")){
				/**
				 * 绠�崟妫�祴鎾斁婧愮殑鍚堟硶鎬�涓嶅悎娉曚笉鎾斁
				 */
				Toast.makeText(this, "please input your video source", 500).show();
				source = "http://devimages.apple.com/iphone/samples/bipbop/gear4/prog_index.m3u8";
				Intent intent = new Intent(this, VideoViewPlayingActivity.class);
				intent.setData(Uri.parse(source));
				startActivity(intent);		
				
				
			}else{
				Intent intent = new Intent(this, VideoViewPlayingActivity.class);
				intent.setData(Uri.parse(source));
				startActivity(intent);
			}	
	}
}
