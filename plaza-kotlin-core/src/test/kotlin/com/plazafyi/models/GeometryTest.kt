// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.JsonValue
import com.plazafyi.core.jsonMapper
import com.plazafyi.errors.PlazaInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class GeometryTest {

    @Test
    fun ofPoint() {
        val point =
            PointGeometry.builder()
                .addCoordinate(2.3522)
                .addCoordinate(48.8566)
                .type(PointGeometry.Type.POINT)
                .build()

        val geometry = Geometry.ofPoint(point)

        assertThat(geometry.point()).isEqualTo(point)
        assertThat(geometry.lineString()).isNull()
        assertThat(geometry.polygon()).isNull()
        assertThat(geometry.multiPoint()).isNull()
        assertThat(geometry.multiLineString()).isNull()
        assertThat(geometry.multiPolygon()).isNull()
    }

    @Test
    fun ofPointRoundtrip() {
        val jsonMapper = jsonMapper()
        val geometry =
            Geometry.ofPoint(
                PointGeometry.builder()
                    .addCoordinate(2.3522)
                    .addCoordinate(48.8566)
                    .type(PointGeometry.Type.POINT)
                    .build()
            )

        val roundtrippedGeometry =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(geometry),
                jacksonTypeRef<Geometry>(),
            )

        assertThat(roundtrippedGeometry).isEqualTo(geometry)
    }

    @Test
    fun ofLineString() {
        val lineString =
            LineStringGeometry.builder()
                .addCoordinate(listOf(0.0, 0.0))
                .addCoordinate(listOf(0.0, 0.0))
                .type(LineStringGeometry.Type.LINE_STRING)
                .build()

        val geometry = Geometry.ofLineString(lineString)

        assertThat(geometry.point()).isNull()
        assertThat(geometry.lineString()).isEqualTo(lineString)
        assertThat(geometry.polygon()).isNull()
        assertThat(geometry.multiPoint()).isNull()
        assertThat(geometry.multiLineString()).isNull()
        assertThat(geometry.multiPolygon()).isNull()
    }

    @Test
    fun ofLineStringRoundtrip() {
        val jsonMapper = jsonMapper()
        val geometry =
            Geometry.ofLineString(
                LineStringGeometry.builder()
                    .addCoordinate(listOf(0.0, 0.0))
                    .addCoordinate(listOf(0.0, 0.0))
                    .type(LineStringGeometry.Type.LINE_STRING)
                    .build()
            )

        val roundtrippedGeometry =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(geometry),
                jacksonTypeRef<Geometry>(),
            )

        assertThat(roundtrippedGeometry).isEqualTo(geometry)
    }

    @Test
    fun ofPolygon() {
        val polygon =
            PolygonGeometry.builder()
                .addCoordinate(
                    listOf(listOf(0.0, 0.0), listOf(0.0, 0.0), listOf(0.0, 0.0), listOf(0.0, 0.0))
                )
                .type(PolygonGeometry.Type.POLYGON)
                .build()

        val geometry = Geometry.ofPolygon(polygon)

        assertThat(geometry.point()).isNull()
        assertThat(geometry.lineString()).isNull()
        assertThat(geometry.polygon()).isEqualTo(polygon)
        assertThat(geometry.multiPoint()).isNull()
        assertThat(geometry.multiLineString()).isNull()
        assertThat(geometry.multiPolygon()).isNull()
    }

    @Test
    fun ofPolygonRoundtrip() {
        val jsonMapper = jsonMapper()
        val geometry =
            Geometry.ofPolygon(
                PolygonGeometry.builder()
                    .addCoordinate(
                        listOf(
                            listOf(0.0, 0.0),
                            listOf(0.0, 0.0),
                            listOf(0.0, 0.0),
                            listOf(0.0, 0.0),
                        )
                    )
                    .type(PolygonGeometry.Type.POLYGON)
                    .build()
            )

        val roundtrippedGeometry =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(geometry),
                jacksonTypeRef<Geometry>(),
            )

        assertThat(roundtrippedGeometry).isEqualTo(geometry)
    }

    @Test
    fun ofMultiPoint() {
        val multiPoint =
            MultiPointGeometry.builder()
                .addCoordinate(listOf(0.0, 0.0))
                .type(MultiPointGeometry.Type.MULTI_POINT)
                .build()

        val geometry = Geometry.ofMultiPoint(multiPoint)

        assertThat(geometry.point()).isNull()
        assertThat(geometry.lineString()).isNull()
        assertThat(geometry.polygon()).isNull()
        assertThat(geometry.multiPoint()).isEqualTo(multiPoint)
        assertThat(geometry.multiLineString()).isNull()
        assertThat(geometry.multiPolygon()).isNull()
    }

    @Test
    fun ofMultiPointRoundtrip() {
        val jsonMapper = jsonMapper()
        val geometry =
            Geometry.ofMultiPoint(
                MultiPointGeometry.builder()
                    .addCoordinate(listOf(0.0, 0.0))
                    .type(MultiPointGeometry.Type.MULTI_POINT)
                    .build()
            )

        val roundtrippedGeometry =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(geometry),
                jacksonTypeRef<Geometry>(),
            )

        assertThat(roundtrippedGeometry).isEqualTo(geometry)
    }

    @Test
    fun ofMultiLineString() {
        val multiLineString =
            MultiLineStringGeometry.builder()
                .addCoordinate(listOf(listOf(0.0, 0.0), listOf(0.0, 0.0)))
                .type(MultiLineStringGeometry.Type.MULTI_LINE_STRING)
                .build()

        val geometry = Geometry.ofMultiLineString(multiLineString)

        assertThat(geometry.point()).isNull()
        assertThat(geometry.lineString()).isNull()
        assertThat(geometry.polygon()).isNull()
        assertThat(geometry.multiPoint()).isNull()
        assertThat(geometry.multiLineString()).isEqualTo(multiLineString)
        assertThat(geometry.multiPolygon()).isNull()
    }

    @Test
    fun ofMultiLineStringRoundtrip() {
        val jsonMapper = jsonMapper()
        val geometry =
            Geometry.ofMultiLineString(
                MultiLineStringGeometry.builder()
                    .addCoordinate(listOf(listOf(0.0, 0.0), listOf(0.0, 0.0)))
                    .type(MultiLineStringGeometry.Type.MULTI_LINE_STRING)
                    .build()
            )

        val roundtrippedGeometry =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(geometry),
                jacksonTypeRef<Geometry>(),
            )

        assertThat(roundtrippedGeometry).isEqualTo(geometry)
    }

    @Test
    fun ofMultiPolygon() {
        val multiPolygon =
            MultiPolygonGeometry.builder()
                .addCoordinate(
                    listOf(
                        listOf(
                            listOf(0.0, 0.0),
                            listOf(0.0, 0.0),
                            listOf(0.0, 0.0),
                            listOf(0.0, 0.0),
                        )
                    )
                )
                .type(MultiPolygonGeometry.Type.MULTI_POLYGON)
                .build()

        val geometry = Geometry.ofMultiPolygon(multiPolygon)

        assertThat(geometry.point()).isNull()
        assertThat(geometry.lineString()).isNull()
        assertThat(geometry.polygon()).isNull()
        assertThat(geometry.multiPoint()).isNull()
        assertThat(geometry.multiLineString()).isNull()
        assertThat(geometry.multiPolygon()).isEqualTo(multiPolygon)
    }

    @Test
    fun ofMultiPolygonRoundtrip() {
        val jsonMapper = jsonMapper()
        val geometry =
            Geometry.ofMultiPolygon(
                MultiPolygonGeometry.builder()
                    .addCoordinate(
                        listOf(
                            listOf(
                                listOf(0.0, 0.0),
                                listOf(0.0, 0.0),
                                listOf(0.0, 0.0),
                                listOf(0.0, 0.0),
                            )
                        )
                    )
                    .type(MultiPolygonGeometry.Type.MULTI_POLYGON)
                    .build()
            )

        val roundtrippedGeometry =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(geometry),
                jacksonTypeRef<Geometry>(),
            )

        assertThat(roundtrippedGeometry).isEqualTo(geometry)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val geometry = jsonMapper().convertValue(testCase.value, jacksonTypeRef<Geometry>())

        val e = assertThrows<PlazaInvalidDataException> { geometry.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
