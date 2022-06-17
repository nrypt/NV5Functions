package test.nry.nv5.lambda

import com.amazonaws.services.lambda.runtime.Context
import com.google.gson.Gson
import junit.framework.TestCase.assertEquals
import nry.nv5.data.Histogram
import nry.nv5.lambda.Handler
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class HandlerTest {
    var gson = Gson()
    @Test
    fun handleRequestDefault() {
        val handler = Handler()
        val ev: Map<String, Any> = emptyMap<String, Any>()
        val context = Mockito.mock(Context::class.java)
        val resultJSON = handler.handleRequest(ev, context)
        val result = gson.fromJson(resultJSON, Histogram::class.java)
        assertEquals(result.size, 1000)
    }

    @Test
    fun handleRequest() {
        val handler = Handler()
        val ev: Map<String, Any> = mapOf("quantity" to 12)
        val context = Mockito.mock(Context::class.java)
        val resultJSON = handler.handleRequest(ev, context)
        val result = gson.fromJson(resultJSON, Histogram::class.java)
        assertEquals(result.size, 12)
    }
}