// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.plazafyi.core.ClientOptions
import com.plazafyi.core.RequestOptions
import com.plazafyi.core.http.HttpResponseFor
import com.plazafyi.models.geocode.AutocompleteRequest
import com.plazafyi.models.geocode.AutocompleteResult
import com.plazafyi.models.geocode.GeocodeAutocompleteParams
import com.plazafyi.models.geocode.GeocodeBatchParams
import com.plazafyi.models.geocode.GeocodeBatchResponse
import com.plazafyi.models.geocode.GeocodeForwardParams
import com.plazafyi.models.geocode.GeocodeForwardRequest
import com.plazafyi.models.geocode.GeocodeResult
import com.plazafyi.models.geocode.GeocodeReverseParams
import com.plazafyi.models.geocode.GeocodeReverseRequest
import com.plazafyi.models.geocode.ReverseGeocodeResult

interface GeocodeServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): GeocodeServiceAsync

    /** Autocomplete a partial address */
    suspend fun autocomplete(
        params: GeocodeAutocompleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AutocompleteResult

    /** @see autocomplete */
    suspend fun autocomplete(
        autocompleteRequest: AutocompleteRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AutocompleteResult =
        autocomplete(
            GeocodeAutocompleteParams.builder().autocompleteRequest(autocompleteRequest).build(),
            requestOptions,
        )

    /** Batch geocode multiple addresses */
    suspend fun batch(
        params: GeocodeBatchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GeocodeBatchResponse

    /** Forward geocode an address */
    suspend fun forward(
        params: GeocodeForwardParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GeocodeResult

    /** @see forward */
    suspend fun forward(
        geocodeForwardRequest: GeocodeForwardRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GeocodeResult =
        forward(
            GeocodeForwardParams.builder().geocodeForwardRequest(geocodeForwardRequest).build(),
            requestOptions,
        )

    /** Reverse geocode a coordinate */
    suspend fun reverse(
        params: GeocodeReverseParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ReverseGeocodeResult

    /** @see reverse */
    suspend fun reverse(
        geocodeReverseRequest: GeocodeReverseRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ReverseGeocodeResult =
        reverse(
            GeocodeReverseParams.builder().geocodeReverseRequest(geocodeReverseRequest).build(),
            requestOptions,
        )

    /**
     * A view of [GeocodeServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): GeocodeServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/v1/geocode/autocomplete`, but is otherwise the
         * same as [GeocodeServiceAsync.autocomplete].
         */
        @MustBeClosed
        suspend fun autocomplete(
            params: GeocodeAutocompleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AutocompleteResult>

        /** @see autocomplete */
        @MustBeClosed
        suspend fun autocomplete(
            autocompleteRequest: AutocompleteRequest,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AutocompleteResult> =
            autocomplete(
                GeocodeAutocompleteParams.builder()
                    .autocompleteRequest(autocompleteRequest)
                    .build(),
                requestOptions,
            )

        /**
         * Returns a raw HTTP response for `post /api/v1/geocode/batch`, but is otherwise the same
         * as [GeocodeServiceAsync.batch].
         */
        @MustBeClosed
        suspend fun batch(
            params: GeocodeBatchParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GeocodeBatchResponse>

        /**
         * Returns a raw HTTP response for `post /api/v1/geocode`, but is otherwise the same as
         * [GeocodeServiceAsync.forward].
         */
        @MustBeClosed
        suspend fun forward(
            params: GeocodeForwardParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GeocodeResult>

        /** @see forward */
        @MustBeClosed
        suspend fun forward(
            geocodeForwardRequest: GeocodeForwardRequest,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GeocodeResult> =
            forward(
                GeocodeForwardParams.builder().geocodeForwardRequest(geocodeForwardRequest).build(),
                requestOptions,
            )

        /**
         * Returns a raw HTTP response for `post /api/v1/geocode/reverse`, but is otherwise the same
         * as [GeocodeServiceAsync.reverse].
         */
        @MustBeClosed
        suspend fun reverse(
            params: GeocodeReverseParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ReverseGeocodeResult>

        /** @see reverse */
        @MustBeClosed
        suspend fun reverse(
            geocodeReverseRequest: GeocodeReverseRequest,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ReverseGeocodeResult> =
            reverse(
                GeocodeReverseParams.builder().geocodeReverseRequest(geocodeReverseRequest).build(),
                requestOptions,
            )
    }
}
