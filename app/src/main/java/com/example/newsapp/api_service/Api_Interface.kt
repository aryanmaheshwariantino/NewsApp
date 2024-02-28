
import com.aryan.recyclerview.models.NewsData
import com.aryan.recyclerview.util.Utils
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api_Interface {

    @GET("/v2/top-headlines?country=us")
    suspend fun getData(
        @Query("apiKey")
        apiKey: String = Utils.apikey
    ): NewsData
}

