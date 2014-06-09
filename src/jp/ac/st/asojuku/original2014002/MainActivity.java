package jp.ac.st.asojuku.original2014002;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();
		//ボタンをIDで探してボタン変数をつくる
		Button btnOK = (Button)findViewById(R.id.btnOK3);
		//ボタン変数にリスナーを登録する
		btnOK.setOnClickListener(this);

		// TODO 自動生成されたメソッド・スタブ
		//ボタンをIDで探してボタン変数をつくる
		Button btnOK2 = (Button)findViewById(R.id.btnOK2);
		//ボタン変数にリスナーを登録する
		btnOK2.setOnClickListener(this);
	}


	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
		switch(v.getId()){ //どのボタンが押されたか判定
			case R.id.btnOK3: //btnMsgが押された
				// インテントのインスタンス生成
				Intent intent = new Intent(MainActivity.this, HitokotoActivity.class);
				// 次画面のアクティビティ起動
				startActivity(intent);
				break;
			case R.id.btnOK2: //btnMsgが押された
				// インテントのインスタンス生成
				Intent intent2 = new Intent(MainActivity.this, MaintenanceActivity.class);
				// 次画面のアクティビティ起動
				startActivity(intent2);
				break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
