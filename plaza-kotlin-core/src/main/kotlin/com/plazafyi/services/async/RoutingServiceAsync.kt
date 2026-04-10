// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.plazafyi.core.ClientOptions
import com.plazafyi.core.RequestOptions
import com.plazafyi.core.http.HttpResponseFor
import com.plazafyi.models.routing.IsochroneRequest
import com.plazafyi.models.routing.MatrixRequest
import com.plazafyi.models.routing.MatrixResult
import com.plazafyi.models.routing.NearestRequest
import com.plazafyi.models.routing.NearestResult
import com.plazafyi.models.routing.RouteRequest
import com.plazafyi.models.routing.RouteResult
import com.plazafyi.models.routing.RoutingIsochroneParams
import com.plazafyi.models.routing.RoutingIsochroneResponse
import com.plazafyi.models.routing.RoutingMatrixParams
import com.plazafyi.models.routing.RoutingNearestParams
import com.plazafyi.models.routing.RoutingRouteParams

interface RoutingServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): RoutingServiceAsync

    /** Calculate an isochrone from a point */
    suspend fun isochrone(
        params: RoutingIsochroneParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RoutingIsochroneResponse

    /** @see isochrone */
    suspend fun isochrone(
        isochroneRequest: IsochroneRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RoutingIsochroneResponse =
        isochrone(
            RoutingIsochroneParams.builder().isochroneRequest(isochroneRequest).build(),
            requestOptions,
        )

    /** Calculate a distance matrix between points */
    suspend fun matrix(
        params: RoutingMatrixParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MatrixResult

    /** @see matrix */
    suspend fun matrix(
        matrixRequest: MatrixRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MatrixResult =
        matrix(RoutingMatrixParams.builder().matrixRequest(matrixRequest).build(), requestOptions)

    /** Snap a coordinate to the nearest road */
    suspend fun nearest(
        params: RoutingNearestParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): NearestResult

    /** @see nearest */
    suspend fun nearest(
        nearestRequest: NearestRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): NearestResult =
        nearest(
            RoutingNearestParams.builder().nearestRequest(nearestRequest).build(),
            requestOptions,
        )

    /** Calculate a route between two points */
    suspend fun route(
        params: RoutingRouteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RouteResult

    /** @see route */
    suspend fun route(
        routeRequest: RouteRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RouteResult =
        route(RoutingRouteParams.builder().routeRequest(routeRequest).build(), requestOptions)

    /**
     * A view of [RoutingServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): RoutingServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/v1/isochrone`, but is otherwise the same as
         * [RoutingServiceAsync.isochrone].
         */
        @MustBeClosed
        suspend fun isochrone(
            params: RoutingIsochroneParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RoutingIsochroneResponse>

        /** @see isochrone */
        @MustBeClosed
        suspend fun isochrone(
            isochroneRequest: IsochroneRequest,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RoutingIsochroneResponse> =
            isochrone(
                RoutingIsochroneParams.builder().isochroneRequest(isochroneRequest).build(),
                requestOptions,
            )

        /**
         * Returns a raw HTTP response for `post /api/v1/matrix`, but is otherwise the same as
         * [RoutingServiceAsync.matrix].
         */
        @MustBeClosed
        suspend fun matrix(
            params: RoutingMatrixParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MatrixResult>

        /** @see matrix */
        @MustBeClosed
        suspend fun matrix(
            matrixRequest: MatrixRequest,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MatrixResult> =
            matrix(
                RoutingMatrixParams.builder().matrixRequest(matrixRequest).build(),
                requestOptions,
            )

        /**
         * Returns a raw HTTP response for `post /api/v1/nearest`, but is otherwise the same as
         * [RoutingServiceAsync.nearest].
         */
        @MustBeClosed
        suspend fun nearest(
            params: RoutingNearestParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<NearestResult>

        /** @see nearest */
        @MustBeClosed
        suspend fun nearest(
            nearestRequest: NearestRequest,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<NearestResult> =
            nearest(
                RoutingNearestParams.builder().nearestRequest(nearestRequest).build(),
                requestOptions,
            )

        /**
         * Returns a raw HTTP response for `post /api/v1/route`, but is otherwise the same as
         * [RoutingServiceAsync.route].
         */
        @MustBeClosed
        suspend fun route(
            params: RoutingRouteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RouteResult>

        /** @see route */
        @MustBeClosed
        suspend fun route(
            routeRequest: RouteRequest,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RouteResult> =
            route(RoutingRouteParams.builder().routeRequest(routeRequest).build(), requestOptions)
    }
}
