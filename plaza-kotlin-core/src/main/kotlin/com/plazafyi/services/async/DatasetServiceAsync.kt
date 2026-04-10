// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.plazafyi.core.ClientOptions
import com.plazafyi.core.RequestOptions
import com.plazafyi.core.http.HttpResponse
import com.plazafyi.core.http.HttpResponseFor
import com.plazafyi.models.datasets.Dataset
import com.plazafyi.models.datasets.DatasetCreateParams
import com.plazafyi.models.datasets.DatasetDeleteParams
import com.plazafyi.models.datasets.DatasetList
import com.plazafyi.models.datasets.DatasetListParams
import com.plazafyi.models.datasets.DatasetRetrieveParams

interface DatasetServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): DatasetServiceAsync

    /** Create a new dataset */
    suspend fun create(
        params: DatasetCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Dataset

    /** Get dataset by ID */
    suspend fun retrieve(
        id: String,
        params: DatasetRetrieveParams = DatasetRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Dataset = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    suspend fun retrieve(
        params: DatasetRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Dataset

    /** @see retrieve */
    suspend fun retrieve(id: String, requestOptions: RequestOptions): Dataset =
        retrieve(id, DatasetRetrieveParams.none(), requestOptions)

    /** List datasets */
    suspend fun list(
        params: DatasetListParams = DatasetListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DatasetList

    /** @see list */
    suspend fun list(requestOptions: RequestOptions): DatasetList =
        list(DatasetListParams.none(), requestOptions)

    /** Delete a dataset */
    suspend fun delete(
        id: String,
        params: DatasetDeleteParams = DatasetDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    suspend fun delete(
        params: DatasetDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /** @see delete */
    suspend fun delete(id: String, requestOptions: RequestOptions) =
        delete(id, DatasetDeleteParams.none(), requestOptions)

    /**
     * A view of [DatasetServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): DatasetServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/v1/datasets`, but is otherwise the same as
         * [DatasetServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: DatasetCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Dataset>

        /**
         * Returns a raw HTTP response for `get /api/v1/datasets/{id}`, but is otherwise the same as
         * [DatasetServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            id: String,
            params: DatasetRetrieveParams = DatasetRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Dataset> = retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            params: DatasetRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Dataset>

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(id: String, requestOptions: RequestOptions): HttpResponseFor<Dataset> =
            retrieve(id, DatasetRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v1/datasets`, but is otherwise the same as
         * [DatasetServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: DatasetListParams = DatasetListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DatasetList>

        /** @see list */
        @MustBeClosed
        suspend fun list(requestOptions: RequestOptions): HttpResponseFor<DatasetList> =
            list(DatasetListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /api/v1/datasets/{id}`, but is otherwise the same
         * as [DatasetServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            id: String,
            params: DatasetDeleteParams = DatasetDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        suspend fun delete(
            params: DatasetDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see delete */
        @MustBeClosed
        suspend fun delete(id: String, requestOptions: RequestOptions): HttpResponse =
            delete(id, DatasetDeleteParams.none(), requestOptions)
    }
}
