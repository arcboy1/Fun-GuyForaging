package com.example.funguyzforaging.ImageAdapter;

import android.net.Uri;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class UserUploadViewModel extends ViewModel {

    private MutableLiveData<List<Uri>> imageList = new MutableLiveData<>();

    public LiveData<List<Uri>> getImageList() {
        return imageList;
    }

    public void addImage(Uri imageUri) {
        List<Uri> currentList = imageList.getValue();
        if (currentList == null) {
            currentList = new ArrayList<>();
        }
        currentList.add(imageUri);
        imageList.setValue(currentList);
    }
}
