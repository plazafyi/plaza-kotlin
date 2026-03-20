// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.plazafyi.TestServerExtension
import com.plazafyi.client.okhttp.PlazaOkHttpClientAsync
import com.plazafyi.models.search.SearchQueryParams
import com.plazafyi.models.search.SearchQueryPostParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class SearchServiceAsyncTest {

    @Test
    suspend fun query() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val searchServiceAsync = client.search()

        val featureCollection =
            searchServiceAsync.query(
                SearchQueryParams.builder()
                    .q("q")
                    .cursor("cursor")
                    .format("format")
                    .limit(0L)
                    .outputFields("output[fields]")
                    .outputInclude("output[include]")
                    .outputPrecision(0L)
                    .outputSort("output[sort]")
                    .build()
            )

        featureCollection.validate()
    }

    @Test
    suspend fun queryPost() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val searchServiceAsync = client.search()

        val featureCollection =
            searchServiceAsync.queryPost(
                SearchQueryPostParams.builder()
                    .q("q")
                    .cursor("cursor")
                    .format("format")
                    .limit(0L)
                    .outputFields("output[fields]")
                    .outputInclude("output[include]")
                    .outputPrecision(0L)
                    .outputSort("output[sort]")
                    .build()
            )

        featureCollection.validate()
    }
}
