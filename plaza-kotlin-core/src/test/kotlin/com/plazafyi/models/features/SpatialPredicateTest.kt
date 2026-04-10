// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.features

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import com.plazafyi.models.Geometry
import com.plazafyi.models.PointGeometry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SpatialPredicateTest {

    @Test
    fun create() {
        val spatialPredicate =
            SpatialPredicate.builder()
                .pointAround(listOf(2.3522, 48.8566))
                .pointContains(listOf(2.3522, 48.8566))
                .pointCrosses(listOf(2.3522, 48.8566))
                .pointIntersects(listOf(2.3522, 48.8566))
                .pointNotContains(listOf(2.3522, 48.8566))
                .pointNotIntersects(listOf(2.3522, 48.8566))
                .pointNotWithin(listOf(2.3522, 48.8566))
                .radius(500.0)
                .pointTouches(listOf(2.3522, 48.8566))
                .pointWithin(listOf(2.3522, 48.8566))
                .build()

        assertThat(spatialPredicate.around())
            .isEqualTo(
                Geometry.ofPoint(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
            )
        assertThat(spatialPredicate.contains())
            .isEqualTo(
                Geometry.ofPoint(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
            )
        assertThat(spatialPredicate.crosses())
            .isEqualTo(
                Geometry.ofPoint(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
            )
        assertThat(spatialPredicate.intersects())
            .isEqualTo(
                Geometry.ofPoint(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
            )
        assertThat(spatialPredicate.notContains())
            .isEqualTo(
                Geometry.ofPoint(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
            )
        assertThat(spatialPredicate.notIntersects())
            .isEqualTo(
                Geometry.ofPoint(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
            )
        assertThat(spatialPredicate.notWithin())
            .isEqualTo(
                Geometry.ofPoint(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
            )
        assertThat(spatialPredicate.radius()).isEqualTo(500.0)
        assertThat(spatialPredicate.touches())
            .isEqualTo(
                Geometry.ofPoint(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
            )
        assertThat(spatialPredicate.within())
            .isEqualTo(
                Geometry.ofPoint(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val spatialPredicate =
            SpatialPredicate.builder()
                .pointAround(listOf(2.3522, 48.8566))
                .pointContains(listOf(2.3522, 48.8566))
                .pointCrosses(listOf(2.3522, 48.8566))
                .pointIntersects(listOf(2.3522, 48.8566))
                .pointNotContains(listOf(2.3522, 48.8566))
                .pointNotIntersects(listOf(2.3522, 48.8566))
                .pointNotWithin(listOf(2.3522, 48.8566))
                .radius(500.0)
                .pointTouches(listOf(2.3522, 48.8566))
                .pointWithin(listOf(2.3522, 48.8566))
                .build()

        val roundtrippedSpatialPredicate =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(spatialPredicate),
                jacksonTypeRef<SpatialPredicate>(),
            )

        assertThat(roundtrippedSpatialPredicate).isEqualTo(spatialPredicate)
    }
}
