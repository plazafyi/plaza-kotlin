// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.plazafyi.core.ClientOptions
import com.plazafyi.core.RequestOptions
import com.plazafyi.core.http.HttpResponseFor
import com.plazafyi.models.elevation.ElevationLookupParams
import com.plazafyi.models.elevation.ElevationLookupRequest
import com.plazafyi.models.elevation.ElevationLookupResult
import com.plazafyi.models.elevation.ElevationProfileParams
import com.plazafyi.models.elevation.ElevationProfileRequest
import com.plazafyi.models.elevation.ElevationProfileResult

interface ElevationServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): ElevationServiceAsync

    /** Look up elevation at one or more points */
    suspend fun lookup(
        params: ElevationLookupParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ElevationLookupResult

    /** @see lookup */
    suspend fun lookup(
        elevationLookupRequest: ElevationLookupRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ElevationLookupResult =
        lookup(
            ElevationLookupParams.builder().elevationLookupRequest(elevationLookupRequest).build(),
            requestOptions,
        )

    /** Elevation profile along coordinates */
    suspend fun profile(
        params: ElevationProfileParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ElevationProfileResult

    /** @see profile */
    suspend fun profile(
        elevationProfileRequest: ElevationProfileRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ElevationProfileResult =
        profile(
            ElevationProfileParams.builder()
                .elevationProfileRequest(elevationProfileRequest)
                .build(),
            requestOptions,
        )

    /**
     * A view of [ElevationServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): ElevationServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/v1/elevation`, but is otherwise the same as
         * [ElevationServiceAsync.lookup].
         */
        @MustBeClosed
        suspend fun lookup(
            params: ElevationLookupParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ElevationLookupResult>

        /** @see lookup */
        @MustBeClosed
        suspend fun lookup(
            elevationLookupRequest: ElevationLookupRequest,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ElevationLookupResult> =
            lookup(
                ElevationLookupParams.builder()
                    .elevationLookupRequest(elevationLookupRequest)
                    .build(),
                requestOptions,
            )

        /**
         * Returns a raw HTTP response for `post /api/v1/elevation/profile`, but is otherwise the
         * same as [ElevationServiceAsync.profile].
         */
        @MustBeClosed
        suspend fun profile(
            params: ElevationProfileParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ElevationProfileResult>

        /** @see profile */
        @MustBeClosed
        suspend fun profile(
            elevationProfileRequest: ElevationProfileRequest,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ElevationProfileResult> =
            profile(
                ElevationProfileParams.builder()
                    .elevationProfileRequest(elevationProfileRequest)
                    .build(),
                requestOptions,
            )
    }
}
