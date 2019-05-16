package in.codeshuffle.foodiehub.ui.restaurantpage;

import android.util.Log;

import javax.inject.Inject;

import in.codeshuffle.foodiehub.data.network.ApiClient;
import in.codeshuffle.foodiehub.data.network.ApiHeader;
import in.codeshuffle.foodiehub.data.network.model.LocationResponse;
import in.codeshuffle.foodiehub.data.network.model.RestaurantDetailResponse;
import in.codeshuffle.foodiehub.ui.base.BasePresenter;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class RestaurantDetailPresenter<V extends RestaurantDetailMvpView> extends BasePresenter<V>
        implements RestaurantDetailMvpPresenter<V> {

    @Inject
    RestaurantDetailPresenter(ApiClient apiClient, ApiHeader apiHeader) {
        super(apiClient, apiHeader);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void handleApiError() {
        super.handleApiError();
    }

    @Override
    public void fetchRestaurantDetails(Long restaurantId) {
        Log.d("Location", "Fetching Restaurant detail: " + restaurantId);

        getMvpView().showLoading();

        getApiClient().getRestaurantDetail(getApiHeaders(), restaurantId)
                .subscribe(new Observer<RestaurantDetailResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RestaurantDetailResponse restaurantDetailResponse) {
                        if (!isViewAttached())
                            return;

                        getMvpView().onRestaurantDetail(restaurantDetailResponse);
                        getMvpView().hideLoading();
                    }

                    @Override
                    public void onError(Throwable t) {
                        if (!isViewAttached())
                            return;

                        getMvpView().onError("Something went wrong");
                        getMvpView().hideLoading();
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }
}
