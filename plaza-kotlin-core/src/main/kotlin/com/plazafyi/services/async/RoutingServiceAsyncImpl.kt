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
import com.plazafyi.models.routing.MatrixResult
import com.plazafyi.models.routing.NearestResult
import com.plazafyi.models.routing.RouteResult
import com.plazafyi.models.routing.RoutingIsochroneParams
import com.plazafyi.models.routing.RoutingIsochronePostParams
import com.plazafyi.models.routing.RoutingIsochronePostResponse
import com.plazafyi.models.routing.RoutingIsochroneResponse
import com.plazafyi.models.routing.RoutingMatrixParams
import com.plazafyi.models.routing.RoutingNearestParams
import com.plazafyi.models.routing.RoutingNearestPostParams
import com.plazafyi.models.routing.RoutingRouteParams

class RoutingServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    RoutingServiceAsync {

    private val withRawResponse: RoutingServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): RoutingServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): RoutingServiceAsync =
        RoutingServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun isochrone(
        params: RoutingIsochroneParams,
        requestOptions: RequestOptions,
    ): RoutingIsochroneResponse =
        // get /api/v1/isochrone
        withRawResponse().isochrone(params, requestOptions).parse()

    override suspend fun isochronePost(
        params: RoutingIsochronePostParams,
        requestOptions: RequestOptions,
    ): RoutingIsochronePostResponse =
        // post /api/v1/isochrone
        withRawResponse().isochronePost(params, requestOptions).parse()

    override suspend fun matrix(
        params: RoutingMatrixParams,
        requestOptions: RequestOptions,
    ): MatrixResult =
        // post /api/v1/matrix
        withRawResponse().matrix(params, requestOptions).parse()

    override suspend fun nearest(
        params: RoutingNearestParams,
        requestOptions: RequestOptions,
    ): NearestResult =
        // get /api/v1/nearest
        withRawResponse().nearest(params, requestOptions).parse()

    override suspend fun nearestPost(
        params: RoutingNearestPostParams,
        requestOptions: RequestOptions,
    ): NearestResult =
        // post /api/v1/nearest
        withRawResponse().nearestPost(params, requestOptions).parse()

    override suspend fun route(
        params: RoutingRouteParams,
        requestOptions: RequestOptions,
    ): RouteResult =
        // post /api/v1/route
        withRawResponse().route(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        RoutingServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): RoutingServiceAsync.WithRawResponse =
            RoutingServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        private val isochroneHandler: Handler<RoutingIsochroneResponse> =
            jsonHandler<RoutingIsochroneResponse>(clientOptions.jsonMapper)

        override suspend fun isochrone(
            params: RoutingIsochroneParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<RoutingIsochroneResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "isochrone")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { isochroneHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val isochronePostHandler: Handler<RoutingIsochronePostResponse> =
            jsonHandler<RoutingIsochronePostResponse>(clientOptions.jsonMapper)

        override suspend fun isochronePost(
            params: RoutingIsochronePostParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<RoutingIsochronePostResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "isochrone")
                    .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { isochronePostHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val matrixHandler: Handler<MatrixResult> =
            jsonHandler<MatrixResult>(clientOptions.jsonMapper)

        override suspend fun matrix(
            params: RoutingMatrixParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MatrixResult> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "matrix")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { matrixHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val nearestHandler: Handler<NearestResult> =
            jsonHandler<NearestResult>(clientOptions.jsonMapper)

        override suspend fun nearest(
            params: RoutingNearestParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<NearestResult> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "nearest")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { nearestHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val nearestPostHandler: Handler<NearestResult> =
            jsonHandler<NearestResult>(clientOptions.jsonMapper)

        override suspend fun nearestPost(
            params: RoutingNearestPostParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<NearestResult> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "nearest")
                    .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { nearestPostHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val routeHandler: Handler<RouteResult> =
            jsonHandler<RouteResult>(clientOptions.jsonMapper)

        override suspend fun route(
            params: RoutingRouteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<RouteResult> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "route")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { routeHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
