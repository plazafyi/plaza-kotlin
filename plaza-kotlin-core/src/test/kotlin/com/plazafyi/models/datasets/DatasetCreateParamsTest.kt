// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.datasets

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DatasetCreateParamsTest {

    @Test
    fun create() {
        DatasetCreateParams.builder()
            .name("name")
            .slug("slug")
            .attribution("attribution")
            .description("description")
            .license("license")
            .sourceUrl("source_url")
            .build()
    }

    @Test
    fun body() {
        val params =
            DatasetCreateParams.builder()
                .name("name")
                .slug("slug")
                .attribution("attribution")
                .description("description")
                .license("license")
                .sourceUrl("source_url")
                .build()

        val body = params._body()

        assertThat(body.name()).isEqualTo("name")
        assertThat(body.slug()).isEqualTo("slug")
        assertThat(body.attribution()).isEqualTo("attribution")
        assertThat(body.description()).isEqualTo("description")
        assertThat(body.license()).isEqualTo("license")
        assertThat(body.sourceUrl()).isEqualTo("source_url")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = DatasetCreateParams.builder().name("name").slug("slug").build()

        val body = params._body()

        assertThat(body.name()).isEqualTo("name")
        assertThat(body.slug()).isEqualTo("slug")
    }
}
