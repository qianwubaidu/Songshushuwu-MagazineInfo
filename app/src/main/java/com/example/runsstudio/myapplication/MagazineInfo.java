package com.example.runsstudio.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MagazineInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magazine_info);

        ImageView image= (ImageView)findViewById(R.id.imageView);



        final Button buttonfocus= (Button) findViewById(R.id.button);
        buttonfocus.setOnClickListener(new View.OnClickListener() {
            int i = 0;

            @Override

            public void onClick(View v) {

                i++;

                //实现在关注和取消关注之间切换的功能
                if (i % 2 == 1) {
                    buttonfocus.setText("取消关注");
                    Toast.makeText(MagazineInfo.this, "关注成功！~", Toast.LENGTH_SHORT).show();
                } else {
                    buttonfocus.setText("关注");
                    Toast.makeText(MagazineInfo.this, "取消关注成功！~", Toast.LENGTH_SHORT).show();
                }


            }
        });


        final Button buttonbook= (Button) findViewById(R.id.button2);
        buttonbook.setOnClickListener(new View.OnClickListener() {
            int i = 0;

            @Override

            public void onClick(View v) {

                i++;

                //实现在订阅和取消订阅之间切换的功能
                if (i % 2 == 1) {
                    buttonbook.setText("取消订阅");
                    Toast.makeText(MagazineInfo.this, "订阅成功！~", Toast.LENGTH_SHORT).show();
                } else {
                    buttonbook.setText("订阅");
                    Toast.makeText(MagazineInfo.this, "取消订阅成功！~", Toast.LENGTH_SHORT).show();
                }
            }
        });



        //显示图片 R.drawable.image1
        image.setImageResource(R.drawable.image1);
        //装载R.layout.pop_window对应的界面布局
        View root2= this.getLayoutInflater().inflate(R.layout.pop_window,null);

        //获取要显示在Popupwindow中的图片的长宽，等下打开的popwindow的长就是height，宽就是width
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.image1);
        int height = bitmap.getHeight();
        int width= bitmap.getWidth();



        //创建popupwindow对象
        final PopupWindow popup= new PopupWindow(root2,width+30,height+30);
        popup.setAnimationStyle(R.style.popwin_anim_style);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.showAtLocation(findViewById(R.id.imageView), Gravity.CENTER,20,20);
            }
        });

        root2.findViewById(R.id.imageView2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //关闭Popup窗口
                popup.dismiss();
            }
        });



    }



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
}
