// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.plazafyi.TestServerExtension
import com.plazafyi.client.okhttp.PlazaOkHttpClientAsync
import com.plazafyi.models.GeoJsonGeometry
import com.plazafyi.models.mapmatch.MapMatchRequest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class MapMatchServiceAsyncTest {

    @Test
    suspend fun match() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val mapMatchServiceAsync = client.mapMatch()

        val mapMatchResult =
            mapMatchServiceAsync.match(
                MapMatchRequest.builder()
                    .trace(
                        GeoJsonGeometry.builder()
                            .coordinatesOfDoubles(listOf(0.0))
                            .type(GeoJsonGeometry.Type.POINT)
                            .build()
                    )
                    .addRadius(0.0)
                    .build()
            )

        mapMatchResult.validate()
    }
}
