// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.plazafyi.TestServerExtension
import com.plazafyi.client.okhttp.PlazaOkHttpClientAsync
import com.plazafyi.models.query.OverpassQuery
import com.plazafyi.models.query.QueryExecuteParams
import com.plazafyi.models.query.QueryOverpassParams
import com.plazafyi.models.query.SparqlQuery
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

        val response =
            queryServiceAsync.execute(
                QueryExecuteParams.builder()
                    .addStep(
                        QueryExecuteParams.Step.builder()
                            .type(QueryExecuteParams.Step.Type.OVERPASS)
                            .query("query")
                            .build()
                    )
                    .build()
            )

        response.validate()
    }

    @Test
    suspend fun overpass() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val queryServiceAsync = client.query()

        val featureCollection =
            queryServiceAsync.overpass(
                QueryOverpassParams.builder()
                    .format("format")
                    .overpassQuery(
                        OverpassQuery.builder()
                            .data(
                                "[out:json];node[amenity=cafe](around:500,48.8566,2.3522);out body;"
                            )
                            .build()
                    )
                    .build()
            )

        featureCollection.validate()
    }

    @Test
    suspend fun sparql() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val queryServiceAsync = client.query()

        val sparqlResult =
            queryServiceAsync.sparql(
                SparqlQuery.builder()
                    .query(
                        "SELECT ?s ?name WHERE { ?s osm:name ?name . ?s osm:amenity \"cafe\" } LIMIT 10"
                    )
                    .build()
            )

        sparqlResult.validate()
    }
}
