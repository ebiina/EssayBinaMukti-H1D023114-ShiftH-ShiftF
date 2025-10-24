package com.unsoed.responsi1mobileh1d023114.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unsoed.responsi1mobileh1d023114.data.model.TeamResponse
import com.unsoed.responsi1mobileh1d023114.data.network.RetrofitClient
import com.unsoed.responsi1mobileh1d023114.utils.Constants
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _teamDetails = MutableLiveData<TeamResponse>()
    val teamDetails: LiveData<TeamResponse> = _teamDetails

    fun fetchTeamDetails(teamId: Int) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.api.getTeamDetails(teamId, Constants.FOOTBALL_API_TOKEN)
                if (response.isSuccessful) {
                    _teamDetails.postValue(response.body())
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
