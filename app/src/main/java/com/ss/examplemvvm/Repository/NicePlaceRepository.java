package com.ss.examplemvvm.Repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ss.examplemvvm.model.NicePlace;

import java.util.ArrayList;
import java.util.List;

public class NicePlaceRepository {
    private static NicePlaceRepository instance;
    private ArrayList<NicePlace> dataset = new ArrayList<>();
    public static NicePlaceRepository getInstance(){
        if (instance == null){
            instance = new NicePlaceRepository();
        }
        return instance;
    }
//pretent to get data from webservice(Api)/ Online Service
   public MutableLiveData<List<NicePlace>> getNicePlaces(){
        setNicePlaces();
        MutableLiveData<List<NicePlace>> data = new MutableLiveData<>();
        data.setValue(dataset);
     return data;
    }
    private void setNicePlaces(){
        dataset.add(
                new NicePlace("https://www.trackerway.com/wp-content/uploads/2019/03/1393604387000-sim-card-illo.jpg",
                        "SimCard")
        );
        dataset.add(
                new NicePlace("https://www.trackerway.com/wp-content/uploads/2019/03/1393604387000-sim-card-illo.jpg",
                        "SimCard1")
        );
        dataset.add(
                new NicePlace("https://www.trackerway.com/wp-content/uploads/2019/03/1393604387000-sim-card-illo.jpg",
                        "SimCard2")
        );
        dataset.add(
                new NicePlace("https://www.trackerway.com/wp-content/uploads/2019/03/1393604387000-sim-card-illo.jpg",
                        "SimCard3")
        );
        dataset.add(
                new NicePlace("https://www.trackerway.com/wp-content/uploads/2019/03/1393604387000-sim-card-illo.jpg",
                        "SimCard4")
        );
        dataset.add(
                new NicePlace("https://www.trackerway.com/wp-content/uploads/2019/03/1393604387000-sim-card-illo.jpg",
                        "SimCard5")
        );
        dataset.add(
                new NicePlace("https://www.trackerway.com/wp-content/uploads/2019/03/1393604387000-sim-card-illo.jpg",
                        "SimCard6")
        );
        dataset.add(
                new NicePlace("https://www.trackerway.com/wp-content/uploads/2019/03/1393604387000-sim-card-illo.jpg",
                        "SimCard7")
        );
        dataset.add(
                new NicePlace("https://www.trackerway.com/wp-content/uploads/2019/03/1393604387000-sim-card-illo.jpg",
                        "SimCard8")
        );
        dataset.add(
                new NicePlace("https://www.trackerway.com/wp-content/uploads/2019/03/1393604387000-sim-card-illo.jpg",
                        "SimCard9")
        );
        dataset.add(
                new NicePlace("https://www.trackerway.com/wp-content/uploads/2019/03/1393604387000-sim-card-illo.jpg",
                        "SimCard10")
        );
        dataset.add(
                new NicePlace("https://www.trackerway.com/wp-content/uploads/2019/03/1393604387000-sim-card-illo.jpg",
                        "SimCard11")
        );

    }
}
