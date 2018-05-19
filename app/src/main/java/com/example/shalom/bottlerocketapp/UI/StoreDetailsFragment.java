package com.example.shalom.bottlerocketapp.UI;


import android.arch.lifecycle.ViewModelProviders;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shalom.bottlerocketapp.R;
import com.example.shalom.bottlerocketapp.service.model.Store;
import com.example.shalom.bottlerocketapp.util.EspressoIdlingResource;
import com.example.shalom.bottlerocketapp.viewmodel.StoreDetailsViewModel;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;
import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class StoreDetailsFragment extends Fragment {

    @BindView(R.id.company_logo)
    ImageView companyLogoImageView;
    @BindView(R.id.street_textview)
    TextView streetTextView;
    @BindView(R.id.city_state_zip_textview)
    TextView cityStateZipTextView;
    @BindView(R.id.coordinates_textview)
    TextView coordinatesTextView;
    @BindView(R.id.phone_number_textview)
    TextView phoneNumberTextView;
    @BindView(R.id.store_id_textview)
    TextView storeIDTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_store_details, container, false);

        ButterKnife.bind(this, view);
        StoreDetailsViewModel viewModel =
                ViewModelProviders
                        .of(getActivity())
                        .get(StoreDetailsViewModel.class);

        //Unparcel a {@link Store} from arguments and pass it to the ViewModel
        Bundle receivedBundle = this.getArguments();
        Store thisStore = Parcels.unwrap(receivedBundle.getParcelable(StoreDetailsViewModel.BUNDLED_STORE_KEY));
        viewModel.setSelectedStore(thisStore);

        //Set data to their appropriate views
        Picasso.get().load(viewModel.getStoreLogoURL()).into(companyLogoImageView);
        streetTextView.setText(viewModel.getStreet());
        cityStateZipTextView.setText(viewModel.getCityStateZipcode());
        coordinatesTextView.setText(viewModel.getCoordinates());
        phoneNumberTextView.setText(viewModel.getPhoneNumber());
        storeIDTextView.setText(viewModel.getStoreID());
        return view;
    }

}
