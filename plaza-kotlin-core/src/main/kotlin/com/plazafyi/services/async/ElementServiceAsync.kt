// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.plazafyi.core.ClientOptions
import com.plazafyi.core.RequestOptions
import com.plazafyi.core.http.HttpResponseFor
import com.plazafyi.models.FeatureCollection
import com.plazafyi.models.GeoJsonFeature
import com.plazafyi.models.elements.BatchRequest
import com.plazafyi.models.elements.ElementBatchParams
import com.plazafyi.models.elements.ElementLookupParams
import com.plazafyi.models.elements.ElementNearbyParams
import com.plazafyi.models.elements.ElementNearbyPostParams
import com.plazafyi.models.elements.ElementQueryParams
import com.plazafyi.models.elements.ElementQueryPostParams
import com.plazafyi.models.elements.ElementRetrieveParams

interface ElementServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): ElementServiceAsync

    /** Get feature by type and ID */
    suspend fun retrieve(
        id: Long,
        params: ElementRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GeoJsonFeature = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    suspend fun retrieve(
        params: ElementRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GeoJsonFeature

    /** Fetch multiple features by type and ID */
    suspend fun batch(
        params: ElementBatchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeatureCollection

    /** @see batch */
    suspend fun batch(
        batchRequest: BatchRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeatureCollection =
        batch(ElementBatchParams.builder().batchRequest(batchRequest).build(), requestOptions)

    /** Get feature by type and ID */
    suspend fun lookup(
        params: ElementLookupParams = ElementLookupParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GeoJsonFeature

    /** @see lookup */
    suspend fun lookup(requestOptions: RequestOptions): GeoJsonFeature =
        lookup(ElementLookupParams.none(), requestOptions)

    /** Find features near a geographic point */
    suspend fun nearby(
        params: ElementNearbyParams = ElementNearbyParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeatureCollection

    /** @see nearby */
    suspend fun nearby(requestOptions: RequestOptions): FeatureCollection =
        nearby(ElementNearbyParams.none(), requestOptions)

    /** Find features near a geographic point */
    suspend fun nearbyPost(
        params: ElementNearbyPostParams = ElementNearbyPostParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeatureCollection

    /** @see nearbyPost */
    suspend fun nearbyPost(requestOptions: RequestOptions): FeatureCollection =
        nearbyPost(ElementNearbyPostParams.none(), requestOptions)

    /** Query features by spatial predicate, bounding box, or H3 cell */
    suspend fun query(
        params: ElementQueryParams = ElementQueryParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeatureCollection

    /** @see query */
    suspend fun query(requestOptions: RequestOptions): FeatureCollection =
        query(ElementQueryParams.none(), requestOptions)

    /** Query features by spatial predicate, bounding box, or H3 cell */
    suspend fun queryPost(
        params: ElementQueryPostParams = ElementQueryPostParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeatureCollection

    /** @see queryPost */
    suspend fun queryPost(requestOptions: RequestOptions): FeatureCollection =
        queryPost(ElementQueryPostParams.none(), requestOptions)

    /**
     * A view of [ElementServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): ElementServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v1/features/{type}/{id}`, but is otherwise the
         * same as [ElementServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            id: Long,
            params: ElementRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GeoJsonFeature> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            params: ElementRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GeoJsonFeature>

        /**
         * Returns a raw HTTP response for `post /api/v1/features/batch`, but is otherwise the same
         * as [ElementServiceAsync.batch].
         */
        @MustBeClosed
        suspend fun batch(
            params: ElementBatchParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FeatureCollection>

        /** @see batch */
        @MustBeClosed
        suspend fun batch(
            batchRequest: BatchRequest,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FeatureCollection> =
            batch(ElementBatchParams.builder().batchRequest(batchRequest).build(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /api/v1/features/lookup`, but is otherwise the same
         * as [ElementServiceAsync.lookup].
         */
        @MustBeClosed
        suspend fun lookup(
            params: ElementLookupParams = ElementLookupParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GeoJsonFeature>

        /** @see lookup */
        @MustBeClosed
        suspend fun lookup(requestOptions: RequestOptions): HttpResponseFor<GeoJsonFeature> =
            lookup(ElementLookupParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v1/features/nearby`, but is otherwise the same
         * as [ElementServiceAsync.nearby].
         */
        @MustBeClosed
        suspend fun nearby(
            params: ElementNearbyParams = ElementNearbyParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FeatureCollection>

        /** @see nearby */
        @MustBeClosed
        suspend fun nearby(requestOptions: RequestOptions): HttpResponseFor<FeatureCollection> =
            nearby(ElementNearbyParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /api/v1/features/nearby`, but is otherwise the same
         * as [ElementServiceAsync.nearbyPost].
         */
        @MustBeClosed
        suspend fun nearbyPost(
            params: ElementNearbyPostParams = ElementNearbyPostParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FeatureCollection>

        /** @see nearbyPost */
        @MustBeClosed
        suspend fun nearbyPost(requestOptions: RequestOptions): HttpResponseFor<FeatureCollection> =
            nearbyPost(ElementNearbyPostParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v1/features`, but is otherwise the same as
         * [ElementServiceAsync.query].
         */
        @MustBeClosed
        suspend fun query(
            params: ElementQueryParams = ElementQueryParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FeatureCollection>

        /** @see query */
        @MustBeClosed
        suspend fun query(requestOptions: RequestOptions): HttpResponseFor<FeatureCollection> =
            query(ElementQueryParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /api/v1/features`, but is otherwise the same as
         * [ElementServiceAsync.queryPost].
         */
        @MustBeClosed
        suspend fun queryPost(
            params: ElementQueryPostParams = ElementQueryPostParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FeatureCollection>

        /** @see queryPost */
        @MustBeClosed
        suspend fun queryPost(requestOptions: RequestOptions): HttpResponseFor<FeatureCollection> =
            queryPost(ElementQueryPostParams.none(), requestOptions)
    }
}
