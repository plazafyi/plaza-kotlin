// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.datasets

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DatasetCreateParamsTest {

    @Test
    fun create() {
        DatasetCreateParams.builder()
            .name("NYC Bike Lanes")
            .slug("nyc-bike-lanes")
            .attribution("attribution")
            .description("description")
            .license("license")
            .sourceUrl("https://example.com")
            .strictMode(true)
            .build()
    }

    @Test
    fun body() {
        val params =
            DatasetCreateParams.builder()
                .name("NYC Bike Lanes")
                .slug("nyc-bike-lanes")
                .attribution("attribution")
                .description("description")
                .license("license")
                .sourceUrl("https://example.com")
                .strictMode(true)
                .build()

        val body = params._body()

        assertThat(body.name()).isEqualTo("NYC Bike Lanes")
        assertThat(body.slug()).isEqualTo("nyc-bike-lanes")
        assertThat(body.attribution()).isEqualTo("attribution")
        assertThat(body.description()).isEqualTo("description")
        assertThat(body.license()).isEqualTo("license")
        assertThat(body.sourceUrl()).isEqualTo("https://example.com")
        assertThat(body.strictMode()).isEqualTo(true)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            DatasetCreateParams.builder().name("NYC Bike Lanes").slug("nyc-bike-lanes").build()

        val body = params._body()

        assertThat(body.name()).isEqualTo("NYC Bike Lanes")
        assertThat(body.slug()).isEqualTo("nyc-bike-lanes")
    }
}
