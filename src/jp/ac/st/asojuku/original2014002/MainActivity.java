package jp.ac.st.asojuku.original2014002;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements View.OnClickListener{

	SQLiteDatabase sdb = null;
	MySQLiteOpenHelper helper = null;

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
		Button btnMNT = (Button)findViewById(R.id.btnMNT);

		//ボタン変数にリスナーを登録する
		btnMNT.setOnClickListener(this);

		//ボタンをIDで探してボタン変数をつくる
		Button btnENTR = (Button)findViewById(R.id.btnENTR);

		//ボタン変数にリスナーを登録する
		btnENTR.setOnClickListener(this);

		//クラスのフィールド変数がNULLなら、データーベース空間オープン
		if(sdb == null){
			helper = new MySQLiteOpenHelper(getApplicationContext());
		}
		try{
			sdb = helper.getWritableDatabase();
		}catch(SQLiteException e){
			//異常終了
		}
		return;
	}


	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
		//生成して代入用のIntentインスタンス変数を用意
		switch(v.getId()){ //どのボタンが押されたか判定
			case R.id.btnOK3: //一言チェックが押された

				//MySQLiteOPenHelperのセレクト一言メソッドを呼び出して一言をランダムに取得
				String strHitokoto = helper.selectRandomHitokoto(sdb);

				// インテントのインスタンス生成
				Intent intent = new Intent(MainActivity.this, HitokotoActivity.class);

				//インテントに一言を混入
				intent.putExtra("hitokoto",strHitokoto );

				// 次画面のアクティビティ起動
				startActivity(intent);
				break;

			case R.id.btnMNT: //メンテボタンが押された
				// インテントのインスタンス生成
				Intent intent2 = new Intent(MainActivity.this, MaintenanceActivity.class);

				// 次画面のアクティビティ起動
				startActivity(intent2);
				break;

			case R.id.btnENTR://登録ボタンが押された

				//エディとテキストからの入力内容を取り出す
				EditText etv = (EditText)findViewById(R.id.edtName);
				String inputMsg = etv.getText().toString();

				//inputMsgがnullではない、かつ、空でない場合のみ、if文内を実行
				if(inputMsg!=null && !inputMsg.isEmpty()){

					//MySQLiteOpenHelperのインサートメソッドを呼び出し
					helper.insertHitokoto(sdb, inputMsg);
				}
				//入力欄をクリア
				etv.setText("");
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
