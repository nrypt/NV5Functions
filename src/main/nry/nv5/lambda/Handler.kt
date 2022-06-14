package nry.nv5.lambda

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;


class Handler: RequestHandler<Map<String, Object>, String> {
    override fun handleRequest(event: Map<String, Object>, ctx: Context): String {
        val n = event.let {
            it["quantity"]?.toString()?.toInt() ?: 1000
        }

        var rnds: Int;
        val nums = mutableListOf<Int>();
        for (i in 1..n) {
            rnds = (0..15).random()
            nums.add(rnds)
        }

        return "{\"data\": " + org.json.JSONArray(nums) + "}"
    }

}