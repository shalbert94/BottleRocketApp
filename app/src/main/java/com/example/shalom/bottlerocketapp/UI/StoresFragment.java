package com.example.shalom.bottlerocketapp.UI;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.shalom.bottlerocketapp.R;
import com.example.shalom.bottlerocketapp.adapter.StoresRecyclerViewAdapter;
import com.example.shalom.bottlerocketapp.service.model.BottleRocketAPIResponse;
import com.example.shalom.bottlerocketapp.service.model.Store;
import com.example.shalom.bottlerocketapp.service.model.Stores;
import com.example.shalom.bottlerocketapp.util.EspressoIdlingResource;
import com.example.shalom.bottlerocketapp.viewmodel.StoresViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Fragment that wil contain a RecyclerView which displays stores derived from a JSON network
 * response
 */
public class StoresFragment extends Fragment {

    private StoresViewModel viewModel;

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stores, container, false);

        viewModel = ViewModelProviders.of(getActivity()).get(StoresViewModel.class);

        recyclerView = view.findViewById(R.id.stores_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);


        StoresRecyclerViewAdapter emptyAdapter =
                new StoresRecyclerViewAdapter(getActivity(), new ArrayList<Store>(0));
        recyclerView.setAdapter(emptyAdapter);

        subscribeToAdapterDataObserver();

        return view;
    }

    private void subscribeToAdapterDataObserver() {
        Observer<BottleRocketAPIResponse> bottleRocketAPIResponseObserver = new Observer<BottleRocketAPIResponse>() {
            @Override
            public void onChanged(@Nullable BottleRocketAPIResponse bottleRocketAPIResponse) {
                switch (bottleRocketAPIResponse.getResponseType()) {
                    case BottleRocketAPIResponse.SUCCESSFUL_RESPONSE:

                        StoresRecyclerViewAdapter adapterWithData =
                                new StoresRecyclerViewAdapter(getActivity(),
                                        bottleRocketAPIResponse.getStores().getStoreList());

                        recyclerView.swapAdapter(adapterWithData, true);

                        break;

                    case BottleRocketAPIResponse.REQUEST_ERROR_RESPONSE:
                        displayNetworkingErrorToast();
                        break;
                    case BottleRocketAPIResponse.THROWABLE_ERROR_RESPONSE:
                        displayNetworkingErrorToast();
                        break;
                }
            }
        };

        viewModel.getBottleRocketAPIResponse().observe(getActivity(), bottleRocketAPIResponseObserver);
    }

    /**
     * Displays a Toast whenever there's an issue with networking to get {@link Stores}
     */
    private void displayNetworkingErrorToast() {
        Toast.makeText(getActivity(),
                "Sorry, we were unable get a list of the stores you want to see.",
                Toast.LENGTH_LONG).show();
    }
}
