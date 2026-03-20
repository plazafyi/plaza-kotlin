// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.plazafyi.core.ClientOptions
import com.plazafyi.core.RequestOptions
import com.plazafyi.core.checkRequired
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
import com.plazafyi.models.FeatureCollection
import com.plazafyi.models.GeoJsonFeature
import com.plazafyi.models.elements.ElementBatchParams
import com.plazafyi.models.elements.ElementLookupParams
import com.plazafyi.models.elements.ElementNearbyParams
import com.plazafyi.models.elements.ElementNearbyPostParams
import com.plazafyi.models.elements.ElementQueryParams
import com.plazafyi.models.elements.ElementQueryPostParams
import com.plazafyi.models.elements.ElementRetrieveParams

class ElementServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ElementServiceAsync {

    private val withRawResponse: ElementServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ElementServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): ElementServiceAsync =
        ElementServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun retrieve(
        params: ElementRetrieveParams,
        requestOptions: RequestOptions,
    ): GeoJsonFeature =
        // get /api/v1/features/{type}/{id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override suspend fun batch(
        params: ElementBatchParams,
        requestOptions: RequestOptions,
    ): FeatureCollection =
        // post /api/v1/features/batch
        withRawResponse().batch(params, requestOptions).parse()

    override suspend fun lookup(
        params: ElementLookupParams,
        requestOptions: RequestOptions,
    ): GeoJsonFeature =
        // post /api/v1/features/lookup
        withRawResponse().lookup(params, requestOptions).parse()

    override suspend fun nearby(
        params: ElementNearbyParams,
        requestOptions: RequestOptions,
    ): FeatureCollection =
        // get /api/v1/features/nearby
        withRawResponse().nearby(params, requestOptions).parse()

    override suspend fun nearbyPost(
        params: ElementNearbyPostParams,
        requestOptions: RequestOptions,
    ): FeatureCollection =
        // post /api/v1/features/nearby
        withRawResponse().nearbyPost(params, requestOptions).parse()

    override suspend fun query(
        params: ElementQueryParams,
        requestOptions: RequestOptions,
    ): FeatureCollection =
        // get /api/v1/features
        withRawResponse().query(params, requestOptions).parse()

    override suspend fun queryPost(
        params: ElementQueryPostParams,
        requestOptions: RequestOptions,
    ): FeatureCollection =
        // post /api/v1/features
        withRawResponse().queryPost(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ElementServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): ElementServiceAsync.WithRawResponse =
            ElementServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        private val retrieveHandler: Handler<GeoJsonFeature> =
            jsonHandler<GeoJsonFeature>(clientOptions.jsonMapper)

        override suspend fun retrieve(
            params: ElementRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<GeoJsonFeature> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "api",
                        "v1",
                        "features",
                        params._pathParam(0),
                        params._pathParam(1),
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val batchHandler: Handler<FeatureCollection> =
            jsonHandler<FeatureCollection>(clientOptions.jsonMapper)

        override suspend fun batch(
            params: ElementBatchParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FeatureCollection> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "features", "batch")
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

        private val lookupHandler: Handler<GeoJsonFeature> =
            jsonHandler<GeoJsonFeature>(clientOptions.jsonMapper)

        override suspend fun lookup(
            params: ElementLookupParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<GeoJsonFeature> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "features", "lookup")
                    .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { lookupHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val nearbyHandler: Handler<FeatureCollection> =
            jsonHandler<FeatureCollection>(clientOptions.jsonMapper)

        override suspend fun nearby(
            params: ElementNearbyParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FeatureCollection> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "features", "nearby")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { nearbyHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val nearbyPostHandler: Handler<FeatureCollection> =
            jsonHandler<FeatureCollection>(clientOptions.jsonMapper)

        override suspend fun nearbyPost(
            params: ElementNearbyPostParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FeatureCollection> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "features", "nearby")
                    .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { nearbyPostHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val queryHandler: Handler<FeatureCollection> =
            jsonHandler<FeatureCollection>(clientOptions.jsonMapper)

        override suspend fun query(
            params: ElementQueryParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FeatureCollection> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "features")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { queryHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val queryPostHandler: Handler<FeatureCollection> =
            jsonHandler<FeatureCollection>(clientOptions.jsonMapper)

        override suspend fun queryPost(
            params: ElementQueryPostParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FeatureCollection> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "features")
                    .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { queryPostHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
