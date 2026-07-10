package com.amonteiro.a06_ipi_lyon_android.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.amonteiro.a06_ipi_lyon_android.data.remote.WeatherApiDataSource
import com.amonteiro.a06_ipi_lyon_android.domain.model.Weather
import kotlinx.coroutines.flow.MutableStateFlow

suspend fun main(){
    val viewModel = MainViewModel()
    viewModel.loadWeathers("Nice")
    //Affichage de la liste (qui doit être remplie) contenue dans la donnée observable
    println("List : ${viewModel.dataList.value}" )

    //Pour que le programme s'arrête, inutile sur Android
    WeatherApiDataSource.close()
}

class MainViewModel : ViewModel() {
    //MutableStateFlow est une donnée observable
    val dataList = MutableStateFlow(emptyList<Weather>())

    suspend fun loadWeathers(cityName:String){
        //TODO récupérer des données et les mettre dans dataList
        dataList.value = WeatherApiDataSource.loadWeathers(cityName)
    }
}