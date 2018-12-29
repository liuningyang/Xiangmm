package com.example.xiangmm;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.xiangmm.fragment.shuju.ShujuFragment;
import com.example.xiangmm.fragment.ganhuo.GanhuoFragment;
import com.example.xiangmm.fragment.weixin.WeiChatFragment;
import com.example.xiangmm.fragment.V2EX.WuFragment;
import com.example.xiangmm.fragment.zhihu.ZhihuFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

   //MaterialSearchView search_view;
    private MenuItem menuItem;
    private MenuItem searchMenuItem;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       //search_view = (MaterialSearchView) findViewById(R.id.search_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        /*for (int i = 0; i < list.size(); i++) {
            list.add("srearch"+i);

        }
        search_view.setVoiceSearch(false);
        search_view.setSubmitOnClick(true);
        search_view.setEllipsize(true);
        String[] array = list.toArray(new String[list.size()]);
        search_view.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            //数据提交时
            //1.点击ListView的Item条目会回调这个方法
            //2.点击系统键盘的搜索/按回车建后回调这个方法
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this, "你要搜索的是：" + query, Toast.LENGTH_SHORT).show();
                return false;
            }

            //文本内容发生改变时，因为框架里面已经做了处理，这里可以不管
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


        search_view.setSuggestions(array);//把数据传给搜索框
        search(search_view);*/
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        menuItem = navigationView.getMenu().findItem(R.id.drawer_zhihu);
        menuItem.setCheckable(true);
        navigationView.setNavigationItemSelectedListener(this);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
         transaction.replace(R.id.fl_content,new ZhihuFragment());
         transaction.commit();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem item = menu.findItem(R.id.action_settings);
        if (menuItem.getItemId() == R.id.drawer_zhihu){
            item.setVisible(true);
        } else {
            item.setVisible(true);
        }
       // search_view.setMenuItem(item);
        searchMenuItem = item;
        return true;

    }
 /**
     * 右上角的输入框的显示和隐藏选择
     *
     * @param
     *//*
    public void search(View view) {
        if (search_view.isSearchOpen()) {
            search_view.closeSearch();//隐藏搜索框
        } else {
            search_view.showSearch(true);//显示搜索框
        }
    }
*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (id){
            case  R.id.drawer_zhihu:
                fragmentTransaction.replace(R.id.fl_content,new ZhihuFragment());
                searchMenuItem.setVisible(true);
                break;
            case R.id.drawer_wechat:
                fragmentTransaction.replace(R.id.fl_content, new WeiChatFragment());
                searchMenuItem.setVisible(false);
                break;
            case R.id.drawer_gank:
                fragmentTransaction.replace(R.id.fl_content,new GanhuoFragment());
                searchMenuItem.setVisible(true);
                break;
            case R.id.drawer_data:
                fragmentTransaction.replace(R.id.fl_content,new ShujuFragment());
                searchMenuItem.setVisible(false);
                break;
            case R.id.drawer_vtex:
                fragmentTransaction.replace(R.id.fl_content,new WuFragment());
                searchMenuItem.setVisible(false);
                break;
            case R.id.drawer_like:
                searchMenuItem.setVisible(false);
                break;
            case R.id.drawer_setting:
                searchMenuItem.setVisible(false);
                break;
        }

        fragmentTransaction.commit();
        if (menuItem != null) {
            menuItem.setChecked(false);
        }

        item.setChecked(true);
        menuItem = item;
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
