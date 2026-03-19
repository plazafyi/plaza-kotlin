// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.plazafyi.core.ClientOptions
import com.plazafyi.core.RequestOptions
import com.plazafyi.core.http.HttpResponseFor
import com.plazafyi.models.FeatureCollection
import com.plazafyi.models.query.OverpassQuery
import com.plazafyi.models.query.QueryOverpassParams
import com.plazafyi.models.query.QuerySparqlParams
import com.plazafyi.models.query.SparqlQuery
import com.plazafyi.models.query.SparqlResult

interface QueryServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): QueryServiceAsync

    /** Execute an Overpass QL query */
    suspend fun overpass(
        params: QueryOverpassParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeatureCollection

    /** @see overpass */
    suspend fun overpass(
        overpassQuery: OverpassQuery,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeatureCollection =
        overpass(QueryOverpassParams.builder().overpassQuery(overpassQuery).build(), requestOptions)

    /** Execute a SPARQL query */
    suspend fun sparql(
        params: QuerySparqlParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SparqlResult

    /** @see sparql */
    suspend fun sparql(
        sparqlQuery: SparqlQuery,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SparqlResult =
        sparql(QuerySparqlParams.builder().sparqlQuery(sparqlQuery).build(), requestOptions)

    /** A view of [QueryServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): QueryServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/v1/overpass`, but is otherwise the same as
         * [QueryServiceAsync.overpass].
         */
        @MustBeClosed
        suspend fun overpass(
            params: QueryOverpassParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FeatureCollection>

        /** @see overpass */
        @MustBeClosed
        suspend fun overpass(
            overpassQuery: OverpassQuery,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FeatureCollection> =
            overpass(
                QueryOverpassParams.builder().overpassQuery(overpassQuery).build(),
                requestOptions,
            )

        /**
         * Returns a raw HTTP response for `post /api/v1/sparql`, but is otherwise the same as
         * [QueryServiceAsync.sparql].
         */
        @MustBeClosed
        suspend fun sparql(
            params: QuerySparqlParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SparqlResult>

        /** @see sparql */
        @MustBeClosed
        suspend fun sparql(
            sparqlQuery: SparqlQuery,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SparqlResult> =
            sparql(QuerySparqlParams.builder().sparqlQuery(sparqlQuery).build(), requestOptions)
    }
}
