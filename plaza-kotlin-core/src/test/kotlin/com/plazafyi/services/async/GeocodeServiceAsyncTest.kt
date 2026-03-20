// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.plazafyi.TestServerExtension
import com.plazafyi.client.okhttp.PlazaOkHttpClientAsync
import com.plazafyi.models.geocode.GeocodeAutocompleteParams
import com.plazafyi.models.geocode.GeocodeAutocompletePostParams
import com.plazafyi.models.geocode.GeocodeBatchParams
import com.plazafyi.models.geocode.GeocodeForwardParams
import com.plazafyi.models.geocode.GeocodeForwardPostParams
import com.plazafyi.models.geocode.GeocodeReverseParams
import com.plazafyi.models.geocode.GeocodeReversePostParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class GeocodeServiceAsyncTest {

    @Test
    suspend fun autocomplete() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val geocodeServiceAsync = client.geocode()

        val autocompleteResult =
            geocodeServiceAsync.autocomplete(
                GeocodeAutocompleteParams.builder()
                    .q("q")
                    .countryCode("country_code")
                    .lang("lang")
                    .lat(0.0)
                    .layer("layer")
                    .limit(0L)
                    .lng(0.0)
                    .build()
            )

        autocompleteResult.validate()
    }

    @Test
    suspend fun autocompletePost() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val geocodeServiceAsync = client.geocode()

        val autocompleteResult =
            geocodeServiceAsync.autocompletePost(
                GeocodeAutocompletePostParams.builder()
                    .q("q")
                    .countryCode("country_code")
                    .lang("lang")
                    .lat(0.0)
                    .layer("layer")
                    .limit(0L)
                    .lng(0.0)
                    .build()
            )

        autocompleteResult.validate()
    }

    @Test
    suspend fun batch() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val geocodeServiceAsync = client.geocode()

        val response =
            geocodeServiceAsync.batch(GeocodeBatchParams.builder().addAddress("string").build())

        response.validate()
    }

    @Test
    suspend fun forward() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val geocodeServiceAsync = client.geocode()

        val geocodeResult =
            geocodeServiceAsync.forward(
                GeocodeForwardParams.builder()
                    .q("q")
                    .bbox("bbox")
                    .countryCode("country_code")
                    .lang("lang")
                    .lat(0.0)
                    .layer("layer")
                    .limit(0L)
                    .lng(0.0)
                    .build()
            )

        geocodeResult.validate()
    }

    @Test
    suspend fun forwardPost() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val geocodeServiceAsync = client.geocode()

        val geocodeResult =
            geocodeServiceAsync.forwardPost(
                GeocodeForwardPostParams.builder()
                    .q("q")
                    .bbox("bbox")
                    .countryCode("country_code")
                    .lang("lang")
                    .lat(0.0)
                    .layer("layer")
                    .limit(0L)
                    .lng(0.0)
                    .build()
            )

        geocodeResult.validate()
    }

    @Test
    suspend fun reverse() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val geocodeServiceAsync = client.geocode()

        val reverseGeocodeResult =
            geocodeServiceAsync.reverse(
                GeocodeReverseParams.builder()
                    .lang("lang")
                    .lat(0.0)
                    .layer("layer")
                    .limit(0L)
                    .lng(0.0)
                    .near("near")
                    .radius(0L)
                    .build()
            )

        reverseGeocodeResult.validate()
    }

    @Test
    suspend fun reversePost() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val geocodeServiceAsync = client.geocode()

        val reverseGeocodeResult =
            geocodeServiceAsync.reversePost(
                GeocodeReversePostParams.builder()
                    .lang("lang")
                    .lat(0.0)
                    .layer("layer")
                    .limit(0L)
                    .lng(0.0)
                    .near("near")
                    .radius(0L)
                    .build()
            )

        reverseGeocodeResult.validate()
    }
}
