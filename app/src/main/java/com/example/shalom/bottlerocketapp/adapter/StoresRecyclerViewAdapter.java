package com.example.shalom.bottlerocketapp.adapter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.shalom.bottlerocketapp.R;
import com.example.shalom.bottlerocketapp.UI.StoreDetailsFragment;
import com.example.shalom.bottlerocketapp.service.model.Store;
import com.example.shalom.bottlerocketapp.viewmodel.StoreDetailsViewModel;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.List;

import javax.xml.transform.Templates;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * RecyclerView adapter for {@link com.example.shalom.bottlerocketapp.UI.StoresFragment}'s
 * RecyclerView
 */
public class StoresRecyclerViewAdapter extends RecyclerView.Adapter<StoresRecyclerViewAdapter.ListItemViewHolder> {

    private FragmentActivity hostFragment;
    private List<Store> stores;

    /**
     * @param stores Values that will be displayed by this adapter
     */
    public StoresRecyclerViewAdapter(FragmentActivity hostFragment, List<Store> stores) {
        this.hostFragment = hostFragment;
        this.stores = stores;
    }

    @NonNull
    @Override
    public ListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Inflate the layout
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_stores, parent, false);

        ListItemViewHolder viewHolder = new ListItemViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemViewHolder holder, int position) {
        //Get appropriate {@link Store} for current position
        final Store store = stores.get(position);

        //Loads store logo using Picasso
        String logoUrl = store.getStoreLogoURL();
        Picasso.get().load(logoUrl).into(holder.storeLogo);

        //Get store contact information
        String address = store.getAddress();
        String city = store.getCity();
        String phoneNumber = store.getPhone();

        //Display the store's address, city, and phone number
        String displayedContactInformation = address + "\n" + city + "\n" + phoneNumber;
        holder.storeAddress.setText(displayedContactInformation);

        holder.wholeListItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = hostFragment.getSupportFragmentManager();
                StoreDetailsFragment storeDetailsFragment = new StoreDetailsFragment();

                /*Pass the clicked movie's details to the Fragment*/
                Bundle storeDetails = new Bundle();
                storeDetails.putParcelable(StoreDetailsViewModel.BUNDLED_STORE_KEY, Parcels.wrap(store));
                storeDetailsFragment.setArguments(storeDetails);

                /*Add Fragment*/
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_container, storeDetailsFragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return stores.size();
    }

    /**
     * A ViewHolder for every view inside each list item
     */
    public class ListItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.list_item)
        RelativeLayout wholeListItem;
        @BindView(R.id.store_logo_imageview)
        ImageView storeLogo;
        @BindView(R.id.address_textview)
        TextView storeAddress;

        public ListItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
