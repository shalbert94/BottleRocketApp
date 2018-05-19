package com.example.shalom.bottlerocketapp;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import com.example.shalom.bottlerocketapp.UI.MainActivity;
import com.example.shalom.bottlerocketapp.adapter.StoresRecyclerViewAdapter;
import com.example.shalom.bottlerocketapp.service.model.BottleRocketAPIResponse;
import com.example.shalom.bottlerocketapp.service.model.Store;
import com.example.shalom.bottlerocketapp.service.model.Stores;
import com.example.shalom.bottlerocketapp.service.repository.BottleRocketRepository;
import com.example.shalom.bottlerocketapp.viewmodel.StoresViewModel;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StoresViewModelUnitTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Test
    public void calledBottleRocketRepository() {

        //Given the ViewModel
        StoresViewModel storesViewModel = Mockito.spy(new StoresViewModel());

        //When getBottleRocketAPIResponse is called
        storesViewModel.getBottleRocketAPIResponse();

        //Then getStores should be called
        verify(storesViewModel, times(1)).getStores();
    }


    @Test
    public void bottleRocketRepositoryNotCalled() {
        //Mock response
        MutableLiveData<BottleRocketAPIResponse> mockApiResponse =
                new MutableLiveData<>();
        mockApiResponse.postValue(new BottleRocketAPIResponse(new Stores()));

        //Given the ViewModel with a non-null property
        StoresViewModel storesViewModel = Mockito.spy(new StoresViewModel());
        storesViewModel.setBottleRocketAPIResponse(mockApiResponse);

        //When getBottleRocketAPIResponse is called
        storesViewModel.getBottleRocketAPIResponse();

        //The getStores should not be called
        verify(storesViewModel, times(0)).getStores();
    }



}
