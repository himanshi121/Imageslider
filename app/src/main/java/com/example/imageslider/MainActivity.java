package com.example.imageslider;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    int imageSwitcherImages[] =
            {R.drawable.one, R.drawable.two, R.drawable.three};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        viewPager = findViewById(R.id.viewPager);
        MyAdapter adapter = new MyAdapter();
        viewPager.setAdapter(adapter);
    }
    class MyAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return imageSwitcherImages.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == (ImageView) object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            ImageView img = new ImageView(MainActivity.this);
            img.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            img.setImageResource(imageSwitcherImages[position]);
            ((ViewPager)container).addView(img,0);
            return img;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            ((ViewPager)container).removeView((ImageView)object);
        }
    }
}
