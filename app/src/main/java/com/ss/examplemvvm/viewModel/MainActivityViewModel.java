package com.ss.examplemvvm.viewModel;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ss.examplemvvm.Repository.NicePlaceRepository;
import com.ss.examplemvvm.model.NicePlace;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<List<NicePlace>>mNicePlaces;
    private NicePlaceRepository nicePlaceRepository;
    private MutableLiveData<Boolean> mIsUpdating = new MutableLiveData<>();
    public  void  init(){
        if (mNicePlaces!= null){
            return;
        }
        nicePlaceRepository = NicePlaceRepository.getInstance();
        mNicePlaces = nicePlaceRepository.getNicePlaces();

    }

    public void addNewValue(final NicePlace nicePlace){
        mIsUpdating.setValue(true);
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected void onPostExecute(Void unused) {
                super.onPostExecute(unused);
                 List<NicePlace> currentPlaces = mNicePlaces.getValue();
                  currentPlaces.add(nicePlace);
                  mNicePlaces.postValue(currentPlaces);
                  mIsUpdating.setValue(false);
            }

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }

    public LiveData<List<NicePlace>>getNicePlaces(){
        return  mNicePlaces;
    }

    public LiveData<Boolean> getIsUpdating(){
        return mIsUpdating;
    }
}
