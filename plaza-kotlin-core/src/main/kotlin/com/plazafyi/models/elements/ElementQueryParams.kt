// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.elements

import com.plazafyi.core.Params
import com.plazafyi.core.http.Headers
import com.plazafyi.core.http.QueryParams
import java.util.Objects

/** Query features by spatial predicate, bounding box, or H3 cell */
class ElementQueryParams
private constructor(
    private val bbox: String?,
    private val contains: String?,
    private val crosses: String?,
    private val cursor: String?,
    private val format: String?,
    private val h3: String?,
    private val intersects: String?,
    private val limit: Long?,
    private val near: String?,
    private val outputBuffer: Double?,
    private val outputCentroid: Boolean?,
    private val outputFields: String?,
    private val outputGeometry: Boolean?,
    private val outputInclude: String?,
    private val outputPrecision: Long?,
    private val outputSimplify: Double?,
    private val outputSort: String?,
    private val radius: Double?,
    private val touches: String?,
    private val type: String?,
    private val within: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Legacy shorthand. Bounding box: south,west,north,east. Use spatial predicates (near, within,
     * intersects) instead.
     */
    fun bbox(): String? = bbox

    /** Geometry that features must contain */
    fun contains(): String? = contains

    /** Geometry that features must cross */
    fun crosses(): String? = crosses

    /** Cursor for pagination */
    fun cursor(): String? = cursor

    /**
     * Response format. json (default) returns paginated GeoJSON. geojson/csv/ndjson stream via
     * chunked transfer encoding.
     */
    fun format(): String? = format

    /** Legacy shorthand. H3 cell index. Use spatial predicates instead. */
    fun h3(): String? = h3

    /** Geometry that features must intersect */
    fun intersects(): String? = intersects

    /** Maximum results (default 100, max 10000) */
    fun limit(): Long? = limit

    /** Point geometry for proximity search (lat,lng). Requires radius. */
    fun near(): String? = near

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

    /** Search radius in meters (for near) or buffer distance (for other predicates) */
    fun radius(): Double? = radius

    /** Geometry that features must touch */
    fun touches(): String? = touches

    /** Element types (comma-separated: node,way,relation) */
    fun type(): String? = type

    /** Geometry that features must be within */
    fun within(): String? = within

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        fun none(): ElementQueryParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [ElementQueryParams]. */
        fun builder() = Builder()
    }

    /** A builder for [ElementQueryParams]. */
    class Builder internal constructor() {

        private var bbox: String? = null
        private var contains: String? = null
        private var crosses: String? = null
        private var cursor: String? = null
        private var format: String? = null
        private var h3: String? = null
        private var intersects: String? = null
        private var limit: Long? = null
        private var near: String? = null
        private var outputBuffer: Double? = null
        private var outputCentroid: Boolean? = null
        private var outputFields: String? = null
        private var outputGeometry: Boolean? = null
        private var outputInclude: String? = null
        private var outputPrecision: Long? = null
        private var outputSimplify: Double? = null
        private var outputSort: String? = null
        private var radius: Double? = null
        private var touches: String? = null
        private var type: String? = null
        private var within: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        internal fun from(elementQueryParams: ElementQueryParams) = apply {
            bbox = elementQueryParams.bbox
            contains = elementQueryParams.contains
            crosses = elementQueryParams.crosses
            cursor = elementQueryParams.cursor
            format = elementQueryParams.format
            h3 = elementQueryParams.h3
            intersects = elementQueryParams.intersects
            limit = elementQueryParams.limit
            near = elementQueryParams.near
            outputBuffer = elementQueryParams.outputBuffer
            outputCentroid = elementQueryParams.outputCentroid
            outputFields = elementQueryParams.outputFields
            outputGeometry = elementQueryParams.outputGeometry
            outputInclude = elementQueryParams.outputInclude
            outputPrecision = elementQueryParams.outputPrecision
            outputSimplify = elementQueryParams.outputSimplify
            outputSort = elementQueryParams.outputSort
            radius = elementQueryParams.radius
            touches = elementQueryParams.touches
            type = elementQueryParams.type
            within = elementQueryParams.within
            additionalHeaders = elementQueryParams.additionalHeaders.toBuilder()
            additionalQueryParams = elementQueryParams.additionalQueryParams.toBuilder()
        }

        /**
         * Legacy shorthand. Bounding box: south,west,north,east. Use spatial predicates (near,
         * within, intersects) instead.
         */
        fun bbox(bbox: String?) = apply { this.bbox = bbox }

        /** Geometry that features must contain */
        fun contains(contains: String?) = apply { this.contains = contains }

        /** Geometry that features must cross */
        fun crosses(crosses: String?) = apply { this.crosses = crosses }

        /** Cursor for pagination */
        fun cursor(cursor: String?) = apply { this.cursor = cursor }

        /**
         * Response format. json (default) returns paginated GeoJSON. geojson/csv/ndjson stream via
         * chunked transfer encoding.
         */
        fun format(format: String?) = apply { this.format = format }

        /** Legacy shorthand. H3 cell index. Use spatial predicates instead. */
        fun h3(h3: String?) = apply { this.h3 = h3 }

        /** Geometry that features must intersect */
        fun intersects(intersects: String?) = apply { this.intersects = intersects }

        /** Maximum results (default 100, max 10000) */
        fun limit(limit: Long?) = apply { this.limit = limit }

        /**
         * Alias for [Builder.limit].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun limit(limit: Long) = limit(limit as Long?)

        /** Point geometry for proximity search (lat,lng). Requires radius. */
        fun near(near: String?) = apply { this.near = near }

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

        /** Search radius in meters (for near) or buffer distance (for other predicates) */
        fun radius(radius: Double?) = apply { this.radius = radius }

        /**
         * Alias for [Builder.radius].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun radius(radius: Double) = radius(radius as Double?)

        /** Geometry that features must touch */
        fun touches(touches: String?) = apply { this.touches = touches }

        /** Element types (comma-separated: node,way,relation) */
        fun type(type: String?) = apply { this.type = type }

        /** Geometry that features must be within */
        fun within(within: String?) = apply { this.within = within }

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
         * Returns an immutable instance of [ElementQueryParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ElementQueryParams =
            ElementQueryParams(
                bbox,
                contains,
                crosses,
                cursor,
                format,
                h3,
                intersects,
                limit,
                near,
                outputBuffer,
                outputCentroid,
                outputFields,
                outputGeometry,
                outputInclude,
                outputPrecision,
                outputSimplify,
                outputSort,
                radius,
                touches,
                type,
                within,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                bbox?.let { put("bbox", it) }
                contains?.let { put("contains", it) }
                crosses?.let { put("crosses", it) }
                cursor?.let { put("cursor", it) }
                format?.let { put("format", it) }
                h3?.let { put("h3", it) }
                intersects?.let { put("intersects", it) }
                limit?.let { put("limit", it.toString()) }
                near?.let { put("near", it) }
                outputBuffer?.let { put("output[buffer]", it.toString()) }
                outputCentroid?.let { put("output[centroid]", it.toString()) }
                outputFields?.let { put("output[fields]", it) }
                outputGeometry?.let { put("output[geometry]", it.toString()) }
                outputInclude?.let { put("output[include]", it) }
                outputPrecision?.let { put("output[precision]", it.toString()) }
                outputSimplify?.let { put("output[simplify]", it.toString()) }
                outputSort?.let { put("output[sort]", it) }
                radius?.let { put("radius", it.toString()) }
                touches?.let { put("touches", it) }
                type?.let { put("type", it) }
                within?.let { put("within", it) }
                putAll(additionalQueryParams)
            }
            .build()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ElementQueryParams &&
            bbox == other.bbox &&
            contains == other.contains &&
            crosses == other.crosses &&
            cursor == other.cursor &&
            format == other.format &&
            h3 == other.h3 &&
            intersects == other.intersects &&
            limit == other.limit &&
            near == other.near &&
            outputBuffer == other.outputBuffer &&
            outputCentroid == other.outputCentroid &&
            outputFields == other.outputFields &&
            outputGeometry == other.outputGeometry &&
            outputInclude == other.outputInclude &&
            outputPrecision == other.outputPrecision &&
            outputSimplify == other.outputSimplify &&
            outputSort == other.outputSort &&
            radius == other.radius &&
            touches == other.touches &&
            type == other.type &&
            within == other.within &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            bbox,
            contains,
            crosses,
            cursor,
            format,
            h3,
            intersects,
            limit,
            near,
            outputBuffer,
            outputCentroid,
            outputFields,
            outputGeometry,
            outputInclude,
            outputPrecision,
            outputSimplify,
            outputSort,
            radius,
            touches,
            type,
            within,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "ElementQueryParams{bbox=$bbox, contains=$contains, crosses=$crosses, cursor=$cursor, format=$format, h3=$h3, intersects=$intersects, limit=$limit, near=$near, outputBuffer=$outputBuffer, outputCentroid=$outputCentroid, outputFields=$outputFields, outputGeometry=$outputGeometry, outputInclude=$outputInclude, outputPrecision=$outputPrecision, outputSimplify=$outputSimplify, outputSort=$outputSort, radius=$radius, touches=$touches, type=$type, within=$within, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
