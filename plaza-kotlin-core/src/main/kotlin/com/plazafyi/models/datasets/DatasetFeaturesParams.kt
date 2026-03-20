// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.datasets

import com.plazafyi.core.Params
import com.plazafyi.core.http.Headers
import com.plazafyi.core.http.QueryParams
import java.util.Objects

/** Query features in a dataset */
class DatasetFeaturesParams
private constructor(
    private val id: String?,
    private val cursor: String?,
    private val format: String?,
    private val limit: Long?,
    private val outputBuffer: Double?,
    private val outputCentroid: Boolean?,
    private val outputFields: String?,
    private val outputGeometry: Boolean?,
    private val outputInclude: String?,
    private val outputPrecision: Long?,
    private val outputSimplify: Double?,
    private val outputSort: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun id(): String? = id

    /** Cursor for pagination */
    fun cursor(): String? = cursor

    /** Response format: json (default), geojson, csv, ndjson */
    fun format(): String? = format

    /** Maximum results */
    fun limit(): Long? = limit

    /** Buffer geometry by meters */
    fun outputBuffer(): Double? = outputBuffer

    /** Replace geometry with centroid */
    fun outputCentroid(): Boolean? = outputCentroid

    /** Comma-separated property fields to include */
    fun outputFields(): String? = outputFields

    /** Include geometry (default true) */
    fun outputGeometry(): Boolean? = outputGeometry

    /** Extra computed fields: bbox, distance, center */
    fun outputInclude(): String? = outputInclude

    /** Coordinate decimal precision (1-15, default 7) */
    fun outputPrecision(): Long? = outputPrecision

    /** Simplify geometry tolerance in meters */
    fun outputSimplify(): Double? = outputSimplify

    /** Sort by: distance, name, osm_id */
    fun outputSort(): String? = outputSort

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        fun none(): DatasetFeaturesParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [DatasetFeaturesParams]. */
        fun builder() = Builder()
    }

    /** A builder for [DatasetFeaturesParams]. */
    class Builder internal constructor() {

        private var id: String? = null
        private var cursor: String? = null
        private var format: String? = null
        private var limit: Long? = null
        private var outputBuffer: Double? = null
        private var outputCentroid: Boolean? = null
        private var outputFields: String? = null
        private var outputGeometry: Boolean? = null
        private var outputInclude: String? = null
        private var outputPrecision: Long? = null
        private var outputSimplify: Double? = null
        private var outputSort: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        internal fun from(datasetFeaturesParams: DatasetFeaturesParams) = apply {
            id = datasetFeaturesParams.id
            cursor = datasetFeaturesParams.cursor
            format = datasetFeaturesParams.format
            limit = datasetFeaturesParams.limit
            outputBuffer = datasetFeaturesParams.outputBuffer
            outputCentroid = datasetFeaturesParams.outputCentroid
            outputFields = datasetFeaturesParams.outputFields
            outputGeometry = datasetFeaturesParams.outputGeometry
            outputInclude = datasetFeaturesParams.outputInclude
            outputPrecision = datasetFeaturesParams.outputPrecision
            outputSimplify = datasetFeaturesParams.outputSimplify
            outputSort = datasetFeaturesParams.outputSort
            additionalHeaders = datasetFeaturesParams.additionalHeaders.toBuilder()
            additionalQueryParams = datasetFeaturesParams.additionalQueryParams.toBuilder()
        }

        fun id(id: String?) = apply { this.id = id }

        /** Cursor for pagination */
        fun cursor(cursor: String?) = apply { this.cursor = cursor }

        /** Response format: json (default), geojson, csv, ndjson */
        fun format(format: String?) = apply { this.format = format }

        /** Maximum results */
        fun limit(limit: Long?) = apply { this.limit = limit }

        /**
         * Alias for [Builder.limit].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun limit(limit: Long) = limit(limit as Long?)

        /** Buffer geometry by meters */
        fun outputBuffer(outputBuffer: Double?) = apply { this.outputBuffer = outputBuffer }

        /**
         * Alias for [Builder.outputBuffer].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun outputBuffer(outputBuffer: Double) = outputBuffer(outputBuffer as Double?)

        /** Replace geometry with centroid */
        fun outputCentroid(outputCentroid: Boolean?) = apply {
            this.outputCentroid = outputCentroid
        }

        /**
         * Alias for [Builder.outputCentroid].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun outputCentroid(outputCentroid: Boolean) = outputCentroid(outputCentroid as Boolean?)

        /** Comma-separated property fields to include */
        fun outputFields(outputFields: String?) = apply { this.outputFields = outputFields }

        /** Include geometry (default true) */
        fun outputGeometry(outputGeometry: Boolean?) = apply {
            this.outputGeometry = outputGeometry
        }

        /**
         * Alias for [Builder.outputGeometry].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun outputGeometry(outputGeometry: Boolean) = outputGeometry(outputGeometry as Boolean?)

        /** Extra computed fields: bbox, distance, center */
        fun outputInclude(outputInclude: String?) = apply { this.outputInclude = outputInclude }

        /** Coordinate decimal precision (1-15, default 7) */
        fun outputPrecision(outputPrecision: Long?) = apply {
            this.outputPrecision = outputPrecision
        }

        /**
         * Alias for [Builder.outputPrecision].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun outputPrecision(outputPrecision: Long) = outputPrecision(outputPrecision as Long?)

        /** Simplify geometry tolerance in meters */
        fun outputSimplify(outputSimplify: Double?) = apply { this.outputSimplify = outputSimplify }

        /**
         * Alias for [Builder.outputSimplify].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun outputSimplify(outputSimplify: Double) = outputSimplify(outputSimplify as Double?)

        /** Sort by: distance, name, osm_id */
        fun outputSort(outputSort: String?) = apply { this.outputSort = outputSort }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [DatasetFeaturesParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): DatasetFeaturesParams =
            DatasetFeaturesParams(
                id,
                cursor,
                format,
                limit,
                outputBuffer,
                outputCentroid,
                outputFields,
                outputGeometry,
                outputInclude,
                outputPrecision,
                outputSimplify,
                outputSort,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> id ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                cursor?.let { put("cursor", it) }
                format?.let { put("format", it) }
                limit?.let { put("limit", it.toString()) }
                outputBuffer?.let { put("output[buffer]", it.toString()) }
                outputCentroid?.let { put("output[centroid]", it.toString()) }
                outputFields?.let { put("output[fields]", it) }
                outputGeometry?.let { put("output[geometry]", it.toString()) }
                outputInclude?.let { put("output[include]", it) }
                outputPrecision?.let { put("output[precision]", it.toString()) }
                outputSimplify?.let { put("output[simplify]", it.toString()) }
                outputSort?.let { put("output[sort]", it) }
                putAll(additionalQueryParams)
            }
            .build()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is DatasetFeaturesParams &&
            id == other.id &&
            cursor == other.cursor &&
            format == other.format &&
            limit == other.limit &&
            outputBuffer == other.outputBuffer &&
            outputCentroid == other.outputCentroid &&
            outputFields == other.outputFields &&
            outputGeometry == other.outputGeometry &&
            outputInclude == other.outputInclude &&
            outputPrecision == other.outputPrecision &&
            outputSimplify == other.outputSimplify &&
            outputSort == other.outputSort &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            id,
            cursor,
            format,
            limit,
            outputBuffer,
            outputCentroid,
            outputFields,
            outputGeometry,
            outputInclude,
            outputPrecision,
            outputSimplify,
            outputSort,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "DatasetFeaturesParams{id=$id, cursor=$cursor, format=$format, limit=$limit, outputBuffer=$outputBuffer, outputCentroid=$outputCentroid, outputFields=$outputFields, outputGeometry=$outputGeometry, outputInclude=$outputInclude, outputPrecision=$outputPrecision, outputSimplify=$outputSimplify, outputSort=$outputSort, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
