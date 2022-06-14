package nry.nv5.lambda

class HandlerTest {
    fun handleRequest() {
        val handler = Handler()
        val ev: Map<String, Any> = mapOf("quantity" to 12)
        val ctx = null
//        val context = Mockito.mock(Context::class.java)
        val result = ctx?.let { handler?.handleRequest(ev as Map<String, Object>, it) }
//        assert()
    }
}