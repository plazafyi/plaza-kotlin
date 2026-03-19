// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.plazafyi.TestServerExtension
import com.plazafyi.client.okhttp.PlazaOkHttpClientAsync
import com.plazafyi.models.GeoJsonGeometry
import com.plazafyi.models.routing.MatrixRequest
import com.plazafyi.models.routing.RouteRequest
import com.plazafyi.models.routing.RoutingIsochroneParams
import com.plazafyi.models.routing.RoutingNearestParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class RoutingServiceAsyncTest {

    @Test
    suspend fun isochrone() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val routingServiceAsync = client.routing()

        val geoJsonFeature =
            routingServiceAsync.isochrone(
                RoutingIsochroneParams.builder().lat(0.0).lng(0.0).time(0.0).mode("mode").build()
            )

        geoJsonFeature.validate()
    }

    @Test
    suspend fun matrix() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val routingServiceAsync = client.routing()

        val matrixResult =
            routingServiceAsync.matrix(
                MatrixRequest.builder()
                    .destinations(
                        GeoJsonGeometry.builder()
                            .coordinatesOfDoubles(listOf(0.0))
                            .type(GeoJsonGeometry.Type.POINT)
                            .build()
                    )
                    .origins(
                        GeoJsonGeometry.builder()
                            .coordinatesOfDoubles(listOf(0.0))
                            .type(GeoJsonGeometry.Type.POINT)
                            .build()
                    )
                    .mode(MatrixRequest.Mode.AUTO)
                    .build()
            )

        matrixResult.validate()
    }

    @Test
    suspend fun nearest() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val routingServiceAsync = client.routing()

        val nearestResult =
            routingServiceAsync.nearest(
                RoutingNearestParams.builder().lat(0.0).lng(0.0).radius(0L).build()
            )

        nearestResult.validate()
    }

    @Test
    suspend fun route() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val routingServiceAsync = client.routing()

        val routeResult =
            routingServiceAsync.route(
                RouteRequest.builder()
                    .destination(
                        GeoJsonGeometry.builder()
                            .coordinatesOfDoubles(listOf(0.0))
                            .type(GeoJsonGeometry.Type.POINT)
                            .build()
                    )
                    .origin(
                        GeoJsonGeometry.builder()
                            .coordinatesOfDoubles(listOf(0.0))
                            .type(GeoJsonGeometry.Type.POINT)
                            .build()
                    )
                    .mode(RouteRequest.Mode.AUTO)
                    .build()
            )

        routeResult.validate()
    }
}
