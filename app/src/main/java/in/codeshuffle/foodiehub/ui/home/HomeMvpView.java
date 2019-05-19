package in.codeshuffle.foodiehub.ui.home;

import in.codeshuffle.foodiehub.data.network.model.RestaurantsResponse;
import in.codeshuffle.foodiehub.ui.base.MvpView;

public interface HomeMvpView extends MvpView {
    void setupLocationService();

    void onRestaurantList(RestaurantsResponse restaurantsResponse);

    void showUpdatedLocationInfo();
}
