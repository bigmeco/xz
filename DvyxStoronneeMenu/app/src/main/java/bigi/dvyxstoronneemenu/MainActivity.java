package bigi.dvyxstoronneemenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // СОЗДАНИЕ КНОПКИ
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        final DrawerArrowDrawable indicator = new DrawerArrowDrawable(this);
//        // цвет кнопки меню
//        indicator.setColor(Color.GREEN);
//        getSupportActionBar().setHomeAsUpIndicator(indicator);

        // setTransformer();

//        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
//        drawerLayout.setScrimColor(Color.TRANSPARENT);
//        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
//            @Override
//            public void onDrawerSlide(View drawerView, float slideOffset) {
//                if (((ViewGroup) drawerView).getChildAt(1).getId() == R.id.leftSideBar) {
//                    indicator.setProgress(slideOffset);
//                }
//            }
//        });

    }

    // НАСТРОЙКА ОТКЛИКА
//    private void setTransformer() {
//        final float spacing = getResources().getDimensionPixelSize(R.dimen.spacing);
//        SideBar rightSideBar = (SideBar) findViewById(R.id.rightSideBar);
//        rightSideBar.setTransformer(new Transformer() {
//            private View lastHoverView;
//
//            @Override
//            public void apply(ViewGroup sideBar, View itemView, float touchY, float slideOffset, boolean isLeft) {
//                boolean hovered = itemView.isPressed();
//                if (hovered && lastHoverView != itemView) {
//                    animateIn(itemView);
//                    animateOut(lastHoverView);
//                    lastHoverView = itemView;
//                }
//            }
//
//            private void animateOut(View view) {
//                if (view == null) {
//                    return;
//                }
//                ObjectAnimator translationX = ObjectAnimator.ofFloat(view, "translationX", -spacing, 0);
//                translationX.setDuration(200);
//                translationX.start();
//            }
//
//            private void animateIn(View view) {
//                ObjectAnimator translationX = ObjectAnimator.ofFloat(view, "translationX", 0, -spacing);
//                translationX.setDuration(200);
//                translationX.start();
//            }
//        });
//    }


    // ПО НАЖАТИЮ КНОПКИ МЕНЮ
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getItemId() == android.R.id.home) {
//            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
//                drawerLayout.closeDrawer(GravityCompat.START);
//            } else {
//                drawerLayout.openDrawer(GravityCompat.START);
//            }
//        }
//        return true;
//    }
// КОН
    public void onClick(View view) {
        if (view instanceof TextView) {
            String title = ((TextView) view).getText().toString();
            if (title.startsWith(" onClick")) {

                Toast.makeText(this, title, Toast.LENGTH_SHORT).show();
            } else if (view.getId() == R.id.menOdin){
                Intent intent;
                intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            } else if (view.getId() == R.id.CERED){
                Intent intent;
                intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        } else if (view.getId() == R.id.userInfo) {
            Intent intent;
            intent = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(intent);
        }
    }
}
