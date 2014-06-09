package jp.ac.st.asojuku.original2014002;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MaintenanceActivity extends Activity implements View.OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hensyu_activity);
	}

	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();
		//ボタンをIDで探してボタン変数をつくる
		Button btnBack = (Button)findViewById(R.id.btnBack);
		//ボタン変数にリスナーを登録する
		btnBack.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
		switch(v.getId()){ //どのボタンが押されたか判定
		case R.id.btnBack: //btnMsgが押された
			// インテントのインスタンス生成
			Intent intent = new Intent(MaintenanceActivity.this, MainActivity.class);
			// 次画面のアクティビティ起動
			startActivity(intent);
	}
	}
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
