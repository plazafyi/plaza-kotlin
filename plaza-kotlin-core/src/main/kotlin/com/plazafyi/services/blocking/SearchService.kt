// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.plazafyi.core.ClientOptions
import com.plazafyi.core.RequestOptions
import com.plazafyi.core.http.HttpResponseFor
import com.plazafyi.models.FeatureCollection
import com.plazafyi.models.search.SearchQueryParams

interface SearchService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): SearchService

    /** Search OSM features by name */
    fun query(
        params: SearchQueryParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeatureCollection

    /** A view of [SearchService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: (ClientOptions.Builder) -> Unit): SearchService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v1/search`, but is otherwise the same as
         * [SearchService.query].
         */
        @MustBeClosed
        fun query(
            params: SearchQueryParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FeatureCollection>
    }
}
