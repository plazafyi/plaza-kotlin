// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.plazafyi.core.ClientOptions
import com.plazafyi.core.RequestOptions
import com.plazafyi.core.http.HttpResponseFor
import com.plazafyi.models.mapmatch.MapMatchMatchParams
import com.plazafyi.models.mapmatch.MapMatchRequest
import com.plazafyi.models.mapmatch.MapMatchResult

interface MapMatchServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): MapMatchServiceAsync

    /** Match GPS coordinates to the road network */
    suspend fun match(
        params: MapMatchMatchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MapMatchResult

    /** @see match */
    suspend fun match(
        mapMatchRequest: MapMatchRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MapMatchResult =
        match(
            MapMatchMatchParams.builder().mapMatchRequest(mapMatchRequest).build(),
            requestOptions,
        )

    /**
     * A view of [MapMatchServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): MapMatchServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/v1/map-match`, but is otherwise the same as
         * [MapMatchServiceAsync.match].
         */
        @MustBeClosed
        suspend fun match(
            params: MapMatchMatchParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MapMatchResult>

        /** @see match */
        @MustBeClosed
        suspend fun match(
            mapMatchRequest: MapMatchRequest,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MapMatchResult> =
            match(
                MapMatchMatchParams.builder().mapMatchRequest(mapMatchRequest).build(),
                requestOptions,
            )
    }
}
