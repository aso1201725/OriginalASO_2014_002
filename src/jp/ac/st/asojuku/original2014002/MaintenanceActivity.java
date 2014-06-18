package jp.ac.st.asojuku.original2014002;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MaintenanceActivity extends Activity implements View.OnClickListener,
			AdapterView.OnItemClickListener{
	/**
	 * 引数のListViewにDBのデータをセット
	 * @param lstHitokoto 対象となるListView
	 */
	private void setDBValuetoList(ListView lstHitokoto){

		SQLiteCursor cursor = null;

		// クラスのフィールド変数がNULLなら、データーベース空間オープン
		if(sdb == null){
			helper = new MySQLiteOpenHelper(getApplicationContext());
		}
		try{
			sdb = helper.getWritableDatabase();
		}catch(SQLiteException e){
			// 異常終了
			Log.e("ERROR",e.toString());
		}
		// MySQLiteOpenHelperにSELECT文を実行させて結果のカーソルを受け取る
		cursor = this.helper.selectHitokotoList(sdb);

		// dblayout: ListViewにさらにレイアウトを指定するもの
		int db_layout = android.R.layout.simple_list_item_activated_1;
		// from: カーソルからListviewに指定するカラムの値を指定するもの
		String[]from = {"phrase"};
		// to: Listviewの中に指定したdb_layoutに配置する、各行のview部品のid
		int[] to = new int[]{android.R.id.text1};

		// ListViewにセットするアダプターを生成
		// カーソルをもとに、fromの列から、toのviewへ値のマッピングが行われる。
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,db_layout,cursor,from,to,0);

		// アダプターを設定します。
		lstHitokoto.setAdapter(adapter);
	}

	// SQLiteデータベース空間を操作するインスタンス変数を宣言
	SQLiteDatabase sdb = null;
	// MySQLiteOpenHelperを操作するインスタンス変数を宣言
	MySQLiteOpenHelper helper = null;

	// リストにて選択したHitokotoテーブルのレコードの「_id」カラム値を保持する変数の宣言
	int selectedID = -1;
	// リストにて選択した行番号を保持する変数の宣言
	int lastPosition = -1;

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
		// 各view部品を操作するidを取得
		Button btnBack = (Button)findViewById(R.id.btnBack);
		Button btnDLT = (Button)findViewById(R.id.btnDLT);
		ListView lstHitokoto = (ListView)findViewById(R.id.LvHITOKOTO);

		// 各ButtonにOnClickListenerをセット
		btnBack.setOnClickListener(this);
		btnDLT.setOnClickListener(this);

		// ListViewにOnItemClickListenerをセット
		lstHitokoto.setOnItemClickListener(this);

		// ListViewにDBの値をセット
		this.setDBValuetoList(lstHitokoto);

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

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
