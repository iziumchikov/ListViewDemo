package demo.listviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewActivity extends Activity
{
    String[] fruits;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_list_view);

        lv = (ListView)findViewById(R.id.listView);
        fruits = getResources().getStringArray(R.array.fruits);
        ArrayAdapter<String> aa = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, fruits);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                displayToast("U selected " + fruits[position]);
            }
        });
    }

    private void displayToast(String str)
    {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}

