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
import com.plazafyi.models.mapmatch.MapMatchMatchParams
import com.plazafyi.models.mapmatch.MapMatchResult

class MapMatchServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    MapMatchServiceAsync {

    private val withRawResponse: MapMatchServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): MapMatchServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): MapMatchServiceAsync =
        MapMatchServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun match(
        params: MapMatchMatchParams,
        requestOptions: RequestOptions,
    ): MapMatchResult =
        // post /api/v1/map-match
        withRawResponse().match(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        MapMatchServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): MapMatchServiceAsync.WithRawResponse =
            MapMatchServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        private val matchHandler: Handler<MapMatchResult> =
            jsonHandler<MapMatchResult>(clientOptions.jsonMapper)

        override suspend fun match(
            params: MapMatchMatchParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MapMatchResult> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "map-match")
                    .putHeader("Accept", "application/geo+json")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { matchHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
