// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.plazafyi.core.ClientOptions
import com.plazafyi.core.RequestOptions
import com.plazafyi.core.http.HttpResponseFor
import com.plazafyi.models.FeatureCollection
import com.plazafyi.models.query.OverpassQuery
import com.plazafyi.models.query.QueryExecuteParams
import com.plazafyi.models.query.QueryExecuteResponse
import com.plazafyi.models.query.QueryOverpassParams

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

    /** Execute a multi-step query pipeline */
    suspend fun execute(
        params: QueryExecuteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): QueryExecuteResponse

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
         * Returns a raw HTTP response for `post /api/v1/query`, but is otherwise the same as
         * [QueryServiceAsync.execute].
         */
        @MustBeClosed
        suspend fun execute(
            params: QueryExecuteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<QueryExecuteResponse>

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
    }
}
