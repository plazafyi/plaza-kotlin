// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.plazafyi.TestServerExtension
import com.plazafyi.client.okhttp.PlazaOkHttpClientAsync
import com.plazafyi.models.query.PlazaqlQuery
import com.plazafyi.models.query.QueryExecuteParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class QueryServiceAsyncTest {

    @Test
    suspend fun execute() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val queryServiceAsync = client.query()

        val featureCollection =
            queryServiceAsync.execute(
                QueryExecuteParams.builder()
                    .format("format")
                    .plazaqlQuery(
                        PlazaqlQuery.builder()
                            .data(
                                "\$\$ = search(node, amenity: \"cafe\").around(distance: 500, geometry: point(48.8566, 2.3522));"
                            )
                            .build()
                    )
                    .build()
            )

        featureCollection.validate()
    }
}
