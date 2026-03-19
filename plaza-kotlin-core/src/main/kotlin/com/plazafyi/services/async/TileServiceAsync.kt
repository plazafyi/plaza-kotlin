// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.plazafyi.core.ClientOptions
import com.plazafyi.core.RequestOptions
import com.plazafyi.core.http.HttpResponse
import com.plazafyi.models.tiles.TileGetParams

interface TileServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): TileServiceAsync

    /** Get a Mapbox Vector Tile */
    @MustBeClosed
    suspend fun get(
        y: Long,
        params: TileGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): HttpResponse = get(params.toBuilder().y(y).build(), requestOptions)

    /** @see get */
    @MustBeClosed
    suspend fun get(
        params: TileGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): HttpResponse

    /** A view of [TileServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: (ClientOptions.Builder) -> Unit): TileServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v1/tiles/{z}/{x}/{y}`, but is otherwise the
         * same as [TileServiceAsync.get].
         */
        @MustBeClosed
        suspend fun get(
            y: Long,
            params: TileGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = get(params.toBuilder().y(y).build(), requestOptions)

        /** @see get */
        @MustBeClosed
        suspend fun get(
            params: TileGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse
    }
}
