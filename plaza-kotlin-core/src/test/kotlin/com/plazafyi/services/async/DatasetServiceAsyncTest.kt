// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.plazafyi.TestServerExtension
import com.plazafyi.client.okhttp.PlazaOkHttpClientAsync
import com.plazafyi.models.datasets.DatasetCreateParams
import com.plazafyi.models.datasets.DatasetFeaturesParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class DatasetServiceAsyncTest {

    @Test
    suspend fun create() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val datasetServiceAsync = client.datasets()

        val dataset =
            datasetServiceAsync.create(
                DatasetCreateParams.builder()
                    .name("NYC Bike Lanes")
                    .slug("nyc-bike-lanes")
                    .attribution("attribution")
                    .description("description")
                    .license("license")
                    .sourceUrl("https://example.com")
                    .build()
            )

        dataset.validate()
    }

    @Test
    suspend fun retrieve() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val datasetServiceAsync = client.datasets()

        val dataset = datasetServiceAsync.retrieve("id")

        dataset.validate()
    }

    @Test
    suspend fun list() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val datasetServiceAsync = client.datasets()

        val datasetList = datasetServiceAsync.list()

        datasetList.validate()
    }

    @Test
    suspend fun delete() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val datasetServiceAsync = client.datasets()

        datasetServiceAsync.delete("id")
    }

    @Test
    suspend fun features() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val datasetServiceAsync = client.datasets()

        val featureCollection =
            datasetServiceAsync.features(
                DatasetFeaturesParams.builder()
                    .id("id")
                    .cursor("cursor")
                    .limit(0L)
                    .outputBuffer(0.0)
                    .outputCentroid(true)
                    .outputFields("output[fields]")
                    .outputGeometry(true)
                    .outputInclude("output[include]")
                    .outputPrecision(0L)
                    .outputSimplify(0.0)
                    .outputSort("output[sort]")
                    .build()
            )

        featureCollection.validate()
    }
}
