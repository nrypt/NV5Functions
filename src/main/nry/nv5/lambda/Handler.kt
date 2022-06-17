package nry.nv5.lambda

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.google.gson.Gson
import nry.nv5.data.Histogram


class Handler: RequestHandler<Map<String, Any>, String> {
    var gson = Gson()
    override fun handleRequest(event: Map<String, Any>, ctx: Context): String {
        val n = event.let {
            it["quantity"]?.toString()?.toInt() ?: 1000
        }

        var rnds: Int
        val nums = mutableListOf<Int>()
        for (i in 1..n) {
            rnds = (0..15).random()
            nums.add(rnds)
        }

        val histogramData = Histogram(nums.toList() as List<Double>, "", nums.size)

        return gson.toJson(histogramData)
    }

}