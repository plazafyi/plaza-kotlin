// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.plazafyi.core.ClientOptions
import com.plazafyi.core.RequestOptions
import com.plazafyi.core.http.HttpResponseFor
import com.plazafyi.models.FeatureCollection
import com.plazafyi.models.query.PlazaqlQuery
import com.plazafyi.models.query.QueryExecuteParams

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

    /** Execute a PlazaQL query */
    suspend fun execute(
        params: QueryExecuteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeatureCollection

    /** @see execute */
    suspend fun execute(
        plazaqlQuery: PlazaqlQuery,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeatureCollection =
        execute(QueryExecuteParams.builder().plazaqlQuery(plazaqlQuery).build(), requestOptions)

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
        ): HttpResponseFor<FeatureCollection>

        /** @see execute */
        @MustBeClosed
        suspend fun execute(
            plazaqlQuery: PlazaqlQuery,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FeatureCollection> =
            execute(QueryExecuteParams.builder().plazaqlQuery(plazaqlQuery).build(), requestOptions)
    }
}
