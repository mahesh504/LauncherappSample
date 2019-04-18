package mindrock.in.testapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class AppsListActivity extends AppCompatActivity {

    private PackageManager manager;
    private List<Item> apps;
    private RecyclerView listView;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apps_list);
        loadapps();
        LoadListView();

    }

    private void loadapps()
    {
        manager =getPackageManager();
        apps=new ArrayList<>();

        Intent i = new Intent(Intent.ACTION_MAIN,null);
        i.addCategory(Intent.CATEGORY_LAUNCHER);

        List<ResolveInfo> AvailableActivities= manager.queryIntentActivities(i,0);

        for(ResolveInfo info: AvailableActivities)
        {
            Item app=new Item();
            app.lable= info.activityInfo.packageName;
            app.name= info.loadLabel(manager);
            app.icon = info.loadIcon(manager);

            apps.add(app);
        }

    }
    private void  LoadListView()
    {
        listView = findViewById(R.id.list);
        layoutManager =new LinearLayoutManager(this);
        listView.setLayoutManager(layoutManager);
        AppsAdapter adapter=new AppsAdapter(this,apps);
        listView.setAdapter(adapter);


    }

}
