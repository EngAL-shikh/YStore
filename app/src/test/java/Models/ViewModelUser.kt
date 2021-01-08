package Models

import GsonData.CategoryFetcher
import GsonData.ProductFetcher
import GsonData.UserFetcher
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

open class ViewModelUser: ViewModel() {
    val userLiveData = MutableLiveData<Int>()
    var fetchUser: LiveData<List<Users>> = TODO()
        get() {
            TODO()
        }
    init {
        fetchUser =UserFetcher().fetchUsers()

    }

    var fetchProfileUser: LiveData<Users>? =
        Transformations.switchMap( userLiveData) { id ->
            UserFetcher().fetchProfileUser(id)
        }

    fun userLiveData(id: Int) {
        userLiveData.value = id
    }


}