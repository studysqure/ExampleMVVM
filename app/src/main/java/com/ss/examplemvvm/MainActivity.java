package com.ss.examplemvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ss.examplemvvm.adapter.RecyAdapter;
import com.ss.examplemvvm.model.NicePlace;
import com.ss.examplemvvm.viewModel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   private RecyclerView mRecyclerView;
   private RecyAdapter mRecyAdapter;
   private ProgressBar mProgressBar;
   private FloatingActionButton mFloatingActionButton;
   private MainActivityViewModel mainActivityViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initProgress();
    }

    private void initProgress() {

        mainActivityViewModel.init();
        mainActivityViewModel.getNicePlaces().observe(this, new Observer<List<NicePlace>>() {
            @Override
            public void onChanged(List<NicePlace> nicePlaces) {
              mRecyAdapter.notifyDataSetChanged();
            }
        });

        mainActivityViewModel.getIsUpdating().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean){
                    showProgressBar();
                }else {
                    hideProgressBar();
                    mRecyclerView.smoothScrollToPosition(mainActivityViewModel.getNicePlaces().getValue().size()-1);
                }
            }
        });
        Log.d("initProgress", "initProgress: "+mainActivityViewModel.getNicePlaces().getValue().toString());
        mRecyAdapter = new RecyAdapter(mainActivityViewModel.getNicePlaces().getValue(),this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mRecyAdapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mRecyclerView.getContext(), DividerItemDecoration.VERTICAL));

        mFloatingActionButton.setOnClickListener(view -> {
            mainActivityViewModel.addNewValue(new NicePlace(
                    "https://www.hdwallpaper.nu/wp-content/uploads/2015/06/1919099.jpg","Love-Rose "
            ));
        });
    }

    private void initView() {
       mRecyclerView = findViewById(R.id.recycle_1);
        mProgressBar = findViewById(R.id.progress_circular);
        mFloatingActionButton = findViewById(R.id.floating_action_btn);
        ViewModelProvider.Factory factory = (ViewModelProvider.Factory) new ViewModelProvider.NewInstanceFactory();
        mainActivityViewModel = new ViewModelProvider(this, factory).get(MainActivityViewModel.class);

    }



    void  showProgressBar(){
        mProgressBar.setVisibility(View.VISIBLE);
    }
    void hideProgressBar(){
        mProgressBar.setVisibility(View.GONE);
    }
}