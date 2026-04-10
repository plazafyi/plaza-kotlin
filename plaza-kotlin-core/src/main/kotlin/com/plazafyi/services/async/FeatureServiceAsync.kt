// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.plazafyi.core.ClientOptions
import com.plazafyi.core.RequestOptions
import com.plazafyi.core.http.HttpResponseFor
import com.plazafyi.models.FeatureCollection
import com.plazafyi.models.GeoJsonFeature
import com.plazafyi.models.features.BatchRequest
import com.plazafyi.models.features.FeatureBatchParams
import com.plazafyi.models.features.FeatureQueryParams
import com.plazafyi.models.features.FeatureRetrieveParams
import com.plazafyi.models.features.SpatialPredicate

interface FeatureServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): FeatureServiceAsync

    /** Get feature by type and ID */
    suspend fun retrieve(
        id: Long,
        params: FeatureRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GeoJsonFeature = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    suspend fun retrieve(
        params: FeatureRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GeoJsonFeature

    /** Fetch multiple features by type and ID */
    suspend fun batch(
        params: FeatureBatchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeatureCollection

    /** @see batch */
    suspend fun batch(
        batchRequest: BatchRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeatureCollection =
        batch(FeatureBatchParams.builder().batchRequest(batchRequest).build(), requestOptions)

    /** Query features by spatial predicate, bounding box, or H3 cell */
    suspend fun query(
        params: FeatureQueryParams = FeatureQueryParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeatureCollection

    /** @see query */
    suspend fun query(
        spatialPredicate: SpatialPredicate,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeatureCollection =
        query(
            FeatureQueryParams.builder().spatialPredicate(spatialPredicate).build(),
            requestOptions,
        )

    /** @see query */
    suspend fun query(requestOptions: RequestOptions): FeatureCollection =
        query(FeatureQueryParams.none(), requestOptions)

    /**
     * A view of [FeatureServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): FeatureServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v1/features/{type}/{id}`, but is otherwise the
         * same as [FeatureServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            id: Long,
            params: FeatureRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GeoJsonFeature> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            params: FeatureRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GeoJsonFeature>

        /**
         * Returns a raw HTTP response for `post /api/v1/features/batch`, but is otherwise the same
         * as [FeatureServiceAsync.batch].
         */
        @MustBeClosed
        suspend fun batch(
            params: FeatureBatchParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FeatureCollection>

        /** @see batch */
        @MustBeClosed
        suspend fun batch(
            batchRequest: BatchRequest,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FeatureCollection> =
            batch(FeatureBatchParams.builder().batchRequest(batchRequest).build(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /api/v1/features`, but is otherwise the same as
         * [FeatureServiceAsync.query].
         */
        @MustBeClosed
        suspend fun query(
            params: FeatureQueryParams = FeatureQueryParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FeatureCollection>

        /** @see query */
        @MustBeClosed
        suspend fun query(
            spatialPredicate: SpatialPredicate,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FeatureCollection> =
            query(
                FeatureQueryParams.builder().spatialPredicate(spatialPredicate).build(),
                requestOptions,
            )

        /** @see query */
        @MustBeClosed
        suspend fun query(requestOptions: RequestOptions): HttpResponseFor<FeatureCollection> =
            query(FeatureQueryParams.none(), requestOptions)
    }
}
