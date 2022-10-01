package com.example.cleanarchtictuersample.presenter.ui.viewmodels

enum class UIState {

    //While user wait for data to be fetched, a loading indicator is shown
     LOADING,

    //When data is successfully retrieved and list can become visible
    SUCCESS ,

    //When there is a problem with network, an error message should be shown
    NETWORK_ERROR,

    UNAUTHRAIZE,

    SERVER_ERROR

}