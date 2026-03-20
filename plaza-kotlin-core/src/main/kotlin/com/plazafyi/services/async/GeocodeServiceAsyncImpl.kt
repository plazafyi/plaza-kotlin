// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.plazafyi.core.ClientOptions
import com.plazafyi.core.RequestOptions
import com.plazafyi.core.handlers.errorBodyHandler
import com.plazafyi.core.handlers.errorHandler
import com.plazafyi.core.handlers.jsonHandler
import com.plazafyi.core.http.HttpMethod
import com.plazafyi.core.http.HttpRequest
import com.plazafyi.core.http.HttpResponse
import com.plazafyi.core.http.HttpResponse.Handler
import com.plazafyi.core.http.HttpResponseFor
import com.plazafyi.core.http.json
import com.plazafyi.core.http.parseable
import com.plazafyi.core.prepareAsync
import com.plazafyi.models.geocode.AutocompleteResult
import com.plazafyi.models.geocode.GeocodeAutocompleteParams
import com.plazafyi.models.geocode.GeocodeAutocompletePostParams
import com.plazafyi.models.geocode.GeocodeBatchParams
import com.plazafyi.models.geocode.GeocodeBatchResponse
import com.plazafyi.models.geocode.GeocodeForwardParams
import com.plazafyi.models.geocode.GeocodeForwardPostParams
import com.plazafyi.models.geocode.GeocodeResult
import com.plazafyi.models.geocode.GeocodeReverseParams
import com.plazafyi.models.geocode.GeocodeReversePostParams
import com.plazafyi.models.geocode.ReverseGeocodeResult

class GeocodeServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    GeocodeServiceAsync {

    private val withRawResponse: GeocodeServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): GeocodeServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): GeocodeServiceAsync =
        GeocodeServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun autocomplete(
        params: GeocodeAutocompleteParams,
        requestOptions: RequestOptions,
    ): AutocompleteResult =
        // get /api/v1/geocode/autocomplete
        withRawResponse().autocomplete(params, requestOptions).parse()

    override suspend fun autocompletePost(
        params: GeocodeAutocompletePostParams,
        requestOptions: RequestOptions,
    ): AutocompleteResult =
        // post /api/v1/geocode/autocomplete
        withRawResponse().autocompletePost(params, requestOptions).parse()

    override suspend fun batch(
        params: GeocodeBatchParams,
        requestOptions: RequestOptions,
    ): GeocodeBatchResponse =
        // post /api/v1/geocode/batch
        withRawResponse().batch(params, requestOptions).parse()

    override suspend fun forward(
        params: GeocodeForwardParams,
        requestOptions: RequestOptions,
    ): GeocodeResult =
        // get /api/v1/geocode
        withRawResponse().forward(params, requestOptions).parse()

    override suspend fun forwardPost(
        params: GeocodeForwardPostParams,
        requestOptions: RequestOptions,
    ): GeocodeResult =
        // post /api/v1/geocode
        withRawResponse().forwardPost(params, requestOptions).parse()

    override suspend fun reverse(
        params: GeocodeReverseParams,
        requestOptions: RequestOptions,
    ): ReverseGeocodeResult =
        // get /api/v1/geocode/reverse
        withRawResponse().reverse(params, requestOptions).parse()

    override suspend fun reversePost(
        params: GeocodeReversePostParams,
        requestOptions: RequestOptions,
    ): ReverseGeocodeResult =
        // post /api/v1/geocode/reverse
        withRawResponse().reversePost(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        GeocodeServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): GeocodeServiceAsync.WithRawResponse =
            GeocodeServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        private val autocompleteHandler: Handler<AutocompleteResult> =
            jsonHandler<AutocompleteResult>(clientOptions.jsonMapper)

        override suspend fun autocomplete(
            params: GeocodeAutocompleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AutocompleteResult> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "geocode", "autocomplete")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { autocompleteHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val autocompletePostHandler: Handler<AutocompleteResult> =
            jsonHandler<AutocompleteResult>(clientOptions.jsonMapper)

        override suspend fun autocompletePost(
            params: GeocodeAutocompletePostParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AutocompleteResult> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "geocode", "autocomplete")
                    .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { autocompletePostHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val batchHandler: Handler<GeocodeBatchResponse> =
            jsonHandler<GeocodeBatchResponse>(clientOptions.jsonMapper)

        override suspend fun batch(
            params: GeocodeBatchParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<GeocodeBatchResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "geocode", "batch")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { batchHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val forwardHandler: Handler<GeocodeResult> =
            jsonHandler<GeocodeResult>(clientOptions.jsonMapper)

        override suspend fun forward(
            params: GeocodeForwardParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<GeocodeResult> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "geocode")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { forwardHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val forwardPostHandler: Handler<GeocodeResult> =
            jsonHandler<GeocodeResult>(clientOptions.jsonMapper)

        override suspend fun forwardPost(
            params: GeocodeForwardPostParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<GeocodeResult> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "geocode")
                    .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { forwardPostHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val reverseHandler: Handler<ReverseGeocodeResult> =
            jsonHandler<ReverseGeocodeResult>(clientOptions.jsonMapper)

        override suspend fun reverse(
            params: GeocodeReverseParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ReverseGeocodeResult> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "geocode", "reverse")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { reverseHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val reversePostHandler: Handler<ReverseGeocodeResult> =
            jsonHandler<ReverseGeocodeResult>(clientOptions.jsonMapper)

        override suspend fun reversePost(
            params: GeocodeReversePostParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ReverseGeocodeResult> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "geocode", "reverse")
                    .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { reversePostHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
