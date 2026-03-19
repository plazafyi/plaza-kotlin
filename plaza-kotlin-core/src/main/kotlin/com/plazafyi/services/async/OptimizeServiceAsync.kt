// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.plazafyi.core.ClientOptions
import com.plazafyi.core.RequestOptions
import com.plazafyi.core.http.HttpResponseFor
import com.plazafyi.models.optimize.OptimizeCreateParams
import com.plazafyi.models.optimize.OptimizeJobStatus
import com.plazafyi.models.optimize.OptimizeRequest
import com.plazafyi.models.optimize.OptimizeResult
import com.plazafyi.models.optimize.OptimizeRetrieveParams

interface OptimizeServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): OptimizeServiceAsync

    /** Optimize route through waypoints */
    suspend fun create(
        params: OptimizeCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OptimizeResult

    /** @see create */
    suspend fun create(
        optimizeRequest: OptimizeRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OptimizeResult =
        create(
            OptimizeCreateParams.builder().optimizeRequest(optimizeRequest).build(),
            requestOptions,
        )

    /** Get async optimization result */
    suspend fun retrieve(
        jobId: String,
        params: OptimizeRetrieveParams = OptimizeRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OptimizeJobStatus = retrieve(params.toBuilder().jobId(jobId).build(), requestOptions)

    /** @see retrieve */
    suspend fun retrieve(
        params: OptimizeRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OptimizeJobStatus

    /** @see retrieve */
    suspend fun retrieve(jobId: String, requestOptions: RequestOptions): OptimizeJobStatus =
        retrieve(jobId, OptimizeRetrieveParams.none(), requestOptions)

    /**
     * A view of [OptimizeServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): OptimizeServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/v1/optimize`, but is otherwise the same as
         * [OptimizeServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: OptimizeCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OptimizeResult>

        /** @see create */
        @MustBeClosed
        suspend fun create(
            optimizeRequest: OptimizeRequest,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OptimizeResult> =
            create(
                OptimizeCreateParams.builder().optimizeRequest(optimizeRequest).build(),
                requestOptions,
            )

        /**
         * Returns a raw HTTP response for `get /api/v1/optimize/{job_id}`, but is otherwise the
         * same as [OptimizeServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            jobId: String,
            params: OptimizeRetrieveParams = OptimizeRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OptimizeJobStatus> =
            retrieve(params.toBuilder().jobId(jobId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            params: OptimizeRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OptimizeJobStatus>

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            jobId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<OptimizeJobStatus> =
            retrieve(jobId, OptimizeRetrieveParams.none(), requestOptions)
    }
}
